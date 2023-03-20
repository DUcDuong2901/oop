

import java.util.Random;

class TextGraphics {

  private static final TextGraphics instance = new TextGraphics();

  private char[][] buffer;
  private int width;
  private int height;

  private TextGraphics() {
    init(10, 10);
  }

  public static TextGraphics getInstance() {
    return instance;
  }

  public void init(int width, int height) {
    this.width = width;
    this.height = height;
    this.buffer = new char[height][width];
    clearBuffer();
  }

  private void clearBuffer() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        buffer[i][j] = ' ';
      }
    }
  }

  public void drawPoint(char c, int x, int y) {
    if (x >= 0 && x < width && y >= 0 && y < height) {
      buffer[y][x] = c;
    }
  }

  public void drawLine(char c, int x1, int y1, int x2, int y2) {
    if (x1 == x2) {
      // Vertical line
      int startY = Math.min(y1, y2);
      int endY = Math.max(y1, y2);
      for (int y = startY; y <= endY; y++) {
        drawPoint(c, x1, y);
      }
    } else if (y1 == y2) {
      // Horizontal line
      int startX = Math.min(x1, x2);
      int endX = Math.max(x1, x2);
      for (int x = startX; x <= endX; x++) {
        drawPoint(c, x, y1);
      }
    } else {
      // Diagonal line
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
 class Main {
  public static void main(String[] args) {
      TextGraphics graphics = TextGraphics.getInstance();
      graphics.init(15, 10);
      graphics.drawPoint('*', 1, 1);
      graphics.fillRect('o', 5, 5, 3, 2);
      graphics.render();
  }
}
