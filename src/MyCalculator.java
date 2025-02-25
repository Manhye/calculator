import java.util.Scanner;

public class MyCalculator {
    public static void main(String[] args) {
        int inp1, inp2;
        String operator;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please enter positive integer including zero(Type 'exit' to exit): )");
            inp1 = checkPositiveInteger(scanner);
            inp2 = checkPositiveInteger(scanner);

            System.out.println("Please enter the operator(+, -, *, /)");
            operator = checkOperator(scanner);

            try{
                switch (operator) {
                    case "+" -> System.out.println(inp1 + " + " + inp2 + " = " + (inp1 + inp2));
                    case "-" -> System.out.println(inp1 + " - " + inp2 + " = " + (inp1 - inp2));
                    case "*" -> System.out.println(inp1 + " * " + inp2 + " = " + (inp1 * inp2));
                    case "/" -> System.out.println(inp1 + " / " + inp2 + " = " + (inp1 / inp2));
                }
            }catch(ArithmeticException e){
                System.out.println("Can't divide by zero");
            }
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

    private static int checkPositiveInteger(Scanner scanner){
        while(true){
            String input = scanner.next();
            if(input.equalsIgnoreCase("exit")){ //When input value is "exit"
                System.out.println("Calculator exited");
                System.exit(0);
            }
            try {
                int value = Integer.parseInt(input); //Try to change String into integer
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