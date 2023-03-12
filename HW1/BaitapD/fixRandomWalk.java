public class fixRandomWalk {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;
        while (Math.abs(x) < n && Math.abs(y) < n) {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(x, y, 0.45);
            double r = Math.random();
            if (Math.abs(x) == Math.abs(y)) {
                if (x > 0 && y > 0) {
                    x++;
                } else if (x < 0 && y < 0) {
                    x--;
                } else if (x > 0 && y < 0) {
                    y++;
                } else {
                    y--;
                }
            } else if (Math.abs(x) > Math.abs(y)) {
                if (x > 0) {
                    y--;
                } else {
                    y++;
                }
            } else {
                if (y > 0) {
                    x++;
                } else {
                    x--;
                }
            }

            steps++;
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledSquare(x, y, 0.45);
            StdDraw.show();
            StdDraw.pause(40);
        }
        StdOut.println("Total steps = " + steps);
    }

}