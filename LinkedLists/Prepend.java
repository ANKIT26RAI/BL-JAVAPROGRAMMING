class LinkedListPrepend{
    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
        }
    }
    public LinkedListPrepend(int value){
        Node newNode=new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    public void printlist(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    public void gethead(){
        if(head==null){
            System.out.println("Head : null");
        }else{
            System.out.println("Head: "+head.value);
        }
    }
    public void gettail(){
        if(tail==null){
            System.out.println("Tail : null");
        }else{
            System.out.println("Tail: "+tail.value);
        }
    }
    public void getLength(){
        System.out.println("Length: "+length);
    }
    public void append(int value){
        Node newNode= new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
        length++;
    }
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
    length++;
    }
    
    
}
public class Prepend {
    public static void main(String[] args) {
        LinkedListPrepend linkedlist = new LinkedListPrepend(1);
        linkedlist.append(2);
        linkedlist.append(3);
        linkedlist.append(4);
        linkedlist.append(5);
        System.out.println("Before :");
        linkedlist.printlist();
        linkedlist.gethead();
        linkedlist.gettail();
        linkedlist.getLength();
        System.out.println("After :");
        linkedlist.prepend(0);
        linkedlist.printlist();
        linkedlist.gethead();
        linkedlist.gettail();
        linkedlist.getLength();
    }
    
}
