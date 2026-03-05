class Node<T>{
    T info; 
    Node<T> link;

    public Node(T info){
        this.info = info;
        this.link = null;
    }
     
}

class LinkedList<T extends Number>{
    Node<T> head;

    public LinkedList(){
        this.head = head;
    }

    public void insertAtEnd(T info){
        Node<T> newNode = new Node<>(info);
        if(head == null){
            head = newNode;
            return;
        }
        Node<T> current = head;
        while(current.link != null){
            current = current.link;
    }   
    current.link = current;
 }

 public double calProduct(){
    if(head == null){
        return 1.0; // assume the Product starts at 1
    }

    double product = 1.0;
    Node<T> current = head;
    while(current != null){
        product *= current.info.doubleValue();
        current = current.link;
    }
    return product;
 }

}

public class TestLLProduct{
    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();
        intList.insertAtEnd(5);
        intList.insertAtEnd(10);
        intList.insertAtEnd(3);
        intList.insertAtEnd(8);

        double prodInt = intList.calProduct();
        System.out.println("The product of all elements in the Integer linked list: " + prodInt);

         LinkedList<Double> doubList = new LinkedList<>();
        doubList.insertAtEnd(5.0);
        doubList.insertAtEnd(10.3);
        doubList.insertAtEnd(3.6);
        doubList.insertAtEnd(8.9);

        double prodDoub = doubList.calProduct();
        System.out.println("The product of all elements in the DOUBLE linked list: " + prodDoub);
    }
}