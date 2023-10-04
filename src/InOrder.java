package src;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class InOrder implements Iterator<BTNode> {

    private Stack<BTNode> stack;

    public InOrder(BinaryTree treeBin) {
        stack = new Stack<>();
        pushLeftNodes(treeBin.getRoot());
    }

    public Stack<BTNode> getStack() { return stack; }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public BTNode next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements can be found");
        }
        System.out.println(stack.peek().getKey());
        BTNode node = stack.pop();
        pushLeftNodes(node.getRight());
        return node;
    }
    private void pushLeftNodes(BTNode node) {
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }
    }
}
