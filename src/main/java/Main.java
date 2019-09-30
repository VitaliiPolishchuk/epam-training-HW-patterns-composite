public class Main {
    static ExpressionTreeBuilderImpl expressionTreeBuilderImpl;
    public static void main(String[] args) {
//        CompoundExpression compoundExpression = new CompoundExpression(EvaluationService.getTypeOperation(null));
//        Number expression1 = new Number(4, EvaluationService.getTypeOperation(null));
//        CompoundExpression expression2 = new CompoundExpression(EvaluationService.getTypeOperation('-'));
//        expression2.add(new Number(3, EvaluationService.getTypeOperation(null)));
//        expression2.add(new Number(2, EvaluationService.getTypeOperation('+')));
//        Number expression3 = new Number(5, EvaluationService.getTypeOperation('*'));
//        compoundExpression.add(expression1);
//        compoundExpression.add(expression2);
//        compoundExpression.add(expression3);
//        System.out.println(compoundExpression.evaluate());

        expressionTreeBuilderImpl = new ExpressionTreeBuilderImpl();
        System.out.println(evaluate("2*(2+4-(33/11+1)*2)"));
    }

    private static double evaluate(String str){
        return expressionTreeBuilderImpl.build(str).evaluate();
    }
}
