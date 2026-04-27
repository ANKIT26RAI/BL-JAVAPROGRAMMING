//LambdaExpressions are used to define nameless or anonymous methods.
//If interface  is having only one abstract method it is called functional Interface.
// @FunctionalInterface
// interface MyLambda{
//     public void display();
    
// }
// /*class My implements MyLambda{
//     public void display(){
//         System.out.println("HEllo world");
//     }
// }*/
// public class LamExpressions {
// public static void main(String[] args) {

//     MyLambda m = ()->{System.out.println("Hello World");};
    
//     // My m = new My();
//     m.display();
// }    
// }

/*How Lambda Expressions can take Parameter and return result. */
// @FunctionalInterface
// interface MyLambda
// {
//     public void display(String str);
// }
// public class LamExpressions {
// public static void main(String[] args) {
//     MyLambda m = (s)->{System.out.println(s);};
//     m.display("hello world");
    
// }
    
// }

// @FunctionalInterface
// interface MyLambda{
//     public int add(int a,int b);
// }
// public class LamExpressions {
// public static void main(String[] args) {
//     MyLambda m = (a,b)->{return a+b;};
//     System.out.println(m.add(20, 30));
// }
    
// }


@FunctionalInterface
interface MyLambda{
    public int add(int a,int b);
}
public class LamExpressions {
public static void main(String[] args) {
    MyLambda m = (a,b)->a+b;
    System.out.println(m.add(20, 30));
}
    
}

