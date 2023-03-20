public class Stack {

    private Node top; // Node đỉnh của Stack

    // nested class Node
    private class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // kiểm tra xem Stack có rỗng hay không
    public boolean isEmpty() {
        return top == null;
    }

    // đẩy một phần tử vào đỉnh của Stack
    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // lấy một phần tử ở đỉnh của Stack và xóa nó khỏi Stack
    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    // trả về giá trị của phần tử ở đỉnh của Stack
    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    // ví dụ sử dụng
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push("Hello");
        stack.push("world");

        System.out.println(stack.pop()); // "world"
        System.out.println(stack.pop()); // "Hello"

        System.out.println(stack.isEmpty()); // true
    }
}
