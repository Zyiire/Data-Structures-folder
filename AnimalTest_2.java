/*Write the code for all the necessary classes and/or interfaces for a solution to the problem below.
Focus on class structure and interaction. You may implement your solution however you wish, but you will be 
graded on the appropriateness of your solution to the requirements. Note the use of capitalization and bold for 
clarification in the problem. You may use whatever constructors or additional methods you wish.
-   Define a structure that can represent Animals.
-   A general Animal should not be able to be instantiated and has a permanent name for its lifetime.
-   Animals have two behaviors; they can speak() and they can move(). By default, when an animal moves, 
the message "This animal moves forward" is displayed. By default, when an animal speaks, the message 
"This animal speaks" is displayed.
-   Define also two classes, Goose and Lynx, that are Animals. Both Goose and Lynx behave such that where
"animal" is displayed in speak() or move ), "goose" or "lynx" is displayed by the appropriate classes. Define 
the default constructors to accomplish this.
-   Finally, any instance of Goose can fly(), just as any Flying object can.
-   An Airplane is also a Flying object. Define the Airplane class such that it is Flying and make sure that any 
instance of Goose is also Flying. The specific behaviors when instances of either class fly() should display in 
the message: the class name and name of object soars, wings flapping for a Goose or the message the class name 
and name of object soars, engines running for an Airplane..
You may use getName() ).get.Class()
-   Instances of either Goose or Airplane should be able to be stored in a variable of type Flying.
-   All classes should include default constructors and if needed overloaded constructors
-   Hand in all abstract classes, classes and interfaces along with a client class that demonstrates the 
different behaviors for a Lynx, Goose and Airplane. You also must provide a screen shot of your output. */

abstract class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void speak() {
        System.out.println("This animal speaks");
    }

    public void move() {
        System.out.println("This animal moves forward");
    }
}

interface Flying {
    void fly();
}

class Goose extends Animal implements Flying {
    public Goose() {
        super("Goose");
    }

    public Goose(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("This goose speaks");
    }

    @Override
    public void move() {
        System.out.println("This goose moves forward");
    }

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName() + " " + getName() + " soars, wings flapping");
    }
}

class Lynx extends Animal { 
    public Lynx() {
        super("Lynx");
    }

    public Lynx(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("This lynx speaks");
    }

    @Override
    public void move() {
        System.out.println("This lynx moves forward");
    }
}

class Airplane implements Flying {
    private final String name;

    public Airplane() {
        this.name = "Airplane";
    }

    public Airplane(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName() + " " + getName() + " soars, engines running");
    }
}

public class AnimalTest_2 {
    public static void main(String[] args) {
        Lynx lynx = new Lynx("Leo");
        Goose goose = new Goose("Gary");
        Airplane airplane = new Airplane("Boeing 747");

        System.out.println("=== Lynx Behaviors ===");
        lynx.speak();
        lynx.move();

        System.out.println("\n=== Goose Behaviors ===");
        goose.speak();
        goose.move();
        goose.fly();

        System.out.println("\n=== Airplane Behaviors ===");
        airplane.fly();

        System.out.println("\n=== Flying Objects ===");
        Flying[] flyingObjects = new Flying[2];
        flyingObjects[0] = goose;
        flyingObjects[1] = airplane;

        for (Flying f : flyingObjects) {
            f.fly();
        }
    }
}
