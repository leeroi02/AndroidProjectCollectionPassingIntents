package com.example.androidprojectcollection;

import java.util.Stack;


public class Calculator {
    public float calculate(String expression, boolean pemdas) throws Exception {
        if (expression.isEmpty()) throw new Exception("Invalid input");

        Stack<Float> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (Character.isDigit(current) || current == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                i--;
                operands.push(Float.parseFloat(sb.toString()));
            } else {
                while (!operators.isEmpty() && precedence(operators.peek(), pemdas) >= precedence(current, pemdas)) {
                    evaluate(operands, operators);
                }
                operators.push(current);
            }
        }

        while (!operators.isEmpty()) {
            evaluate(operands, operators);
        }

        if (operands.size() != 1) throw new Exception("Invalid expression format");
        return operands.pop();
    }

    private void evaluate(Stack<Float> operands, Stack<Character> operators) {
        char operator = operators.pop();
        float value2 = operands.pop();
        float value1 = operands.pop();
        float result = 0;
        switch (operator) {
            case '+':
                result = value1 + value2;
                break;
            case '-':
                result = value1 - value2;
                break;
            case '*':
                result = value1 * value2;
                break;
            case '/':
                if (value2 == 0) throw new ArithmeticException("Division by zero");
                result = value1 / value2;
                break;
            case '%':
                result = value1 % value2;
                break;
        }
        operands.push(result);
    }

    private int precedence(char symbol, boolean pemdas) {
        if (!pemdas) return 1;
        switch (symbol) {
            case '^':
                return 3;
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}