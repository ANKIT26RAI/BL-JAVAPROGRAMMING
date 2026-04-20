class LinkedListRemoveB{
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
    public LinkedListRemoveB(int value){
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
    public Node RemoveLast(){
        if(length==0) return null;
        if(length==1){
            head=null;
            tail=null;
        }else{
            Node temp=head;
            while(temp.next!=tail){
                temp= temp.next;
            }
            tail=temp;
            tail.next=null;
        }
        length--;
        return null;
        }
public Node LinkedListRemovebetween(int index){
 
    if(index==0) return removeFirst();
    if(index==length-1) return RemoveLast();

    Node prev = getElement(index-1);
    Node temp =prev.next;
    prev.next=temp.next;
    temp.next=null;
    length--;
    return temp;
}
}

public class RemovefromIndex {
    public static void main(String[] args) {
        LinkedListRemoveB linkedlis=new LinkedListRemoveB(0);
        linkedlis.append(1);
        linkedlis.append(3);
        linkedlis.append(2);
        linkedlis.append(3);
        linkedlis.append(4);
        linkedlis.printlist();
        System.out.println("After :");
        linkedlis.LinkedListRemovebetween(2);
        linkedlis.printlist();
    }
}
