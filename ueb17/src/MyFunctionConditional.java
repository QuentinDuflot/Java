import java.util.function.IntPredicate;
/**
 * 
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 10/05/2019
 *
 */
public interface MyFunctionConditional extends MyFunction {
	//1.C)
	default public MyFunctionConditional conditionateInput(IntPredicate intPredicate) {
		return value -> intPredicate.test(value) ? apply(value) : 0;
	}
	
	default public MyFunctionConditional conditionateOutput(IntPredicate intPredicate) {
		return value -> intPredicate.test(apply(value)) ? apply(value) : 0;
	}
}