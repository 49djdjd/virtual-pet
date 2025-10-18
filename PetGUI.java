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
    private JLabel nameStatus;
    private JLabel hungerStatus;
    private JLabel happinessStatus;
    private JLabel energyStatus;
    public PetGUI(){
        nameStatus = new JLabel("Name: ");
        String name1 = JOptionPane.showInputDialog("Enter your pet's name: ");
        //creating new object for testing
        PetClass pet = new PetClass(name1);
        JFrame frame = new JFrame("My Virtual Pet");
        frame.setLayout(null);
        frame.setSize(1920,1080);
        //creaing image icon
        ImageIcon petImage = new ImageIcon("pet.png");
        ImageIcon background = new ImageIcon("grass.png");
        //holding image
        JLabel petLabel = new JLabel(petImage);
        JLabel backgroundLabel = new JLabel(background);
        frame.add(petLabel);
        petLabel.setBounds(200,300,500,500);
        frame.add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 1920, 1080);
        JPanel status = new JPanel();
        status.setLayout(new GridLayout(4,1));
        frame.add(status);
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
        updateStatus(pet);
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
        buttonPanel.setBounds(950,50,500,60);
        frame.add(buttonPanel);
        //refernced ai for this section -> is a lamba expression
        javax.swing.Timer timer = new javax.swing.Timer(3000, e->{
            pet.passTime();
            pet.makeEverythingIsPositive();
            updateStatus(pet);
        });
        //hmm still kind of confused of this section
        feedButton.addActionListener(new ActionListener(){
            //this helps catch mistakes
            @Override
            public void actionPerformed(ActionEvent e){
                pet.feedPet();
                pet.makeEverythingIsPositive();
                updateStatus(pet);
                System.out.println("Pet is fed!");
            }
            });
        playButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                pet.playTime();
                pet.makeEverythingIsPositive();
                updateStatus(pet);
                System.out.println("Pet is happy!");
            }
                });
        restButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                pet.restPet();
                pet.makeEverythingIsPositive();
                updateStatus(pet);
                System.out.println("Pet is resting !");
                    }
                    });
        timer.start();
        frame.setVisible(true);
        }
private void updateStatus(PetClass a){
    nameStatus.setText("Name: " + a.getName());
    hungerStatus.setText("Hunger: " + a.getHunger());
    energyStatus.setText("Energy: " + a.getEnergy());
    happinessStatus.setText("Happiness " + a.getHappiness());

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