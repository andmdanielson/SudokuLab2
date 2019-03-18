package pkgGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {
	
	public SudokuTest() {
	}
	final int[][] sudoku= {{1,2,3,4},{3,4,2,1},{2,1,4,3},{4,3,1,2}};
	final int[][] part_sudoku={{1,2,0,4},{3,0,2,1},{0,1,4,0},{4,0,1,0}};
	
	@Test
	public void TestRegionNbr_Test1() throws Exception {
		int[][] puzzle= {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		Sudoku myS=new Sudoku(puzzle);
		int[] expected= {3,4,4,1};
		int[] actual=myS.getRegion(2, 1);
		assertArrayEquals(expected, actual);
	}
	
	@Test (expected=Exception.class)
	public void TestRegionNbr_Test2() throws Exception {
		int[][] puzzle= {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		Sudoku myS=new Sudoku(puzzle);
		int[] arr=myS.getRegion(5,10);
	}
	
	@Test
	public void isPartialSudoku_test1() throws Exception {
		Sudoku mySu=new Sudoku(part_sudoku);
		boolean expected=true;
		boolean actual=mySu.isPartialSudoku();
		assertEquals(expected,actual);
	}
	
	@Test
	public void isPartialSudoku_test2() throws Exception {
		Sudoku mySu=new Sudoku(sudoku);
		boolean expected=false;
		boolean actual=mySu.isPartialSudoku();
		assertEquals(expected,actual);
	}

}
