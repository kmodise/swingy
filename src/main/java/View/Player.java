package View;

import java.awt.*;

public class Player {

    GamePanel panel;
    int x;
    int y;
    int width;
    int height;

    double xSpeed;
    double ySpeed;

    Rectangle hitBox;

    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;
    //x@param x is where the Player starts
    public Player(int x, int y, GamePanel panel){
    this.panel = panel;
    this.x = x;
    this.y = y;
    width = 20;
    height = 20;
    hitBox = new Rectangle(x, y, width,height);
    }
    public void set(){

        if (keyLeft && keyRight || !keyLeft && !keyRight)
            xSpeed *= 0.8;
        else if (keyLeft && !keyRight)
            xSpeed--;
        else if (!keyLeft && keyRight)
            xSpeed++;

//        if (keyUp){
//            hitBox.y++;
//            ySpeed++;
////            for(Wall wall: panel.walls){
//                if (wall.hitBox.intersects(hitBox))
//                    ySpeed = -6;
//            }
//            hitBox.y--;
//        }
//        ySpeed += 0.3;

        //x-axis collision
        hitBox.x += xSpeed;
        for(Wall wall: panel.walls){
            if (wall.hitBox.intersects(hitBox)){
                hitBox.x -= xSpeed;
                while (!wall.hitBox.intersects(hitBox)){
                    hitBox.x += Math.signum(xSpeed);
                }
                hitBox.x -= Math.signum(xSpeed);
                xSpeed = 0;
                x = hitBox.x;
            }
        }


        //y-axis collision

        hitBox.y += ySpeed;
        for(Wall wall: panel.walls){
            if (wall.hitBox.intersects(hitBox)){
                hitBox.y -= ySpeed;
                while (!wall.hitBox.intersects(hitBox)){
                    hitBox.y += Math.signum(ySpeed);
                }
                hitBox.y -= Math.signum(ySpeed);
                ySpeed = 0;
                y = hitBox.y;
            }
        }


        if (keyUp && keyDown || !keyUp && !keyDown)
            ySpeed *= 0.8;
        else if (keyUp && !keyDown)
            ySpeed--;
        else if (!keyUp && keyDown)
            ySpeed++;

        //setting the max speed
        if (xSpeed > 4)
            xSpeed = 4;
        if (xSpeed < -4)
            xSpeed = -4;
        if (ySpeed > 4)
            ySpeed = 4;
        if (ySpeed < -4)
            ySpeed = -4;

        //preventing the player from sliding
        if (xSpeed > 0 && xSpeed < 0.75)
            xSpeed = 0;
        if (xSpeed < 0 && xSpeed > -0.75)
            xSpeed = 0;
        if (ySpeed > 0 && ySpeed < 0.75)
            ySpeed = 0;
        if (ySpeed < 0 && ySpeed > -0.75)
            ySpeed = 0;

            x+=xSpeed;
            y+=ySpeed;

            hitBox.x = x;
            hitBox.y = y;
    }
    public  void draw(Graphics2D gtd){
        gtd.setColor(Color.black);
        gtd.fillRect(x,y,width,height);

    }
}
