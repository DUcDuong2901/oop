public class Square implements Expression {
    private Expression expression;

    public Square(Expression expression) {
        this.expression = expression;
    }

    @Override
    public int evaluate() {
        int value = expression.evaluate();
        return value * value;
    }

    @Override
    public String toString() {
        String expressionString = expression.toString();
        if (expression instanceof Numeral || expressionString.startsWith("(") && expressionString.endsWith(")")) {
            return expressionString + "^2";
        } else {
            return "(" + expressionString + ")^2";
        }
    }
}
