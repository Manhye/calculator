import java.util.*;


public class Calculator {
    private Queue<String> values = new LinkedList<>();
    private static int index = 0;
    Calculator(){}

    public double init(List<Token> tokens){
        convertToPostfix(tokens);
        double result = calc();
        index=0;
        return result;
    }

    public void convertToPostfix(List<Token> tokens){
        Stack<String> operators = new Stack<>();
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
                Operator operator = Operator.getOperator(tokens.get(index).getValue());
                if(operators.empty()){
                    operators.push(tokens.get(index).getValue());
                }else{
                    Operator topOperator = Operator.getOperator(operators.peek());
                    if(topOperator.getPriority()<=operator.getPriority()){
                        while(topOperator.getPriority()<=operator.getPriority() && !operators.empty()){
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


    public double calc(){
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
}
