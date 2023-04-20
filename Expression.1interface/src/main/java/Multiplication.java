public class Multiplication extends BinaryExpression {
    private Expression left;
    private Expression right;

    public Multiplication(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String getOperator() {
        return "x";
    }

    @Override
    public int applyOperator(int leftOperand, int rightOperand) {
        return leftOperand * rightOperand;
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
