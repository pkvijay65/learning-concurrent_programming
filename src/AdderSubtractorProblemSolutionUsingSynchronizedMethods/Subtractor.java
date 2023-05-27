package AdderSubtractorProblemSolutionUsingSynchronizedMethods;

public class Subtractor implements Runnable{

    private Counter counter;

    public Subtractor(Counter counter) {
      this.counter = counter;
    }

    public void run() {
      for (int i = 0; i < 10000; i++) {
        this.counter.decrement();
      }
    }
}
