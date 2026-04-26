//Important topic .
//import java.lang.*;
//it is by default imported package.
//first class which we going to discuss is ObjectClass.
//ObjectClass is a parent class for all the classes in Java.
//Any new class you learn is directly or inderectly inherating from  ObjectClass.
//ObjectClass we can also say mother of all classes.
//clone():Creates and returns a copy of this object.//Protected.
//equals(Object obj): It compares two Object. //boolean.
//finalize():will be called by garbage collector whenever a object of a class being garbage collected / taken up.means this method is present in this class.
// import java.lang.*;
// public class JavaLang {
//     public static void main(String[] args) {
//     Object o1= new Object();
//    // Object o2= new Object();
//    Object o2 = o1; 
//    //System.out.println(o1.equals(o2));
//    System.out.println(o1.hashCode());
// }
// }

// import java.lang.*;

// import javax.management.ObjectName;
// class MyObject{
//  public String toString()
//  {
//     return "My Object";
//  }
//  //can we overide hashcode method.
//  public int hashCode(){
//     return 100;
//  }
//  //we can overide equal method also.
//  public boolean equals(Object o){
//     return this.hashCode()==o.hashCode();
//  }
//  //we cannot override final methods.
// }
// public class JavaLang {
// public static void main(String[] args) {
//     MyObject o1= new MyObject();
//     MyObject o2= new MyObject();
//     System.out.println(o1.hashCode());
//     System.out.println(o1.equals(o2));
// }
    
// }

// Wrapper Classes.
//For every datatypes the wrapper classes are available.
//Character.
//Byte.
//Short.
//Integer.
//Long.
//Float.
//Double.
//Boolean.


public class JavaLang {

    public static void main(String[] args) {
         Integer i = new Integer(10);
         Integer a = Integer.valueOf(10);
         Integer b= 10;

         Byte c=15;
         Byte d = Byte.valueOf("15");
         byte bb = 15;
         Byte e = Byte.valueOf(bb);

         Short f = Short.valueOf("123");
         Float g= 12.3f;
         Float h = Float.valueOf("123.5");

         Double o = Double.valueOf(123.456);
         Character k = Character.valueOf('A');
         Boolean l = Boolean.valueOf("true");

         float x=h.floatValue();

    }
}