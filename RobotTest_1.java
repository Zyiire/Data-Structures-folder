/*2. Write an application that combines several classes and interfaces.
-   The abstract class Robot has concrete subclasses named RobotA, RobotB, and RobotC.
-   Class RobotA1 extends RobotA.
-   Classes RobotB1 and RobotB2 extend RobotB.
-   Class RobotC1 extends RobotC.
-   The Locomotion interface declares 3 methods named forward(), reverse(), and stop().
** It is implemented by classes RobotB and RobotC.
- The Sound interface declares 1 method named beep().
** It is implemented by classes RobotA1, RobotB1, and RobotC.
-   Define all of these classes and implement the interfaces as specified.
-   Create 1 instance of each class.
-   Then invoke the beep() method of all objects that are of type Sound.
-   Also invoke the stop() method of all objects that are of type Locomotion. */

abstract class Robot {
    protected String sound;
    protected String locomotion;
    public Robot(String sound, String locomotion){
        this.sound = sound;
        this.locomotion = locomotion;
    }
}

abstract class RobotA extends Robot {
    public RobotA(String sound, String locomotion){
        super(sound, locomotion);
}
}

abstract class RobotB extends Robot implements Locomotion {
    public RobotB(String sound, String locomotion){
        super(sound, locomotion);
}
}

abstract class RobotC extends Robot implements Locomotion, Sound {
    public RobotC(String sound, String locomotion){
        super(sound, locomotion);
    }
    public void beep() { System.out.println(sound); }
}

class RobotA1 extends RobotA implements Sound{
    public RobotA1(String sound, String locomotion){
        super(sound, locomotion);
    }
    public void beep() { System.out.println(sound); }
}

class RobotB1 extends RobotB implements Sound{
    public RobotB1(String sound, String locomotion){
        super(sound, locomotion);
    }
    public void forward() { System.out.println(locomotion + " forward"); }
    public void reverse() { System.out.println(locomotion + " reverse"); }
    public void stop() { System.out.println(locomotion + " stop"); }
    public void beep() { System.out.println(sound); }
}

class RobotB2 extends RobotB{
    public RobotB2(String sound, String locomotion){
        super(sound, locomotion);
    }
    public void forward() { System.out.println(locomotion + " forward"); }
    public void reverse() { System.out.println(locomotion + " reverse"); }
    public void stop() { System.out.println(locomotion + " stop"); }
}

class RobotC1 extends RobotC{
    public RobotC1(String sound, String locomotion){
        super(sound, locomotion);
    }
    public void forward() { System.out.println(locomotion + " forward"); }
    public void reverse() { System.out.println(locomotion + " reverse"); }
    public void stop() { System.out.println(locomotion + " stop"); }
}

interface Locomotion{
    void forward();
    void reverse();
    void stop();
}

interface Sound{
    void beep();
}

public class RobotTest_1{
    public static void main(String[] args){
        Robot[] robots = new Robot[4];
        robots[0] = new RobotA1("Beep A1", "Walk");
        robots[1] = new RobotB1("Beep B1", "Roll");
        robots[2] = new RobotB2("Beep B2", "Slide");
        robots[3] = new RobotC1("Beep C1", "Fly");

        System.out.println("Sound Robots:");
        for(Robot robot : robots){
            if(robot instanceof Sound){
                ((Sound)robot).beep();
            }
        }

        System.out.println("\nLocomotion Robots:");
        for(Robot robot : robots){
            if(robot instanceof Locomotion){
                ((Locomotion)robot).stop();
            }
        }
    }
}
