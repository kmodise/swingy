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
        enemies.add(new Enemy(300, 400,50,50, 80, 43));
        enemies.add(new Enemy(90, 400,50,50, 40, 30));
        enemies.add(new Enemy(400, 90,60,80, 90,50));
        enemies.add(new Enemy(600, 500,50,50, 80, 43));
        enemies.add(new Enemy(550, 50,50,50, 80, 43));
        enemies.add(new Enemy(150, 4610,50,30, 80, 43));

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
