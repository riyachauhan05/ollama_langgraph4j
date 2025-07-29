package com.example.bot;

import dev.langchain4j.agent.tool.Tool;

public class CalculatorTool {

    @Tool("Add two numbers")
    public int add(int a, int b) {
        return a + b;
    }

    @Tool("Multiply two numbers")
    public int multiply(int a, int b) {
        return a * b;
    }

    @Tool("Subtract second number from first number")
    public int subtract(int a, int b) {
        return a - b;
    }

    @Tool("Divide first number by second number")
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is undefined.");
        }
        return (double) a / b;
    }
}
