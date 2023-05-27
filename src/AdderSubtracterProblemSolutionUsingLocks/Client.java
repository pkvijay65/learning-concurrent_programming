package AdderSubtracterProblemSolutionUsingLocks;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
  public static void main(String[] args) {
    Counter counter = new Counter();

    Lock lock = new ReentrantLock();

    Adder adder = new Adder(counter, lock);
    Subtractor subtractor = new Subtractor(counter, lock);

    Thread adderThread = new Thread(adder);
    Thread subtractorThread = new Thread(subtractor);

    adderThread.start();
    subtractorThread.start();
    try {
      adderThread.join();
      subtractorThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // The final value will be 0 because the adder and subtractor threads
    // are synchronized via the lock. Critical sections are protected by
    // the lock.
    System.out.println("Final value: " + counter.get());
  }
}
