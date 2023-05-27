package ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Client {
  public static void main(String[] args) {
    Queue<Object> store = new LinkedList<>();
    Semaphore ps = new Semaphore(5);
    Semaphore cs = new Semaphore(0);

    System.out.println("Initial Store size is " + store.size());

    for(int i = 1; i <= 10; i++){
      Producer producer = new Producer("producer" + i, ps, cs, store);
      Thread threadForProd = new Thread(producer);
      threadForProd.start();

      Consumer consumer = new Consumer("consumer" + i, ps, cs, store);
      Thread threadForCon = new Thread(consumer);
      threadForCon.start();
    }

    // the store size never exceeds 5 because the producer and consumer
    // threads are synchronized using the ps and cs semaphores.

    //semaphore helps here over locks because we can have multiple producers and consumers
    //and we can control the number of producers and consumers that can access the store at a time
  }

}
