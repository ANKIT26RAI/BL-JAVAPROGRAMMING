class LinkedListReverse{
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
        public LinkedListReverse(int value){
            Node newNode = new Node(value);
            head= newNode;
            tail=newNode;
            length=1;
        }
        public void apppend(int value){
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
            Node temp = head;
            while(temp!=null){
                System.out.println(temp.value);
                temp= temp.next;
            }
        }
        public void reverse(){
            Node temp=head;
            head=tail;
            tail=temp;

            Node after = temp.next;
            Node before = null;
           for(int i=0;i<length;i++){
            after = temp.next;
            temp.next=before;
            before=temp;
            temp=after;
           }
        }
    }

public class Reverse {
    public static void main(String[] args) {
        LinkedListReverse linkedlist = new LinkedListReverse(0);
        linkedlist.apppend(1);
        linkedlist.apppend(2);
        linkedlist.apppend(3);
        linkedlist.apppend(4);
        linkedlist.printlist();
        System.out.println("After reversing :");
        linkedlist.reverse();
        linkedlist.printlist();

    }
}
