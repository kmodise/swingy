package View;

import java.awt.*;
import Model.GetHero;
import javax.swing.JOptionPane;


public class Player{

    int fight(int PlayerAttack, int EnemyDefence ){
        if (PlayerAttack > EnemyDefence){
            return (1);
        }
        return (0);
    }

GetHero getHero = new GetHero();
    //hero specifications
   String Heroname = getHero.Heroname;
    char  Heroclass = getHero.Heroclass;
    int     Level = getHero.Level;
    int     Experience = getHero.Experience;
    int     Attack = getHero.Attack;
    int     Defense = getHero.Defense;
    int     HitPoints = getHero.HitPoints;
    
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
        this.Heroname = getHero.Heroname;
        this.Heroclass = getHero.Heroclass;
        this.Level = getHero.Level;
        this.Experience = getHero.Experience;
        this.Attack = getHero.Attack;
        this.Defense = getHero.Defense;
        this.HitPoints = getHero.HitPoints;
        System.out.println(Heroname);
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

        System.out.println(panel.enemies);
        //enemy collision
        hitBox.x += xSpeed;
        for(Enemy enemy: panel.enemies){
            if(enemy.hitBox.intersects(hitBox)){
                int option = Integer.parseInt(JOptionPane.showInputDialog(null, "1 == fight \n2 == run"));
                if (option == 1){
                    if (fight(Attack,enemy.Defence) == 0) {
                        JOptionPane.showMessageDialog(null, "X YOU LOSE, ENEMY TOO STRONG");
                        System.exit(1);
                    }else{
                        //not working
                                enemy.hitBox.setLocation(1000, 1000);
                        xSpeed = 0;
                        ySpeed = 0;
                        //hitbox needs to be disabled or
                           //the wall need to disappear;
//                        panel.enemies = null;
                    }
                    //else??
                    
                }
                else{
                    xSpeed = x;
                    ySpeed = y;
                }

                hitBox.x -= xSpeed;
            }
        }

        //y-axis enemy collision
        for(Enemy enemy: panel.enemies){
            if(enemy.hitBox.intersects(hitBox)){
                int option = Integer.parseInt(JOptionPane.showInputDialog(null, "1 == Fight\n2 == Run"));
                if (option == 1){
                    if (fight(Attack,enemy.Defence) == 0) {
                        JOptionPane.showMessageDialog(null, "Y enemy too strong YOU LOSE");
                        System.exit(1);
                    }else {
                        //the enemy needs to disappear;
                        enemy.hitBox.setLocation(1000, 1000);
                        ySpeed = 0;
                        xSpeed = 0;


//                        panel.enemies = null;

                    }
                    //WORKING HERE   fggjrsdlgjrgjreorejgoerigjeriogjreoigjreoigjregioerhjioerjgier
                    


                }
                else{
                    xSpeed = x;
                    ySpeed = y;
                }
                hitBox.y -= xSpeed;
            }
        }

        //x-axis collision
        hitBox.x += xSpeed;
        for(Wall wall: panel.walls){

            if (wall.hitBox.intersects(hitBox)){
                hitBox.x -= xSpeed;
                while (!wall.hitBox.intersects(hitBox)){
                    hitBox.x += Math.signum(xSpeed);
                }
                hitBox.x -= Math.signum(xSpeed);
                JOptionPane.showMessageDialog(null, "you win","Nice",JOptionPane.INFORMATION_MESSAGE);
                System.exit(1);
                // xSpeed = 0;
                // x = hitBox.x;
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
