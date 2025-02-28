import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputProcessor iProcessor = new InputProcessor();
        Calculator calculator = new Calculator();
        Log log = Log.getInstance();
        OutputProcessor oProcessor = new OutputProcessor();
        List<Token> tokens = new ArrayList<Token>();
        Printer printer = new Printer();
        CalFrame calFrame = CalFrame.getInstance();
        double result=0;

//        while(true){
//            tokens = iProcessor.init();
//            result = calculator.init(tokens);
//            oProcessor.init(result, tokens);
//
//            tokens.clear();
//        }
    }
}