package exercise2;

import java.util.Scanner;

public class Calculating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            if (x < 0) {
                System.out.println("Неверное время");
            } else {
                int h = x / 3600;
                int m = (x % 3600) / 60;
                int s = x % 60;
                System.out.printf("%02d:%02d:%02d%n", h, m, s);
            }
        } else {
            System.out.println("Не удалось обработать число. Пожалуйста, попробуйте еще раз");
            scanner.next();
        }
        scanner.close();
    }
}