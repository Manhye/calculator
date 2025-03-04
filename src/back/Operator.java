package back;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+",(a,b) -> a+b,4),
    MINUS("-",(a,b) -> a-b, 4),
    MULTIPLY("*",(a,b) -> a*b, 3),
    DIVIDE("/",(a,b) -> a/b, 3),

    LEFT_PARENTHESIS("(", null, 2),
    RIGHT_PARENTHESIS(")", null,2),

    FACTORIAL("!", (a, b) ->{
        double result = 1;
        for(int i = 1; i <= a; i++){
            result*=i;
        }
        return result;
    }, 0),
    POWER("^",(a,b) -> Math.pow(a,b), 1);


    private String operator;
    private BiFunction<Double, Double, Double> operation;
    private final int priority;


    Operator(String operator, BiFunction<Double, Double, Double> operation, int priority) {
        this.operator = operator;
        this.operation=operation;
        this.priority=priority;
    }
    public double calc(double a, double b) {
        return operation.apply(a,b);
    }

    public String getOperator(){
        return operator;
    }

    public static Operator getOperator(String operator) {
        for(Operator op : Operator.values()){
            if(op.operator.equals(operator)){
                return op;
            }
        }
        return null;
    }

    public int getPriority(){
        return this.priority;
    }

    public static int getPriority(String symbol) {
        for (Operator op : values()) {
            if (op.operator.equals(symbol)) {
                return op.priority;
            }
        }
        return -1;
    }

}

