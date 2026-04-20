class LinkedListRemovelast{
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }
        public LinkedListRemovelast(int value){
            Node newNode = new Node(value);
            head=newNode;
            tail=newNode;
            length=1;
        }
        public void getHead(){
            if(length==0){
                System.out.println("Head: null");

            }else{
                System.out.println("Head: " + head.value);
            }

        }
        public void getTail(){
            if(tail==null){
                System.out.println("Tail: null");
            }else{
                System.out.println("Tail :"+tail.value);
            }
        }
        public void getLength(){
            System.out.println("Length : "+ length);
        }
        public void printlist(){
            Node temp=head;
            while(temp!=null){
                System.out.println(temp.value);
            temp=temp.next;
            }
            
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
        public void RemoveLast(){
        if(length==0) return;
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
        }

    
}
public class Removelast {
    public static void main(String[] args) {
        System.out.println("Before :");
        LinkedListRemovelast linkedlist = new LinkedListRemovelast(1);
        linkedlist.append(2);
        linkedlist.append(3);
        linkedlist.append(4);
        linkedlist.append(5);
        linkedlist.printlist();
        linkedlist.getHead();
        linkedlist.getTail();
        linkedlist.getLength();
        linkedlist.RemoveLast();

        System.out.println("After: ");
        linkedlist.printlist();
        linkedlist.getHead();
        linkedlist.getTail();
        linkedlist.getLength();
        

    }
}
