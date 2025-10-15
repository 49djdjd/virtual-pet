//first time using this so referenced ai on what to import
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

//referenced online sites and AI for this part
public class PetGUI{
    public PetGUI(){
        //creating new object
        JFrame frame = new JFrame("My Virtual Pet");
        frame.setSize(1500,1000);
        //creaing image icon
        ImageIcon pet = new ImageIcon("pet.png");
        //holding image
        JLabel petLabel = new JLabel(pet);
        frame.add(petLabel);
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