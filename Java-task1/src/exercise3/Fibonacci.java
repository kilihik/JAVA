package exercise3;

import java.util.Scanner;

public class Fibonacci {
    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }    
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("");
            
            try {
                int n = sc.nextInt();
                if (n < 0) {
                    System.out.println("Номер не может быть отрицательным!");
                    continue;
                }
                if (n > 92) {
                    System.out.println("Слишком большое n");
                    continue;
                }
                long result = fibonacci(n);
                System.out.println(result);
                break;
                
            } catch (Exception e) {
                System.out.println("Не удалось обработать число. Пожалуйста, попробуйте еще раз");
                sc.next(); 
            }
        }
        
        sc.close();
    }
}