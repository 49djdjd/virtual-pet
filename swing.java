//first time using this so referenced ai on what to import
import javax.swing.Jframe;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

//referenced online sites and AI for this part 
public class PetGUI{
    public PetGUI(){
        //creating new object
        JFrame frame = new JFrame("My Virtual Pet");
        frame.setSize(500,400);
        //creaing image icon
        ImageIcon pet = new ImageIcon("pet.png");
        //holding image
        JLabel petLabel = new JLabel();
        frame.add(petLabel)

    }
}
public static void main(String[] args){
    pubilic void run(){
        new PetGUI();
    }
}