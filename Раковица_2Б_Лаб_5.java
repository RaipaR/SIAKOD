// Класс, представляющий узел бинарного дерева
class BinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
}

// Класс, реализующий бинарное дерево
class BinaryTree<T> {
    private BinaryTreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    // Метод для добавления элемента в бинарное дерево
    public void add(T item) {
        root = addRecursive(root, item);
    }

    // Рекурсивный метод для добавления элемента в бинарное дерево
    private BinaryTreeNode<T> addRecursive(BinaryTreeNode<T> current, T item) {
        if (current == null) {
            return new BinaryTreeNode<>(item);
        }

        if (compareItems(item, current.getData()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), item));
        } else if (compareItems(item, current.getData()) > 0) {
            current.setRight(addRecursive(current.getRight(), item));
        }

        return current;
    }

    // Метод для поиска элемента в бинарном дереве
    public boolean contains(T item) {
        return containsRecursive(root, item);
    }

    // Рекурсивный метод для поиска элемента в бинарном дереве
    private boolean containsRecursive(BinaryTreeNode<T> current, T item) {
        if (current == null) {
            return false;
        }

        if (compareItems(item, current.getData()) == 0) {
            return true;
        }

        if (compareItems(item, current.getData()) < 0) {
            return containsRecursive(current.getLeft(), item);
        } else {
            return containsRecursive(current.getRight(), item);
        }
    }

    // Метод для сравнения двух элементов
    private int compareItems(T item1, T item2) {
        if (item1 instanceof Comparable && item2 instanceof Comparable) {
            return ((Comparable<T>) item1).compareTo(item2);
        } else {
            throw new IllegalArgumentException("Items must implement Comparable interface");
        }
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        // Пример 1: Бинарное дерево строковых значений
        BinaryTree<String> stringTree = new BinaryTree<>();

        stringTree.add("apple");
        stringTree.add("banana");
        stringTree.add("orange");
        stringTree.add("grape");
        stringTree.add("cherry");

        System.out.println("Содержит элемент 'banana': " + stringTree.contains("banana"));
        System.out.println("Содержит элемент 'pear': " + stringTree.contains("pear"));

        // Пример 2: Бинарное дерево целых чисел
        BinaryTree<Integer> intTree = new BinaryTree<>();

        intTree.add(10);
        intTree.add(5);
        intTree.add(15);
        intTree.add(3);
        intTree.add(7);

        System.out.println("Содержит элемент 15: " + intTree.contains(15));
        System.out.println("Содержит элемент 8: " + intTree.contains(8));
    }
}
