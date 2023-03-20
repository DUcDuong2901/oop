

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Random;

 class TextGraphics {

   private static TextGraphics instance;
   private char[][] buffer;
   public int width;
   public int height;

   private TextGraphics() {
     this.width = 10;
     this.height = 10;
     this.buffer = new char[height][width];
     clearBuffer();
   }

   public static TextGraphics getInstance() {
     if (instance == null) {
       instance = new TextGraphics();
     }
     return instance;
   }

   public void init(int width, int height) {
     this.width = width;
     this.height = height;
     this.buffer = new char[height][width];
     clearBuffer();
   }

   public void drawPoint(char c, int x, int y) {
     buffer[y][x] = c;
   }

   public void drawLine(char c, int x1, int y1, int x2, int y2) {
     int dx = Math.abs(x2 - x1);
     int dy = Math.abs(y2 - y1);
     int sx = x1 < x2 ? 1 : -1;
     int sy = y1 < y2 ? 1 : -1;
     int err = dx - dy;

     while (true) {
       drawPoint(c, x1, y1);
       if (x1 == x2 && y1 == y2) {
         break;
       }
       int e2 = 2 * err;
       if (e2 > -dy) {
         err -= dy;
         x1 += sx;
       }
       if (e2 < dx) {
         err += dx;
         y1 += sy;
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
       for (int j = 0; j < width; j++) {
         System.out.print(buffer[i][j]);
       }
       System.out.println();
     }
   }

   public void clearBuffer() {
     for (int i = 0; i < height; i++) {
       for (int j = 0; j < width; j++) {
         buffer[i][j] = ' ';
       }
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
     TextGraphics textGraphics = TextGraphics.getInstance();
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
