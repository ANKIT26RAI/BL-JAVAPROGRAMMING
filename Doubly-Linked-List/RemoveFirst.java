class LinkedListRemoveFirst{
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
    public LinkedListRemoveFirst(int value){
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
    public Node removeFirst(){
        if(length==0) return null;
        Node temp= head;
        if(length==1){
           head=null;
           tail=null;
        }else{
            head = temp.next;
            temp.next=null;
            head.prev=null;
        }
        length--;
        return temp;
        
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

public class RemoveFirst {
    public static void main(String[] args) {
        LinkedListRemoveFirst dll = new LinkedListRemoveFirst(0);
        dll.append(1);
        dll.append(2);
        dll.append(3);

        dll.removeFirst();
        dll.printList();
    }
}
