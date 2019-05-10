import java.util.function.IntPredicate;

public interface MyFunctionConditional extends MyFunction{

	default public MyFunctionConditional conditionateInput(IntPredicate intPredicate)
	{
		return value -> intPredicate.test(value) ? apply(value) : 0;
	}
}
