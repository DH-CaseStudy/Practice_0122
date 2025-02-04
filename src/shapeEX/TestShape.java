package shapeEX;

import java.util.ArrayList;

public class TestShape {
	public static void main(String[] args) {
		Shape[] shape = new Shape[2];

		shape[0] = new Circle(10);
		shape[0].calculationArea();
		System.out.printf("원의 면적은 ");
		shape[0].print();

		shape[1] = new Rectangular(100.0, 2.0);
		shape[1].calculationArea();
		System.out.printf("직사각형의 면적은 ");
		shape[1].print();

		ArrayList<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle(10));
		shapes.add(new Rectangular(100.0, 2.0));

		for (Shape shape1 : shapes) {
//			if(shape1 instanceof Circle){
//
//			} else if(shape1 instanceof Rectangular){
//
//			}
			shape1.calculationArea();
			shape1.print();
		}
	}
}