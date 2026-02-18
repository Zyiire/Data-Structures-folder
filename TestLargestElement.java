 class Node {
    int info;
    Node link;

    public Node(int info){
        this.info = info;
        this.link = null;
    }
}
class LinkedList{ 
    Node head;

    public LinkedList(){
        this.head = null;
    }
    
    public void insertAtEnd(int info){
        Node newNode = new Node(info);
        if(head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.link != null){
            current = current.link;
        }

        current.link = newNode;
    }

    public int findLargestElement(){
        if(head == null){
            return Integer.MIN_VALUE; //this is the smallest possible value an int can hold
        }

        int maxElement = head.info;
        Node current = head.link;
        while(current != null){
            if(current.info > maxElement){
                maxElement = current.info;
            }
            current = current.link;
        }
        return maxElement;
    }
}

public class TestLargestElement{
    public static void main(String [] args){
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(8);

        int largestElement = linkedList.findLargestElement();
        System.out.println("The Largest element in the linked list is: " + largestElement);
    }
}