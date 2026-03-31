package exercise7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MaxandMin {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        consoleScanner.useLocale(Locale.US);

        String fileName = consoleScanner.nextLine().trim();
        
        String exactPath = "/Users/wilsonho/AP1_Jv_T01.ID_1369279-1/src/exercise7/" + fileName;
        File inputFile = new File(exactPath);
        
        System.out.println();
        
        if (!inputFile.exists()) {
            System.out.println("Ошибка ввода. Файл не существует.");
            consoleScanner.close();
            return;
        }
        
        try {
            Scanner fileScanner = new Scanner(inputFile);
            fileScanner.useLocale(Locale.US);

            if (!fileScanner.hasNextInt()) {
                System.out.println("Ошибка ввода. Недостаточное количество элементов");
                fileScanner.close();
                consoleScanner.close();
                return;
            }
            
            int count = fileScanner.nextInt();
            
            if (count <= 0) {
                System.out.println("Ошибка ввода. Размер <= 0");
                fileScanner.close();
                consoleScanner.close();
                return;
            }
            
            List<Double> numbers = new ArrayList<>();
            
            while (fileScanner.hasNext() && numbers.size() < count) {
                if (fileScanner.hasNextDouble()) {
                    double num = fileScanner.nextDouble();
                    numbers.add(num);
                } else {
                    fileScanner.next();
                }
            }
            
            fileScanner.close();
            
            if (numbers.size() < count) {
                System.out.println("Ошибка ввода. Недостаточное количество элементов");
                consoleScanner.close();
                return;
            }
            
            System.out.println(numbers.size());
            
            for (int i = 0; i < numbers.size(); i++) {
                System.out.print(numbers.get(i));
                if (i < numbers.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            double min = numbers.get(0);
            double max = numbers.get(0);
            
            for (double num : numbers) {
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }
            String resultPath = "/Users/wilsonho/AP1_Jv_T01.ID_1369279-1/src/exercise7/result.txt\"";
            PrintWriter writer = new PrintWriter(resultPath);
            writer.println(min + " " + max);
            writer.close();
            
            System.out.println("Сохранение минимального и максимального значений в файл");
            
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка ввода. Файл не существует.");
        }
        
        consoleScanner.close();
    }
}