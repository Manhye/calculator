import java.util.List;

public class OutputProcessor {
    Log log = Log.getInstance();

    public void init(double result, List<Token> tokens){
        Printer printer = new Printer();
        String sLog = printer.printResult(result, tokens);
        log.addLog(sLog);
    }
}
