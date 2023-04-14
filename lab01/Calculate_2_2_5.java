import javax.swing.JOptionPane;
public class Calculate_2_2_5{
    public static void main(String[] args){
        String num1, num2;
        num1 = JOptionPane.showInputDialog(null, "Please enter the first number", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        num2 = JOptionPane.showInputDialog(null, "Please enter the second number", "Input the second number", JOptionPane.INFORMATION_MESSAGE);


        double nom1 = Double.parseDouble(num1);
        double nom2 = Double.parseDouble(num2);
        while (nom2 == 0){
            num2 = JOptionPane.showInputDialog(null, "Cannot divide with 0! Please enter again!", "Error!", JOptionPane.INFORMATION_MESSAGE);
            nom2 = Double.parseDouble(num2);
        }
        double sum = nom1 + nom2;
        double difference = nom1 - nom2;
        double product = nom1*nom2;
        double quotient = nom1 / nom2;


        JOptionPane.showMessageDialog(null, sum, "The sum of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, difference, "The difference of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, product, "The product of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, quotient, "The quotient of two numbers", JOptionPane.INFORMATION_MESSAGE);
    }
}

