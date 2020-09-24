package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends javax.swing.JPanel implements ActionListener {
    Player player;
    ArrayList<Wall>  walls = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    Timer gameTimer;
    public GamePanel(){

        player = new Player(400, 300,  this);

        makeWalls();
        Enemies();
        gameTimer = new Timer();

    gameTimer.schedule(new TimerTask(){

        @Override
        public void run() {
            player.set();
            repaint();
        }
    }, 0, 17);
    }

    public void makeWalls(){

        walls.add(new Wall(70, 580,590,10));
        walls.add(new Wall(70, 0,590,10));

        walls.add(new Wall(650, 10,10,590));
        walls.add(new Wall(50, 0,10,590));



    }

    public void Enemies(){
//don't forget to randomise the enemy positions;
        enemies.add(new Enemy(300, 400,50,50, 80, 90));
        enemies.add(new Enemy(300, 100,50,50, 80, 90));
        
        //x = 600 is the max
        enemies.add(new Enemy(600, 300,50,50, 80, 90));
        //x = 80 is the min
        enemies.add(new Enemy(80, 300,50,50, 80, 90));
        enemies.add(new Enemy(100, 300,50,50, 80, 90));
        enemies.add(new Enemy(200, 300,50,50, 80, 90));
        enemies.add(new Enemy(340, 300,50,50, 80, 90));
        enemies.add(new Enemy(500, 300,50,50, 80, 90));

        enemies.add(new Enemy(80, 400,50,80, 80, 90));
        enemies.add(new Enemy(100, 400,50,50, 80, 90));
        enemies.add(new Enemy(200, 400,50,70, 80, 90));
        enemies.add(new Enemy(340, 400,50,80, 80, 90));
        enemies.add(new Enemy(500, 400,50,70, 80, 90));

        enemies.add(new Enemy(80, 100,50,50, 80, 90));
        enemies.add(new Enemy(100, 00,50,50, 80, 90));
        enemies.add(new Enemy(200, 100,50,50, 80, 90));
        enemies.add(new Enemy(340, 100,50,50, 80, 90));
        enemies.add(new Enemy(500, 100,50,50, 80, 90));

        enemies.add(new Enemy(80, 30,50,50, 80, 90));
        enemies.add(new Enemy(100, 30,50,50, 80, 90));
        enemies.add(new Enemy(200, 30,50,50, 80, 90));
        enemies.add(new Enemy(340, 30,50,50, 80, 90));
        enemies.add(new Enemy(500, 30,50,50, 80, 90));

        enemies.add(new Enemy(80, 200,50,50, 80, 90));
        enemies.add(new Enemy(100, 200,50,50, 80, 90));
        enemies.add(new Enemy(200, 200,50,50, 80, 90));
        enemies.add(new Enemy(340, 200,50,50, 80, 90));
        enemies.add(new Enemy(500, 200,50,50, 80, 90));

        enemies.add(new Enemy(80, 500,50,50, 80, 90));
        enemies.add(new Enemy(100, 500,50,50, 80, 90));
        enemies.add(new Enemy(200, 500,50,50, 80, 90));
        enemies.add(new Enemy(340, 500,50,50, 80, 90));
        enemies.add(new Enemy(500, 500,50,50, 80, 90));



        enemies.add(new Enemy(300, 300,50,50, 80, 90));
        enemies.add(new Enemy(400, 100,50,50, 80, 90));
        enemies.add(new Enemy(90, 400,50,50, 40, 30));
        enemies.add(new Enemy(400, 90,60,80, 90,50));
        enemies.add(new Enemy(600, 500,50,50, 80, 43));
        enemies.add(new Enemy(550, 50,50,50, 80, 43));
        enemies.add(new Enemy(150, 460,50,30, 80, 43));
        enemies.add(new Enemy(10, 40,50,30, 80, 43));
        enemies.add(new Enemy(500, 60,50,30, 80, 43));
        enemies.add(new Enemy(150, 20,50,30, 80, 43));
        enemies.add(new Enemy(20, 560,50,30, 80, 43));




    }

    public  void paint(Graphics g){
        //prints over previous frames
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);
        for (Wall wall: walls){
            wall.draw(gtd);
        }
        for(Enemy enemy: enemies){
            enemy.draw(gtd);
        }
    }



    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a')
            player.keyLeft = true;
        if(e.getKeyChar() == 'w')
            player.keyUp = true;
        if(e.getKeyChar() == 's')
            player.keyDown = true;
        if(e.getKeyChar() == 'd')
            player.keyRight = true;

    }

    public void KeyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a')
            player.keyLeft = false;
        if(e.getKeyChar() == 'w')
            player.keyUp = false;
        if(e.getKeyChar() == 's')
            player.keyDown = false;
        if(e.getKeyChar() == 'd')
            player.keyRight = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
