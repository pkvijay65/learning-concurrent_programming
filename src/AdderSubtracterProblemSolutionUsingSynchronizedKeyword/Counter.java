package AdderSubtracterProblemSolutionUsingSynchronizedKeyword;

public class Counter {
  private int val;

  public Counter() {
    this.val = 0;
  }

  public void increment() {
    this.val++;
  }

  public void decrement() {
    this.val--;
  }

  public int get() {
    return this.val;
  }
}
