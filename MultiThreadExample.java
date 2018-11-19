import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;



public class MultiThreadExample {

static AtomicBoolean isEven = new AtomicBoolean(false);
static AtomicInteger atomicNumber = new AtomicInteger(1);
static Object object = new Object();

public static void main(String[] args) {
    Runnable print = () -> {
        while (atomicNumber.get() <= 100) {
            synchronized (object) {
                if ((atomicNumber.get() % 2 == 0) && "Even".equals(Thread.currentThread().getName())) {
                    System.out.println("The Number is : " + ":" + atomicNumber.getAndIncrement());
                } else if ((atomicNumber.get() % 2 != 0) && "Odd".equals(Thread.currentThread().getName())) {
                    System.out.println("The Number is : " + ":" + atomicNumber.getAndIncrement());
                }
            }
        }
    };

    Thread t1 = new Thread(print);
    t1.setName("Even");
    t1.start();
    Thread t2 = new Thread(print);
    t2.setName("Odd");
    t2.start();

}
}
