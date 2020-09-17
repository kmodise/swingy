package View;

import java.awt.*;

public class Enemy {
    int x;
    int y;
    int height;
    int width;
    int Attack;
    int Defence;

    Rectangle hitBox;
    public Enemy(int x, int y, int width, int height, int Attack, int Defence){
        this.Attack = Attack;
        this.Defence = Defence;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;

        hitBox = new Rectangle(x, y, width, height);
    }
    public  void draw(Graphics2D gtd){
        gtd.drawRect(x, y, width, height);
        gtd.setColor(Color.BLUE);
        gtd.fillRect(x+1,y+1,width-2,height-2);

    }
}
