package BaitapD;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class fixRandomWalk {
    public static void main(String[] args) {
            int n = Integer.parseInt(args[0]);
            StdDraw.setScale(-n - 0.5, n + 0.5);
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.enableDoubleBuffering();

            int x = 0, y = 0;
            int steps = 0;
            int direction = 0; // 0 = right, 1 = up, 2 = left, 3 = down
            int segment_length = 1;

            while (Math.abs(x) <= n && Math.abs(y) <= n) {
                for (int i = 0; i < segment_length && Math.abs(x) <= n && Math.abs(y) <= n; i++) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(x, y, 0.45);
                    switch (direction) {
                        case 0:
                            x++;
                            break;
                        case 1:
                            y++;
                            break;
                        case 2:
                            x--;
                            break;
                        case 3:
                            y--;
                            break;
                    }
                    steps++;
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(x, y, 0.45);
                    StdDraw.show();
                    StdDraw.pause(40);
                }
                direction = (direction + 1) % 4;
                if (direction == 0 || direction == 2) {
                    segment_length++;
                }
            }
            StdOut.println("Total steps = " + steps);
        }

    }
