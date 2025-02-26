public enum Operator {


    PLUS("+",(a,b) -> a+b),
    MINUS("-",(a,b) -> a-b),
    MULTIPLY("*",(a,b) -> a*b),
    DIVIDE("/",(a,b) -> a/b);

    private final String operator;
    private final Operation operation;

    Operator(String operator, Operation operation) {
        this.operator = operator;
        this.operation=operation;
    }


    @Override
    public String toString() {
        return operator;
    }


    public double calc(double a, double b){
        return operation.calc(a, b);
    }


    public static Operator getOperator(String operator) {
        for(Operator op : Operator.values()){
            if(op.operator.equals(operator)){
                return op;
            }
        }
        return null;
    }

}
