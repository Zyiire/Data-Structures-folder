class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode (int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree{
    TreeNode root;

    public BinaryTree(int val){
        this.root = new TreeNode(val);
    }

    public void addNode(int val){
        addNodeRecursively(root, val);
    }

    public void addNodeRecursively(TreeNode node, int val){
        if(node.left == null){
            node.left = new TreeNode(val);
        } else if (node.right == null){
            node.right = new TreeNode(val);
        } else{
            addNodeRecursively(node.left, val);
        }
    }

    public int sumTree(TreeNode node){
        if(node == null){
            return 0;
        }
        return node.val + sumTree(node.left) + sumTree(node.right);
    }

    public int sumTree(){
        return sumTree(root);
    }
}

public class TreeNodeEX {
 
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);

        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(5);
        tree.addNode(6);
        tree.addNode(7);

        int sum = tree.sumTree();

        System.out.println("Sum of the numbers is: " + sum);
    }
}
