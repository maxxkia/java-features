package jep444;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

public class VirtualThreadTest {

  /* Thread.Builder, Thread.ofVirtual(), and Thread.ofPlatform() are new APIs to create virtual
  and platform threads.

  Thread.startVirtualThread(Runnable) is a convenient way to create and then start a virtual thread.

  A Thread.Builder can create either a thread or a ThreadFactory, which can then create multiple threads with identical properties.

  Thread.isVirtual() tests whether a thread is a virtual thread.

  Thread.getAllStackTraces() now returns a map of all platform threads rather than all threads.

  */

  @Test
  void createVirtualThread() throws Exception {
    AtomicInteger integer = new AtomicInteger(0);
    Thread vthread = Thread.ofVirtual().name("vthread").unstarted(() -> {
      System.out.println("executing vthread");
      integer.compareAndExchange(1, 5);
    });

    integer.set(1);
    vthread.start();
    Thread.sleep(50L);
    assertThat(integer.get()).isEqualTo(5);
  }
}
