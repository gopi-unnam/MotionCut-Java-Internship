
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simple Calculator");
        System.out.println("Supported operations: +, -, *, /");

     
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

       
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Choose the operation (+,-,*,/): ");
        char operation = scanner.next().charAt(0);

        double result = calculate(num1, num2, operation);
        System.out.println("Result: " + result);

        scanner.close();
    }

    private static double calculate(double num1, double num2, char operation) {
        double result = 0;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    System.exit(1); 
                }
                break;
            default:
                System.out.println("Error: Unsupported operation.");
                System.exit(1); 
        }

        return result;
    }
}
  