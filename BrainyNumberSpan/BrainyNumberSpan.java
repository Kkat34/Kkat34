/*
* Hello I'm class BrainyNumberSpan
* 
* I represent a span starting at number 'left'
* and ending on number 'right'
* 
* For example, if my 'left' = 10
* and my 'right' = 15
* 
* Then I span five numbers (10, 11, 12, 13, and 14)
* 
* Note that the 'left' boundary is *included* in the span.
* Note that the 'right' boundary is *excluded* in the span.
*   
* My purpose is to provide a user friendly methods to
* operate over my span
* 
* The ivars left and right are positive integers
* */ 

public class BrainyNumberSpan {
	
	private int left;	//left boundary of span (include boundary)
	private int right;	//right boundary of span (exclude boundary)	

	/** No-Arg Constructor */
	public BrainyNumberSpan() {
		this.left = 0;
		this.right = 0;
	}	
	
	/** One-Arg Constructor */
	public BrainyNumberSpan(int aLeft, int aRight) {
		this.left = aLeft;
		this.right = aRight;
	}	
	
	/** Static Factory Constructor */
	public static BrainyNumberSpan fromLeftRight(int aLeft, int aRight) {
		return new BrainyNumberSpan(aLeft, aRight);
	}	

	/** Getter */
	public int getLeft() {
		return this.left;
	}
	
	/** Getter */
	public int getRight() {
		return this.right;
	}	
	
	/** Simply return nice string */
	@Override
	public String toString() {
		return String.format("[%d - %d]", this.getLeft(), this.getRight());
	}

	// Computation Instance Methods
	
	/* Returns a count of easily divisible numbers in this number span.
	 * The definition of easily divisible can be found in BrainyNumber */ 
	public int countEasilyDivisible() {
		int count = 0;
		for (int n = this.getLeft(); n < this.getRight(); n++) {
			BrainyNumber bn = new BrainyNumber(n);
			if (bn.isEasilyDivisible())
				++count;
		}
		return count;
	}
	
	/* Returns a count of abcFactors in this number span
	 * that are greater than the passed in method parameter (an `i`int)
	 * The definition of abcFactors can be found in BrainyNumber */ 
	public int countAbcFactorsGreaterThan(int threshold) {
		//Cound abcFactors within span that are greater than threshold
		int count = 0;
		for (int n = this.getLeft(); n < this.getRight(); n++) {
			BrainyNumber bn = new BrainyNumber(n);
			if (bn.abcFactor() > threshold)
				++count;
		}
		return count;
	}	
	
	/* Returns a count of abcFactors in this number span
	 * that are less than the passed in method parameter (an `i`int)
	 * The definition of abcFactors can be found in BrainyNumber */ 
	public int countAbcFactorsLessThan(int threshold) {
		int count = 0;
		for (int n = this.getLeft(); n < this.getRight(); n++) {
			BrainyNumber span = new BrainyNumber(n);
			if (span.abcFactor() < threshold)
				++count;
		}
		return count;
	}	
	
	/* Returns a sum of abcFactors in this number span */
	public int sumAbcFactors() {
		int sum = 0;
		for (int n = this.getLeft(); n < this.getRight(); n++) {
			BrainyNumber span = new BrainyNumber(n);
			sum += span.abcFactor();
		}
		return sum;
	}			
	
	
}
