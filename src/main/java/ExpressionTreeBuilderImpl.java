public class ExpressionTreeBuilderImpl implements ExpressionTreeBuilder {

    int index;

    public Expression build(String expressionStr){
        if(expressionStr == null) {
            return null;
        }
        index = 0;
        return buildHelper(expressionStr, EvaluationServiceImpl.TypeOperation.ADD);
    }

    private Expression buildHelper(String expressionStr, EvaluationServiceImpl.TypeOperation tO){
        CompoundExpression res = new CompoundExpression(tO);
        while(index < expressionStr.length()){
            char ch = expressionStr.charAt(index);
            if(ch == '(') {
                ++index;
                res.add(buildHelper(expressionStr, EvaluationServiceImpl.TypeOperation.ADD));
            } else if(ch == ')'){
                ++index;
                return res;
            } else if(isOperation(ch)){
                EvaluationServiceImpl.TypeOperation typeOperation = EvaluationServiceImpl.getTypeOperation(ch);
                ++index;
                if(Character.isDigit(expressionStr.charAt(index))){
                    double number = getNumber(expressionStr);
                    res.add(new Number(number, typeOperation));
                } else {
                    ++index;
                    res.add(buildHelper(expressionStr, typeOperation));
                }
            } else if(Character.isDigit(ch)){
                res.add(new Number(getNumber(expressionStr), EvaluationServiceImpl.TypeOperation.ADD));
            }
        }
        return res;
    }

    private double getNumber(String expressionStr){
        double res = 0;
        while(index < expressionStr.length() && Character.isDigit(expressionStr.charAt(index))){
            res *= 10;
            res += Character.getNumericValue(expressionStr.charAt(index));
            ++index;
        }
        return res;
    }

    private boolean isOperation(char ch){
        return "-+*/".contains(String.valueOf(ch));
    }
}
