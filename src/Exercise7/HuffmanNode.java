package src.Exercise7;
public class HuffmanNode {
    private char key;
    private int frecuency;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(char key_, int frecuency_){
        key = key_;
        frecuency = frecuency_;
        left = null;
        right = null;
    }

    public void setKey(char value) { key = value; }
    public int getKey() { return key; }
    public void setLeftChild(HuffmanNode leftNode) { left = leftNode;}
    public void setRightChild(HuffmanNode righNode) {right = righNode;}
    public HuffmanNode getLeft() { return left; }
    public HuffmanNode getRight(){ return right; }
    public int getFrecuency() { return frecuency; }
}
