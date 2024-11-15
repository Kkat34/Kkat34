public class Point {

	private int x;
	private int y;

//No-arg Constructor (which is called when we do "new Point()"
public Point() {
		//Constructing a Point: 0 by 0
		this.x = 0;
		this.y = 0;
	}

public Point(int aX, int aY) {
		//Constructing a Point: aX by aY
		this.x = aX;
		this.y = aY;
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

//------------------------------------------
	//Common
public String toString() {
        return "" + this.x + " x " + this.y;
    }

    public static void main(String[] args) {
        // Create an instance of Point
        Point point = new Point();

        // Call methods or perform desired operations
        point.moveToOrigin();
        System.out.println("Point coordinates: " + point.toString());

        point.move1();
        System.out.println("Point coordinates: " + point.toString());
 

 
 
    }

}