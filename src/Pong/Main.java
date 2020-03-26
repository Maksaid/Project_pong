package Pong;

import java.awt.*;
import java.awt.event.*;
import java.security.Key;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Main extends JPanel implements ActionListener {

    JFrame frame;

    Paddle leftPaddle;

    Paddle rightPaddle;

    Ball ball;

    public static boolean menu = true;
    public static boolean pause = false;
    public static boolean solo = true;
    private KeyListener exitlistener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            int key = keyEvent.getKeyCode();
            if (menu && key == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
            if (key == KeyEvent.VK_ESCAPE && !pause)
                menu = true;
            if (key == KeyEvent.VK_P && !menu && !pause) {
                timer.stop();
                pause = true;
            } else if (key == KeyEvent.VK_P && !menu) {
                timer.start();
                pause = false;
            }


        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    };

    Image img = new ImageIcon("field.png").getImage();

    Image imgmenu = new ImageIcon("kosmos.png").getImage();

    Timer timer = new Timer(7, this);

    Font font = new Font("Courier", Font.PLAIN, 50);

    public Main(JFrame frame) {
        this.frame = frame;

        leftPaddle = new Paddle(frame);
        rightPaddle = new Paddle(frame);
        ball = new Ball(frame);
        ball.setLeftPaddle(leftPaddle);
        ball.setRightPaddle(rightPaddle);
        MouseListener menulistener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getX() < frame.getWidth() / 2)
                    solo = true;
                else
                    solo = false;
                menu = false;

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        };
        frame.addMouseListener(menulistener);
        frame.addKeyListener(exitlistener);
        timer.start();


        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                leftPaddle.keyPressed(e, KeyEvent.VK_W, KeyEvent.VK_S);
                if (!solo)
                    rightPaddle.keyPressed(e, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                leftPaddle.keyReleased(e, KeyEvent.VK_W, KeyEvent.VK_S);
                if (!solo)
                    rightPaddle.keyReleased(e, KeyEvent.VK_UP, KeyEvent.VK_DOWN);

            }

        });

    }

    public void paint(Graphics g) {
        if (menu)
            g.drawImage(imgmenu, 0, 0, frame.getWidth(), frame.getHeight(), null);
        else {
            g.drawImage(img, 0, 0, frame.getWidth(), frame.getHeight(), null);
            g.setColor(Color.WHITE);
            g.drawRect(100, leftPaddle.getY(), 25, leftPaddle.getPaddleHeight());
            g.setColor(Color.MAGENTA);
            g.drawRect(frame.getWidth() - 125, rightPaddle.getY(), 25, rightPaddle.getPaddleHeight());
            g.setColor(Color.white);
            g.fillOval(ball.getBallX() - 5, ball.getBallY() - 5, 10, 10);
            g.setColor(Color.GRAY);
            g.setFont(font);
            g.drawString(ball.getP1score(), frame.getWidth() / 4, 40);
            g.drawString(ball.getP2score(), frame.getWidth() / 4 * 3, 40);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        leftPaddle.move();
        ball.move();
        rightPaddle.ball = ball;
        if (!solo)
            rightPaddle.move();
        else
            rightPaddle.solomove();
        repaint();
    }

    public int geRightPaddleY() {
        return rightPaddle.getY();
    }
}