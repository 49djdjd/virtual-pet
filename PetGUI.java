//first time using this so referenced ai on what to import
import java.awt.FlowLayout;
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
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

//referenced online sites and AI for this part
public class PetGUI{
    private JLabel nameStatus;
    private JLabel hungerStatus;
    private JLabel happinessStatus;
    private JLabel energyStatus;
    public PetGUI(){

        //creating new object
        PetClass pet = new PetClass("silly", 100,100,100);
        JFrame frame = new JFrame("My Virtual Pet");
        frame.setLayout(new FlowLayout());
        frame.setSize(1500,1000);
        //creaing image icon
        ImageIcon petImage = new ImageIcon("pet.png");
        //holding image
        JLabel petLabel = new JLabel(petImage);
        frame.setLayout(new FlowLayout());
        frame.add(petLabel);
        JPanel status = new JPanel();
        frame.add(status);
        nameStatus = new JLabel();
        hungerStatus = new JLabel();
        energyStatus = new JLabel();
        happinessStatus = new JLabel();
        status.add(nameStatus);
        nameStatus.setText(null);
        status.add(hungerStatus);
        hungerStatus.setText("Hunger: " + pet.getHunger());
        status.add(energyStatus);
        status.add(happinessStatus);
        status.add(new JLabel("Pet Status "));
        JButton feedButton = new JButton("Feed Pet:");
        JButton playButton = new JButton("Play with Pet");
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