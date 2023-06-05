import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    // Метод для сортировки массива с использованием алгоритма сортировки пузырьком
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Обмен элементов
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    // Метод для сортировки массива с использованием алгоритма быстрой сортировки
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Обмен элементов
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Обмен элементов
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // Создание массива случайных чисел
        int[] smallArray = generateRandomArray(100);
        int[] largeArray = generateRandomArray(10000);

        // Измерение скорости работы алгоритма сортировки пузырьком для небольшого массива
        long startTime = System.nanoTime();
        bubbleSort(smallArray);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Время выполнения сортировки пузырьком (небольшой массив): " + duration + " наносекунд");

        // Измерение скорости работы алгоритма быстрой сортировки для небольшого массива
        startTime = System.nanoTime();
        quickSort(smallArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Время выполнения быстрой сортировки (небольшой массив): " + duration + " наносекунд");

        // Измерение скорости работы алгоритма сортировки пузырьком для крупного массива
        startTime = System.nanoTime();
        bubbleSort(largeArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Время выполнения сортировки пузырьком (крупный массив): " + duration + " наносекунд");

        // Измерение скорости работы алгоритма быстрой сортировки для крупного массива
        startTime = System.nanoTime();
        quickSort(largeArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Время выполнения быстрой сортировки (крупный массив): " + duration + " наносекунд");
    }

    // Метод для генерации случайного массива заданной длины
    private static int[] generateRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000); // Генерация случайного числа от 0 до 999
        }
        return array;
    }
}
