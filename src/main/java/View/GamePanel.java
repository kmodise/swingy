package View;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends javax.swing.JPanel implements ActionListener {
    Player player;
    Timer gameTimer;
    public GamePanel(){
    gameTimer = new Timer();
    gameTimer.schedule(new TimerTask(){

        @Override
        public void run() {

        }
    }, 0, 17);
    }

    public  void paint(Graphics2D g){
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
