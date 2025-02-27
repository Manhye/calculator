import java.util.ArrayList;
import java.util.List;

public class Log {
    private static final Log instance = new Log();
    private final List<String> results;

    private Log() {
        results = new ArrayList<>();
    }

    public static Log getInstance() {
        return instance;
    }

    public void addLog(String log) {
        results.add(log);
    }

    public void printLog(){
        Printer printer = new Printer();
        printer.printLog(results);
    }
}
