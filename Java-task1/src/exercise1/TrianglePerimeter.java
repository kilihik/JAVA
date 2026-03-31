package exercise1;
import java.util.Locale;
import java.util.Scanner;
class TrianglePerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        float x1 =  scanner.nextFloat();
        float y1 =  scanner.nextFloat();
        float x2 =  scanner.nextFloat();
        float y2 =  scanner.nextFloat();
        float x3 =  scanner.nextFloat();
        float y3 =  scanner.nextFloat();
        double AB = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        double BC = Math.sqrt(Math.pow(x1-x3,2) + Math.pow(y1-y3,2));
        double AC = Math.sqrt(Math.pow(x2-x3,2) + Math.pow(y2-y3,2));
        if (AB +BC > AC && AB + AC > BC && BC + AC > AB) {
            double per = AB + BC + AC;
            System.out.printf("Периметр: %.3f%n", per);
        } else {
            System.out.println("Это не треугольник");
        }
        scanner.close();

    }

}