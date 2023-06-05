// Класс, представляющий узел очереди

import java.util.NoSuchElementException;

class QueueNode<T> {
    private T data;
    private QueueNode<T> next;

    public QueueNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public QueueNode<T> getNext() {
        return next;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }
}

// Класс, реализующий очередь
class Queue<T> {
    private QueueNode<T> front; // указатель на начало очереди
    private QueueNode<T> rear;  // указатель на конец очереди

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // Метод для проверки, является ли очередь пустой
    public boolean isEmpty() {
        return front == null;
    }

    // Метод для добавления элемента в очередь
    public void enqueue(T item) {
        QueueNode<T> newNode = new QueueNode<>(item);

        // Если очередь пустая, новый элемент становится началом и концом очереди
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            // Иначе, добавляем новый элемент в конец очереди и обновляем указатель на конец
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    // Метод для удаления элемента из очереди и возвращения его значения
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        // Получаем значение элемента в начале очереди
        T item = front.getData();

        // Обновляем указатель на начало очереди
        front = front.getNext();

        // Если после удаления элемента очередь стала пустой, обновляем указатель на конец очереди
        if (front == null) {
            rear = null;
        }

        return item;
    }

    // Метод для получения значения элемента в начале очереди без удаления
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return front.getData();
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Первый элемент: " + queue.peek());

        System.out.println("Извлеченные элементы:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}