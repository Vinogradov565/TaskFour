class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;
    protected boolean canSwim;

    public Animal(String name, int runLimit, int swimLimit, boolean canSwim) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.canSwim = canSwim;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (canSwim && distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может плыть " + distance + " м.");
        }
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name, 500, 10, true);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name, 200, 0, false);
    }
}

public class main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");
        Dog dog1 = new Dog("Бобик");

        cat1.run(150);
        cat1.swim(10);

        cat2.run(250);
        cat2.swim(5);

        dog1.run(600);
        dog1.swim(8);
    }
}
// Интерфейс для геометрических фигур
interface Shape {
    double calculatePerimeter();
    double calculateArea();
    String getFillColor();
    String getBorderColor();
}

// Базовый класс для фигур
abstract class AbstractShape implements Shape {
    private String fillColor;
    private String borderColor;

    public AbstractShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Класс для круга
class Circle extends AbstractShape {
    private double radius;

    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Класс для прямоугольника
class Rectangle extends AbstractShape {
    private double width;
    private double height;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// Класс для треугольника
class Triangle extends AbstractShape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

 class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0, "Red", "Black");
        Rectangle rectangle = new Rectangle(4.0, 6.0, "Blue", "Green");
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, "Yellow", "Purple");

        // Вывод характеристик фигур
        System.out.println("Circle - Perimeter: " + circle.calculatePerimeter() +
                ", Area: " + circle.calculateArea() +
                ", Fill Color: " + circle.getFillColor() +
                ", Border Color: " + circle.getBorderColor());

        System.out.println("Rectangle - Perimeter: " + rectangle.calculatePerimeter() +
                ", Area: " + rectangle.calculateArea() +
                ", Fill Color: " + rectangle.getFillColor() +
                ", Border Color: " + rectangle.getBorderColor());

        System.out.println("Triangle - Perimeter: " + triangle.calculatePerimeter() +
                ", Area: " + triangle.calculateArea() +
                ", Fill Color: " + triangle.getFillColor() +
                ", Border Color: " + triangle.getBorderColor());
    }
}