import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class Calculator {
    private int inp1;
    private int inp2;
    private String operator;
    private Queue<String> log = new LinkedList<>();
    Calculator(){}

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
            String result = "";     // Feedback: Minimize repetitive parts
            switch (operator) {
                case "+" -> {
                    result = inp1 + " + " + inp2 + " = " + (inp1 + inp2);
                }
                case "-" -> {
                    result = inp1 + " - " + inp2 + " = " + (inp1 - inp2);
                }
                case "*" -> {
                    result = inp1 + " * " + inp2 + " = " + (inp1 * inp2);
                }
                case "/" -> {
                    result = inp1 + " / " + inp2 + " = " + (inp1 / inp2);
                }
            }
            System.out.println(result);
            log.add(result);

        }catch(ArithmeticException e){
            System.out.println("Can't divide by zero");
        }
    }

    public void getLog(){
        Iterator<String> it = log.iterator();
        int index = 1;
        while(it.hasNext()){
            System.out.println(index+". " + it.next());
            index++;
        }
    }
}
