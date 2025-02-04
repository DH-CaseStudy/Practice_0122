package shapeEX;

public class Rectangular extends Shape {
    private double width;
    private double height;

    public Rectangular(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void calculationArea() {
        //System.out.println("직사각형의 면적은 " + width * height);
        this.area = width * height;
    }
}
