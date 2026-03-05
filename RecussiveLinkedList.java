public class RecussiveLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }

    }

    private Node head = null;

    public void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = current;
        }
    }

    // recurrion to display the list forward
    public void displayRecurr(Node current){
        if(current == null){
            return;
        } 
        System.out.println(current.data);
        displayRecurr(current.next);
    }

    public void display(){
        System.out.println("Linked List");
        displayRecurr(head);
        System.out.println();
    }

    public static void main(String[] args) {
        
        RecussiveLinkedList list = new RecussiveLinkedList();

        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);

        list.display();
    }
    
}
