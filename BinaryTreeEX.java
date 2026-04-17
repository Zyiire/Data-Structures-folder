class Node{
    int data;
    Node left;
    Node right;

    public Node(int item){
        data = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    Node root;

    BinarySearchTree(){
        root = null;
    }

    void inorder(){
        inorderRec(root);
    }

    void inorderRec(Node root){
        if(root != null){
            inorderRec(root.left);
            System.out.println(root.data + " I ");
            inorderRec(root.right);
        }
    }

}

public class BinaryTreeEX {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);

        System.out.println("Inorder treversal of BST");

        tree.inorder();
    }
}
