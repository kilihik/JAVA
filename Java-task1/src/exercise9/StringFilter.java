package exercise9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int count = Integer.parseInt(scanner.nextLine().trim());
        
        List<String> strings = new ArrayList<>();
        
        for (int i = 0; i < count; i++) {
            strings.add(scanner.nextLine());
        }
        
        String filter = scanner.nextLine();
        scanner.close();

        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (str.contains(filter)) {
                result.add(str);
            }
        }
        
        if (result.isEmpty()) {
            System.out.println();
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}