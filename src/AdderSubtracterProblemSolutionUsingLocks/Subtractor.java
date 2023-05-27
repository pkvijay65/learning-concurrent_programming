package AdderSubtracterProblemSolutionUsingLocks;


import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {

  private Counter counter;
  private Lock lock;

  public Subtractor(Counter counter, Lock lock) {

    this.counter = counter;
    this.lock = lock;
  }

  public void run() {
    for (int i = 0; i < 10000; i++) {
      lock.lock();
      this.counter.decrement();
      lock.unlock();
    }
  }
}
