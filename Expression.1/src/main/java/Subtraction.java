public class Subtraction extends BinaryExpression{
    public Subtraction (Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return "-";
    }

    @Override
    protected int applyOperator(int leftOperand, int rightOperand) {
        return leftOperand - rightOperand;
    }
}
