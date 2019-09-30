import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationServiceImpl implements EvaluationService {

    private Deque<Double> stack;
    public enum TypeOperation {ADD, SUBTRACT, MULTIPLY, DIVIDE}

    public EvaluationServiceImpl() {
        this.stack = new ArrayDeque<>();;
    }

    public void add(Expression expression){
        double valueToAdd = 0;
        switch (expression.getTypeOperation()){
            case ADD:
                valueToAdd = expression.evaluate();
                break;
            case SUBTRACT:
                valueToAdd = -expression.evaluate();
                break;
            case MULTIPLY:
                valueToAdd = stack.pop() * expression.evaluate();
                break;
            case DIVIDE:
                valueToAdd = stack.pop() / expression.evaluate();
                break;
        }
        stack.push(valueToAdd);
    }

    public double getResult(){
        double res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public static TypeOperation getTypeOperation(Character operation){
        TypeOperation res = TypeOperation.ADD;
        if(operation == null) {
            return res;
        }
        switch (operation){
            case '+':
                res = TypeOperation.ADD;
                break;
            case '-':
                res = TypeOperation.SUBTRACT;
                break;
            case '*':
                res = TypeOperation.MULTIPLY;
                break;
            case '/':
                res = TypeOperation.DIVIDE;
                break;
        }
        return res;
    }
}
