import java.util.Random;

public class MCCAirPort {

    static class ArrayQueue<T> {
        private Object[] data;
        private int front;
        private int back;
        private int size;

        public ArrayQueue() {
            data = new Object[10];
            front = 0;
            back = -1;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int count() {
            return size;
        }

        public T peek() {
            if (isEmpty()) return null;
            return (T) data[front];
        }

        public void enqueue(T item) {
            if (size == data.length) {
                Object[] bigger = new Object[data.length * 2];
                for (int i = 0; i < size; i++)
                    bigger[i] = data[(front + i) % data.length];
                front = 0;
                back = size - 1;
                data = bigger;
            }
            back = (back + 1) % data.length;
            data[back] = item;
            size++;
        }

        public T dequeue() {
            if (isEmpty()) return null;
            T item = (T) data[front];
            front = (front + 1) % data.length;
            size--;
            return item;
        }
    }

    final double LANDING_TIME  = 3;
    final double TAKE_OFF_TIME = 2;
    final double LANDING_RATE  = 10;
    final double TAKE_OFF_RATE = 10;
    final int    ITERATIONS    = 1440;

    Random generator = new Random(System.currentTimeMillis());

    public void simulate() {
        ArrayQueue<Integer> landingQueue  = new ArrayQueue<>();
        ArrayQueue<Integer> takeOffQueue  = new ArrayQueue<>();

        int runwayFreeAt = 0;

        double totalLandingQueueLength  = 0;
        double totalTakeOffQueueLength  = 0;
        double totalLandingWaitTime     = 0;
        double totalTakeOffWaitTime     = 0;
        int    landingPlanesServed      = 0;
        int    takeOffPlanesServed      = 0;

        for (int minute = 1; minute <= ITERATIONS; minute++) {

            if (generator.nextDouble() < LANDING_RATE  / 60.0)
                landingQueue.enqueue(minute);
            if (generator.nextDouble() < TAKE_OFF_RATE / 60.0)
                takeOffQueue.enqueue(minute);

            totalLandingQueueLength += landingQueue.count();
            totalTakeOffQueueLength += takeOffQueue.count();

            if (minute >= runwayFreeAt) {
                if (!landingQueue.isEmpty()) {
                    int arrivalTime = landingQueue.dequeue();
                    totalLandingWaitTime += (minute - arrivalTime);
                    landingPlanesServed++;
                    runwayFreeAt = minute + (int) LANDING_TIME;
                } else if (!takeOffQueue.isEmpty()) {
                    int arrivalTime = takeOffQueue.dequeue();
                    totalTakeOffWaitTime += (minute - arrivalTime);
                    takeOffPlanesServed++;
                    runwayFreeAt = minute + (int) TAKE_OFF_TIME;
                }
            }
        }

        double avgLandingQueueLength = totalLandingQueueLength / ITERATIONS;
        double avgTakeOffQueueLength = totalTakeOffQueueLength / ITERATIONS;
        double avgLandingWaitTime    = landingPlanesServed  > 0 ? totalLandingWaitTime  / landingPlanesServed  : 0;
        double avgTakeOffWaitTime    = takeOffPlanesServed > 0  ? totalTakeOffWaitTime / takeOffPlanesServed : 0;

        System.out.printf("Average landing queue length:  %.6f%n", avgLandingQueueLength);
        System.out.printf("Average take off queue length: %.6f%n", avgTakeOffQueueLength);
        System.out.printf("Average landing queue time:    %.6f%n", avgLandingWaitTime);
        System.out.printf("Average take off queue time:   %.6f%n", avgTakeOffWaitTime);
    }

    public static void main(String[] args) {
        new MCCAirPort().simulate();
    }
}
