package test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

interface Shap {
    public void draw();
}

class Circle implements Shap {
    @Override
    public void draw() {
        System.out.println("Inside Circle");
    }
}

class Rectangle implements Shap {
    @Override
    public void draw() {
        System.out.println("Inside rectangle.");
    }
}

class ShapeFactory {
    private Shap shapeInstance;
    public Shap getShapeInstance(String shapeType) {
        if (shapeType.equalsIgnoreCase("Circle")) {
            shapeInstance = new Circle();
        } else if (shapeType.equalsIgnoreCase("Rectangle")) {
            shapeInstance = new Rectangle();
        }
        return shapeInstance;
    }
}

public class Test {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shap instance = shapeFactory.getShapeInstance("Circle");
        instance.draw();
        Shap rectangle = shapeFactory.getShapeInstance("Rectangle");
        rectangle.draw();
        String name ="yashwant";
        Map<Character, Long> map = name.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        String test = "airplane";
//        Arrays.stream(test.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
//        System.out.println("==repetativeCharsMap==="+repetativeCharsMap);
    }
}
