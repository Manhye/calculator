import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InputProcessor {
    private List<Token> tokens = new ArrayList<>();
    Printer printer = new Printer();

    InputProcessor(){}

    public List<Token> init() {
        ExpressionChecker eChecker = new ExpressionChecker();
        printer.basePrint();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String sInp = scanner.nextLine();
            try {
                tokens = eChecker.checkExpression(sInp);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                tokens.clear();
                printer.basePrint();
            }
            if(!tokens.isEmpty()){
                break;
            }
        }
        return tokens;
    }
}
