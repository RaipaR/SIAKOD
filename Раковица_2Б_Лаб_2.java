// Класс, представляющий узел стека
class StackNode<T> {
    private T data;
    private StackNode<T> next;

    public StackNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }
}

// Класс, реализующий стек
class Stack<T> {
    private StackNode<T> top; // указатель на вершину стека

    public Stack() {
        this.top = null;
    }

    // Метод для проверки, является ли стек пустым
    public boolean isEmpty() {
        return top == null;
    }

    // Метод для добавления элемента на вершину стека
    public void push(T item) {
        StackNode<T> newNode = new StackNode<>(item);

        // Устанавливаем новый узел как вершину стека и обновляем ссылку на предыдущую вершину
        newNode.setNext(top);
        top = newNode;
    }

    // Метод для удаления элемента с вершины стека и возвращения его значения
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // Получаем значение элемента на вершине стека
        T item = top.getData();

        // Обновляем ссылку на вершину стека
        top = top.getNext();

        return item;
    }

    // Метод для получения значения элемента на вершине стека без удаления
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        return top.getData();
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Верхний элемент: " + stack.peek());

        System.out.println("Извлеченные элементы:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
