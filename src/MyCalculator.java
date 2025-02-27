import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyCalculator {
    public static void main(String[] args) {
        InputProcessor iProcessor = new InputProcessor();
        Calculator calculator = new Calculator();
        Log log = Log.getInstance();
        OutputProcessor oProcessor = new OutputProcessor();
        List<Token> tokens = new ArrayList<Token>();
        Printer printer = new Printer();

        double result=0;

        while(true){
            tokens = iProcessor.init();
            result = calculator.init(tokens);
            oProcessor.init(result, tokens);

            tokens.clear();
        }


    }
}
        //oProcessor.init();




/*
        Calculator myCalc = new Calculator();
        double inp1, inp2;
        Operator operator;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please enter two numbers\nEnter \"exit\" to exit\nEnter \"log\" to show all logs\nEnter \"big\" to show bigger results");
            inp1 = checkNumber(scanner, myCalc);
            inp2 = checkNumber(scanner, myCalc);

            System.out.println("Please enter the operator(+, -, *, /)");
            operator = checkOperator(scanner);

            myCalc.setValues(inp1, inp2, operator);
            myCalc.calc();
        }
    }*/

    /*private static Operator checkOperator(Scanner scanner) {
        while(true){
            String input = scanner.next();
            Operator op = Operator.getOperator(input);
            if(op == null){
            System.out.println("Invalid operator");
            }else{
                return op;
            }
        }
    }*/

/*
    private static double checkNumber(Scanner scanner, Calculator myCalc) {
        while(true){
            String input = scanner.next();
            if(input.equalsIgnoreCase("exit")){ // When input value is "exit"
                System.out.println("Calculator exited");
                System.exit(0);
            }
            if(input.equals("log")){
                myCalc.getLog();
                continue;
            }
            if(input.equals("big")){
                System.out.println("Please Enter number you want to compare");
                try{
                    double dComp = scanner.nextDouble();
                    myCalc.getBig(dComp);
                }catch(InputMismatchException e){
                    System.out.println("Not a number. Please try again");
                    scanner.next();
                }
                continue;
            }
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Not a number. Please try again");
            }
        }
    }
}
*/

