package model;


import java.util.Stack;

public class Calculator {
    private String expression;

    public Calculator(String expression) {
        this.expression = expression;
    }

    public  double calculateExpression(String expression) {
        expression = expression.replaceAll("\\s+", ""); // Eliminar espacios en blanco
        Stack<Double> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        String[] tokens = expression.split("(?<=\\()|(?=\\()|(?<=\\))|(?=\\))|(?<=[+\\-*/])|(?=[+\\-*/])");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            } else if (token.equals("(")) {
                operatorStack.push("(");
            } else if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.pop(); // Remove '('
            } else if (isOperator(token)) {
                char operator = token.charAt(0);
                while (!operatorStack.isEmpty() && getOperatorPrecedence(operator) <= getOperatorPrecedence(operatorStack.peek().charAt(0))) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.push(token);
            } else if (isFunction(token)) {
                operatorStack.push(token);
            } else if (isNumeric(token)) {
                operandStack.push(Double.parseDouble(token));
            } else {
                throw new IllegalArgumentException("Token desconocido: " + token);
            }
        }

        while (!operatorStack.isEmpty()) {
            processOperator(operandStack, operatorStack);
        }

        return operandStack.pop();
    }

    public  boolean isOperator(String token) {
        return token.matches("[+\\-*/]");
    }

    public  int getOperatorPrecedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    public  boolean isFunction(String token) {
        return token.equals("sen") || token.equals("cos");
    }

    public  boolean isNumeric(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }

    public  void processOperator(Stack<Double> operandStack, Stack<String> operatorStack) {
        String operator = operatorStack.pop();
        if (isFunction(operator)) {
            double operand = operandStack.pop();
            double result = applyFunction(operator, operand);
            operandStack.push(result);
        } else {
            char op = operator.charAt(0);
            double operand2 = operandStack.pop();
            double operand1 = operandStack.pop();
            double result = performOperation(operand1, operand2, op);
            operandStack.push(result);
        }
    }

    public double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Operador desconocido: " + operator);
        }
    }

    public double applyFunction(String function, double operand) {
        switch (function) {
            case "sen":
                return Math.sin(Math.toRadians(operand));
            case "cos":
                return Math.cos(Math.toRadians(operand));
            default:
                throw new IllegalArgumentException("Función desconocida: " + function);
        }
    }

    public String getExpression() {
        return expression;
    }
}
