package practice.concurrency;

/**
 *
 * Run two threads sequentially
 * The first one prints Hello and waits for the second to print Doge
 *
 */
public class SequentialThreads {
	
	private static Object lock = new Object();

	public static void twoSequentialThreads() {

		Runnable firstRunnable = () -> {
			for (int i = 1; i < 20; i++) {
				synchronized (lock) {
					System.out.print("Hello ");
					try {
						lock.notifyAll();
						lock.wait();
					} catch (InterruptedException e) {
						System.out.println("Error in Thread 1: "
								+ e.getMessage());
					}
				}
			}
		};

		Runnable secondRunnable = () -> {
			for (int i = 2; i <= 20; i++) {
				synchronized (lock) {
					System.out.println("Doge");
					try {
						lock.notifyAll();
						lock.wait();
					} catch (InterruptedException e) {
						System.out.println("Error in Thread 2: "
								+ e.getMessage());
					}
				}
			}
		};

		Thread firstThread = new Thread(firstRunnable);
		Thread secondThread = new Thread(secondRunnable);

		System.out.println("Brace yourself, greeting threads are coming !");
		firstThread.start();
		secondThread.start();
	}

}
