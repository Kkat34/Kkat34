class Point {
    private int x;
    private int y;
    
    
    public Point(int x, int y, Frame frame) {
        this.x = x;
        this.y = y;
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Frame {
    private int leftX;
    private int topY;
    private int rightX;
    private int bottomY;

    public Frame(int leftX, int topY, int rightX, int bottomY) {
        this.leftX = leftX;
        this.topY = topY;
        this.rightX = rightX;
        this.bottomY = bottomY;
    }

public boolean contains(Point point) {
        int pointX = point.getX();
        int pointY = point.getY();
        
        return leftX <= pointX && rightX >= pointX
                && topY <= pointY && bottomY >= pointY;
    }

public boolean contains(Frame otherFrame) {
        return leftX <= otherFrame.leftX && rightX >= otherFrame.rightX
                && topY <= otherFrame.topY && bottomY >= otherFrame.bottomY;
    }

 public int getLeftX() {
        return leftX;
    }

    public int getTopY() {
        return topY;
    }

    public int getRightX() {
        return rightX;
    }

    public int getBottomY() {
        return bottomY;
    }

    public int getWidth() {
    return rightX - leftX;
    }

    public int getHeight() {
    return bottomY - topY;
    }

    public boolean containsVert(Frame otherFrame) {
        return (leftX <= otherFrame.leftX && rightX >= otherFrame.rightX);
    }
public boolean containsHoriz(Frame otherFrame) {
        return (topY <= otherFrame.topY && bottomY >= otherFrame.bottomY);
    }
    public boolean intersects(Frame otherFrame) {
        return leftX < otherFrame.rightX && rightX > otherFrame.leftX
                && topY < otherFrame.bottomY && bottomY > otherFrame.topY;
    }

    public boolean containsX(int x) {
        return leftX < x && rightX > x;
    }

    public boolean containsY(int y) {
        return topY < y && bottomY > y;
    }

    public Point getMiddle() {
    int middleX = leftX + (rightX - leftX) / 2;
    int middleY = topY + (bottomY - topY) / 2;

    return new Point(middleX, middleY, this);
    }

    public static void main(String[] args) {
        Frame frame1 = new Frame(0, 0, 10, 10);
        Frame frame2 = new Frame(2, 2, 8, 8);
        Frame frame3 = new Frame(5, 5, 15, 15);

        Point point1 = new Point(5, 5, frame1);
        Point point2 = new Point(15, 15, frame1);
        Point middle = frame1.getMiddle();
        System.out.println(frame1.contains(point1)); // Output: true
        System.out.println(frame1.contains(point2)); // Output: false

        System.out.println("Middle point of the frame: (" + middle.getX() + ", " + middle.getY() + ")");
        System.out.println("Width of the frame: " + frame1.getWidth()); // Output: 10
        System.out.println("Height of the frame: " + frame1.getHeight()); // Output: 10

        System.out.println(frame1.containsX(5)); // Output: true
        System.out.println(frame1.containsX(15)); // Output: false

        System.out.println(frame1.containsY(5)); // Output: true
        System.out.println(frame1.containsY(15)); // Output: false

        System.out.println(frame1.contains(frame2)); // Output: true
        System.out.println(frame1.containsVert(frame2)); // Output: true
        System.out.println(frame1.containsHoriz(frame2)); // Output: true

        System.out.println(frame1.intersects(frame3)); // Output: true
    }
}
