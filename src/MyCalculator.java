import java.util.Scanner;

public class MyCalculator {
    public static void main(String[] args) {
        Calculator myCalc = new Calculator();
        int inp1, inp2;
        String operator;
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

    private static String checkOperator(Scanner scanner) {
        while(true){
            String operator = scanner.next();
            if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                return operator;
            }else{
                System.out.println("Wrong operator");
            }
        }
    }

    private static int checkPositiveInteger(Scanner scanner, Calculator myCalc) {
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
                int value = Integer.parseInt(input); // Try to change String into integer
                if (value < 0) {
                    System.out.println("Please enter the positive integer or zero. Please try again");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Not a number. Please try again");
            }
        }
    }
}

