class DoublyLinkedListRemoveLast{
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
    public DoublyLinkedListRemoveLast(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail=newNode;
        length=1;
    }
    public Node removelast(){
    if(length==0) return null;
     Node temp=tail;
    if(length==1){
        head=null;
        tail= null;
    }else{
        tail=tail.prev;
        tail.next=null;
        temp.prev=null;
    }
    length--;
    return temp;
    }
    public void append(int value){
        Node newNode = new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            newNode.prev=tail;
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


public class RemoveLast {
    public static void main(String[] args) {
        DoublyLinkedListRemoveLast dll = new DoublyLinkedListRemoveLast(0);
        dll.append(1);
        dll.append(2);
        dll.append(3);
        System.out.println("Before :");
        dll.getHead();
        dll.getTail();
        dll.getLength();
        dll.printList();
        System.out.println("After : ");
        dll.removelast();
        dll.getHead();
        dll.getTail();
        dll.getLength();
        dll.printList();
    }
}
