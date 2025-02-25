public class Calculator {
    private int inp1;
    private int inp2;
    private int temp;
    private String operator;
    private String[] log = new String[100];
    Calculator(){
        temp = 0;
    }

    public void setValues(int inp1, int inp2, String operator) {
        this.inp1 = inp1;
        this.inp2 = inp2;
        this.operator = operator;
    }

    public int getInp1(){
        return inp1;
    }
    public int getInp2(){
        return inp2;
    }
    public String getOperator(){
        return operator;
    }

    public void setInp1(int inp1) {
        this.inp1 = inp1;
    }
    public void setInp2(int inp2) {
        this.inp2 = inp2;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void calc(){
        try{
            switch (operator) {
                case "+" -> {
                    System.out.println(inp1 + " + " + inp2 + " = " + (inp1 + inp2));
                    log[temp++]=inp1 + " + " + inp2 + " = " + (inp1 + inp2);
                }
                case "-" -> {
                    System.out.println(inp1 + " - " + inp2 + " = " + (inp1 - inp2));
                    log[temp++]=inp1 + " - " + inp2 + " = " + (inp1 - inp2);
                }
                case "*" -> {
                    System.out.println(inp1 + " * " + inp2 + " = " + (inp1 * inp2));
                    log[temp++]=inp1 + " * " + inp2 + " = " + (inp1 * inp2);
                }
                case "/" -> {
                    System.out.println(inp1 + " / " + inp2 + " = " + (inp1 / inp2));
                    log[temp++]=inp1 + " / " + inp2 + " = " + (inp1 / inp2);
                }
            }
        }catch(ArithmeticException e){
            System.out.println("Can't divide by zero");
        }
    }

    public void getLog(){
        for(int i = 0; i < temp; i++){
            System.out.println(i+1+". " + log[temp - 1 - i]);
        }
    }
}
