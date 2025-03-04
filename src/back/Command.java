package back;

public class Command {
    private String help = "Command List\n" +
            "@big + (number) : show bigger results\n" +
            "@exit: exit the program\n" +
            "@help: show other commands\n"+
            "@log: show logs\n" +
            "@del: delete the first log";
    public String init(String input) {
        if(input.equals("@help")) {
            return help;
        }else if(input.equals("@exit")) {
            System.exit(0);
        }else if(input.equals("@log")) {
            Log log = Log.getInstance();
            return log.getLog();
        }else if(input.startsWith("@big")) {
            Log log = Log.getInstance();
            String sLastNumber = input.substring(input.lastIndexOf(" ") + 1);
            return log.getBigger(Double.parseDouble(sLastNumber));
        }else if(input.startsWith("@del")){
            Log log = Log.getInstance();
            return log.delete();
        }
        return "UNKNOWN VALUE";
    }
}
