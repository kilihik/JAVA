package exercise6;

import java.util.Scanner;

public class Sortarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            System.out.println("Не удалось обработать число. Пожалуйста, попробуйте еще раз");
            return;
        }
        
        int size = sc.nextInt();
        
        if (size <= 0) {
            System.out.println("Ошибка ввода. Размер <= 0.");
            return;
        }
        
        sc.nextLine();
        
        double[] array = new double[size];
        
        String line = sc.nextLine();
        String[] numbers = line.trim().split("\\s+");
        
        if (numbers.length < size) {
            System.out.println("Не удалось обработать число. Пожалуйста, попробуйте еще раз");
            return;
        }

        for (int i = 0; i < size; i++) {
            try {
                array[i] = Double.parseDouble(numbers[i]);
            } catch (NumberFormatException e) {
                System.out.println("Не удалось обработать число. Пожалуйста, попробуйте еще раз");
                return;
            }
        }
   
        bubbleSort(array);
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}