import javax.swing.JOptionPane;

public class Equations_2_2_6 {
    public static double Solve_first_degree_equation(double[] arg){
        if (arg[0] == 0){
            return arg[1];
        } else{
            return -arg[1] / arg[0];
        }
    }
    public static double[] Solve_second_degree_equation(double[] arg){
        if (arg[0] == 0){
            double[] res = new double[1];
            res[0] = -arg[2] / arg[1];
            return res;
        }else{
            double delta = arg[1]*arg[1] - 4*arg[0]*arg[2];
            if (delta < 0){
                JOptionPane.showMessageDialog(null, "No real solution", "Warnig!", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
            if (delta == 0){
                double[] res = {-arg[1]/(2*arg[0]),-arg[1]/(2*arg[0]) };
                return res;
            }
            else{
                double[] res = {(-arg[1] + Math.sqrt(delta))/(2*arg[0]),(-arg[1] - Math.sqrt(delta))/(2*arg[0])};
                return res;
            }
        }
    }
    public static double[] Solve_first_degree_SOE(double[][] arg){
        if (arg[1][0] / arg[0][0] == arg[1][1] / arg[0][1] && arg[1][0]/arg[0][0] == arg[1][2] / arg[0][2]){
            JOptionPane.showMessageDialog(null, "Infinite solution", "Warning!", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        if (arg[1][0] / arg[0][0] == arg[1][1] / arg[0][1] && arg[1][0]/arg[0][0] != arg[1][2] / arg[0][2]){
            JOptionPane.showMessageDialog(null, "No solution!", "Warning!", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        else{
            double D = arg[0][0] *arg[1][1] - arg[1][0]*arg[0][1];
            double D1 = arg[0][1] *arg[1][2] - arg[1][1]*arg[0][2];
            double D2 = arg[0][0] *arg[1][2] - arg[1][0]*arg[0][2];
            double[] sol = {D1/D, D2/D};
            return sol;
        }
    }

    public static void main(String[] arg){
        String command = JOptionPane.showInputDialog(null, "Please enter your command", "Task", JOptionPane.INFORMATION_MESSAGE);
        if (command.contains("first")){
            String[] inp = new String[2];
            for (int i = 0; i< 2; i++){
                inp[i] = JOptionPane.showInputDialog(null, "Enter the coefficients", "Input", JOptionPane.INFORMATION_MESSAGE);
            }
            double[] coef = new double[2];
            for (int i = 0; i< 2; i++){
                coef[i] = Double.parseDouble(inp[i]);
            }
            JOptionPane.showMessageDialog(null, Solve_first_degree_equation(coef), "Solution", JOptionPane.INFORMATION_MESSAGE);
        }

        if (command.contains("system")){
            String[][] inp = new String[2][3];
            for (int i = 0; i< 2; i++){
                for (int j = 0; j< 3; j++){
                    inp[i][j] = JOptionPane.showInputDialog(null, "Enter the coefficients", "Input", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            double[][] coef = new double[2][3];
            for (int i = 0; i < 2; i++){
                for (int j = 0; j < 3; j++){
                    coef[i][j] = Double.parseDouble(inp[i][j]);
                }
            }
            double[] res = Solve_first_degree_SOE(coef);
            if (res == null){} 
            else{
                JOptionPane.showMessageDialog(null, res[0], "Solution for x1", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, res[1], "Solution for x2", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (command.contains("second")){
            String[] inp = new String[3];
            for (int i = 0; i< 3; i++){
                inp[i] = JOptionPane.showInputDialog(null, "Enter the coefficients", "Input", JOptionPane.INFORMATION_MESSAGE);
            }
            double[] coef = new double[3];
            for (int i = 0; i<3; i++){
                coef[i] = Double.parseDouble(inp[i]);
            }

            double[] res = Solve_second_degree_equation(coef);
            if (res == null){}
            else{
                if (res.length == 1){
                    JOptionPane.showMessageDialog(null, res[0], "Single root", JOptionPane.INFORMATION_MESSAGE);
                } else{
                    JOptionPane.showMessageDialog(null, res[0], "First root", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, res[1], "Second root", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Not a valid command", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}