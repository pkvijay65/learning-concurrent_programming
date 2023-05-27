package AdderSubtractorProblemSolutionUsingSynchronizedMethods;

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
    // The final value is 0 because the object being shared, has all its
    // methods synchronized.

    //difference between synchronized methods and synchronized blocks
    //synchronized methods are synchronized on the object itself
    //synchronized blocks are synchronized on the object provided to it

    //the synchronized keyword is nothing but the syntactic sugar for the lock
    System.out.println("Final value: " + counter.get());
  }
}
