package example.corejava.designpatterns;

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle class");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle class");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square class");
    }
}

class ShapeFactory {
    private Shape instanceType;

    public Shape getInstanceType(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("CIRCLE")) {
            instanceType = new Circle();
        } else if (type.equalsIgnoreCase("RECTANGLE")) {
            instanceType = new Rectangle();
        } else if (type.equalsIgnoreCase("SQUARE")) {
            instanceType = new Square();
        }
        return instanceType;
    }
}
public class Factory {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getInstanceType("CIRCLE");
        circle.draw();

        Shape rectangle = shapeFactory.getInstanceType("RECTANGLE");
        rectangle.draw();

        Shape square = shapeFactory.getInstanceType("Square");
        square.draw();
    }
}
