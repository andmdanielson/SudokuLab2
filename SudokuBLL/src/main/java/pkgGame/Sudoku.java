package pkgGame;

import pkgHelper.LatinSquare;

import org.apache.commons.lang.ArrayUtils;

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
		if ((iRegion+1>iSize)||(iRegion<0)) {
			throw new Exception("Bad Region Call");
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
	
	public boolean isPartialSudoku() throws Exception {
		boolean iPS=true;
		if(ContainsZero()==false) {
			iPS=false;
			return iPS;
		}
		for(int idx=0; idx<iSize; idx++) {
			int[] iRow=getRow(idx);
			int[] iCol=getColumn(idx);
			int[] iReg=getRegion(idx);
			
			
			int[] iRow_n0=ArrayUtils.removeElement(Arrays.copyOf(iRow, iRow.length), 0);
			int[] iCol_n0=ArrayUtils.removeElement(Arrays.copyOf(iCol, iCol.length), 0);
			int[] iReg_n0=ArrayUtils.removeElement(Arrays.copyOf(iReg, iReg.length), 0);
			
			if(hasDuplicates(iRow_n0)==true) {
				iPS=false;
				break;
			}
			
			if(hasDuplicates(iCol_n0)==true) {
				iPS=false;
				break;
			}
			
			if(hasDuplicates(iReg_n0)==true) {
				iPS=false;
				break;
			}
		}
		return iPS;
	}
}
