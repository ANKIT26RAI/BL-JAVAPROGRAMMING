
class StackPop{
    private Node top;
    private int height;
    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
        }
    }
    public StackPop(int value){
        Node newNode = new Node(value);
        top = newNode;
        height=1;
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

public Node pop(){
    if(height==0) return null;
    Node temp= top;
    top=temp.next;
    temp.next=null;
    height--;
    return temp;
}

public void StackPrint(){
    Node temp=top;
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
public class Pop {
    public static void main(String[] args) {
    StackPop st = new StackPop(5);
    st.push(4);
    st.push(3);
    st.push(2);
    st.push(1);
    st.push(0);
    System.out.println("Before : ");
    st.StackPrint();
    st.pop();
    System.out.println("After: ");
    st.StackPrint();

    }
}
