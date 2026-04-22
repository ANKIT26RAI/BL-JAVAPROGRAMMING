//Stack is based on LIFO(Last In First Out).


 class Stack{
private Node top;
private int height;

    class Node{
    int value;
    Node next;
    Node(int value){
        this.value=value;
    }
}
public Stack(int value){
    Node newnNode = new Node(value);
    top= newnNode;
    height=1;
}
public void printStack(){
    Node temp = top;
    while(temp!=null){
        System.out.println(temp.value);
        temp=temp.next;
    }
}
public void getTop(){
    System.out.println("Top: "+top.value);
}
public void getHeight(){
    System.out.println("Height: "+ height);
}
}
public class Constructor {
    public static void main(String[] args) {
        Stack myStack = new Stack(4);
        myStack.getTop();
        myStack.getHeight();

        myStack.printStack();
    }
}
