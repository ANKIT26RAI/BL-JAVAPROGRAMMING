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

/* 
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

    */

// class MyThreads extends Thread 
// {
//     public void run(){
//         int count =1;
//         while (true) {
//             System.out.println(count++ + "My Thread");
//         }
//     }
// }
// public class Multithreading {

//     public static void main(String[] args) {
//         MyThreads t = new MyThreads();
//         //t.setDaemon(true);
//         t.start();

//         // try {
//         //     Thread.sleep(100);
//         // } catch (Exception e) {
//         //     // TODO: handle exception
//         //     System.out.println(e);
//         // }

//         //Thread mainThread = Thread.currentThread();
//         // try {
//         //     mainThread.join();
//         // } catch (Exception e) {
//         //     // TODO: handle exception
//         //     System.out.println(e);
//         // }
//         int count =1;
//         while (true) {
//             System.out.println(count++ + " Main");
//         Thread.yield();
//         }
//     }
// }



//--------------------Synchronization-------------------------
//1.Resource Sharing.
//2.Critical Section.
//3.Mutual Exclusion.
//4.Locking/Mutex.
//5.Semaphore.
//6.Monitor.
//7.Race Condition.
//8.Inter Thread Communication.

/*
// 1. RESOURCE SHARING — Multiple threads accessing same variable/object
int balance = 1000; // ← shared by all threads

// 2. CRITICAL SECTION — Code block that accesses shared resource
count++; // ← only one thread should run this at a time

// 3. MUTUAL EXCLUSION — Only one thread in critical section at a time
public synchronized void increment() { count++; }

// 4. LOCKING/MUTEX — Mechanism that enforces mutual exclusion
ReentrantLock lock = new ReentrantLock();
lock.lock();   // acquire
lock.unlock(); // release

// 5. SEMAPHORE — Controls how many threads access a resource at once
Semaphore sem = new Semaphore(3); // allows 3 threads simultaneously
sem.acquire();
sem.release();

// 6. MONITOR — synchronized block using any object as a lock
synchronized(obj) {
    // only one thread at a time
}

// 7. RACE CONDITION — Bug when output depends on thread execution order
count++; // ⚠️ two threads reading/writing same time = unpredictable result

// 8. INTER-THREAD COMMUNICATION — Threads signaling each other
obj.wait();        // release lock and wait
obj.notify();      // wake up one waiting thread
obj.notifyAll();   // wake up all waiting threads

*/

//------------------What is Monitor------------
/* 
A Monitor is an object that provides mutual exclusion + inter-thread communication together.
Every Java Object has:
┌────────────────────────────┐
│         MONITOR            │
│  ┌─────────────────────┐   │
│  │   Mutex (Lock)      │   │  ← only 1 thread inside at a time
│  └─────────────────────┘   │
│  ┌─────────────────────┐   │
│  │   Wait Set          │   │  ← threads waiting (called wait())
│  └─────────────────────┘   │
│  ┌─────────────────────┐   │
│  │   Entry Set         │   │  ← threads trying to acquire lock
│  └─────────────────────┘   │
└────────────────────────────┘
*/
// class MyData
// {
//  synchronized   void display(String str)
//     {
//         for(int i=0;i<str.length();i++)
//         {
//             System.out.print(str.charAt(i));
//     }
//     }
// }

// class MyThread1 extends Thread
// {
//     MyData d;
//     MyThread1(MyData d)
//     {
//         this.d= d;
//     }
//     public void run()
//     {
//         d.display("Hello World ");
//     }

// }

// class MyThread2 extends Thread
// {
//     MyData data;
//     MyThread2(MyData data){
//         this.data=data;
//     }
//     public void run(){
//         data.display("Welcome");
//     }
// }
// public class Multithreading {

//     public static void main(String[] args) {
//         MyData d = new MyData();
//         MyThread1 t1= new MyThread1(d);
//         MyThread2 t2 = new MyThread2(d);
//         t1.start();
//         t2.start();
//     }
// }

/* 
//Student challenge ATM.

class BankAccount {
    private int balance = 10000;

    public synchronized void withdraw(String person, int amount) {
        System.out.println(person + " is checking balance...");

        if (balance >= amount) {
            System.out.println(person + " withdrawing " + amount);
            
            try { Thread.sleep(1000); }  // simulating ATM processing time
            catch (InterruptedException e) {}

            balance -= amount;
            System.out.println(person + " ✅ Done! Remaining: " + balance);
        } else {
            System.out.println(person + " ❌ Insufficient balance: " + balance);
        }
    }
}

class ATMThread extends Thread {
    BankAccount account;
    String personName;
    int amount;

    ATMThread(BankAccount account, String personName, int amount) {
        this.account = account;
        this.personName=personName;
        this.amount=amount;
    }

    public void run() {
        System.out.println(personName + " is WAITING for ATM...");
        account.withdraw(personName, amount);
    }
}

public class Multithreading {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        ATMThread t1 = new ATMThread(account, "Ankit", 100000);
        ATMThread t2 = new ATMThread(account, "Bob", 9000000);
        ATMThread t3 = new ATMThread(account, "charlie", 8900000);

        t1.start();
        t2.start();
        t3.start();
    }
}
    */

//-----------Inter-THREAD Communication.------------------

Inter-Thread Communication allows threads to talk to each other.
Used when one thread depends on another thread's result.

3 Key Methods (must be inside synchronized block):
┌─────────────────────────────────────────────────────┐
│  wait()      → release lock + pause this thread     │
│  notify()    → wake up ONE waiting thread           │
│  notifyAll() → wake up ALL waiting threads          │
└─────────────────────────────────────────────────────┘

Demo — Basic Producer Consumer

class Shared {
    int data;
    boolean hasData = false;

    // Producer puts data
    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait();           // ← wait if data not consumed yet
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();             // ← wake consumer
    }

    // Consumer takes data
    public synchronized void consume() throws InterruptedException {
        while (!hasData) {
            wait();           // ← wait if no data yet
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify();             // ← wake producer
    }
}

public class Demo {
    public static void main(String[] args) {
        Shared s = new Shared();

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) s.produce(i);
            } catch (InterruptedException e) {}
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) s.consume();
            } catch (InterruptedException e) {}
        });

        producer.start();
        consumer.start();
    }
}


//Student — Teacher Challenge
📚 Scenario:
   Teacher prepares a lesson → notifies Student
   Student studies lesson   → notifies Teacher for next
   Repeat for 5 lessons

Lessons: ["Arrays", "Loops", "OOP", "Threads", "Collections"]


class Classroom {
    String lesson;
    boolean lessonReady = false;

    // TODO 1: Teacher prepares lesson (synchronized)
    public _______ void teachLesson(String topic) throws InterruptedException {
        // TODO 2: Wait if previous lesson not studied yet
        while (_______) {
            _______;
        }
        lesson = topic;
        lessonReady = _______;
        System.out.println("👨‍🏫 Teacher taught: " + topic);
        // TODO 3: Notify student
        _______;
    }

    // TODO 4: Student studies lesson (synchronized)
    public _______ void studyLesson() throws InterruptedException {
        // TODO 5: Wait if no lesson ready
        while (_______) {
            _______;
        }
        System.out.println("👨‍🎓 Student studied: " + lesson);
        lessonReady = _______;
        // TODO 6: Notify teacher
        _______;
    }
}

class Teacher extends Thread {
    Classroom room;
    String[] lessons = {"Arrays", "Loops", "OOP", "Threads", "Collections"};

    Teacher(Classroom room) {
        // TODO 7: initialize
        _______;
    }

    public void run() {
        try {
            // TODO 8: loop through lessons and teach each
            for (String lesson : _______) {
                room._______(lesson);
            }
        } catch (InterruptedException e) {}
    }
}

class Student extends Thread {
    Classroom room;

    Student(Classroom room) {
        // TODO 9: initialize
        _______;
    }

    public void run() {
        try {
            // TODO 10: study 5 lessons
            for (int i = 0; i < _______; i++) {
                room._______();
            }
        } catch (InterruptedException e) {}
    }
}

public class School {
    public static void main(String[] args) {
        // TODO 11: Create classroom, teacher, student and start
        Classroom room = _______;
        Teacher t = _______;
        Student s = _______;
        _______;
        _______;
    }
}