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


// @FunctionalInterface
// interface MyLambda{
//     public int add(int a,int b);
// }
// public class LamExpressions {
// public static void main(String[] args) {
//     MyLambda m = (a,b)->a+b;
//     System.out.println(m.add(20, 30));
// }
    
// }

//Can Lambda Expressions have local variables .
//Can They Access Local Variable and Instance variable or not.


// interface MyLambda
// {
//     public void dislay();
// }
// class Demo 
// {
//     int temp=0;
//     //Lambda Expressions can aceess instance variable of class .
//     //even if they are not final and it can modify them also.
//     public void method1()
//     {
//         final int count =0;
// //Lambda Expressions can access local variable or capture local variables only if they are final
// //or never modify inside method.
//         MyLambda ml= ()->{
//             //Lambda Expressions can have their own variable.
//             //And can use as much as it want to.
//         //     int count =0;
//         //    count++;
//             System.out.println("hI");
//             System.out.println("Bye"+count);     
//             System.out.println(++temp);
//         };
        

//     }
// }
// public class LamExpressions
// {
//     public static void main(String[] args) {
//         Demo d = new Demo();
//         d.method1();
//     }
// }


//Can we pass Lambda Expressions as Parameters.

interface MyLambda{
    public void display();
}
class UseLambda
{
    public void callLambda(MyLambda ml){
        ml.display();
    }
    
}
class Demo
{
    public void method1()
    {
        UseLambda ul = new UseLambda();
        ul.callLambda(()->{System.out.println("Hello");});
    }
}
public class LamExpressions {

    public static void main(String[] args) {
        Demo d = new Demo();
        d.method1();
    }
}