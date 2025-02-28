import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Queue;

public class Printer {
    List<Token> tokens = new ArrayList<>();
    public void basePrint(){
        System.out.println("Enter '@help' for extra commands");
    }
    public void invalidOperator(){
        System.out.println("Invalid operator");
    }
    public void printToken(List<Token> tokens){
        for(Token token : tokens){
            System.out.print(token.value+" ");
        }
        System.out.println();
    }

    public String printResult(double result, List<Token> tokens){
        String log = "";
        for(Token token : tokens){
            System.out.print(token.value+" ");
            log += token.value + " ";
        }
        System.out.println("= " + BigDecimal.valueOf(result).stripTrailingZeros().toPlainString());
        log += "= " + BigDecimal.valueOf(result).stripTrailingZeros().toPlainString();
        return log;
    }

    public void help(){
        String help = "Command List\n" +
                "@big + (number) : show bigger results\n" +
                "@exit: exit the program\n" +
                "@help: show other commands\n"+
                "@log: show logs";
        System.out.println(help);
        CalFrame.getInstance().setText(help);
    }

    public void printLog(List<String> results) {
        String log = "";
        for(String line : results){
            System.out.println(line);
            log +=  line + "\n";
        }
        CalFrame.getInstance().setText(log);
    }
}
