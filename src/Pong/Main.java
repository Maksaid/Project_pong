package Pong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Main extends JPanel implements ActionListener {

    JFrame frame;

    LeftPaddle leftPaddle;

    RightPaddle rightPaddle;

    Ball ball;

    Image img = new ImageIcon("field.png").getImage();

    Timer timer = new Timer(13, this);


    public Main(JFrame frame) {
        this.frame = frame;

        leftPaddle = new LeftPaddle(frame);
        rightPaddle = new RightPaddle(frame);
         ball = new Ball(frame);
         ball.setLeftPaddle(leftPaddle);
         ball.setRightPaddle(rightPaddle);
        timer.start();
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                leftPaddle.keyPressed(e);
                rightPaddle.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                leftPaddle.keyReleased(e);
                rightPaddle.keyReleased(e);

            }
            @Override
            public void keyTyped(KeyEvent e){
                leftPaddle.keyTyped(e);
                rightPaddle.keyTyped(e);
            }

        });

    }

    public void paint(Graphics g) {

        g.drawImage(img, 0, 0, frame.getWidth(), frame.getHeight(), null);
        g.setColor(Color.WHITE);
        g.drawRect(100, leftPaddle.getLY(), 25, leftPaddle.getPaddleHeight());
        g.setColor(Color.MAGENTA);
        g.drawRect(frame.getWidth()-125,rightPaddle.getRY(),25,rightPaddle.getPaddleHeight());
        g.setColor(Color.white);
        g.fillOval(ball.getBallX()-5,ball.getBallY()-5,10 ,10);
        g.drawString(ball.getP1score(),frame.getWidth()/4,40);
        g.drawString(ball.getP2score(),frame.getWidth()/4*3,40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        leftPaddle.move();
        ball.move();
        rightPaddle.moveR();
        repaint();
    }


}