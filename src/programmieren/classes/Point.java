package programmieren.classes;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        return String.format("Punkt mit Koordinaten: x = %f, y = %f", this.x, this.y);
    }

    public double distanceToStart() {
        return Math.sqrt(Math.pow((this.x - 0), 2) + Math.pow((this.y - 0), 2));
    }

    public double getDistance(Point point) {
        return Math.sqrt(Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2));
    }

    public Point spiegelungX() {
        return new Point(-this.x, this.y);
    }

    public Point spiegelungY() {
        return new Point(this.x, -this.y);
    }

    public Point mirrorOrigin() {
        return new Point(-this.x, -this.y);
    }

    public static void main(String[] args) {
        Point pointA = new Point(4.0, 2.0);
        System.out.println("A: " + pointA);
        Point pointB = new Point(-1.0, -1.0);
        System.out.println("B: " + pointB);
        System.out.println("Abstand A-B: "
                + pointA.getDistance(pointB));
        pointA = pointA.mirrorOrigin();
        System.out.println("A': " + pointA);
        System.out.println("Abstand A’-B: "
                + pointA.getDistance(pointB));
    }

}
