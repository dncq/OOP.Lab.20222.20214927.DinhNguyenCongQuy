// import java.util.Scanner;

// public class Calculate {
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         double num1 = sc.nextDouble();
//         double num2 = sc.nextDouble();
//         System.out.println("Sum: " + (num1 + num2));
//         System.out.println("Difference: " + (num1 - num2));
//         System.out.println("Product: " + (num1 * num2));
//         System.out.println("Quotient: " + (num1 / num2));
//     }
// }

import javax.swing.JOptionPane;
public class Calculate_2_2_5{
    public static void main(String[] args){
        String num1, num2;
        num1 = JOptionPane.showInputDialog(null, "Please enter the first number", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        num2 = JOptionPane.showInputDialog(null, "Please enter the second number", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double nom1 = Double.parseDouble(num1);
        double nom2 = Double.parseDouble(num2);
        double sum = nom1 + nom2;
        double difference = nom1 - nom2;
        double product = nom1*nom2;

        JOptionPane.showMessageDialog(null, sum, "The sum of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, difference, "The difference of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, product, "The product of two numbers", JOptionPane.INFORMATION_MESSAGE);
        if (nom2 != 0){
            double quotient = nom1 / nom2;
            JOptionPane.showMessageDialog(null, quotient, "The quotient of two numbers", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Cannot divide with 0", "The quotient of two numbers", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}

