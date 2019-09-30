public class Main {
    static ExpressionTreeBuilderImpl expressionTreeBuilderImpl;
    public static void main(String[] args) {

        expressionTreeBuilderImpl = new ExpressionTreeBuilderImpl();
        System.out.println(evaluate("2*(2+4-(33/11+1)*2)"));
    }

    private static double evaluate(String str){
        return expressionTreeBuilderImpl.build(str).evaluate();
    }
}
