public class Number implements Expression {
    private double token;
    private EvaluationServiceImpl.TypeOperation typeOperation;

    @Override
    public String toString() {
        return "Number{" +
                "token=" + token +
                ", typeOperation=" + typeOperation +
                "}\n";
    }

    public Number(double token, EvaluationServiceImpl.TypeOperation typeOperation) {
        this.token = token;
        this.typeOperation = typeOperation;
    }

    public double evaluate() {
        return token;
    }

    public EvaluationServiceImpl.TypeOperation getTypeOperation() {
        return typeOperation;
    }
}
