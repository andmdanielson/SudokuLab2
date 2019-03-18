package pkgGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {
	
	public SudokuTest() {
	}
	//a
	@Test
	public void TestRegionNbr() throws Exception {
		int[][] puzzle= {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		Sudoku myS=new Sudoku(puzzle);
		int[] expected= {3,4,4,1};
		int[] actual=myS.getRegion(2, 1);
		assertArrayEquals(expected, actual);
	}
	

}
