import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@interface MyAnno
{
    String name();
    String project();
    String date();
    String version() default "13";
}

@MyAnno(name="Ankit",project="Bank",)
public class UserDefinedAnn {
    @MyAnno(name="Ankit")
    int data;
    public static void main(@MyAnno(name="Ankit") String[] args) {
        
        @MyAnno(name="Ajay")
        int x;
    }
}

//in build Annotations
//1.Retentions.
//Specifies how long the annotation is retained
//Takes a RetentionPolicy value
// @Retention(RetentionPolicy.CLASS)
// @interface MyAnno
// {
//     String name();
//     String project();
//     String date();
//     String version() default "13";
// }

// @MyAnno(name="Ankit",project="Bank",)
// public class UserDefinedAnn {
//     @MyAnno(name="Ankit")
//     int data;
//     public static void main(@MyAnno(name="Ankit") String[] args) {
        
//         @MyAnno(name="Ajay")
//         int x;
//     }
// }
//2.Documented.
// Includes the annotation in JavaDoc documentation
// Without it, custom annotations won't appear in generated docs.
//3.Target.
//Specifies where the annotation can be applied
Notes format requestClaude finished the responseYou said: give in notes formgive in notes form22:12Claude responded: JavaDoc TagsJavaDoc Tags
Class Tags

@author – Specifies the author of the class
@version – Indicates the version of the class
@since – Specifies when the class was introduced
@see – Adds a "See Also" reference link

Method Tags

@param – Describes a method parameter
@return – Describes the return value of a method
@throws – Documents an exception the method may throw
@exception – Alias for @throws
@deprecated – Marks the method as outdated/no longer recommended
@code – Displays text in code font (used inline)

Others

@link – Creates an inline hyperlink to another class/method
@value – Displays the value of a static field
@serial – Used for documenting serializable fields



💡 Tip: JavaDoc comments use /** ... */ and are placed directly above the class or method they describe. Running javadoc on your source generates HTML documentation automatically.
//1.Those Annotations which are applied on code:
//in-built Annotations:
//1.@Override.
//2.@Deprecated.
//3.@FunctionalInterface.
//4.@SafeVarargs.22:29Claude responded: Java Built-in Annotations (Applied on Code)Java Built-in Annotations (Applied on Code)
1. @Override

Tells the compiler that the method is overriding a parent class method
Gives a compile-time error if the method doesn't actually override anything

java@Override
public String toString() {
    return "Hello";
}

2. @Deprecated

Marks a method/class as outdated / no longer recommended
Compiler gives a warning when it's used

java@Deprecated
public void oldMethod() {
    // avoid using this
}

3. @FunctionalInterface

Marks an interface as a Functional Interface (only one abstract method)
Used with Lambda expressions
Gives error if more than one abstract method is added

java@FunctionalInterface
public interface MyFunc {
    void execute(); // only one abstract method allowed
}

4. @SafeVarargs

Suppresses unchecked warnings related to varargs (variable arguments) with generics
Applied on methods/constructors with final, static, or constructors

java@SafeVarargs
public static <T> void display(T... items) {
    for (T item : items) 
        System.out.println(item);
}


💡 Key Point: These are all compile-time annotations — they help the compiler catch errors or suppress warnings before the program runs.
 class Parent {
     public void display();
}
class Child extends Parent{
     @Override
    public void display(){
        System.out.println("Override");

    }
}
public class JavaAnnotations {

    public static void main(String[] args) {
        Child c = new Child();
        c.display();
    }
}Show more22:37Claude responded: The code has a small issue — Parent.The code has a small issue — Parent.display() has no body, so it must be either abstract or part of an interface.
Two Fixes:
✅ Fix 1 — Make Parent Abstract
javaabstract class Parent {
    public abstract void display(); // abstract method - no body
}

class Child extends Parent {
    @Override
    public void display() {
        System.out.println("Override");
    }
}

public class JavaAnnotations {
    public static void main(String[] args) {
        Child c = new Child();
        c.display(); // Output: Override
    }
}

✅ Fix 2 — Use an Interface
javainterface Parent {
    void display(); // implicitly abstract
}

class Child implements Parent {
    @Override
    public void display() {
        System.out.println("Override");
    }
}

public class JavaAnnotations {
    public static void main(String[] args) {
        Child c = new Child();
        c.display(); // Output: Override
    }
}

Output
Override

Key Notes
ConceptExplanation@OverrideEnsures display() in Child truly overrides ParentWithout @OverrideCode still works, but no compile-time safetyWith @OverrideCompiler throws error if method signature doesn't match

💡 @Override is a safety net — it's optional but always a good practice to use it.
//4.@SuppressWarnings.
class OldClass
{
    public void display()
    {
        System.out.println("Hello");
    }
    @Deprecated
    public void show()
    {
        System.out.println("Hi");
    }
}
public class JavaAnnotations {
public static void main(String[] args) {
    @SuppressWarnings("deprecation")
     OldClass OC = new OldClass();
     OC.show();
}
    
}Show more23:01Claude responded: @SuppressWarnings Annotation@SuppressWarnings Annotation
What it does

Tells the compiler to suppress (hide) specific warnings
Does not fix the problem — just silences the warning


Code Breakdown
javaclass OldClass {
    public void display() {
        System.out.println("Hello");
    }

    @Deprecated  // ⚠️ marks show() as outdated
    public void show() {
        System.out.println("Hi");
    }
}

public class JavaAnnotations {
    public static void main(String[] args) {

        @SuppressWarnings("deprecation")  // 🔇 suppresses the deprecation warning
        OldClass OC = new OldClass();
        
        OC.show();  // calling deprecated method — warning suppressed
    }
}
Output
Hi

Common Warning Types you can Suppress
Warning TypeSuppresses"deprecation"Warnings from using @Deprecated methods"unchecked"Unchecked type cast warnings (generics)"unused"Warnings for unused variables/methods"rawtypes"Raw type usage warnings"all"Suppresses all warnings

Suppress Multiple at Once
java@SuppressWarnings({"deprecation", "unchecked"})
OldClass OC = new OldClass();


💡 Key Point: @SuppressWarnings hides the warning but the underlying issue still exists. Use it only when you are intentionally using the flagged code.
23:02Claude responded: What's Happening in the TerminalWhat's Happening in the Terminal
The warning is still showing even after using @SuppressWarnings("deprecation") — here's why:

The Problem
Note: JavaAnnotations.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.

@SuppressWarnings placed on a local variable (OldClass OC) only suppresses the warning partially in some compilers
The javac compiler still shows a Note (not a full warning) at the file level


✅ Fix — Place @SuppressWarnings on the Method level
javapublic class JavaAnnotations {

    @SuppressWarnings("deprecation")  // ✅ put on method, not variable
    public static void main(String[] args) {
        OldClass OC = new OldClass();
        OC.show();
    }
}

Placing it on the method or class level fully suppresses the warning.


Scope Levels (Best to Worst)
ScopeExampleEffectivenessClass level@SuppressWarnings on classSuppresses all warnings in classMethod level ✅@SuppressWarnings on methodRecommended — targeted & effectiveVariable level ⚠️@SuppressWarnings on variableMay not fully suppress javac notes


💡 Rule of thumb: Always place @SuppressWarnings at the smallest effective scope — preferably the method level.
//in build Annotations
//1.Retentions.
//2.Documented.
//3.Target.
//4.Inherited.
//5.Repeatable.00:17Claude responded: Built-in Meta-Annotations in JavaBuilt-in Meta-Annotations in Java

💡 Meta-Annotations = Annotations that are applied on other annotations (not on code directly)


1. @Retention

Specifies how long the annotation is retained
Takes a RetentionPolicy value

PolicyMeaningSOURCEDiscarded by compiler — exists only in source codeCLASSStored in .class file but not available at runtime (default)RUNTIMEAvailable at runtime via Reflection
java@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation { }

2. @Documented

Includes the annotation in JavaDoc documentation
Without it, custom annotations won't appear in generated docs

// java@Documented
// public @interface MyAnnotation { }

// 3. @Target

//Specifies where the annotation can be applied

// ElementType            Applied On
// TYPE                  Class, Interface, Enum
// METHOD                Methods
// FIELD                  Fields/Variables
// PARAMETER              Method parameters
// CONSTRUCTOR             Constructors
// LOCAL_VARIABLE            Local variables
// @Target(ElementType.METHOD)  // only applicable on methods
// public @interface MyAnnotation { }
//4.Inherited.
@Inherited
public @interface MyAnnotation { }

@MyAnnotation
class Parent { }

class Child extends Parent { }
// Child automatically has @MyAnnotation
//Allows an annotation to be inherited by subclasses
//If parent class has the annotation, child class automatically gets it
//5.Repeatable.
// Allows the same annotation to be applied multiple times on the same element
// Requires a container annotation

// @Repeatable(MyAnnotations.class)
// public @interface MyAnnotation {
//     String value();
// }

// // Container annotation
// public @interface MyAnnotations {
//     MyAnnotation[] value();
// }

// // Usage
// @MyAnnotation("first")
// @MyAnnotation("second")
// class MyClass { }