package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
@WebService(portName ="labescape", serviceName = "labescapeservice" )
public class LabEscapeWS {
	@WebMethod
	public ArrayList<ArrayList<Character>> drawPathForEscape(ArrayList<ArrayList<Character>> labyrinth, int startX, int startY){
		int rowSize = labyrinth.size();
		int colSize = labyrinth.get(0).size();
		ArrayList<ArrayList<Character>> output = new ArrayList<ArrayList<Character>>();
		char[][] inputArray = null;;
		
		for (int i = 0; i < rowSize; i++) {
			ArrayList<Character> rowsList = labyrinth.get(i);
			char[] row = new char[rowSize];
		    for(int j = 0 ; j < colSize; j++){
		    	row[j] = rowsList.get(j);
		    }
			inputArray[i] = row;
		}
		char[][] result = null;
		try {
			result = LabEscape.drawPathForEscape(inputArray, startX, startY);
		} catch (NoEscapeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0 ; i < result.length; i ++){
			for(int j = 0 ; j < result[i].length ; j++){
				output.get(i).add(result[i][j]);
			}
		}
		
		return output;
		
	}
	
}
