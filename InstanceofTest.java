/*Write a complete Java program that does the following:
- declares interfaces I1 and I2, both with empty bodies.
- declare interface I3 with an empty body, which extends both of the above interfaces
- declare interface I4 with an empty body
- class X implements I3 with an empty body
- class W with an empty body implements I4 and extends X
- create a class InstanceofTest that does the following in the main( ):
** create an object w of class W.
** Use the instanceof operator to test if the object w implements each of the interfaces
and is of type X, and display the appropriate message.
 */

interface I1 {
    
}

interface I2 {
    
}

interface I3 extends I1, I2 {
    
}

interface I4 {
    
}

class X implements I3{

}

class W extends X implements I4{

}

public class InstanceofTest{
    public static void main(String[] args){
        W w = new W();

        if (w instanceof I1) {
            System.out.println("w implements I1");
        }
        if (w instanceof I2) {
            System.out.println("w implements I2");
        }
        if (w instanceof I3) {
            System.out.println("w implements I3");
        }
        if (w instanceof I4) {
            System.out.println("w implements I4");
        }
        if (w instanceof X) {
            System.out.println("w is of type X");
        }
    }
}

