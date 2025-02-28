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

    public void printBiggerLog(double inp){
        Printer printer = new Printer();
        List<String> biggerResults = results.stream()
                .filter(s -> {
                    try {
                        String sLastNumber = s.substring(s.lastIndexOf(" ") + 1);
                        double dTemp = Double.parseDouble(sLastNumber);
                        return dTemp > inp;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .toList();
        String str = String.join("\n", biggerResults);

        if (biggerResults.isEmpty()) {
            CalFrame.getInstance().setText("Biggest result, yet");
        } else {
            CalFrame.getInstance().setText(str);
        }

    }
    public String getCurrentLog() {
        if (results.isEmpty()) {
            return "No logs available";
        } else {
            return results.get(results.size() - 1);
        }
    }
}
