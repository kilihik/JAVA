package exercise5;

import java.util.Scanner;

public class MatchingFirst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int size;
        while (true) {
            try {
                size = Integer.parseInt(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                System.out.println("Не удалось обработать число. Пожалуйста, попробуйте еще раз");
            }
        }
        
        if (size <= 0) {
            System.out.println("Ошибка ввода. Размер <= 0");
            sc.close();
            return;
        }
        
        int[] numbers = new int[size];
        
        String line;
        int index = 0;
        
        while (index < size) {
            line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            
            String[] tokens = line.split("\\s+");
            
            for (String token : tokens) {
                if (index >= size) break;
                
                try {
                    numbers[index] = Integer.parseInt(token);
                    index++;
                } catch (Exception e) {
                    System.out.println("Не удалось обработать число. Пожалуйста, попробуйте еще раз");
                }
            }
        }
        
        int[] matchingNumbers = new int[size];
        int matchingCount = 0;
        
        for (int i = 0; i < size; i++) {
            if (hasSameFirstAndLastDigit(numbers[i])) {
                matchingNumbers[matchingCount] = numbers[i];
                matchingCount++;
            }
        }
        
        if (matchingCount == 0) {
            System.out.println("Таких элементов нет.");
        } else {
            for (int i = 0; i < matchingCount; i++) {
                System.out.print(matchingNumbers[i]);
                if (i < matchingCount - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        sc.close();
    }
    
    public static boolean hasSameFirstAndLastDigit(int number) {
        int absNumber = Math.abs(number);
        int lastDigit = absNumber % 10;
        int firstDigit = absNumber;
        
        while (firstDigit >= 10) {
            firstDigit /= 10;
        }
        
        return firstDigit == lastDigit;
    }
}