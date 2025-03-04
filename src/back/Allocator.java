package back;

public class Allocator {

    public String init(String input){
        String returnVal = "";
        if(input.charAt(0) == '@'){
            Command command = new Command();
            returnVal = command.init(input);
        }else{
            Calculator calculator = new Calculator();
            returnVal = calculator.init(input);
            Log log = Log.getInstance();
            log.addLog(returnVal);
            calculator = null;
        }
        return returnVal;
    }
}
