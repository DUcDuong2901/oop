public class Stack<Item> {

    private Node top;

    private class Node {
        private Item data;
        private Node next;

        public Node(Item data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Item data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Item data = top.data;
        top = top.next;
        return data;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Hello");
        stack.push("world");

        System.out.println(stack.pop()); // "world"
        System.out.println(stack.pop()); // "Hello"

        System.out.println(stack.isEmpty()); // true
    }
}
