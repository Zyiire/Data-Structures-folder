public class LinkedList {
    static class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }

    }

    private Node head = null;

    public void addNode(String data){
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
        public void display(){
            if(head == null){
                System.out.println("List is Empty");
                return;
            }
            Node current = head;
            System.out.println("Linked List: ");
            while(current != null){
                System.out.println(current.data);
                current = current.next;
            }
        }

        public void removeDups(){
            removeDuplicateRecursive(head);
        }
        // recursive helper method to remove duplicates
        private void removeDuplicateRecursive(Node current){
            if(current == null || current.next == null){
                return;
            }

            //check if current Node's data matches the next Node's data
            Node runner = current;
            while(runner != null && runner.next != null){
                if(runner.next.data.equals(current.data)){
                    runner.next = runner.next.next; //skip the duplicate node
                }
                else{
                    runner = runner.next;
                }
            }
            removeDuplicateRecursive(current.next);
        }
       
    public static void main(String[] args) {
            LinkedList list = new LinkedList();

            list.addNode("A");
            list.addNode("B");
            list.addNode("C");
            list.addNode("D");
            list.addNode("B");
            list.addNode("D");
            
            System.out.println("Before removel");

            list.display();

            list.removeDups();

            System.out.println("After removel");

            list.display();
        }
    }
