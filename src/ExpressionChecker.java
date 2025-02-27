import java.util.ArrayList;
import java.util.List;

public class ExpressionChecker {
    private int length;
    List<Token> tokens = new ArrayList<>();

    public List<Token> checkExpression(String expression){
        length = expression.length();
        char cTemp;
        String sTemp = "";
        for(int i = 0; i<length; i++) {
            cTemp = expression.charAt(i);
            if (Character.isDigit(cTemp) || cTemp == '.') {
                sTemp += cTemp;
            }else if(cTemp == ' ') {
                continue;
            }else if(cTemp == '@') {
                InputCommands iCommand = new InputCommands(expression);
                tokens.clear();
                break;
            }else{
                if(!sTemp.isEmpty()) {
                    tokens.add(new Token("number", sTemp));
                    sTemp = "";
                }
                if(Operator.checkOperator(String.valueOf(cTemp))){
                    tokens.add(new Token("operator", String.valueOf(cTemp)));
                }
            }
        }
        if(!sTemp.isEmpty()){
            tokens.add(new Token("number", sTemp));
        }

        return tokens;
    }
}
