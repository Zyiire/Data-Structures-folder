class DoublyLinkedList{
    class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            head.prev = null;
            tail.prev = null;
    } else { 
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        tail.next = null;
    }
}

public void display(){
    Node current = head;
    if(head == null){
        System.out.println("List is Empty");
        return;
    }

    System.out.println("Here are the nodes of the Doubly Linke List");
    while(current != null){  // this is not circular so we will hit null 
        System.out.println(current.data + " ");
        current = current.next;
    }
}
}

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addNode(1);
        dll.addNode(2);
        dll.addNode(3);
        dll.addNode(4);
        dll.addNode(5);

        dll.display();


    }
}
