
public class Addition extends BinaryExpression{
    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return "+";
    }

    @Override
    protected int applyOperator(int leftOperand, int rightOperand) {
        return leftOperand + rightOperand;
    }

}

