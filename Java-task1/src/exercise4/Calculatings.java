package exercise4;

import java.util.Scanner;

public class Calculatings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        while (true) {
            try {
                x = Integer.parseInt(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                System.out.println("Не удалось обработать число. Пожалуйста, попробуйте еще раз");
            }
        }
        if (x <= 0) {
            System.out.println("Ошибка ввода. Размер <= 0");
            sc.close();
            return;
        }
        int[] mas = new int[x];
        int sum = 0;
        int count = 0;
        for (int y = 0; y < x; y++) {
            mas[y] = sc.nextInt();
        }
        for (int y = 0; y < x; y++) {
            if (mas[y] < 0) {
                sum += mas[y];
                count++;
            }
        }
        if (count > 0) {
            double sred = (double) sum / count;
            if (sred == (int) sred) {
                System.out.println((int) sred);
            } else {
                System.out.println(sred);
            }
        } else {
            System.out.println("Отрицательных элементов нет.");
        }
        
        sc.close();
    }
}