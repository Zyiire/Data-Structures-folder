public class LinLinkList<T> {

    static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> head = null;

    public void addNode(T data){

        Node<T> newNode = new Node<>(data);

        if(head == null){
            head = newNode;
        }else{
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }

        Node<T> current = head;
        while(current != head){
            System.out.println(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public void addAll(T[] items){
        if(items == null || items.length == 0){
            return;
        }
        for(T item : items){
            addNode(item);

        }

    }

    public static void main(String[] args) {
        LinLinkList<String> list = new LinLinkList<>();
        list.addNode("A");
        list.addNode("B");
        list.addNode("S");

        list.display();

        String[] newItems = {"C", "D", "E"};

        list.addAll(newItems);

        System.out.println("After Adding the Array: ");
        list.display();


    }
}
