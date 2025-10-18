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
    public fishMiniGame(JFrame b){
        JPanel gamePanel = new JPanel();
        frame = b;
        b.add(gamePanel);
        gamePanel.setBounds(0,0, frame.getWidth(), frame.getHeight());
        gamePanel.setFocusable(true);
        gamePanel.setLayout(null);
        petLabel = new JLabel(new ImageIcon("pet.png"));
        petLabel.setBounds(200,300,500,500);
        gamePanel.add(petLabel);
        //ai used to reference
        gamePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT){
                    petLabel.setBounds(petLabel.getX()-10, petLabel.getY(), petLabel.getWidth(), petLabel.getHeight());
                }
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
