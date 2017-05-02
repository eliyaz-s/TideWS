package main.java;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LabEscapeTest {

	static char[][] input = { {'O','O','O','O','O','O','O','O','O','O'},
		  {'O',' ',' ',' ',' ','O',' ',' ',' ','O'},
		  {'O',' ','O','O',' ','O',' ','O',' ','O'},
		  {'O',' ',' ','O',' ','O',' ','O',' ','O'},
		  {'O',' ','O','O',' ',' ',' ','O',' ',' '},
		  {'O',' ','O','O','O','O','O','O','O','O'},
		  {'O',' ',' ',' ',' ',' ',' ',' ',' ','O'},
		  {'O','O','O','O','O','O','O','O','O','O'}
		}; 
	
//	static char[][] input2 = { {'O','O'},	{'O' ,' '}};
//	static char[][] output2 = { {'O','O'},	{'O' ,'*'}};
	
	static char [][] output = {{'O','O','O','O','O','O','O','O','O','O'},
			{'O','*','*','*','*','O','*','*','*','O'},
			{'O','*','O','O','*','O','*','O','*','O'},
			{'O','*',' ','O','*','O','*','O','*','O'},
			{'O',' ','O','O','*','*','*','O','*','*'},
			{'O',' ','O','O','O','O','O','O','O','O'},
			{'O',' ',' ',' ',' ',' ',' ',' ',' ','O'},
			{'O','O','O','O','O','O','O','O','O','O'}
			};
	@Test
	public final void test1() {
		char[][] result = null;
		try {
			result = LabEscape.drawPathForEscape(input, 3, 1);
			for(int i = 0 ; i < result.length; i ++){
				for(int j = 0 ; j < result[i].length; j ++){
					System.out.print(result[i][j]);
				}System.out.println();
			}
			assertArrayEquals(output, result);
		} catch (NoEscapeException e) {
			System.out.println(e.getMessage());
		}
	}


}
