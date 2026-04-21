class DoublyLinkedListAppend{
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
    public DoublyLinkedListAppend(int value){
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    public void append(int value){
        Node newNode = new Node(value);
        if(length==0){
          head=newNode;
          tail=newNode;
        }else{
            newNode.prev=tail;
            tail.next=newNode;
            tail=newNode;
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

public class Append {
    public static void main(String[] args) {
        DoublyLinkedListAppend dll = new DoublyLinkedListAppend(0);
        dll.append(1);
        dll.append(2);
        dll.getHead();
        dll.getTail();
        dll.getLength();
        dll.printList();
    }
}
