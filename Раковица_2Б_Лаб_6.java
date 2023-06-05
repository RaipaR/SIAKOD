import java.util.HashSet;

// Класс, реализующий множество
class Set<T> {
    private HashSet<T> set;

    public Set() {
        this.set = new HashSet<>();
    }

    // Метод для добавления элемента в множество
    public void add(T item) {
        set.add(item);
    }

    // Метод для удаления элемента из множества
    public void remove(T item) {
        set.remove(item);
    }

    // Метод для проверки, содержится ли элемент в множестве
    public boolean contains(T item) {
        return set.contains(item);
    }

    // Метод для получения размера множества
    public int size() {
        return set.size();
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new Set<>();

        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println("Размер множества: " + set.size());
        System.out.println("Содержит элемент 2: " + set.contains(2));

        set.remove(3);

        System.out.println("Размер множества после удаления: " + set.size());
        System.out.println("Содержит элемент 3: " + set.contains(3));
    }
}
