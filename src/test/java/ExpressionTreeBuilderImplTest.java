import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionTreeBuilderImplTest {
    ExpressionTreeBuilderImpl instance;

    @Before
    public void setUp() {
        instance = new ExpressionTreeBuilderImpl();
    }

    @Test
    public void shouldReturnNullWhenInputIsNullMethodBuild() {
        Expression expected = null;
        Expression actual = instance.build(null);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyCompoundExpressionWhenInputIsEmptyMethodBuild() {
        Expression expected = new CompoundExpression(EvaluationServiceImpl.TypeOperation.ADD);
        Expression actual = instance.build("");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeEqualsWhenInputIsExpressionMethodBuild() {
        CompoundExpression compoundExpression = new CompoundExpression(EvaluationServiceImpl.getTypeOperation(null));
        Number expression1 = new Number(4, EvaluationServiceImpl.getTypeOperation(null));
        CompoundExpression expression2 = new CompoundExpression(EvaluationServiceImpl.getTypeOperation('-'));
        expression2.add(new Number(3, EvaluationServiceImpl.getTypeOperation(null)));
        expression2.add(new Number(2, EvaluationServiceImpl.getTypeOperation('+')));
        Number expression3 = new Number(5, EvaluationServiceImpl.getTypeOperation('*'));
        compoundExpression.add(expression1);
        compoundExpression.add(expression2);
        compoundExpression.add(expression3);
        Expression expected = compoundExpression;
        Expression actual = instance.build("4-(3+2)*5");
        assertEquals(expected, actual);
    }
}