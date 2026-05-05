//1.MultiProgramming.
//MultiUser:Multiple user will use the computer to run multiprograms.

//MultiTasking->MultiThreading:Single User Running more than one program on a single computer.

//ControFlow of Program.
// class Test
// {
//     static void display(){ //Step 3
//         System.out.println("Hello"); //step 4
//     }
// }
// public class Multithreading { 
//      public static void main(String[] args) { //(Step 1)
//        Test t = new Test();
//         t.display(); //Step 2
//         System.out.println("World");
//     }
// }


//HOW TO ACHEIVE MULTITHREADING IN JAVA.
//1.Thread Class.
//2.Runnable Interface.//These are two things present inside java to achieve multithreading.

//We can say extend thread class.
//If your class is extending from another class and you still want multithreading then you can implement Interface.


//Program using thread class.
// class MyThread extends Thread
// {
//     public void run() //run method is or run is starting point of thread.
//     {
//         int i=1;
//         while(true)
//         {
//             System.out.println(i+" hello ");
//         i++;
//         }
//     }
// }
// public class Multithreading {

//     public static void main(String[] args) {
//         MyThread t = new MyThread();
//         t.start(); //this is starting the threading.
//         int i=1;
//         while (true) {
//             System.out.println(i+" World ");
//             i++;
//         }
//     }
// }

//The Multithreading class now extends Thread itself,
//so it serves as both the thread definition and the entry point.

// public class Multithreading extends Thread {
// public void run(){
//     int i=1;
//     while (true) {
//         System.out.println(i+" Hello ");
//         i++;
//     }
// }
//     public static void main(String[] args) {
//         Multithreading mt = new Multithreading();
//         mt.start();
//         int i=1;
//         while (true) {
//             System.out.println(i +" World ");
//            i++;
//         }
//     }
// }

//---------------------------------Multithreading using Runnable Interface----------------------
// class My implements Runnable
// {
//     public void run()
//     {
//         int i=1;
//         while (true) {
//             System.out.println(i + " Hello ");
//             i++;
//         }
//     }
// }
// public class Multithreading {

//      public static void main(String[] args) {
//         My m= new My();
//         Thread T = new Thread(m);
//         T.start();
//         int i=1;
//         while (true) {
//             System.out.println(i + " World ");
//             i++;
//         }
//      }
// }


//-------------------Using Single Class--------------------
//  public class Multithreading implements Runnable{
// public void run(){
//    int i=1;
//    while (true) {
//     System.out.println(i + " Hello ");
//     i++;
//    }
// }
//     public static void main(String[] args) {
//         Multithreading mt = new Multithreading();
//         Thread t = new Thread(mt);
//         t.start();
//         int i=1;
//         while (true) {
//             System.out.println(i +" World ");
//             i++;
//         }
//     }
// }


//---------------States Of A Thread------------------
// new-----------Start------->ready--------run------>running---------end-------->terminated.
//1.Running has a wait state it waits for some resource such as shared resource Once it get [notify] it start running again.
//2.Running has also timedwait state where we have to give time to put it in sleep mode once done it will again start running again.
//3.Running has also blocked state where once the thread has entered the wait state it will be blocked and request of I/O resource will be accepted it again start running.

/*--------------All 6 Thread States in Java (Thread.State)--------------|
State                Trigger               Description
NEW                  new Thread()          Thread created but start() not called yet
RUNNABLE             start()               Ready to run or currently running on CPU
RUNNING              CPU scheduled         Actively executing (subset of Runnable in JVM)
WAITING              wait(),               Waiting indefinitely for notify signal
                     join()               
BLOCKED              Waiting for a lock    Trying to enter a synchronized block held by another thread
TERMINATED           run() completes       Thread has finished execution, cannot be restarted
*/

/*Thread Priorities.:
Threads can have priorities that why java support multiple priorities.public class Multithreading {

    Suppose one program has multiple threads and one of thread is main thread all other all child threads.
    They are in Queue which we call ready queue.
    JVM will maintain ready Queue. IT has something called scheduler.
    Scheduler will schedule these threads.

    If all threads have same time of priority they will equally share CPU.
    Like Round-Robin.
    But if there are priorities:
    Java Support Prioprity
    Thread.MIN_PRIORITY=1,
    Thread.NORM_PRIORITY=5,
    Thread.MAX_PRIORITY=10.
 
    Highest Priority is mostly given to Rendering the data.
    */


    /*
    -------------------Thread Class--------------------
    Constructors :
    Thread() //This is default constructor.
    Thread(Runnable r) //This is constructor where we can pass c;ass Runnable Interface.
    Thread(Runnable r, String name) //you can also mention the name of thread.
    Thread(ThreadGroup g, String name) //you can also have group of threads and include thread in that group.
    Thread(String name).


    getxxx()/setxxx()
    long getId()
    String getName()
    int getPriority()
    Thread.state getState()
    ThreadGroup getThreadGroup()

    void setName(String name)
    void setPriority(int P)
    void setDaemon(boolean d)

    --------------------Enquiry-----------------------
    boolean isAlive()
    boolean isDaemon()
    boolean isInterrupted()

    --------------Instance Methods--------------------
    void interrupt()
    void join()
    void join(long millis)
    void run()
    void start()


    ----------Static Methods----------------------------
    int activeCount()
    Thread currentThread()
    void yeild()
    void dumpStack()
  */

    // class MyRun implements Runnable
    // {
    //     public void run(){}
    // }

    // public class Multithreading {
    
    //     public static void main(String[] args) {
    //         Thread t = new Thread(new MyRun());
    //     }
    // }


    class MyThread extends Thread
    {
        public MyThread(String name)
        {
            super(name);
         //   setPriority(MAX_PRIORITY);
        }
        public void run(){
            int count =1;
            while (true) {
                System.out.println(count++);
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e);
                }
            }

        }
    }
    public class Multithreading {
    
        public static void main(String[] args) {
            MyThread t= new MyThread("My thread 1");
            t.start();
            t.interrupt();
            // System.out.println(t.getId());
            // System.out.println(t.getName());
            // System.out.println(t.getPriority());
            // t.start();//i made thread run .
            // System.out.println(t.getState());//bcz due to running of thread it will now show Runnable state.
            // System.out.println(t.isAlive());
        }
    }