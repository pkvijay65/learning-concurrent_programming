package AdderSubtracterProblem;


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
    // The final value presumably be 0, but it is not.
    // The final value is not 0 because the adder and subtractor threads
    // are not synchronized. The adder and subtractor threads are not
    // synchronized because the counter is not synchronized.
    System.out.println("Final value: " + counter.get());
  }
}
