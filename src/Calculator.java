import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int inp1, inp2;
        String operator;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("양의 정수를 2개 입력해 주세요(종료하려면 \"exit\"을 입력해주세요)");
            inp1 = checkPositiveInteger(scanner);
            inp2 = checkPositiveInteger(scanner);

            System.out.println("연산자를 입력해 주세요(+, -, *, /)");
            operator = checkOperator(scanner);

            try{
                switch (operator) {
                    case "+" -> System.out.println(inp1 + " + " + inp2 + " = " + (inp1 + inp2));
                    case "-" -> System.out.println(inp1 + " - " + inp2 + " = " + (inp1 - inp2));
                    case "*" -> System.out.println(inp1 + " * " + inp2 + " = " + (inp1 * inp2));
                    case "/" -> System.out.println(inp1 + " / " + inp2 + " = " + (inp1 / inp2));
                }
            }catch(ArithmeticException e){
                System.out.println("0으로 나눌 수는 없습니다.");
            }
        }
    }

    private static String checkOperator(Scanner scanner) {
        while(true){
            String operator = scanner.next();
            if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                return operator;
            }else{
                System.out.println("잘못된 연산자 입니다.");
            }
        }
    }

    private static int checkPositiveInteger(Scanner scanner){
        while(true){
            String input = scanner.next();
            if(input.equalsIgnoreCase("exit")){ //"exit"을 입력한 경우 종료
                System.out.println("계산기 종료");
                System.exit(0);
            }
            try {
                int value = Integer.parseInt(input); // 정수 변환 시도
                if (value < 0) {
                    System.out.println("양의 정수를 입력해야 합니다. 다시 입력하세요.");
                    continue;
                }
                return value; // 정상적인 값이면 반환
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자가 아닙니다. 다시 입력하세요.");
            }
        }

    }
}

