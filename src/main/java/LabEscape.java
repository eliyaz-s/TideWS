package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * This class is used to solve a 2D labyrinth. The result path shall be denoted
 * with '*' in the output matrix.
 */
public class LabEscape {

//	private static final char WALL = 'O';
	private static final char FREE = ' ';
	private static final char PATH = '*';
	static List<Integer> path = new ArrayList<Integer>();

	LabEscape(){
		
	}
	/**
	 * @param labyrinth
	 *            A labyrinth drawn on a matrix of characters. It's at least
	 *            4x4, can be a rectangle or a square. Walkable areas are
	 *            represented with a space character, walls are represented with
	 *            a big O character. The escape point is always on the border
	 *            (see README)
	 * @param startX
	 *            Starting row number for the escape. 0 based.
	 * @param startY
	 *            Starting column number for the escape. 0 based.
	 * @return A char matrix with the same labyrinth and a path drawn from the
	 *         starting point to the escape
	 * @throws NoEscapeException
	 *             when no path exists to the outside, from the selected
	 *             starting point
	 */
	public static char[][] drawPathForEscape(char[][] labyrinth, int startX, int startY) throws NoEscapeException {
		char[][] result = createCopyMaze(labyrinth);
		if (searchPath(labyrinth, startX, startY)) {
			for (int i = 0; i < path.size(); i += 2) {
				int psX = path.get(i);
				int psY = path.get(i + 1);
				result[psX][psY] = PATH;
			}
		} else {
			throw new NoEscapeException("No path available");
		}
		return result;
	}
	/**
	 * This method is used to create an empty maze which shall be used to
	 * populate the result matrix with path updated with '*'
	 * 
	 * @param A
	 *            char matrix with the same labyrinth.
	 * @return
	 */
	private static char[][] createCopyMaze(char[][] labyrinth) {
		int x = labyrinth.length;
		int y = labyrinth[0].length;
		char[][] copyMaze = new char[x][y];

		for (int i = 0; i < labyrinth.length; i++) {
			char[] res = Arrays.copyOf(labyrinth[i], labyrinth[i].length);
			copyMaze[i] = res;
		}
		return copyMaze;
	}

	/**
	 * This method is used to find the path from the start coordinates to the
	 * escape.This is a recursive method and return true if the position is
	 * moved forward. Path will be updated with coordinates.
	 * 
	 * @param labyrinth The input labyrinth is a 2D matrix 
	 * @param startX Starting row number for the escape. 0 based.
	 * @param startY Starting column number for the escape. 0 based.
	 * @return false if no path is obtained 
	 */
	private static boolean searchPath(char[][] labyrinth, int startX, int startY) {

		int x = labyrinth.length;
		int y = labyrinth[0].length;
		/*
		 *  The condition below will determine if we have reached the escape. 
		 *  We are checking if we are looking for element at the edge of the matrix and is equal to ' '
		 */
		if ((startX == x - 1 || startY == y - 1) && labyrinth[startX][startY] == FREE) {  
			labyrinth[startX][startY] = PATH;
			path.add(startX);
			path.add(startY);
			return true;
		}
		if (labyrinth[startX][startY] == FREE) {
			labyrinth[startX][startY] = PATH;
			int devX = 0; // deviation on rows 
			int devY = -1; // deviation on column
			if (searchPath(labyrinth, startX + devX, startY + devY)) {
				path.add(startX);
				path.add(startY);
				return true;
			}
			devX = 0;
			devY = 1;
			if (searchPath(labyrinth, startX + devX, startY + devY)) {
				path.add(startX);
				path.add(startY);
				return true;
			}

			devX = -1;
			devY = 0;
			if (searchPath(labyrinth, startX + devX, startY + devY)) {
				path.add(startX);
				path.add(startY);
				return true;
			}
			devX = 1;
			devY = 0;
			if (searchPath(labyrinth, startX + devX, startY + devY)) {
				path.add(startX);
				path.add(startY);
				return true;
			}
		}
		return false;
	}
}
