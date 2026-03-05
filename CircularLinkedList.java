public class CircularLinkedList {
    static class Node{
        int data;
        Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
    }

    private Node head = null;
    private Node tail = null;

    public void addNode(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;

            newNode.next = head;  //make it circular
         } else {
            tail.next = newNode;  // add new node after tail
            tail = newNode;
            tail.next = head;   // circular
         }
    }


    public void display(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }

        Node current = head;
        System.out.println("Circular linked list:");

        do{ 
            System.out.print(current.data + " ");
            current = current.next;
        }while(current != head);

        System.out.println();
    }

    public int computeSum() {
        if (head == null) {
            return 0;
        }

        int sum = 0;
        Node current = head;

        do {
            sum += current.data;
            current = current.next;
        } while (current != head);

        return sum;
    }

    public int findMax() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        int max = head.data;
        Node current = head.next;

        while (current != head) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }

        return max;
    }

    public void showCircularNature(int iterations) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Demonstrating circular nature (" + iterations + " iterations):");
        Node current = head;
        for (int i = 0; i < iterations; i++) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("(continues...)");
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.addNode(10);
        cll.addNode(20);
        cll.addNode(30);
        cll.addNode(40);

        cll.display();

        System.out.println("Illistrate circular nature");
        Node current = cll.head;
        for(int i = 0; i < 10; i++){
            System.out.println(current.data+ " ");
            current = current.next;
        }
    }
}
