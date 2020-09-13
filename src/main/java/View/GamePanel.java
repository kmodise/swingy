package View;

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
    Timer gameTimer;
    public GamePanel(){
        player = new Player(400, 300,  this);

        makeWalls();

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
//            for(int i = 70; i<600; i +=70 ){
//                walls.add(new Wall(i, 580,100,10));
//            }
        walls.add(new Wall(70, 580,590,10));
        walls.add(new Wall(70, 0,590,10));

        walls.add(new Wall(650, 10,10,590));
        walls.add(new Wall(50, 0,10,590));
//        walls.add(new Wall(0, 50,-50,-590));
//        walls.add(new Wall(0, 450,50,50));
//        walls.add(new Wall(600, 550,50,50));
//        walls.add(new Wall(600, 500,50,50));
//        walls.add(new Wall(600, 450,50,50));
//        walls.add(new Wall(450, 550,50,50));
//        walls.add(new Wall(450, 550,50,50));
//        walls.add(new Wall(450, 550,50,50));
//        walls.add(new Wall(1000, 200,500,503));

    }

    public  void paint(Graphics g){
        //prints over previous frames
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);
        for (Wall wall: walls){
            wall.draw(gtd);
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
