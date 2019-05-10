import java.util.function.IntPredicate;
/**
 * 
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 10/05/2019
 *
 */
public interface MyFunctionConditional extends MyFunction{

	default public MyFunctionConditional conditionateInput(IntPredicate intPredicate)
	{
		return value -> intPredicate.test(value) ? apply(value) : 0;
	}
}
