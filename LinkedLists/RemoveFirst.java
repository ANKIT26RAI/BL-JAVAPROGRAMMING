class LinkedListRemoveFirst {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedListRemoveFirst(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (tail == null) {          // ✅ lowercase tail
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);  // ✅ lowercase tail
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeFirst() {      // ✅ Node return type
        if (length == 0) return null;

        Node temp = head;            // ✅ declared before if block
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            tail = null;
        }
        return temp;                 // ✅ now in scope
    }
}

public class RemoveFirst {
    public static void main(String[] args) {
        LinkedListRemoveFirst list = new LinkedListRemoveFirst(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Before:");
        list.printList();
        list.getHead();
        list.getTail();
        list.getLength();

        list.removeFirst();

        System.out.println("After:");
        list.printList();
        list.getHead();
        list.getTail();
        list.getLength();
    }
}