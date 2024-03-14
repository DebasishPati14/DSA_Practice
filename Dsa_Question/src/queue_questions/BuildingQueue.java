package queue_questions;

/*
Queue => 5 69 47 6 11 70
Top: 5
Deque: 5
Deque: 69
Top: 47
Queue => 100 0 47 6 11 70
Queue overflow
Queue overflow
Queue => 100 7 47 6 11 70
 */
public class BuildingQueue {

    public static void main(String[] args) {
        int[] arrayElements = { 5, 69, 47, 6, 11, 70 };

        CustomDynamicQueue queue = new CustomDynamicQueue(arrayElements.length);

        queue.remove();

        for (int item : arrayElements) {
            queue.add(item);
        }

        queue.display();

        System.out.println("Top: " + queue.top());
        System.out.println("Deque: " + queue.remove());
        System.out.println("Deque: " + queue.remove());
        System.out.println("Top: " + queue.top());
        queue.display();
        queue.add(100);
        queue.display();
        queue.add(7);
        queue.display();
        queue.add(33);
        queue.add(-87);

        queue.display();
    }

    public static class CustomQueue {
        private int[] data;
        private int first = 0;
        private int size = 0;

        CustomQueue(int size) {
            data = new int[size];
        }

        void add(int ele) {
            if (size == data.length) {
                System.out.println("Queue overflow");
            } else {
                int rear = (first + size) % this.data.length;
                data[rear] = ele;
                size++;
            }
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                int ele = data[first];
                data[first] = 0;
                first = (first + 1) % this.data.length;
                size--;
                return ele;
            }
        }

        int top() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return data[first];
            }
        }

        // int dequeue() {
        // if (endOfQue == -1) {
        // System.out.println("Queue underflow");
        // return -1;
        // } else {
        // int first = data[startOfQue];
        // data[startOfQue] = 0;
        // startOfQue++;
        // return first;
        // }
        // }
        // void enqueue(int item) {
        // if (endOfQue + 1 == data.length) {
        // if (startOfQue == 0) {
        // System.out.println("Queue overflow");
        // } else {
        // endOfQue = 0;
        // data[endOfQue] = item;
        // }
        // } else {
        // if (startOfQue == endOfQue + 1 && data[data.length - 1] != 0) {
        // System.out.println("Queue overflow");
        // } else {
        // endOfQue++;
        // data[endOfQue] = item;
        // }
        // }
        // }
        // int top() {
        // if (endOfQue == -1) {
        // System.out.println("Queue underflow");
        // return -1;
        // } else {
        // return data[startOfQue];
        // }
        // }

        void display() {
            System.out.print("Queue => ");
            for (int i = 0; i < size; i++) {
                // for (int i : data) {
                int idx = (first + i) % this.data.length;
                System.out.print(data[idx] + " ");
                // }
            }
            System.out.println();
        }

    }

    public static class CustomDynamicQueue {
        private int[] data;
        private int first = 0;
        private int size = 0;

        CustomDynamicQueue(int size) {
            data = new int[size];
        }

        void add(int ele) {
            if (size == data.length) {
                // System.out.println("Queue overflow");
                int[] newData = new int[2 * this.data.length];
                for (int i = 0; i < size; i++) {
                    int idx = (i + first) % data.length;
                    newData[i] = data[idx];
                    System.out.println(newData[i] + "Ele" + data[idx]);
                }
                this.data = newData;
                // first++;
                // int rear = (first + size) % this.data.length;
                data[size] = ele;
                size++;
                first = 0;
            } else {
                int rear = (first + size) % this.data.length;
                data[rear] = ele;
                size++;
            }
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                int ele = data[first];
                data[first] = 0;
                first = (first + 1) % this.data.length;
                size--;
                return ele;
            }
        }

        int top() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return data[first];
            }
        }

        void display() {
            System.out.print("Queue => ");
            for (int i = 0; i < size; i++) {
                int idx = (i + first) % this.data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }
    }

}
