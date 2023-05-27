package AdderSubtracterProblemSolutionUsingAtomicValues;

import java.util.concurrent.atomic.AtomicInteger;

public class Subtractor implements Runnable{

    private AtomicInteger counter;

    public Subtractor(AtomicInteger counter) {
      this.counter = counter;
    }

    public void run() {
      for (int i = 0; i < 10000; i++) {
        this.counter.decrementAndGet();
      }
    }
}
