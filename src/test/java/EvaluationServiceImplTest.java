import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluationServiceImplTest {
    @Test
    public void shouldReturnADDTypeOperationWhenInputIsNULLMethodGetTypeOperation() {
        EvaluationServiceImpl.TypeOperation expected = EvaluationServiceImpl.TypeOperation.ADD;
        EvaluationServiceImpl.TypeOperation actual = EvaluationServiceImpl.getTypeOperation(null);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAddTypeOperationWhenInputIsPlusMethodGetTypeOperation() {
        EvaluationServiceImpl.TypeOperation expected = EvaluationServiceImpl.TypeOperation.ADD;
        EvaluationServiceImpl.TypeOperation actual = EvaluationServiceImpl.getTypeOperation('+');
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSubtractTypeOperationWhenInputIsMinusMethodGetTypeOperation() {
        EvaluationServiceImpl.TypeOperation expected = EvaluationServiceImpl.TypeOperation.SUBTRACT;
        EvaluationServiceImpl.TypeOperation actual = EvaluationServiceImpl.getTypeOperation('-');
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMuliplyTypeOperationWhenInputIsStarMethodGetTypeOperation() {
        EvaluationServiceImpl.TypeOperation expected = EvaluationServiceImpl.TypeOperation.MULTIPLY;
        EvaluationServiceImpl.TypeOperation actual = EvaluationServiceImpl.getTypeOperation('*');
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDivideTypeOperationWhenInputIsSlashMethodGetTypeOperation() {
        EvaluationServiceImpl.TypeOperation expected = EvaluationServiceImpl.TypeOperation.DIVIDE;
        EvaluationServiceImpl.TypeOperation actual = EvaluationServiceImpl.getTypeOperation('/');
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAddTypeOperationWhenInputIsOutOfRangeMethodGetTypeOperation() {
        EvaluationServiceImpl.TypeOperation expected = EvaluationServiceImpl.TypeOperation.ADD;
        EvaluationServiceImpl.TypeOperation actual = EvaluationServiceImpl.getTypeOperation('.');
        assertEquals(expected, actual);
    }
}