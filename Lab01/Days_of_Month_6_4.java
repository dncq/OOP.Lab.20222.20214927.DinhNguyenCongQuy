import javax.swing.JOptionPane;
public class Days_of_Month_6_4 {
	public static void main(String[] arg) {
		String mon, year;
		String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
//		String[] full_months = {"January","February","March","April","May","June","July","August","September","October","November","December"};

		mon = JOptionPane.showInputDialog(null,"Please enter the month: ","Month",JOptionPane.INFORMATION_MESSAGE);
		boolean check = true;
		while (check) {
			for (int i = 1; i <= 12; i++) {
				if (mon.contains(months[i-1]) || Integer.parseInt(mon) == i) {
					check = false;
					break;
				}
			}
			if (check == true) {
			mon = JOptionPane.showInputDialog(null,"Not a valid month!.Please enter the month: ","Month",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		year = JOptionPane.showInputDialog(null,"Please enter the year: ","Year",JOptionPane.INFORMATION_MESSAGE);
		int numyear = Integer.parseInt(year);
		while (true) {
			if (numyear < 0) {
				year = JOptionPane.showInputDialog(null,"Not a valid year.Please enter the year: ","Year",JOptionPane.INFORMATION_MESSAGE);
				numyear = Integer.parseInt(year);
			} else {break;}
		}

		if (mon.contains(months[0]) || mon.contains("1") ||
			mon.contains(months[2]) || mon.contains("3") ||
			mon.contains(months[4]) || mon.contains("5") ||
			mon.contains(months[6]) || mon.contains("7") ||
			mon.contains(months[7]) || mon.contains("8") ||
			mon.contains(months[9]) || mon.contains("10") ||
			mon.contains(months[11]) || mon.contains("12")){
			JOptionPane.showMessageDialog(null, "The number of days in this month is 31","Answer",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(mon.contains(months[3]) || mon.contains("1") ||
				mon.contains(months[5]) || mon.contains("1") ||
				mon.contains(months[8]) || mon.contains("1") ||
				mon.contains(months[10]) || mon.contains("1")){
			JOptionPane.showMessageDialog(null, "The number of days in this month is 30","Answer",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(mon.contains(months[1]) || mon.contains("2")) {
			if (numyear % 4 == 0) {
				if (numyear % 100 == 0) {
					if (numyear % 16 != 0) {
						JOptionPane.showMessageDialog(null, "The number of days in this month is 28","Answer",JOptionPane.INFORMATION_MESSAGE);
					} else if (numyear % 16 == 0) {
						JOptionPane.showMessageDialog(null, "The number of days in this month is 29","Answer",JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "The number of days in this month is 29","Answer",JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "The number of days in this month is 28","Answer",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}

