package hust.soict.dsai.Lab01.SourceCodeLab01;
import javax.swing.JOptionPane;
public class Days_of_Month_6_4 {
	public static void main(String[] arg) {
		String mon, year;
		String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

		mon = JOptionPane.showInputDialog(null,"Please enter the month: ","Month",JOptionPane.INFORMATION_MESSAGE);
		
		while (true) {
			if (mon.equals("Jan") || mon.equals("Jan.") || mon.equals("1") || mon.equals("January") ||
				mon.equals("Feb") || mon.equals("Feb.") || mon.equals("2") || mon.equals("February") ||
				mon.equals("Mar") || mon.equals("Mar.") || mon.equals("3") ||mon.equals("March") ||
				mon.equals("Apr") || mon.equals("Apr.") || mon.equals("4") ||mon.equals("April") ||
				mon.equals("May") || mon.equals("May.") || mon.equals("5") ||mon.equals("May") ||
				mon.equals("Jun") || mon.equals("Jun.") || mon.equals("6") ||mon.equals("June") ||
				mon.equals("Jul") || mon.equals("Jul.") || mon.equals("7") ||mon.equals("July") ||
				mon.equals("Aug") || mon.equals("Aug.") || mon.equals("8") ||mon.equals("August") ||
				mon.equals("Sep") || mon.equals("Sep.") || mon.equals("9") ||mon.equals("September") ||
				mon.equals("Oct") || mon.equals("Oct.") || mon.equals("10") ||mon.equals("October") ||
				mon.equals("Nov") || mon.equals("Nov.") || mon.equals("11") ||mon.equals("November") ||
				mon.equals("Dec") || mon.equals("Dec.") || mon.equals("12") || mon.equals("December")){
				break;
			}
			else {
				mon = JOptionPane.showInputDialog(null,"Not a valid month!.Please enter the month: ","Month",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		year = JOptionPane.showInputDialog(null,"Please enter the year: ","Year",JOptionPane.INFORMATION_MESSAGE);
		int numyear = 0;
		while (true) {
			try {
				numyear = Integer.parseInt(year);
				if (numyear < 0) {
					year = JOptionPane.showInputDialog(null,"Not a valid year.Please enter the year: ","Year",JOptionPane.INFORMATION_MESSAGE);
					numyear = Integer.parseInt(year);
					} else {break;}
				}
			catch (NumberFormatException e) {
				year = JOptionPane.showInputDialog(null,"Not a valid year.Please enter the year: ","Year",JOptionPane.INFORMATION_MESSAGE);
			}
		}
			

		
		if (mon.contains(months[0]) || mon.equals("1") ||
			mon.contains(months[2]) || mon.equals("3") ||
			mon.contains(months[4]) || mon.equals("5") ||
			mon.contains(months[6]) || mon.equals("7") ||
			mon.contains(months[7]) || mon.equals("8") ||
			mon.contains(months[9]) || mon.equals("10") ||
			mon.contains(months[11]) || mon.equals("12")){
			JOptionPane.showMessageDialog(null, "The number of days in this month is 31","Answer",JOptionPane.INFORMATION_MESSAGE);
		}
		if(mon.contains(months[3]) || mon.equals("1") ||
				mon.contains(months[5]) || mon.equals("1") ||
				mon.contains(months[8]) || mon.equals("1") ||
				mon.contains(months[10]) || mon.equals("1")){
			JOptionPane.showMessageDialog(null, "The number of days in this month is 30","Answer",JOptionPane.INFORMATION_MESSAGE);
		}
		if(mon.contains(months[1]) || mon.equals("2")) {
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