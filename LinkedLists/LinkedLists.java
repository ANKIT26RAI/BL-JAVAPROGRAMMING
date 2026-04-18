//Difference b/w ArrayList and LinkedList:
//ArrayList is an data Structure which is mostly compared to linkedlist.
//bcz they both are dynamic in length.
//1.We donot have index in Linked List.
//2.We donot have continguous memory in Linked list they are spread out.
//Linked List is going to have variables called:
//  head which point to the first node.
//  tail which points to last node.
//both of these are pointers that point to nodes.
// and each node is going to have pointer that going to point to next node.
// till we reach last node
//and last node going to have pointer which point to null.
//in memory linked list is going to be all over where each  node points to next one and last to null.
//Big O n- is number of nodes.
//Operation     Method           Position  Time     Why
//Add           addFirst()       Head      O(1)     Just update HEAD pointer
//Add           addLast()        Tail      O(1)     Just update TAIL pointer
//Add           add(index, val)  Middle    O(n)     Must traverse to index
//Remove        removeFirst()    Head      O(1)     Just move HEAD forward
//Remove        removeLast()     Tail      O(1)     Just move TAIL back
//Remove        remove(index)    Middle    O(n)     Must traverse to index
//Search        get(index)       Any       O(n)     No direct access, must traverse
//Search        contains(val)    Any       O(n)     Must traverse to find value
//what is node ? : Node contains value and a pointer to next or null.
 // public LinkedLists(int value){...}
    //create new Node
    // public void append(int value) {...}
    //create new node
    //add Node to end
    // public void prepend (int value){...}
    //create new Node
    //add Node to beginning
    // public boolean insert(int index, int value){...}
    //create new Node
    //insert Node at particular index.
//Constructor.

 class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
    int value;
    Node next;
    Node (int value){
        this.value = value;
    }
}

     public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length=1;
     }
        public void printlist(){
            Node temp = head;
            while(temp!=null){
                System.out.println(temp.value);
                temp = temp.next;
            }
        }
        public void getHead(){
            System.out.println("Head: " +head.value );
        }
        public void getTail(){
            System.out.println("Tail: "+tail.value);
        }
        public void getLength(){
            System.out.println("Length: "+length);
        }

    }
   


public class LinkedLists {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(5); 

        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();
        myLinkedList.printlist();
    }

    
}
