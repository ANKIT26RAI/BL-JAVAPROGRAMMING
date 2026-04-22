class DeQueue{
    private Node firstQueue;
    private Node lastQueue;
    private int length;
    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public DeQueue(int value){
        Node newNode = new Node(value);
        firstQueue=newNode;
        lastQueue=newNode;
        length =1;
    }
    public void printQueue(){
        Node temp =firstQueue;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length==0){
            firstQueue=newNode;
            lastQueue=newNode;
        }else{
            lastQueue.next=newNode;
            lastQueue=newNode;
            newNode.next=null;
        }
        length++;
    }
    public Node dequeue(){
        if(length==0) return null;
        Node temp = firstQueue;
        firstQueue=temp.next;
        temp.next=null;
        length--;
        return temp;
        
    }
    public void getLength(){
        System.out.println("Length : "+length );
    }
    public  void getFirst(){
        System.out.println("First : "+firstQueue.value);
    }
    public void getLast(){
        System.out.println("Last : "+ lastQueue.value);
    }
    
}
public class DeQueues {
    public static void main(String[] args) {
        DeQueue dq = new DeQueue(0);
        dq.enqueue(1);
        dq.enqueue(2);
        dq.enqueue(3);
        dq.printQueue();
        System.out.println("After : ");
        dq.dequeue();
        dq.printQueue();
        dq.getFirst();
        dq.getLast();
        dq.getLength();
    }

    
}
