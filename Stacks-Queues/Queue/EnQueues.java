class EnQueue{
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
    public EnQueue(int value){
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
public class EnQueues {
    public static void main(String[] args) {
        EnQueue eq = new EnQueue(0);
        eq.enqueue(1);
        eq.enqueue(2);
        eq.printQueue();
        eq.getFirst();
        eq.getLast();
        eq.getLength();
    }

    
}