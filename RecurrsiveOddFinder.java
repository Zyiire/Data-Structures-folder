public class RecurrsiveOddFinder {
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

    public void findOddRecursive(Node current){
        if(current == null){
            return;
        }
        if(current.data % 2 != 0){
            System.out.print(current.data + " ");
        }

        findOddRecursive(current.next);
    }
        public void findOddElements(){
            System.out.println("Odd Elements");
            findOddRecursive(head);
            System.out.println();
        }
        public static void main(String[] args) {
            RecurrsiveOddFinder list = new RecurrsiveOddFinder();

            list.addNode(10);
            list.addNode(15);
            list.addNode(20);
            list.addNode(19);
            list.addNode(30);

            list.findOddElements();
        }
    }
 
    

