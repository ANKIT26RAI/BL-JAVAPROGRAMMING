/*
Main memory is divided into three part:
Method Area : Where Java Program will reside.
Stack which will contain local variable and refrence variables.
Heap will have those objects that have created using new.
*/
/*
Stream is flow of data.
Data is flowing from resource to program or Program to resource.
Buffer :
Why we need :
If the speed at which Program is sending a data and computer is receiving a data does not match the same speed.
Then we will have problem.
So we need some buffer.
Buffer is memory object which is used for holding the data sometimes to bring the compatability among the devices.


--How data flows in an out?
data is send in bytes.

Java Provides lot of classes in the Streams.
1.ByteStream classes. (1byte)
InputStream.
OutputStream.
2.CharacterStream Classes. (2 bytes)
Reader.
Writer.


class InputStream
Methods:
int read()
int read(byte[] b)
int read(byte[] b, int off, int len)

int available().
long skip(long n)

void mark(int limit)
void reset()
boolean markSupported()


void close()


class OutputStream

void write(int b)
void write(byte[] b)
void write(byte[] b, int off, int len)

void flush()

void close()


---------------------FileOutputStream----------------
We will see how to create or write a file using FileOutput Stream.
And how to read file using FileInput Stream.

*/
 
import java.io.*;
import java.net.Socket;

//public class IO {
  //  public static void main(String[] args) {
    //    try{
      //  FileOutputStream fos = new FileOutputStream("C:/Users/anky2/OneDrive/Desktop/Java/Test.txt");
       // String str = "Learn Java Programming";
        /* 
        Loop method for printing text
        byte[] b = str.getBytes();
        for(byte c:b){
        fos.write(c);
        }
        */
       /*
       Off set methods
       byte b[] str.getBytes();
       fos.write(b,6,str.length()-6);
       */
        //fos.write(str.getBytes());
        //fos.close();
    //} 
      //  catch(FileNotFoundException e)
    //{
      //  System.out.println(e);
    //}catch(IOException e) {
    //    System.out.println(e);
   // }
    //}
//}
/* 
public class IO {

    public static void main(String[] args) throws Exception {
        try (FileOutputStream fos = new FileOutputStream("C:/Users/anky2/OneDrive/Desktop/Java/Test1.text")) {
            String str = "Try with resource way of creating with minimal line";
            byte b[] = str.getBytes();
            fos.write(b);
        } 
        }
    }

*/

//------------How to read from file-------------------
/* 
public class IO {

    public static void main(String[] args) throws Exception
     {
        try (FileInputStream fis = new FileInputStream("C:/Users/anky2/OneDrive/Desktop/Java/Test1.text")) {
       //   byte b[]= new byte[fis.available()];
       //   fis.read(b);
       //   String str = new String(b);
       //   System.out.println(str);
      int x;
      do
      {
         x= fis.read();
         if(x!=-1)
         System.out.print((char)x);
      }    while(x!=-1);
    } 
    }
}
*/

//We change from FileInputStream to FileReader and nothing will change.just bcz it read character.

//Student Challenge Copy a file.
 
//First task : Copying a data from one file to another file in lower cases.

// public class IO {

//     public static void main(String[] args)  throws Exception {
        
//         try(FileReader fr = new FileReader("C:/Users/anky2/OneDrive/Desktop/Java/Test.txt");
//         FileWriter fw = new FileWriter("C:/Users/anky2/OneDrive/Desktop/Java/Text1.text"))
//     {
//     int b;
//         while((b = fr.read())!=-1)
//         {
//             if(b>=65&&b<=120) fw.write(Character.toLowerCase(b));
//             else fw.write(b);
//         }
//     }

//         System.out.println("-------Output File Content ----------");
//         try (FileReader  fr2 = new FileReader("C:/Users/anky2/OneDrive/Desktop/Java/Text1.text")) {
//             int b1;
//             while ((b1=fr2.read())!=-1) {
//                 System.out.print((char)b1);
                
//             }
//         } 
// }
// }

    
//use true to append.


// public class IO {

//     public static void main(String[] args) throws Exception
//     {
//         FileReader fr1 = new FileReader("C:/Users/anky2/OneDrive/Desktop/Java/File1.txt");
//         FileReader fr2 = new FileReader("C:/Users/anky2/OneDrive/Desktop/Java/File2.txt");

//         FileWriter fw = new FileWriter("C:/Users/anky2/OneDrive/Desktop/Java/Desitnation.txt");
//         int b;
    
//         while((b=fr1.read())!=-1)
//     {
//         fw.write((char)b);
//     }

//     fw.write('\n');

//     while ((b = fr2.read())!=-1) {
//         fw.write((char)b);
//      }

//      fr1.close();
//      fr2.close();
//      fw.close();
//     }
// }

//------------Performing upper operation using Sequence Input Stream.
// import java.io.SequenceInputStream;
// public class IO {

//     public static void main(String[] args) throws Exception
//      {
//         FileInputStream fre= new FileInputStream("C:/Users/anky2/OneDrive/Desktop/Java/Test.txt");
//         FileInputStream fre1= new FileInputStream("C:/Users/anky2/OneDrive/Desktop/Java/Desitnation.txt");
       
//         FileOutputStream fwr = new FileOutputStream("C:/Users/anky2/OneDrive/Desktop/Java/Squence.txt");

//         SequenceInputStream sis = new SequenceInputStream(fre,fre1);

//         int b;
//         while ((b=sis.read())!=-1) {
//             fwr.write(b);
//         }
        
//         fre.close();
//         fre1.close();
//         fwr.close();
//         sis.close();
//     }
// } 

//ByteArrayInput Stream and ByteArrayOutput Stream.

//CharArrayReader and CharArrayWriter. 

// import java.io.*;
// public class IO {

//     public static void main(String[] args) throws Exception
//      {
        
//         byte b[]={'a','b','c','d','e','f','g','h','i','j'};
//         ByteArrayInputStream bis = new ByteArrayInputStream(b);
//         int x;
//         while((x=bis.read())!=-1)
//         {
//             System.out.println((char)x);
//         }
//         bis.close();
//     }
// }

// public class IO {

//     public static void main(String[] args) throws Exception
//     {
//         byte b1[]={'a','b','c','d','e','f','g','h','i','j'};
//         ByteArrayInputStream bis = new ByteArrayInputStream(b1);
        
//         String str = new String(bis.readAllBytes());
//         System.out.println(str);
//         bis.close();
//     }
// }

//ByteArrayOutputStream.
// public class IO {

//     public static void main(String[] args) throws Exception
//      {
//         ByteArrayOutputStream bos = new ByteArrayOutputStream(20);
//         bos.write('a');
//         bos.write('b');
//         bos.write('c');
//         byte b[]=bos.toByteArray();
//     for(byte x:b){
//         System.out.println((char)x);
//     }
//     bos.writeTo(new FileOutputStream("C:/Users/anky2/OneDrive/Desktop/BOS.txt"));
//     bos.close();
//     }
// }


//CharArrayReader.
// public class IO {

//     public static void main(String[] args) throws Exception
//     {
//         char c[]={'a','b','c','d','e','f','g','h'};
//         CharArrayReader cr = new CharArrayReader(c);
//         int x;
//         while ((x=cr.read())!=-1) {
//             System.out.print((char)x);
//         }
//         cr.close();
//     }
// }

//Char Writer
// public class IO {

//     public static void main(String[] args) throws Exception
//      {
//         CharArrayWriter chw = new CharArrayWriter();
//         chw.write("Hello world");
//         chw.write(" ");
//         chw.write("King slayer");

//         System.out.println(chw.toString());
//         System.out.println(chw.size());

//         char cr[] = chw.toCharArray();
//         System.out.println("First Char : "+cr[0]);
//     }
// }