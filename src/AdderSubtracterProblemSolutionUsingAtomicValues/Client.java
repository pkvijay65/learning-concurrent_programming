package AdderSubtracterProblemSolutionUsingAtomicValues;

import java.util.concurrent.atomic.AtomicInteger;

public class Client {
  public static void main(String[] args) {
    AtomicInteger counter = new AtomicInteger(0);

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

    // The final value is 0 because we are using the AtomicInteger class
    // which is thread-safe. The AtomicInteger class is thread-safe because
    // it uses the compare-and-swap (CAS) algorithm.
    System.out.println("Final value: " + counter.get());
  }
}
