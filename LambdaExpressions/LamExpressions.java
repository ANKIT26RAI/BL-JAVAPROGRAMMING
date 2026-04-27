//LambdaExpressions are used to define nameless or anonymous methods.
//If interface  is having only one abstract method it is called functional Interface.
@FunctionalInterface
interface MyLambda{
    public void display();
    
}
/*class My implements MyLambda{
    public void display(){
        System.out.println("HEllo world");
    }
}*/
public class LamExpressions {
public static void main(String[] args) {

    MyLambda m = ()->{System.out.println("Hello World");};
    
    // My m = new My();
    m.display();
}    
}
