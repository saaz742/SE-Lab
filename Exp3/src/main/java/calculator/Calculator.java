package calculator;

public class Calculator {
    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private double divide(int a, int b) {
        if (b == 0)
            throw new ArithmeticException("Division by zero is undefined");
        return (double) a / b;
    }

    private double power(int a, int b) {
        if (b < 0)
            if (a == 0)
                throw new ArithmeticException("0^(negative number) is undefined");
            else
                return (double) 1 / power(a, -b);
        else if (b == 0) {
            if (a == 0) {
                throw new ArithmeticException("0^0 is undefined");
            }
            return 1;
        }else if (b == 1) {
            return a;
        }else {
            double part = power(a, b / 2);
            if (b % 2 == 0) {
                return part * part;
            }else {
                return a * part * part;
            }
        }
    }

    public double calculate (int a, int b, char operator) {
        switch (operator) {
            case '+' -> {
                return add(a, b);
            }
            case '-' -> {
                return subtract(a, b);
            }
            case '*' -> {
                return multiply(a, b);
            }
            case '/' -> {
                return divide(a, b);
            }
            case '^' -> {
                return power(a, b);
            }
            default -> {
                throw new IllegalArgumentException("Invalid operator");
            }
        }
    }
}
