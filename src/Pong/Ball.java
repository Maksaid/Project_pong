package Pong;

import javax.swing.*;
import java.io.FileInputStream;
import java.util.Random;


public class Ball {
    private int BallX;
    private int BallY;
    private int BalldirX;
    private int BalldirY;
    private int BallSpeed = 5;
    private int p1score, p2score;
    private boolean firstmove = true;
    JFrame frame;
    Ball ball;
    Paddle leftPaddle;
    Paddle rightPaddle;

    public Ball(JFrame frame){
        this.frame = frame;
        p1score=p2score=0;
        BallX = frame.getWidth()/2 ;
        BallY = frame.getHeight()/2;
        Random r = new Random();
    }
    void move(){
        if(firstmove){
        spawnBall();
        firstmove=false;}
        BallX += BalldirX;
        BallY += BalldirY;
        if(BallX + BalldirX >= frame.getWidth() || BallX + BalldirX <= 0){
            if(BallX + BalldirX >= frame.getWidth()){
                spawnBall();
                p1score++;
                BallX = frame.getWidth()/2 ;
                BallY = frame.getHeight()/2;}
            else{
                p2score++;
                spawnBall();
                BallX = frame.getWidth()/2 ;
                BallY = frame.getHeight()/2;}


        }
        if(BallY + BalldirY >= frame.getHeight() || BallY + BalldirY <= 0 ){
            BalldirY *= -1;
        }
        //столкновение с ракетками
        if (BallX+BalldirX >=105 && BallX+BalldirX <= 130 && (BallY + BalldirY< leftPaddle.getY()+leftPaddle.getPaddleHeight() )&& BallY + BalldirY> leftPaddle.getY()  )
            if (leftPaddle.getPlayerDirection() == Direction.UP) {
                BalldirX = (BalldirX * -1) + 1;
                BalldirY -= 1;

            }
        else
                if (leftPaddle.getPlayerDirection() == Direction.DOWN){
                BalldirX = (BalldirX * -1) - 1;
                BalldirY+=1;}
                else
                    if (leftPaddle.getPlayerDirection() == Direction.NONE)
                        BalldirX*=-1;
        if (BallX + BalldirX>= frame.getWidth()-130 && BallX + BalldirX <= frame.getWidth()-105 && BallY + BalldirY <= rightPaddle.getY() + rightPaddle.getPaddleHeight() + 5 && BallY + BalldirY > rightPaddle.getY() + 5)
            if (rightPaddle.getPlayerDirection() == Direction.UP){
                BalldirX = BalldirX * -1 - 1;
            BalldirY += 1;}
            else
            if (rightPaddle.getPlayerDirection() == Direction.DOWN){
                BalldirX = (BalldirX * -1) + 1 ;
                BalldirY -=1;
            }
            else
            if (rightPaddle.getPlayerDirection() == Direction.NONE)
                BalldirX*=-1;
        //столкновение с краями ракеток
        if (BallX  <= 125 && BallX >= 95 && BallY >= leftPaddle.getY() + 5 && BallY <= leftPaddle.getY() -15) //с левой ракеткой сверху
            BalldirY *=-1;
        if (BallX <= 125 && BallX >=0 && BallY <= leftPaddle.getY() + frame.getHeight()/7 && BallY >= leftPaddle.getY() + frame.getHeight()/7 - 10) //с левой ракеткой сверху
            BalldirY *=-1;


    }


    public void setXDirection(int xDir){
        BalldirX = xDir;
    }
    public void setYDirection(int yDir){
        BalldirY = yDir;
    }

    public int getBallX() {
        return BallX;
    }

    public int getBallY() {
        return BallY;
    }

    public void setRightPaddle(Paddle rightPaddle) {
        this.rightPaddle = rightPaddle;
    }

    public int getBallSpeed() {
        return BallSpeed;
    }

    public void setLeftPaddle(Paddle leftPaddle) {
        this.leftPaddle = leftPaddle;
    }

    public String getP1score() {
        return String.valueOf(p1score);
    }

    public String getP2score() {
        return String.valueOf(p2score);
    }
    private void spawnBall(){

        BalldirX = (int) (Math.random()*BallSpeed*2)- BallSpeed;
        if(BalldirX  ==  0)
            BalldirX +=2;
        BalldirY = (int) (Math.random()*2) - 1;
        if(BalldirY == 0)
            BalldirY+=1;
        BalldirY = (int) Math.sqrt(BallSpeed*BallSpeed - BalldirX*BalldirX) * BalldirY;
    }

}
