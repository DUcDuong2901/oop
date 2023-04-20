public class Subtraction extends BinaryExpression {
    private Expression left;
    private Expression right;

    public Subtraction(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String getOperator() {
        return "-";
    }

    @Override
    public int applyOperator(int leftOperand, int rightOperand) {
        return leftOperand - rightOperand;
    }

    @Override
    public int evaluate() {
        return applyOperator(left.evaluate(), right.evaluate());
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " " + getOperator() + " " + right.toString() + ")";
    }
}
