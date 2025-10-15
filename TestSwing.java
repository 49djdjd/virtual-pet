import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Test");
        JLabel label = new JLabel("Hello, Swing!");
        frame.add(label);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}