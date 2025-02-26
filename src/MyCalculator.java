import java.util.Scanner;

public class MyCalculator {
    public static void main(String[] args) {
        Calculator myCalc = new Calculator();
        double inp1, inp2;
        Operator operator;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please enter two positive integers including zero\nEnter \"exit\" to exit\nEnter \"log\" to show all logs");
            inp1 = checkPositiveInteger(scanner, myCalc);
            inp2 = checkPositiveInteger(scanner, myCalc);

            System.out.println("Please enter the operator(+, -, *, /)");
            operator = checkOperator(scanner);

            myCalc.setValues(inp1, inp2, operator);
            myCalc.calc();
        }
    }

    private static Operator checkOperator(Scanner scanner) {
        while(true){
            String input = scanner.next();
            Operator op = Operator.getOperator(input);
            if(op == null){
            System.out.println("Invalid operator");
            }else{
                return op;
            }
        }
    }

    private static double checkPositiveInteger(Scanner scanner, Calculator myCalc) {
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
            try {
                double value = Double.parseDouble(input); // Try to change String into integer

                return value;
            } catch (NumberFormatException e) {
                System.out.println("Not a number. Please try again");
            }
        }
    }
}

