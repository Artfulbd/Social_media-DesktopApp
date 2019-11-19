
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class testInDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintWriter out1;
		try {
			out1 = new PrintWriter(new BufferedWriter(new FileWriter("Admin\\approvedPost\\feed.txt", true)));
			out1.println();
			out1.println("0lkjbklname");
			out1.println("66516654");
			out1.println("12:50");
			out1.println(0);
			out1.println(0);
			out1.print("luhfg sgh sdk ghs");
			out1.flush();
			out1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
