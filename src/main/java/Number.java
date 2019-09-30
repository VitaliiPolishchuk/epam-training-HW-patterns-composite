import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Double.compare(number.token, token) == 0 &&
                typeOperation == number.typeOperation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, typeOperation);
    }
}
