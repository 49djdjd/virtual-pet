//first time using this so referenced ai on what to import
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

//referenced online sites and AI for this part
public class PetGUI{
    private Timer timer;
    private JLabel nameStatus;
    private JLabel hungerStatus;
    private JLabel happinessStatus;
    private JLabel energyStatus;
    private PetClass p;
    private JFrame f;
    public PetGUI(){
        nameStatus = new JLabel("Name: ");
        String name1 = JOptionPane.showInputDialog("Enter your pet's name: ");
        //creating new object for testing
        PetClass p = new PetClass(name1);
        JFrame f = new JFrame("My Virtual Pet");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(1920,1080);
        showHomeScreen(f, p);
    }
        //creaing image icon
        public void showHomeScreen(JFrame f, PetClass p){
            //referenced this line from ai
            f.getContentPane().removeAll();
            //organizing it (in the order it appears)
            ImageIcon background = new ImageIcon("grass.png");
            JLabel backgroundLabel = new JLabel(background);
            f.add(backgroundLabel);
            backgroundLabel.setBounds(0, 0, 1920, 1080);
            ImageIcon petImage = new ImageIcon("pet.png");
            //holding image
            JLabel petLabel = new JLabel(petImage);
            f.add(petLabel);
            petLabel.setBounds(200,500,500,500);
            JPanel status = new JPanel();
            status.setLayout(new GridLayout(4,1));
            f.add(status);
            Font statusFont = new Font("Verdana", Font.PLAIN, 20);
            status.setBounds(50, 50, 500, 100);
            nameStatus = new JLabel();
            hungerStatus = new JLabel();
            energyStatus = new JLabel();
            happinessStatus = new JLabel();
            nameStatus.setFont(statusFont);
            hungerStatus.setFont(statusFont);
            energyStatus.setFont(statusFont);
            happinessStatus.setFont(statusFont);
            status.add(nameStatus);
            status.add(hungerStatus);
            status.add(energyStatus);
            status.add(happinessStatus);
            //ai helped debugged
            JButton feedButton = new JButton("Feed Pet"); 
            feedButton.setPreferredSize(new Dimension(200, 50));
            JButton playButton = new JButton("Play with Pet");
            playButton.setPreferredSize(new Dimension(200,50));
            JButton restButton = new JButton("Rest Pet!");
            restButton.setPreferredSize(new Dimension(200,50));
            JPanel buttonPanel = new JPanel(new FlowLayout());
            buttonPanel.add(feedButton);
            buttonPanel.add(playButton);
            buttonPanel.add(restButton);
            buttonPanel.setBounds(950,50,700,60);
            f.add(buttonPanel);
            updateStatus(p);
            f.revalidate();
            f.repaint();
            //refernced ai for this section -> is a lamba expression
            timer = new javax.swing.Timer(3000, e->{
            p.passTime();
            p.makeEverythingIsPositive();
            updateStatus(p);
        });
        resume();
            //hmm still kind of confused of this section
            feedButton.addActionListener(new ActionListener(){
            //this helps catch mistakes
            @Override
            public void actionPerformed(ActionEvent e){
                pause();
                p.makeEverythingIsPositive();
                updateStatus(p);
                System.out.println("Pet is fed!");
                new fishMiniGame(f, p) ;
            }
        });
            playButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                p.playTime();
                p.makeEverythingIsPositive();
                updateStatus(p);
                System.out.println("Pet is happy!");
            }
                });
            restButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                p.restPet();
                p.makeEverythingIsPositive();
                updateStatus(p);
                System.out.println("Pet is resting !");
                    }
                    });
            f.setVisible(true);

}

private void updateStatus(PetClass a){
    nameStatus.setText("Name: " + a.getName());
    hungerStatus.setText("Hunger: " + a.getHunger());
    energyStatus.setText("Energy: " + a.getEnergy());
    happinessStatus.setText("Happiness " + a.getHappiness());

}
public void pause(){
    timer.stop();
}
public void resume(){
    timer.start();
}
public static void main(String[] args){
    SwingUtilities.invokeLater((new Runnable() {
        @Override
        public void run(){
            new PetGUI();
        }

    }));

    }
}