class LinkedListSet{
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
    public LinkedListSet(int value){
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
    public Node getIndex(int index){
        if(index<0 || index>=length) return null;
 Node temp = head;
        if(index<length/2){
           
            for(int i=0;i<index;i++){
                temp= temp.next;
            }
        }else{
                temp = tail;
                for(int i=length-1;i>index;i--){
                    temp=temp.prev;
                }
            }
        return temp;    
        }
        public boolean setIndex(int index , int value){
            Node temp= getIndex(index);
            if (temp!=null) {
                temp.value=value;
                return true;
            }
            return false;
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
public class Set {
public static void main(String[] args) {
    LinkedListSet dll = new LinkedListSet(0);
    dll.append(1);
    dll.append(2);
    dll.append(3);
    System.out.println("Before: ");
    dll.printList();
    System.out.println("After: ");
    dll.setIndex(2,5);
    dll.printList();
}    
}
