package exercise8;

import java.util.Scanner;

public class Ascendchek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        line = line.trim();
        
        if (line.isEmpty()) {
            System.out.println("Ошибка ввода");
            return;
        }

        String[] parts = line.split("\\s+");

        Integer prevNumber = null;
        int position = 1;

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            
            try {
                int currentNumber = Integer.parseInt(part);

                if (prevNumber != null) {
                    if (currentNumber < prevNumber) {
                        System.out.println("Последовательность не упорядочена по порядковому номеру числа " + i + ".");
                        return;
                    }
                }
                
                prevNumber = currentNumber;
                position++;
                
            } catch (NumberFormatException e) {
                if (i == 0) {
                    System.out.println("Ошибка ввода");
                    return;
                } else {
                    break;
                }
            }
        }
        System.out.println("Последовательность упорядочена в порядке возрастанию.");
    }
}