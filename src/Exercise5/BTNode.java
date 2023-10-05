package src.Exercise5;
public class BTNode {
    private int key;
    private BTNode left;
    private BTNode right;

    public BTNode() { // default constructor
        key = 0;
        left = null;
        right = null;
    }

    public BTNode(int key_){
        key = key_;
        left = null;
        right = null;
    }


    public void setKey(int value) { key = value; }
    public int getKey() { return key; }

    public void setLeftChild(BTNode left_) { left = left_;}
    public BTNode getLeft() { return left; }

    public void setRightChild(BTNode right_) { right = right_;}
    public BTNode getRight() { return right; }
}