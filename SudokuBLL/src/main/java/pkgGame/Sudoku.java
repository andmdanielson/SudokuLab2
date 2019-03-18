package pkgGame;

import pkgHelper.LatinSquare;

import java.util.Arrays;

public class Sudoku extends LatinSquare{
	
	private int iSize;
	private int iSqrtSize;
	
	public Sudoku(int size) 
		throws java.lang.Exception{
		super();
		iSize=size;
		double root=Math.sqrt(size);
		if (root-Math.floor(root)==0) {
			iSqrtSize=(int) root;
		}
		else {
			throw new Exception();
		}
	}
	
	public Sudoku(int[][] puzzle)
		throws java.lang.Exception{
		super(puzzle);
		iSize=puzzle.length;
		double root=Math.sqrt(puzzle.length);
		if (root-Math.floor(root)==0) {
			iSqrtSize=(int) root;
		}
		else {
			throw new Exception();
		}
	}
	
	public int[][] getPuzzle(){
		return getLatinSquare();
	}
	
	public int[] getRegion(int iRegion) throws Exception {
		if (iRegion+1>iSize) {
			throw new Exception();
		}
		int[] region=new int[iSize];
		int RowI=(iRegion/iSqrtSize)*iSqrtSize;
		int RowF=RowI+iSqrtSize;
		int ColI=(iRegion%iSqrtSize)*iSqrtSize;
		int ColF=ColI+iSqrtSize;
		int idx=0;
		for(int iRow=RowI; iRow<RowF; iRow++) {
			for(int iCol=ColI; iCol<ColF; iCol++) {
				int[] row=getRow(iRow);
				region[idx]=row[iCol];
				idx++;
			}
		}
		return region;
	}
	
	public int[] getRegion(int iCol, int iRow) throws Exception {
		int region=(iCol/iSqrtSize)+(iRow/iSqrtSize)*iSqrtSize;
		return getRegion(region);
	}
}
