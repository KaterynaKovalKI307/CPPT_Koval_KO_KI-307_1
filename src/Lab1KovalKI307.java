import java.io.*;
import java.util.*;


/**
 * Клас Lab1KovalKI307 реалізує програму для створення зубчатого масиву
 * і запису його у текстовий файл та виведення на екран.
 */
public class Lab1KovalKI307 {
    /**
     * Головний метод, що виконує основну логіку програми.
     *
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     * @throws FileNotFoundException Виникає, якщо файл не може бути створений або відкритий для запису.
     */
    public static void main(String[] args) throws FileNotFoundException {
        int nRows; // Змінна для зберігання розміру матриці
        char[][] arr; // Матриця для зберігання символів
        String filler; // Символ-заповнювач
        Scanner in = new Scanner(System.in); // Об'єкт для отримання вводу з клавіатури
        File dataFile = new File("MyFile.txt"); // Файл для запису результатів
        PrintWriter fout = new PrintWriter(dataFile); // Об'єкт для запису до файлу

        // Просимо користувача ввести розмір квадратної матриці
        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine(); // Перехід на наступний рядок після введення числа

        // Просимо користувача ввести символ-заповнювач
        System.out.print("Введіть символ-заповнювач: ");
        filler = in.nextLine();

        // Перевірка на правильність введення символу-заповнювача
        if (filler.length() != 1) {
            System.out.println("Помилка: Символ-заповнювач повинен бути рівно одним символом.");
            return; // Виходимо з програми
        }

        // Ініціалізація матриці розміром nRows x nRows
        arr = new char[nRows][nRows];

        // Заповнюємо ліву верхню половину і праву нижню половину матриці символом
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows; j++) {
                if (i < nRows / 2 && j < nRows / 2) {
                    arr[i][j] = filler.charAt(0);
                } else if (i >= nRows / 2 && j >= nRows / 2) {
                    arr[i][j] = filler.charAt(0);
                } else {
                    arr[i][j] = ' ';
                }
                fout.print(arr[i][j] + " "); // Записуємо символ у файл
            }
            fout.println(); // Перехід на наступний рядок у файлі
        }

        // Виводимо матрицю на екран
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(); // Перехід на наступний рядок у консолі
        }

        fout.flush(); // Зберігаємо дані у файл
        fout.close(); // Закриваємо файл
    }
}
