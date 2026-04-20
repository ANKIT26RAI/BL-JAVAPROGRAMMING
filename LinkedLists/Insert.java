class LinkedListInsert{
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
    public LinkedListInsert(int value){
        Node newNode= new Node(value);
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
    public Node getElement(int index){
     if(index<0||index>=length){
        return null;
     }   
     Node temp = head;
     for(int i=0;i<index;i++){
        temp=temp.next;
     }
     return temp;
    }
    public void printlist(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    public boolean insertAtIndex(int index,int value){
        if(index<0||index>length) return false;
         if(index==0){
            prepend(value);
            return true;
         }
         if(index==length){
            append(value);
            return true;
         }
        Node newNode = new Node(value);
        Node temp=getElement(index-1);
        newNode.next=temp.next;
        temp.next=newNode;
        length++;
        return true;
    }
}
public class Insert {
    public static void main(String[] args) {
        LinkedListInsert linkedlist = new LinkedListInsert(0);
        linkedlist.append(1);
        linkedlist.append(3);
        linkedlist.insertAtIndex(2,2);
        linkedlist.printlist();
    }
}
