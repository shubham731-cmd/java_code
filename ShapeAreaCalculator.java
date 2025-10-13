
abstract class Shape {
    abstract double getArea();

    void printType() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return 3.14 * radius * radius;
    }

    @Override
    void printType() {
        System.out.println("This is a Circle.");
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double getArea() {
        return length * width;
    }

    @Override
    void printType() {
        System.out.println("This is a Rectangle.");
    }
}

class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double getArea() {
        return 0.5 * base * height;
    }

    @Override
    void printType() {
        System.out.println("This is a Triangle.");
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);
        Shape s3 = new Triangle(3, 8);

        Shape[] shapes = {s1, s2, s3};

        for (Shape s : shapes) {
            s.printType();
            System.out.println("Area: " + s.getArea());
            System.out.println();
        }
    }
}
