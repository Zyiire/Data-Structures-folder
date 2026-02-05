/*
1. Consider the following classes and interfaces.
-   The abstract class Animal has abstract subclasses named Bird and Reptile.
-   Classes Dove, Eagle, Hawk, Penguin, and Seagull extend Bird.
-   Classes Rattlesnake and Turtle extend Reptile.
-   The ColdBlooded interface defines no constants and declares no methods.
**It is implemented by Reptile.
- The OceanDwelling interface also defines no constants and declares no methods.
** It is implemented by the Penguin, Seagull, and Turtle classes.
- Write a program that defines all of these classes and implements the interfaces as specified.
*  * Create 1 instance of each class.
*  * Then display ALL cold-blooded animals and ALL ocean-dwelling animals.
 */

abstract class Animal {
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

abstract class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
}

abstract class Reptile extends Animal implements ColdBlooded{
    public Reptile(String name) {
        super(name);
    }
}

class Dove extends Bird {
    public Dove(String name) { super(name); }
}
class Eagle extends Bird {
    public Eagle(String name) { super(name); }
}
class Hawk extends Bird {
    public Hawk(String name) { super(name); }
}
class Panguine extends Bird implements OceanDwelling{
    public Panguine(String name) { super(name); }
}
class Seagull extends Bird implements OceanDwelling{
    public Seagull(String name) { super(name); }
}

class Rattlesnake extends Reptile{
    public Rattlesnake(String name) { super(name); }
}

class Turtle extends Reptile implements OceanDwelling{
    public Turtle(String name) { super(name); }
}

interface ColdBlooded {

}

interface OceanDwelling {

}

public class AnimalTest_1{
    public static void main(String[] args){
        Animal[] animals = new Animal[7];
        animals[0] = new Dove("Dove");
        animals[1] = new Eagle("Eagle");
        animals[2] = new Hawk("Hawk");
        animals[3] = new Panguine("Penguin");
        animals[4] = new Seagull("Seagull");
        animals[5] = new Rattlesnake("Rattlesnake");
        animals[6] = new Turtle("Turtle");

        System.out.println("Cold-blooded animals: ");
        for(Animal animal : animals){
            if(animal instanceof ColdBlooded){
                System.out.println(animal.getName());
            }
        }
        System.out.println("Ocean-dwelling animals: ");
        for(Animal animal : animals){
            if(animal instanceof OceanDwelling){
                System.out.println(animal.getName());
            }
        }
    }
}