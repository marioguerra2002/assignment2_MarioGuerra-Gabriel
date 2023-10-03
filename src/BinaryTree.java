package src;
public class BinaryTree {

    private BTNode root;
    public BinaryTree(){
        root = null;
    }

    public int Height (BTNode node) {
        if (node == null) {
            return -1;
        }
        else {
            // int left_height = Height(node.getLeft()); // recursively call the left and right nodes
            // int r ight_height = Height(node.getRight()); 
            // // compare which one is bigger, left or right height and return the bigger one + 1 (the actual node)
            // if (left_height > right_height) { 
            //     return left_height + 1;
            // }
            // else {
            //     return right_height + 1;
            // }
            /// alternativa
            int leftHeight = Height(node.getLeft()); // recursively call the left and right nodes
            int rightHeight = Height(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1; // return the bigger one + 1 (the actual node)
        }
    }
    
    public int Size(BTNode node){
        if (node == null) {
            return 0;
        }
        else {
            return Size(node.getLeft()) + Size(node.getRight()) + 1; // its goign to return the size of the left and right nodes + 1 (the actual node)
        }
    }
    public BTNode PlaceToAdd(BTNode node, int key) { // add_
        if (node == null) {
            return new BTNode(key); // if the node is null, return a new node with the key
        }
        if (key < node.getKey()) { // if the key is less than the node key, go to the left
            node.setLeftChild(PlaceToAdd(node.getLeft(), key)); // recursively call the left node until it reaches a null node
        }
        else if (key > node.getKey()) { // if the key is greater than the node key, go to the right
            node.setRightChild(PlaceToAdd(node.getRight(), key)); // recursively call the right node until it reaches a null node
        }
        
        return node; // return the node
    }

    // public void Add(int key){
    //     root = PlaceToAdd(root, key); // call the PlaceToAdd method and set the root to the node returned by the method to add the node

    // }

    public boolean Contains(){
        boolean flag = false;
        return flag;
    }
    public void InOrder(BTNode node){
        if (node != null) {
            InOrder(node.getLeft()); // recursively call the left node
            System.out.println(node.getKey()); // print the node key
            InOrder(node.getRight()); // recursively call the right node
        }
    }
    public BTNode Remove(BTNode node, int key){
        if (node == null) {
            return null;
        }
        if (node.getKey() > key) {
            node.setLeftChild(Remove(node.getLeft(), key)); // recursively call the left node until it reaches a null node
        } else if (node.getKey() < key) {
            node.setRightChild(Remove(node.getRight(), key)); // recursively call the right node until it reaches a null node
        }
        else { // if the node to delete is found
            if (node.getRight() == null) {  // if the right node is null
                return node.getLeft(); // return the left node
            }
            else if (node.getLeft() == null) { // if the left node is null
                return node.getRight(); // return the right node
            }
            node.setKey(Min(node.getRight())); // set the node key to the minimum value of the right node
            node.setRightChild(Remove(node.getRight(), node.getKey())); // recursively call the right node until it reaches a null node
        }
        return node;
 
    }
    public int Min(BTNode node){
        if (node.getLeft() == null) {
            return node.getKey();
        }
        else {
            return Min(node.getLeft()); // recursively call the left node until it reaches a null node (left is always smaller)
        }
    }
    public boolean Contains(BTNode node, int key){  // key is the value we are looking for
        if (node == null) {
            return false;
        }
        if (node.getKey() > key) {
            return Contains(node, key);
        } else if (node.getKey() < key) {
            return Contains(node, key);
        } else {  // => node.getKey() == key (if it's found)
            return true;
        }
    }
    public static void main(String[] args)  {
        
    }
}
