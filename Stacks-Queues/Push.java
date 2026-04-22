
class StackPush{
    private Node top;
    private int height;
    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
        }
    }
    public StackPush(int value){
        Node newNode = new Node(value);
        top = newNode;
        height=1;
    }

public void StackPrint(){
    Node temp=top;
    while(temp!=null){
        System.out.println(temp.value);
        temp=temp.next;
    }
}
public void push(int value){
    Node newNode = new Node(value);
    if(height == 0){
        top= newNode;
    }else{
        newNode.next=top;
        top = newNode;
    }
    height++;
}
public void getTop(){
    System.out.println("Top: "+top.value);
}
public void getHeight(){
    System.out.println("Height: "+ height);
}

}
public class Push {
    public static void main(String[] args) {
    StackPush st = new StackPush(1);
    st.push(0);
    st.StackPrint();
    st.getTop();
    st.getHeight();

    }
}
