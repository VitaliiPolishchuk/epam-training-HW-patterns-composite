import java.util.ArrayList;
import java.util.List;

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
}
