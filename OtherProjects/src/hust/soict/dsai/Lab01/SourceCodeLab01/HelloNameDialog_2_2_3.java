package hust.soict.dsai.Lab01.SourceCodeLab01;
import javax.swing.JOptionPane;
public class HelloNameDialog_2_2_3 {
    public static void main(String[] args){
        String result;
        result = JOptionPane.showInputDialog("Please enter your name:");
        JOptionPane.showMessageDialog(null, "Hi " + result + "!");
        System.exit(0);
    }
}
