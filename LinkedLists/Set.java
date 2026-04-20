class LinkedListSet{
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
    public  LinkedListSet(int value){
        Node newNode = new Node(value);
        head=newNode;
        tail =newNode;
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
    public void printlist(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    public Node getElement(int index){
        if(index<0||index>=length){
            return null;
        }
        Node temp= head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;

    }
    public boolean setNode(int index,int element){
        Node temp=getElement(index);
        if(temp!=null){
        temp.value=element;
        return true;
        }
        return false;
    }
}
public class Set {
    public static void main(String[] args) {
        LinkedListSet linkedlist=new LinkedListSet(11);
        linkedlist.append(3);
        linkedlist.append(23);
        linkedlist.append(7);
        System.out.println("Before : ");
        linkedlist.printlist();
        linkedlist.setNode(1,4);
        System.out.println("After: ");
        linkedlist.printlist();
    }
}
