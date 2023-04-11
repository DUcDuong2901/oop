import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBall {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());

        Ball ball = new Ball();
        frame.add(ball);

        JFrame frame2 = new JFrame("Observe");
        frame2.setSize(100, 150);
        JPanel panel = new JPanel();
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton startStopButton = new JButton("Start");
        panel.add(startStopButton);
        frame2.add(panel, BorderLayout.SOUTH);
        JLabel label = new JLabel();
        frame2.add(label);
        //public void update(Observable o, Object arg) {
        //    label.setText("Bounces: " + ball.getBounces());
        //}


        startStopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ball.isRunning()) {
                    ball.stop();
                    startStopButton.setText("Start");
                } else {
                    ball.start();
                    startStopButton.setText("Stop");
                }
            }
        });

        frame.setVisible(true);
    }
}

class Ball extends JPanel implements Runnable {
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private int diameter = 20;

    private int count = 0;
    private boolean running = false;
    private boolean touch = false;

    public void start() {
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void run() {
        while (running) {
            move();
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(x, y, diameter, diameter);
    }
    public boolean collisionOccurred() {
        if (x >= getWidth() - 30 || x <= 0) {
            touch = true;
            return touch;


        }
        if (y >= getHeight() - 30 || y <= 0) {
            touch = true;
            return touch;

        }
        return touch;

    }
    private void move() {
        if (x + dx < 0 || x + dx > getWidth() - diameter) {
            dx *= -1;
        }
        if (y + dy < 0 || y + dy > getHeight() - diameter) {
            dy *= -1;
        }
        x += dx;
        y += dy;
    }
}

