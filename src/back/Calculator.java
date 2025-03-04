package back;

import java.math.BigDecimal;
import java.util.*;


public class Calculator {
    private List<Token> tokens = new ArrayList<>();
    private static int index = 0;
    private Queue<String> values = new LinkedList<>();
    private double result;



    public String init(String input){
        tokens=tokenize(input);
        convertToPostfix(tokens);
        try{
            result = calc();

        }catch (ArithmeticException e){
            return " => Division by zero!";
        }
        String formula = toFormula();
        tokens.clear();
        values.clear();
        index = 0;

        return formula;
    }



    private List<Token> tokenize(String formula) {
        try {
            tokens = checkExpression(formula);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            tokens.clear();
        }
        return tokens;
    }

    private List<Token> checkExpression(String expression){
        int length = expression.length();
        char cTemp;
        String sTemp = "";
        for(int i = 0; i<length; i++) {
            cTemp = expression.charAt(i);
            if (Character.isDigit(cTemp) || cTemp == '.') {
                sTemp += cTemp;
            }else if(cTemp == ' ') {
                continue;
            }else{
                if(!sTemp.isEmpty()) {
                    tokens.add(new Token("number", sTemp));
                    sTemp = "";
                }
                if(checkOperator(String.valueOf(cTemp))){
                    tokens.add(new Token("operator", String.valueOf(cTemp)));
                }else{
                    tokens.clear();
                    tokens.add(new Token("number", "Invalid Operator"));
                    return tokens;
                }
            }
        }
        if(!sTemp.isEmpty()){
            tokens.add(new Token("number", sTemp));
        }

        return tokens;
    }

    private boolean checkOperator(String operator){
        for(Operator op : Operator.values()){
            if(op.getOperator().equals(operator)){
                return true;
            }
        }
        return false;
    }

    private void convertToPostfix(List<Token> tokens){
        Stack<String> operators = new Stack<>();
        operators.clear();

        while(index<tokens.size()) {
            if (tokens.get(index).getType().equals("number")) {
                values.add(tokens.get(index).getValue());
            } else if (tokens.get(index).getValue().equals("(")) {
                index++;
                convertToPostfix(tokens);
            } else if (tokens.get(index).getValue().equals(")")) {
                break;
            }else if(tokens.get(index).getValue().equals("!")){
                values.add(tokens.get(index).getValue());
            }else{
                if(operators.empty()){
                    operators.push(tokens.get(index).getValue());
                }else{
                    String peekVal = operators.peek();
                    if(Operator.getPriority(peekVal)<=Operator.getPriority(tokens.get(index).getValue())){
                        while(Operator.getPriority(peekVal)<=Operator.getPriority(tokens.get(index).getValue()) && !operators.empty()){
                            values.add(operators.pop());
                        }
                        operators.push(tokens.get(index).getValue());
                    }else{
                        operators.push(tokens.get(index).getValue());
                    }
                }
            }
            index++;
        }

        while(!operators.isEmpty()) {
            values.add(operators.pop());
        }
    }

    private double calc(){
        Stack<Double> numbers = new Stack();

        String sTemp;
        Queue<String> tempValues = new LinkedList<>(values);

        int length = tempValues.size();
        for(int i = 0; i<length; i++) {
            sTemp = tempValues.poll();
            try{
                Double val = Double.parseDouble(sTemp);
                numbers.push(val);
            }catch(NumberFormatException e){
                if(sTemp.equals("!")){
                    double a = numbers.pop();
                    Operator operator = Operator.getOperator(sTemp);
                    double result = operator.calc(a,1);
                    numbers.push(result);
                }else{
                    double a = numbers.pop();
                    double b = numbers.pop();
                    Operator operator = Operator.getOperator(sTemp);
                    double result = operator.calc(b,a);
                    numbers.push(result);
                }

            }
        }
        return numbers.pop();
    }

    private String toFormula(){
        String formula = "";
        for(Token token : tokens){
            System.out.print(token.getValue()+" ");
            formula += token.getValue() + " ";
        }
        try{
            System.out.println("= " + BigDecimal.valueOf(result).stripTrailingZeros().toPlainString());
            formula += "= " + BigDecimal.valueOf(result).stripTrailingZeros().toPlainString();
        }catch(NumberFormatException e){
            return " => Division by zero!";
        }

        return formula;
    }
}
