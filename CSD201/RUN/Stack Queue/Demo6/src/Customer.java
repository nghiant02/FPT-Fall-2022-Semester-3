import java.util.LinkedList;
import java.util.Random;

public class Customer extends Thread {
    static Random rand = new Random(System.currentTimeMillis());
    long delay;
    LinkedList<String> queue;
    Thread acc;

    public Customer(String custName, long delay, LinkedList<String> queue, Thread acc) {
        super(custName);
        this.delay = delay;
        this.queue = queue;
        this.acc = acc;
    }

    @Override
    public void run() {
        while (acc.isAlive()) {
            try {
                int price = 100 + rand.nextInt(100);
                String msg = this.getName() + ", " + price + "$";
                queue.addLast(msg);
                if (!acc.isAlive()) this.yield();
                else this.sleep(delay);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
