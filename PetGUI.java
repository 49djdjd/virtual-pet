//first time using this so referenced ai on what to import
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

//referenced online sites and AI for this part
public class PetGUI{
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
        frame.add(petLabel);
        JPanel statusbar = new JPanel();
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