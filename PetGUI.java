//first time using this so referenced ai on what to import
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        frame.setLayout(new BorderLayout());
        frame.setSize(1500,1000);
        //creaing image icon
        ImageIcon petImage = new ImageIcon("pet.png");
        //holding image
        JLabel petLabel = new JLabel(petImage);
        frame.add(petLabel, BorderLayout.WEST);
        JPanel status = new JPanel();
        frame.add(status);
        status.setLayout(new GridLayout(4,2));
        nameStatus = new JLabel();
        hungerStatus = new JLabel();
        energyStatus = new JLabel();
        happinessStatus = new JLabel();
        status.add(nameStatus);
        nameStatus.setText("Name: " + pet.getName());
        status.add(hungerStatus);
        hungerStatus.setText("Hunger: " + pet.getHunger());
        status.add(energyStatus);
        energyStatus.setText("Energy: " + pet.getEnergy());
        status.add(happinessStatus);
        happinessStatus.setText("Happiness " + pet.getHappiness());
        status.add(new JLabel("Pet Status "));
        JButton feedButton = new JButton("Feed Pet:");
        feedButton.setPreferredSize(new Dimension(100, 30));
        JButton playButton = new JButton("Play with Pet");
        playButton.setPreferredSize(new Dimension(100,30));
        //this adds them to window
        frame.add(feedButton);
        frame.add(playButton);
        //hmm still kind of confused of this section
        feedButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                pet.feedPet();
                
                System.out.println("Pet is fed!");
            }
            });
        frame.setVisible(true);
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