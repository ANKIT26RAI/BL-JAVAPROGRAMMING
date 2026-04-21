class DoublyLinkedListInsert{
    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;
        Node prev;
        public Node(int value){
            this.value=value;
        }
    }
    public DoublyLinkedListInsert(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail=newNode;
        length=1;
    }
    public void appennd(int value){
        Node newNode = new Node(value);
        if(length==0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next= newNode;
            newNode.prev=tail;
            tail=newNode;
            
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
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }else{
            head.prev=newNode;
            newNode.next=head;
            head=newNode;

        }
        length++;

    }
    public boolean insert(int index,int value){
        if(index<0||index>length) return false;
        if(index==0){
            prepend(value);
            return true;
        }
        if(index == length){
            appennd(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = getIndex(index-1);
        Node after = before.next;
        newNode.prev=before;
        newNode.next= after;
        before.next=newNode;
        after.prev= newNode;
        length++;
        return true;
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

public class Insert {
    public static void main(String[] args) {
        DoublyLinkedListInsert dll = new DoublyLinkedListInsert(0);
        dll.appennd(1);
        dll.appennd(2);
        dll.appennd(3);
        dll.appennd(4);
        dll.printList();
        dll.insert(2,6);
        dll.printList();
    }
}
