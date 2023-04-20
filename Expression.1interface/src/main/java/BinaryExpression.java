public abstract class BinaryExpression implements Expression {
    protected Expression left;
    protected Expression right;

    public BinaryExpression() {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " " + getOperator() + " " + right.toString() + ")";
    }

    protected abstract String getOperator();

    @Override
    public int evaluate() {
        return applyOperator(left.evaluate(), right.evaluate());
    }

    protected abstract int applyOperator(int leftOperand, int rightOperand);
}
