package shapeEX;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculationArea() {
        //System.out.println("원의 면적은 " + radius * radius * Math.PI);
        this.area = radius * radius * Math.PI;
    }
}
