package calculator;

import java.util.Scanner;

public class Parser {
    static class Inputs {
        public int first;
        public int second;
        public char operator;
    }

    static Inputs parse(String input) {
        Inputs inputs = new Inputs();
        try {
            String[] parts = input.split(" ");
            inputs.first = Integer.parseInt(parts[0]);
            inputs.second = Integer.parseInt(parts[2]);
            inputs.operator = parts[1].charAt(0);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input");
        }
        return inputs;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            Inputs inputs = parse(input);
            try {
                double result = calculator.calculate(inputs.first, inputs.second, inputs.operator);
                System.out.println(result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
