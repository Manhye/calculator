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
        System.out.println(
                "Command List\n" +
                        "@big + (number) : show bigger results\n" +
                        "@exit: exit the program\n" +
                        "@help: show other commands\n"
        );
    }

    public void printLog(List<String> results) {
        for(String line : results){
            System.out.println(line);
        }
    }
}
