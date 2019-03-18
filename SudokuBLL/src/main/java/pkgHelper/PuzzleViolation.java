package pkgHelper;

import pkgEnum.ePuzzleViolation;

public class PuzzleViolation {
	private ePuzzleViolation ePuzzleViolation;
	private int iValue;
	
	public PuzzleViolation(ePuzzleViolation ePV, int iV) {
		ePuzzleViolation=ePV;
		iValue=iV;
	}
	
	public ePuzzleViolation getePuzzleViolation() {
		return ePuzzleViolation;
	}
	
	public int getiValue() {
		return iValue;
	}
}
