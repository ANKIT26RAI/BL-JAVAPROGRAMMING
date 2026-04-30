//Why Java Provide ObjectClass -> so we achieve generalisation in java.
//Object obj1 = new String("Hello");   // String     IS-A Object ✅
//Object obj2 = new Integer(42);       // Integer    IS-A Object ✅
//Object obj3 = new MyClass();         // MyClass    IS-A Object ✅
//To achieve generalization Java used Object before 1.5.
//Later Generics was introduced.
// public class Generics {
//     public static void main(String[] args) {
//         Object obj = new String("hello");
//         //obj = new Integer(10);
//         String str = (String)obj;
//         System.out.println(str);
//     }
    
// }



// public class Generics {

//     public static void main(String[] args) {
//         Object obj[]=new Object[3];
//         obj[0]="hi";
//         obj[1]="bye";
//         //obj[2]=new Integer(10);//error
//         obj[2]="hp";
//         String str;
//         for(int i=0;i<3;i++){
//             str =(String)obj[i];
//             System.out.println(str);
//         }
//     }
// }


//Generic Type Array.
//Storing any type of Object.

// public class Generics<T>
// {
// T data[]=(T[])new Object[3];
// public static void main(String[] args)
//  {
// Generics<String> gd = new Generics<>();
// gd.data[0]="hi";
// gd.data[1]="bye";
// //gd.data[2] =10;   
// String str = gd.data[0];

// }
    
// }

//Example:
// class Data<T>
// {
//     private T obj;

//     public void setData(T v)
//     {
//         obj=v;
//     }
//     public T getData()
//     {
//         return obj;
//     }
// }
// public class Generics {

//     public static void main(String[] args) {
//         // Data<Integer> d = new Data<>();
//         // d.setData(10);
//         // System.out.println(d.getData());
//         Data<String> d = new Data<>();
//         d.setData("king");
//         System.out.println(d.getData());
//     }
// }

//Class MyArray.
// @SuppressWarnings("unchecked")
// class MyArray<T>
// {
//     T A[]=(T[])new Object[10];
//     int length =0;

//     public void append(T v)
//     {
//         A[length++]=v;
//     }
//     public void display(){
//         for(int i=0;i<length;i++)
//             {
//             System.out.println(A[i]);
//         }
//     }
// }
// public class Generics {

//     public static void main(String[] args) {
//         MyArray<Integer> ma = new MyArray<>();
//         ma.append(10);
//         ma.append(20);
//         ma.append(30);
//         ma.display();
        
//     }
// }

//Generics
//1.No Parameters.
// @SuppressWarnings("unchecked")
// class MyArray<T>
// {
//     T A[] =(T[])new Object[10];
//     int length;

//     public void append(T v){
//         A[length++]=v;

//     }
//     public void display(){
//         for(int i=0;i<length;i++){
//             System.out.println(A[i]);
//         }
//     }
// }
// @SuppressWarnings("unchecked")
// public class Generics {
// public static void main(String[] args) {
//     MyArray MA= new MyArray<>();
//     MA.append(10);
//     MA.append("ho");
//     MA.append("i");
//     MA.display();
// }
    
// }

// @SuppressWarnings("unchecked")
// class MyArray<T>
// {
//     T A[] =(T[])new Object[10];
//     int length;

//     public void append(T v){
//         A[length++]=v;

//     }
//     public void display(){
//         for(int i=0;i<length;i++){
//             System.out.println(A[i]);
//         }
//     }
// }
// public class Generics {
// public static void main(String[] args) {
//     MyArray<Object> MA= new MyArray<>();
//     MA.append(10);
//     MA.append("ho");
//     MA.append("i");
//     MA.display();
// }
    
// }
//2.Multiple Parameters.
// @SuppressWarnings("unchecked")
// class MyArray<T,k>
// {
//     T A[] =(T[])new Object[10];
//     int length;

//     public void append(T v){
//         A[length++]=v;

//     }
//     public void display(){
//         for(int i=0;i<length;i++){
//             System.out.println(A[i]);
//         }
//     }
// }
// @SuppressWarnings("unchecked")
// public class Generics {
// public static void main(String[] args) {
//     MyArray<Integer,String> MA= new MyArray<>();
//     MA.append(10);
//     MA.append("ho");
//     MA.append("i");
//     MA.display();
// }
    
// }
//3.Subtypes.

// import javax.management.ObjectName;
// @SuppressWarnings("unchecked")
// class MyArray<T>
// {
//     T A[] = (T[]) new Object[10];
//     int length;

//     public void append(T v){
//       A[length++]=v;
    
//     }
//     public void display()
//     {
//         for(int i=0;i<length;i++){
//             System.out.println(A[i]);
//         }
//     }
// }
// class MyArray2 extends MyArray<String>
// {

// }
// public class Generics {

//     public static void main(String[] args) {
//         MyArray2 ma = new MyArray2();
//         ma.append("hi");
//         ma.append("bye");
//         ma.append("k");
//         ma.display();
//     }
// }import javax.management.ObjectName;
/*@SuppressWarnings("unchecked")
class MyArray<T>
{
    T A[] = (T[]) new Object[10];
    int length;

    public void append(T v){
      A[length++]=v;
    
    }
    public void display()
    {
        for(int i=0;i<length;i++){
            System.out.println(A[i]);
        }
    }
}
class MyArray2<T> extends MyArray<T>
{

}
public class Generics {

    public static void main(String[] args) {
        MyArray2<Integer> ma = new MyArray2();
        ma.append(1);
        ma.append(2);
        ma.append(3);
        ma.display();
    }
}
    */
//4.Bounded Types.
// class MyArray<T extends Number>
// {
//     T A[] =(T[]) new Number[10];

//     int length;
//     public void append(T v)
//     {
//         A[length++]=v;
//     }
//     public void display()
//     {
//         for(int i=0;i<length;i++){
//         System.out.println(A[i]);
//         }
//     }
// }

// public class Generics {
// public static void main(String[] args) {
//     MyArray<Double> ma = new MyArray<>();
//     ma.append(3.5);
//     ma.append(6.57);
//     ma.append(5.67);
//     ma.display();
// }
    
// }

// class A{}
// class B extends A{}
// class C extends A{}
// class MyArray<T extends Number>
// {
//     T A[] =(T[]) new Number[10];

//     int length;
//     public void append(T v)
//     {
//         A[length++]=v;
//     }
//     public void display()
//     {
//         for(int i=0;i<length;i++){
//         System.out.println(A[i]);
//         }
//     }
// }

// public class Generics {
// public static void main(String[] args) {
//     MyArray<Double> ma = new MyArray<>();
//     ma.append(3.5);
//     ma.append(6.57);
//     ma.append(5.67);
//     ma.display();
// }
    
// }

//Generic MeTHODS.
// class MyArray<T>
// {
//     T A[] =(T[]) new Object[10];

//     int length;
//     public void append(T v)
//     {
//         A[length++]=v;
//     }
//     public void display()
//     {
//         for(int i=0;i<length;i++){
//         System.out.println(A[i]);
//         }
//     }
// }

// public class Generics {
// static <E> void show(E[] list)
// {
// for(E x :list)
//     {
//     System.out.println(x);
// }
// }
//     public static void main(String[] args) {
//    show(new String[] {"Ji","go","byr"});
//    show(new Integer[] {10,20,30,40,40});
// }
    
// }

// class MyArray<T>
// {
//     T A[] =(T[]) new Object[10];

//     int length;
//     public void append(T v)
//     {
//         A[length++]=v;
//     }
//     public void display()
//     {
//         for(int i=0;i<length;i++){
//         System.out.println(A[i]);
//         }
//     }
// }

// public class Generics {
// static <E> void show(E... list)
// {
// for(E x :list)
//     {
//     System.out.println(x);
// }
// }
//     public static void main(String[] args) {
//    show("hi","hello","ji");
//    show(1,2,3,4,5);
    
// }
// }


// class MyArray<T>
// {
//     T A[] =(T[]) new Object[10];

//     int length;
//     public void append(T v)
//     {
//         A[length++]=v;
//     }
//     public void display()
//     {
//         for(int i=0;i<length;i++){
//         System.out.println(A[i]);
//         }
//     }
// }

// public class Generics {
// static void fun(MyArray<? extends Number> obj)//wildcard.
// {
//     obj.display();
// }

//     public static void main(String[] args) {
//    MyArray<String> ma = new MyArray<String>();
//    ma.append("hi");
//    ma.append("bye");
//    MyArray<Integer> ma2 = new MyArray<Integer>();
//    ma2.append(10);
//    ma2.append(20);

//    fun(ma);
//    fun(ma2);
    
// }

// }


//Do's AND Dont's in Generics.
/*
1.Only extends is allowed in Generic Class definition.
2.extends is used for interface also.
3.extends from Only one class and multiple interfaces.
4.extends and super are allowed with ? in methods.
5.<?> will accept all types but cannot access.
6.Base type of an Object should be same or ?.
*/

//---------------------WildCard.--------------
