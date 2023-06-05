public class Stack<T> { // Обобщенный класс Stack, параметризованный типом T
    private Node<T> top; // Вершина стека
    
    private static class Node<T> { // Вложенный статический класс Node, параметризованный типом T
        private T data; // Данные узла
        private Node<T> next; // Ссылка на следующий узел
        
        public Node(T data, Node<T> next) { // Конструктор класса Node
            this.data = data;
            this.next = next;
        }
    }
    
    public void push(T data) { // Метод добавления элемента в стек
        Node<T> node = new Node<>(data, top); // Создание нового узла
        top = node; // Обновление вершины стека
    }
    
    public T pop() { // Метод удаления элемента из стека
        if (top == null) { // Если стек пуст, выбрасываем исключение
            throw new EmptyStackException();
        }
        T data = top.data; // Получаем данные вершины стека
        top = top.next; // Обновляем вершину стека
        return data; // Возвращаем данные удаленного элемента
    }
    
    public T peek() { // Метод получения элемента с вершины стека
        if (top == null) { // Если стек пуст, выбрасываем исключение
            throw new EmptyStackException();
        }
        return top.data; // Возвращаем данные вершины стека
    }
    
    public boolean isEmpty() { // Метод проверки, пуст ли стек
        return top == null;
    }
}