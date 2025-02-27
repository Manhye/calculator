public enum Operator {


    PLUS("+",(a,b) -> a+b,4),
    MINUS("-",(a,b) -> a-b, 4),
    MULTIPLY("*",(a,b) -> a*b, 3),
    DIVIDE("/",(a,b) -> a/b, 3),

    LEFT_PARENTHESIS("(", null, 2),
    RIGHT_PARENTHESIS(")", null,2);


    private String operator;
    private Operation operation;
    private int priority;

    Operator(){};

    Operator(String operator, Operation operation, int priority) {
        this.operator = operator;
        this.operation=operation;
        this.priority=priority;
    }


    @Override
    public String toString() {
        return operator;
    }

    public int getPriority() {
        return priority;
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

    public static Boolean checkOperator(String operator) {
        Operator op = Operator.getOperator(operator);
        if(op == null){
            throw new IllegalArgumentException("Invalid Operator: " + operator);
        }else{
            return true;
        }
    }
}
