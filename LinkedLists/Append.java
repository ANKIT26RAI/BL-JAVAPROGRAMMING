class LinkedlistAppend{
    private Node head;
    private Node tail;
    private int length;
class Node{
    int value;
    Node next;
    Node(int value){
        this.value =value;
    }
}
public  LinkedlistAppend(int value){
    Node newNode= new Node(value);
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
public void getHead(){
    if(head==null){
        System.out.println("Head: null");
    }else{
        System.out.println("Head: "+head.value);
    }
}
public void gettail(){
    if(head==null){
        System.out.println("Tail : null");
    }else{
        System.out.println("Tail: "+ tail.value);
    }
}
public void getLength(){
    System.out.println("Length: "+ length);
}

public void append(int value){
    Node newNode = new Node(value);
    if(length==0){
        head = newNode;
        tail = newNode;

    }else{
        tail.next=newNode;
        tail=newNode;
    }
    length++;
}


}
public class Append {
    public static void main(String[] args) {
        LinkedlistAppend linkedList = new LinkedlistAppend(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.getHead();
        linkedList.gettail();
        linkedList.getLength();
        linkedList.printlist();

    }
}
