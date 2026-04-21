class DoublyLinkedList{
    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;
        Node prev;
        public Node(int value){
            this.value=value;
        }
    }
    public DoublyLinkedList(int value){
        Node newNode= new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    public void getHead(){
        
            System.out.println("Head: "+head.value);
        
    }
    public void getTail(){
       
            System.out.println("Tail: "+ tail.value);
        
    }
    public void getLength(){
        System.out.println("Length: "+ length);
    }
    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
}
public class Constructor {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(7);
        dll.getHead();
        dll.getTail();
        dll.getLength();
        dll.printList();
    }
}
