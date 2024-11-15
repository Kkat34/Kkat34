public class PointTests {

        public void prn(Object o)  {
		System.out.println(o);
	}

        public void testNoArgConstructor()  {

		Point point;
		point = new Point();
		prn("\n-- testNoArgConstructor --");
		prn("Expected: 0 x 0");
		prn("Actual: " + point.toString());
	}

	public void testConstructorWithOneParam()  {

		Point point;
		point = new Point(5);
		prn("\n-- testConstructorWithOneParam --");
		System.out.println("Expected: 5 x 5");
		System.out.println("Actual: " + point.toString());
	}

	public void testConstructorWithTwoParams()  {
		Point point;
		point = new Point(12, 7);
		System.out.println("\n-- testConstructorWithTwoParams --");
		System.out.println("Expected: 12 x 7");
		System.out.println("Actual: " + point.toString());
	}

	public void testMoveToOrigin() {
             Point point;

		point = new Point();

		point.moveToOrigin();

		System.out.println("-- testMoveToOrigin --");
		System.out.println("Expected X: " + 0);
		System.out.println("Expected Y: " + 0);
		System.out.println("Actual X: " + point.getX());
		System.out.println("Actual Y: " + point.getY());

	}

	public void testMove1() {
            Point point;

		point = new Point();

		point.move1();

		System.out.println("-- testMove1--");
		System.out.println("Expected X: " + 100);
		System.out.println("Expected Y: " + 70);
		System.out.println("Actual X: " + point.getX());
		System.out.println("Actual Y: " + point.getY());

	}

        public void testSetX() {
            Point point;

		point = new Point();

		point.setX(5);

		System.out.println("-- testSetX--");
		System.out.println("Set X to 5");
		System.out.println("Actual X: " + point.getX());
		
	}

        public void testSetY() {
            Point point;

		point = new Point();

		point.setY(7);

		System.out.println("-- testSetY--");
		System.out.println("Set Y to 7");
		System.out.println("Actual Y: " + point.getY());
		
	}

        public void testSet() {
            Point point;

		point = new Point();

		point.set(5,7);

		System.out.println("-- testSet--");
		System.out.println("Set X to 5");
		System.out.println("Set Y to 7");
		System.out.println("Actual X: " + point.getX());
		System.out.println("Actual Y: " + point.getY());

	}

        
        

	//=======================================

	public static void main(String[] args) {
		PointTests test = new PointTests();
		test.testMoveToOrigin();
		test.testMove1();
                test.testSetX();
                test.testSetY();
                test.testSet();
                test.testSet();
                test.testNoArgConstructor();
		test.testConstructorWithOneParam();
		test.testConstructorWithTwoParams();
	}

}