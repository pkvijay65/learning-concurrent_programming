package AdderSubtractorProblemSolutionUsingSynchronizedMethods;

public class Counter {
  private int val;

  public Counter() {
    this.val = 0;
  }

  public synchronized void increment() {
    this.val++;
  }

  public synchronized void decrement() {
    this.val--;
  }

  public synchronized int get() {
    return this.val;
  }
}
