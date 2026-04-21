class LinkedListPrepend{
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node prev;
        Node next;
        public Node(int value){
            this.value=value;
        }
    }
    public LinkedListPrepend(int value){
        Node newnNode = new Node(value);
        head = newnNode;
        tail=newnNode;
        length=1;

    }
    public void append(int value){
        Node newNode = new Node(value);
        if(length==0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next=newNode;
            newNode.prev=tail;
            tail= newNode;

        }
        length++;
    }
    public void prepend(int value){
        Node newnNode = new Node(value);
        if(length==0){
            head=newnNode;
            tail=newnNode;
        }else{
            head.prev=newnNode;
            newnNode.next=head;
            head=newnNode;
        }
        length++;
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
public class Prepend {
    public static void main(String[] args) {
        LinkedListPrepend dll = new LinkedListPrepend(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        System.out.println("Before : ");
        dll.printList();
        dll.getHead();
        dll.getTail();
        dll.getLength();
        System.out.println("After: ");
        dll.prepend(0);
        dll.printList();
        dll.getHead();
        dll.getTail();
        dll.getLength();
    }
}
