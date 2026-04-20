class LinkedListGet{
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
    public LinkedListGet(int value){
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    public void append(int value){
        Node newNode= new Node(value);
        if(length ==0 ){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
        length++;
    }
    public Node getElement(int index){
     if(length<0||index>=length){
        return null;
     }   
     Node temp = head;
     for(int i=0;i<index;i++){
        temp=temp.next;
     }
     return temp;
    }

}
public class Get {
    public static void main(String[] args) {
        LinkedListGet linkedlist = new LinkedListGet(0);
        linkedlist.append(1);
        linkedlist.append(2);
        linkedlist.append(14);
        System.out.print(linkedlist.getElement(3).value);
    }
}
