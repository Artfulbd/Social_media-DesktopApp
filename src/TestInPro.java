import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;
public class TestInPro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> name= new ArrayList<>();
		ArrayList<String> id= new ArrayList<>();
		ArrayList<String> time= new ArrayList<>();
		ArrayList<String> agCount= new ArrayList<>();
		ArrayList<String> dagCount= new ArrayList<>();
		ArrayList<String> post= new ArrayList<>();
		try {
			File f= new File("Admin\\approvedPost\\feed.txt");
			Scanner s= new Scanner(f);
			String hold;
			while(s.hasNext()) {
				hold=s.nextLine();
				name.add(hold);
				hold=s.nextLine();
				id.add(hold);
				hold=s.nextLine();
				time.add(hold);
				hold=s.nextLine();
				agCount.add(hold);
				hold=s.nextLine();
				dagCount.add(hold);
				hold=s.nextLine();
				post.add(hold);
			}
			s.close();
		} catch (FileNotFoundException e1) {
			
		}
		for(int i=0;i<name.size();i++) {
			System.out.println(" Name: ("+i+"): "+name.get(i));
			System.out.println(" Id: ("+i+"):   "+id.get(i));
			System.out.println(" Time: ("+i+"): "+time.get(i));
			System.out.println(" Dot: ("+i+"): "+agCount.get(i));
			System.out.println(" Dot2: ("+i+"): "+dagCount.get(i));
			System.out.println(" Post: ("+i+"): "+post.get(i)+"\n");
		}
	}

}
