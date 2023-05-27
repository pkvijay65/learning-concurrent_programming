package AdderSubtracterProblemSolutionUsingSynchronizedKeyword;

public class Client {
  public static void main(String[] args) {
    Counter counter = new Counter();

    Adder adder = new Adder(counter);
    Subtractor subtractor = new Subtractor(counter);

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
    // The final value is 0 because in the adder and subtractor threads,
    // the critical sections are protected by the synchronized keyword.
    // The synchronized keyword ensures that only one thread can access
    // the critical section at a time.

    //the synchronized keyword is nothing but the syntactic sugar for the lock
    System.out.println("Final value: " + counter.get());
  }
}
