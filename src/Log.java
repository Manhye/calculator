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
        int count = (int) results.stream()
                        .filter(s -> {
                            try{
                                String sLastNumber = s.substring(s.lastIndexOf(" ")+1);
                                double dTemp = Double.parseDouble(sLastNumber);
                                return dTemp > inp;
                            }catch(NumberFormatException e){
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
