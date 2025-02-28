import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InputProcessor {
    private List<Token> tokens = new ArrayList<>();
    Printer printer = new Printer();

    InputProcessor(){}

    public List<Token> init(String formula) {
        ExpressionChecker eChecker = new ExpressionChecker();
        printer.basePrint();
        try {
            tokens = eChecker.checkExpression(formula);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            tokens.clear();
            printer.basePrint();
        }
        return tokens;
    }
}
