public class Point {

	private int x;
	private int y;


//No-arg Constructor (which is called when we do "new Point()"
public Point() {
		//Constructing a Point: 0 by 0
		this.x = 0;
		this.y = 0;
	}

public Point(int aValue) {
		//Constructing a Value: aValue by aValue
		//A value is  special type of point
		this.x = aValue;
		this.y = aValue;
        }

public void moveToOrigin() {
		//Set ivars to arbritrary small values
		this.x = 0;
		this.y = 0;
	}

public void move1() {
		//Set ivars to arbritrary large values
		this.x = 100;
		this.y = 70;
	}

public void setX(int aValue) {
		this.x = aValue;
	}

public void setY(int aValue) {
		this.y = aValue;
        }

public void set(int aValue) {
		this.x= aValue;
                this.y= aValue;
	}

public void set(int aX, int aY) {
		this.x = aX;
                this.y = aY;
	}

//------------------------------------------
	//Getters

public int getX() {
		return this.x;
	}
public int getY() {
		return this.y;
	}
public boolean isBalanced() {
                return x == y;
        }
public boolean isAtOrigin() {
                return x == 0 && y == 0;
        }
public boolean reset(boolean resetX, boolean resetY) {
        if (resetX) {
            x = 0;
        }
        
        if (resetY) {
            y = 0;
        }
        
        return x == 0 && y == 0;
    }
public void print(boolean option) {
        if (option) {
            System.out.println("Point coordinates: (" + x + ", " + y + ")");
            if (x > 2 && y > 2) {
                System.out.println("Both x and y are greater than 2.");
            } else {
                System.out.println("At least one of x or y is not greater than 2.");
            }
        } else {
            System.out.println("Point coordinates: (" + x + ", " + y + ")");
        }
    }
 public boolean isRightOf(Point otherPoint) {
        return this.x > otherPoint.getX();
    }
public boolean isRightAndAbove(Point otherPoint) {
        return this.x > otherPoint.x && this.y > otherPoint.y;
    }
public Point(int x, int y) {
    this.x = x;
    this.y = y;
}

public String toString() {
    return "" + this.x + " x " + this.y;
}
public class RectangleChecker {
    private int leftX;
    private int topY;
    private int width;
    private int height;

    public RectangleChecker(int leftX, int topY, int width, int height) {
        this.leftX = leftX;
        this.topY = topY;
        this.width = width;
        this.height = height;
    }

    public boolean isPointInsideRectangle(int x, int y) {
        if (x >= leftX && x <= leftX + width && y >= topY && y <= topY + height) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Create an instance of Point
        Point point = new Point();

        // Call methods or perform desired operations
        point.moveToOrigin();
        System.out.println("Point coordinates: " + point.toString());
        point.print(true);
        point.move1();
        System.out.println("Point coordinates: " + point.toString());
 

 
 
    }
 }

}