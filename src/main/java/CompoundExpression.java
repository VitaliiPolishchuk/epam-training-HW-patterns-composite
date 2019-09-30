import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompoundExpression implements Expression{

    private List<Expression> expressions;
    private EvaluationServiceImpl.TypeOperation typeOperation;
    EvaluationService evaluationService;

    public CompoundExpression(EvaluationServiceImpl.TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
        this.expressions = new ArrayList<>();
        evaluationService = new EvaluationServiceImpl();
    }

    public double evaluate() {
        for(Expression expression : expressions){
            evaluationService.add(expression);
        }
        return evaluationService.getResult();
    }

    public EvaluationServiceImpl.TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void add(Expression expression){
        expressions.add(expression);
    }

    @Override
    public String toString() {
        return "CompoundExpression{" +
                "expressions=" + expressions +
                ", typeOperation=" + typeOperation +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompoundExpression that = (CompoundExpression) o;
        return Objects.equals(expressions, that.expressions) &&
                typeOperation == that.typeOperation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(expressions, typeOperation, evaluationService);
    }
}
