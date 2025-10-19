//first time using this so referenced ai on what to import
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
//groups things togetehr
import javax.swing.JPanel;
//main window
import javax.swing.JFrame;
//clickable button
import javax.swing.JButton;
//displays text/image
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class fishMiniGame extends JPanel{
    private JLabel petLabel;
    private JFrame frame;
    private JLabel[] fishArray;
    private final int numFish = 5;
    public fishMiniGame(JFrame b){

        JPanel gamePanel = new JPanel();
        frame = b;
        //referenced ai to help delete everything for new panel
        b.getContentPane().removeAll();
        b.add(gamePanel);
        b.revalidate();
        b.repaint();
        gamePanel.setBounds(0,0, frame.getWidth(), frame.getHeight());
        gamePanel.setFocusable(true);
        gamePanel.setLayout(null);
        petLabel = new JLabel(new ImageIcon("pet.png"));
        petLabel.setBounds(200,500,500,500);

        gamePanel.add(petLabel);
        ImageIcon fish = new ImageIcon("fish.png");
        //ai used to help with array (so multiple fish can come down together)
        fishArray = new JLabel[numFish];
        for (int i = 0; i < numFish; i++){
            JLabel fishLabel = new JLabel(fish);
            int maximum = Math.max(1, gamePanel.getWidth() - 200);
            int random = (int)(Math.random()*maximum);
            fishLabel.setBounds(random,0, 200,200);
            fishArray[i] = fishLabel;
            gamePanel.add(fishLabel);
    
        }
        //referenced ai to debugg this
        Timer fishTimer = new Timer(20, e-> {
            for (int i = 0; i < fishArray.length; i++){
                fishArray[i].setLocation(fishArray[i].getX(), fishArray[i].getY()+5);
            }
        });
        fishTimer.start();
        //ai used to reference (for keyListener)
        gamePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e){
                int positionX = petLabel.getX();
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT){
                    positionX -= 30;
                }
                if (key == KeyEvent.VK_RIGHT){
                    positionX += 30;
                }
                if (positionX< 0){
                    positionX=0;
                }
                if (positionX > gamePanel.getWidth()-petLabel.getWidth()){
                    positionX = gamePanel.getWidth()-petLabel.getWidth();
                }
                petLabel.setBounds(positionX, petLabel.getY(), petLabel.getWidth(), petLabel.getHeight());
            }
            @Override
            public void keyReleased(KeyEvent e){

            }
            @Override
            public void keyTyped(KeyEvent e){

            }
        });
        gamePanel.requestFocusInWindow();


        }


    }
