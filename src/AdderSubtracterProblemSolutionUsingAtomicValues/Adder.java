package AdderSubtracterProblemSolutionUsingAtomicValues;

import java.util.concurrent.atomic.AtomicInteger;

public class Adder implements Runnable {

    private AtomicInteger counter;

    public Adder(AtomicInteger counter) {
      this.counter = counter;
    }

    public void run() {
      for (int i = 0; i < 10000; i++) {
        this.counter.incrementAndGet();
      }
    }
}
