public class InputCommands {
    Printer printer = new Printer();
    InputCommands(String expression) {
        String command = expression.substring(1);
        Log log = Log.getInstance();

        switch (command) {
            //case "big":
            case "exit": System.exit(0); break;
            case "help": printer.help(); break;
            case "log": log.printLog(); break;

        }
    }
}
