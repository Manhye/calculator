public enum Operator {
    PLUS("+"){
        public double calc(double a, double b) {
            return a + b;
        }
    },
    MINUS("-"){
        public double calc(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY("*"){
        public double calc(double a, double b) {
            return a * b;
        }
    },
    DIVIDE("/"){
        public double calc(double a, double b) {
            return a / b;
        }
    };

    private final String operator;
    private Operator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return operator;
    }

    public abstract double calc(double a, double b);

    public static Operator getOperator(String operator) {
        for(Operator op : Operator.values()){
            if(op.operator.equals(operator)){
                return op;
            }
        }
        return null;
    }
}
