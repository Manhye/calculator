package back;
import java.util.ArrayList;
import java.util.List;

public class Log {
    private static final Log instance = new Log();
    private final List<String> logs = new ArrayList<>();

    public void addLog(String log){
        logs.add(log);
    }

    public String getLog(){
        return String.join("\n", logs);
    }

    public static Log getInstance(){
        return instance;
    }

    public String getBigger(double inp){
        List<String> returnVal = logs.stream()
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
        String str = String.join("\n", returnVal);
        if(returnVal.isEmpty()){
            return "Biggest result, yet";
        }else{
            return str;
        }
    }
}
