package LvThree;
import java.util.function.DoubleBinaryOperator;

public enum OperatorType {
    DIVIDE("/", (firstnumber, secondnumber) -> firstnumber / secondnumber),
    MINUS("-", (firstnumber, secondnumber) -> firstnumber - secondnumber),
    PLUS("+", (firstnumber, secondnumber) -> firstnumber + secondnumber),
    TIMED("*", (firstnumber, secondnumber) -> firstnumber * secondnumber),
    REMAIN("*", (firstnumber, secondnumber) -> firstnumber % secondnumber);

    private final String OperatorType;

    private final DoubleBinaryOperator BinaryOperator;

    OperatorType(String OperatorType,  DoubleBinaryOperator BinaryOperator) {
        this.OperatorType = OperatorType;
        this.BinaryOperator = BinaryOperator;
    }


    public String getOperatorType() {
        return OperatorType;
    }

    public double getBinaryOperator(double firstnumber, double secondnumber) {
        return BinaryOperator.applyAsDouble(firstnumber, secondnumber);
    }

}
