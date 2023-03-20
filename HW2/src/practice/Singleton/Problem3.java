
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TextGraphics {

  private static TextGraphics instance;

  private char[][] buffer;
  public int width;
  public int height;

  private TextGraphics() {
  }

  public static TextGraphics getInstance(int width, int height) {
    if (instance == null) {
      instance = new TextGraphics();
      instance.init(width, height);
    }
    return instance;
  }

  public void init(int width, int height) {
    this.width = width;
    this.height = height;
    this.buffer = new char[height][width];
    clearBuffer();
  }

  public void clearBuffer() {
    for (int i = 0; i < height; i++) {
      Arrays.fill(buffer[i], ' ');
    }
  }

  public void drawPoint(char c, int x, int y) {
    if (x >= 0 && x < width && y >= 0 && y < height) {
      buffer[y][x] = c;
    }
  }

  public void drawLine(char c, int x1, int y1, int x2, int y2) {
    if (x1 == x2) {
      int startY = Math.min(y1, y2);
      int endY = Math.max(y1, y2);
      for (int y = startY; y <= endY; y++) {
        drawPoint(c, x1, y);
      }
    } else if (y1 == y2) {
      int startX = Math.min(x1, x2);
      int endX = Math.max(x1, x2);
      for (int x = startX; x <= endX; x++) {
        drawPoint(c, x, y1);
      }
    } else {
      double slope = (double) (y2 - y1) / (double) (x2 - x1);
      double b = y1 - slope * x1;
      int startX = Math.min(x1, x2);
      int endX = Math.max(x1, x2);
      for (int x = startX; x <= endX; x++) {
        int y = (int) Math.round(slope * x + b);
        drawPoint(c, x, y);
      }
    }
  }

  public void fillRect(char c, int x, int y, int width, int height) {
    for (int i = y; i < y + height; i++) {
      for (int j = x; j < x + width; j++) {
        drawPoint(c, j, i);
      }
    }
  }

  public void render() {
    for (int i = 0; i < height; i++) {
      System.out.println(buffer[i]);
    }
  }
}


class Bugs {

    private static final char[] BUG_CHARS = { '+', '*', '.', 'o' };
    private static final int[] DIR_X = { -1, 0, 1, 0 };
    private static final int[] DIR_Y = { 0, 1, 0, -1 };
    private int x;
    private int y;
    private int dir;
    private char bugChar;
  
    public Bugs(int x, int y) {
      this.x = x;
      this.y = y;
      Random random = new Random();
      this.dir = random.nextInt(4);
      this.bugChar = BUG_CHARS[random.nextInt(BUG_CHARS.length)];
    }
  
    public void move(int width, int height) {
      int nextX = x + DIR_X[dir];
      int nextY = y + DIR_Y[dir];
  
      if (nextX < 0) {
        nextX = width - 1;
      } else if (nextX >= width) {
        nextX = 0;
      }
  
      if (nextY < 0) {
        nextY = height - 1;
      } else if (nextY >= height) {
        nextY = 0;
      }
  
      x = nextX;
      y = nextY;
    }
  
    public int getX() {
      return x;
    }
  
    public int getY() {
      return y;
    }
  
    public char getBugChar() {
      return bugChar;
    }
  }
  
  class Main {
  
    public static void main(String[] args) throws InterruptedException {
      TextGraphics textGraphics = TextGraphics.getInstance(5, 5);
      textGraphics.init(40, 20);
      List<Bugs> bugsList = new ArrayList<>();
      Random random = new Random();
      for (int i = 0; i < 10; i++) {
        Bugs bugs = new Bugs(
          random.nextInt(textGraphics.width),
          random.nextInt(textGraphics.height)
        );
        bugsList.add(bugs);
      }
      while (true) {
        textGraphics.clearBuffer();
        for (Bugs bugs : bugsList) {
          textGraphics.drawPoint(bugs.getBugChar(), bugs.getX(), bugs.getY());
          bugs.move(textGraphics.width, textGraphics.height);
        }
        textGraphics.render();
        Thread.sleep(10);
      }
    }
  }
  