public class Multiplication extends BinaryExpression {
    public Multiplication (Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return "x";
    }

    @Override
    protected int applyOperator(int leftOperand, int rightOperand) {
        return leftOperand * rightOperand;
    }

}
