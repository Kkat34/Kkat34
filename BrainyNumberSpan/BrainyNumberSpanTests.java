/*
* Hello I'm class BrainyNumberSpanTests
* My job is to do some tests on BrainyNumberSpan
* */

public class BrainyNumberSpanTests {
	
	public static void main(String[] args) {
		BrainyNumberSpanTests tests = new BrainyNumberSpanTests();
		tests.test_countEasilyDivisible();
		tests.test_countAbcFactorsGreaterThan();
		tests.test_countAbcFactorsLessThan();
		tests.test_sumAbcFactors();
	}
	
	//===========================================
	
	private void test_countEasilyDivisible() {
		header("test_countEasilyDivisible");
		BrainyNumberSpan span = new BrainyNumberSpan(1, 10);		
		prn("countEasilyDivisible: " + span.toString() 
				+ " -> " + span.countEasilyDivisible());
		check(span.countEasilyDivisible(), 8);		
	}
	
	private void test_countAbcFactorsGreaterThan() {
		header("test_countAbcFactorsGreaterThan");
		BrainyNumberSpan span = new BrainyNumberSpan(1, 101);		
		prn("countAbcFactorsGreaterThan: " + span.toString() 
				+ " -> " + span.countAbcFactorsGreaterThan(20));
		check(span.countAbcFactorsGreaterThan(20), 23);		
	}		
	
	private void test_countAbcFactorsLessThan() {
		header("test_countAbcFactorsLessThan");
		BrainyNumberSpan span = new BrainyNumberSpan(1, 101);		
		prn("countAbcFactorsGreaterThan: " + span.toString() 
				+ " -> " + span.countAbcFactorsLessThan(5));
		check(span.countAbcFactorsLessThan(5), 1);		
	}	
	
	private void test_sumAbcFactors() {
		header("test_sumAbcFactors");
		BrainyNumberSpan span = new BrainyNumberSpan(11, 20);		
		prn("sumAbcFactors: " + span.toString() 
				+ " -> " + span.sumAbcFactors());
		check(span.sumAbcFactors(), 208);		
	}		
	
	//===========================================
	
	public void check(Object actual, Object expected) {
		if (actual.equals(expected))
			prn("** pass **");
		else
			prnf("FAILED -- actual <%s> vs expected <%s>%n", actual, expected); 
	}
	
	public static void header(String header) {
		prn("\nStarting test: " + header);
	}	

	public static void prn(Object o) {
		System.out.println(o);
	}
	
	public static void prnf(String format, Object... params) {
		System.out.printf(format, params);
	}	

}