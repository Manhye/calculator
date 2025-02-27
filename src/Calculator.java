import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class Calculator {
    private double inp1;
    private double inp2;
    private Operator operator;
    private Queue<String> log = new LinkedList<>();
    Calculator(){}

    public void setValues(double inp1, double inp2, Operator operator) {
        this.inp1 = inp1;
        this.inp2 = inp2;
        this.operator = operator;
    }

    public double getInp1(){
        return inp1;
    }
    public double getInp2(){
        return inp2;
    }
    public Operator getOperator(){
        return operator;
    }

    public void setInp1(double inp1) {
        this.inp1 = inp1;
    }
    public void setInp2(double inp2) {
        this.inp2 = inp2;
    }
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void calc(){
        try{
            BigDecimal b1 = BigDecimal.valueOf(inp1);
            BigDecimal b2 = BigDecimal.valueOf(inp2);

            BigDecimal bResult = BigDecimal.valueOf(operator.calc(inp1, inp2));
            String sResult = String.format("%s %s %s = %s", b1.stripTrailingZeros().toPlainString(),
                    operator, b2.stripTrailingZeros().toPlainString(), bResult.stripTrailingZeros().toPlainString());

            System.out.println(sResult);
            log.add(sResult);

        }catch(ArithmeticException e){
            System.out.println("Can't divide by zero");
        }
    }

    public void getLog(){
        Iterator<String> it = log.iterator();
        int index = 0;
        while(it.hasNext()){
            index++;
            System.out.println(index+". " + it.next());
        }
    }

    public void getBig(double dComp) {
        int count = (int) log.stream()
                .filter(s -> {
                    try {
                        String sLastNumber = s.substring(s.lastIndexOf(" ") + 1);
                        double dTemp = Double.parseDouble(sLastNumber);
                        return dTemp > dComp;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .peek(s -> System.out.println(s))
                .count();
        if (count == 0) {
            System.out.println("Biggest result, yet");
        }
    }


}
