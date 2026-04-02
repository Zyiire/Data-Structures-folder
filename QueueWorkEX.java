class QueueOverflowException extends Exception{
    public QueueOverflowException(String message){
        super(message);
    }
}

class QueueUnderflowException extends Exception{
    public QueueUnderflowException(String message){
        super(message);
    }
}


public class QueueWorkEX {

    private int maxSize;
    private int[] queueArrays;
    private int front;
    private int rear;
    private int currentSize;

    public QueueWorkEX(int size){
        maxSize = size;
        queueArrays = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }

    public int front() throws QueueOverflowException{
        if(isEmpty()){
            throw new QueueOverflowException("Queue is empty");
        }

        return queueArrays[front];
    }

    public int back() throws QueueUnderflowException{
        if(isEmpty()){
            throw new QueueUnderflowException("Queue is empty");
        }

        return queueArrays[rear];
    }

    public void enqueue( int item)throws QueueOverflowException{
        if(isFull()){
            throw new QueueOverflowException("The queue is full");
        }

        rear = (rear + 1) % maxSize;
        queueArrays[rear] = item;
        currentSize++;
    }

    public int dequeue()throws QueueUnderflowException{
        if(isEmpty()){
            throw new QueueUnderflowException("Queue is empty");
        }

        int removeItem = queueArrays[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return removeItem;
    }

    public void findAndRemoveMinMax()throws QueueUnderflowException{
        if(!isEmpty()){
            int maxVal = Integer.MAX_VALUE; //2,147,483,647
            int minVal = Integer.MIN_VALUE; //-2,147,483,648

            for(int i = 0; 1 < currentSize; i++){
                int item = queueArrays[(front + i) % maxSize];
                minVal = Math.min(minVal, item);
                maxVal= Math.max(maxVal, item);
            }

            // remove the min and max
            removeValue(minVal);
            removeValue(maxVal);

            System.out.println("\nThe min is: " + minVal);
            System.out.println("\nThe max is: " + maxVal);
        }

        else{
            throw new QueueUnderflowException("Queue is empty");
        }
    }

    private void removeValue(int value){
        // find where the value is
        int indexToRemove = -1; 

        for(int i = 0; 1 < currentSize; i++){
            if(queueArrays[(front + 1) % maxSize] == value){
                indexToRemove = (front + i) % maxSize;
                break;
            }
        }

        if(indexToRemove != -1){
            for(int i = indexToRemove; 1 < currentSize -1; i++){
                queueArrays[i] = queueArrays[i + 1]; 
            }

            rear = (rear - 1 + maxSize) % maxSize;
            currentSize--;
        }
    }

    public static void main(String[] args) {
        QueueWorkEX queue = new QueueWorkEX(10);

        try{ 
            queue.enqueue(5);
            queue.enqueue(3);
            queue.enqueue(8);
            queue.enqueue(2);
            queue.enqueue(10);
            queue.enqueue(4);
            queue.enqueue(6);

            queue.findAndRemoveMinMax();

            //remaining elements in the Queue
            System.out.println("Remaining elements: ");
            while(!queue.isEmpty()){
                System.out.println(queue.dequeue());
            }
        } catch (QueueOverflowException | QueueUnderflowException e){
            e.printStackTrace();
        }
    }
}
