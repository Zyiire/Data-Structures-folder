/* Fix this and find the average of the Node class elements not of random 
double variables. */

class Node{
    int info;
    Node link;

public Node(int info){
    this.info = info;
    this.link = link;
 }
}

class LinkedList{
    Node head;

    public LinkedList(){
        this.head = head;
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
public double calculateAvg(){
if(head == null){
return 0.0; //if list is empty
}
int sum = 0;
int count = 0;
Node current = head;
while(current != null){
sum += current.info;
count++;
current = current.link;
}

return (double) sum / count;
}
}

public class AverageLinkedListTest{
public static void main(String [] args){
LinkedList linkList = new LinkedList();
linkList.insertAtEnd(5);
linkList.insertAtEnd(10);
linkList.insertAtEnd(3);
linkList.insertAtEnd(8);

double avg = linkList.calculateAvg();
System.out.println("Average of all elements: " + avg);
}

}
