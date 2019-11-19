import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class aprovePost extends JFrame {

	private JPanel contentPane;
	private JTextField pendingCount;

	public aprovePost(String passedid, int admin, int sideid) {
		setTitle("Artful");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton myProf = new JButton("My profile");
		myProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile n=new UserProfile(passedid,0,0);
				dispose();
				n.setVisible(true);
			}
		});
		myProf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		myProf.setBounds(987, 10, 131, 36);
		contentPane.add(myProf);

		JButton logOut = new JButton("Log out");
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LogIn n= new LogIn();
				n.setVisible(true);
			}
		});
		logOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		logOut.setBounds(1138, 10, 104, 31);
		contentPane.add(logOut);

		JLabel pee = new JLabel("Pending post count :");
		pee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pee.setBounds(29, 31, 159, 20);
		contentPane.add(pee);

		pendingCount = new JTextField();
		pendingCount.setText("0");
		pendingCount.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 16));
		pendingCount.setEditable(false);
		pendingCount.setColumns(10);
		pendingCount.setBackground(Color.WHITE);
		pendingCount.setBounds(189, 30, 96, 22);
		contentPane.add(pendingCount);

		JButton btnConfirmPost = new JButton("Confirm post");
		btnConfirmPost.setForeground(new Color(220, 20, 60));
		btnConfirmPost.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnConfirmPost.setBounds(907, 127, 272, 55);
		contentPane.add(btnConfirmPost);

		JButton next = new JButton("Next ");
		next.setFont(new Font("Tahoma", Font.PLAIN, 19));
		next.setBounds(1027, 496, 131, 42);
		contentPane.add(next);

		JButton disagree = new JButton("Disagree");
		disagree.setForeground(Color.RED);
		disagree.setFont(new Font("Tahoma", Font.PLAIN, 28));
		disagree.setBounds(927, 192, 241, 44);
		contentPane.add(disagree);

		JButton previous = new JButton("Previous");
		previous.setFont(new Font("Tahoma", Font.PLAIN, 19));
		previous.setBounds(917, 451, 131, 42);
		contentPane.add(previous);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 183, 769, 446);
		contentPane.add(scrollPane);

		JTextArea postArea = new JTextArea();
		postArea.setFont(new Font("MS PGothic", Font.PLAIN, 30));
		scrollPane.setViewportView(postArea);
		postArea.setEditable(false);

		//set window
		ArrayList<String> name= new ArrayList<>();
		ArrayList<String> id= new ArrayList<>();
		ArrayList<String> post= new ArrayList<>();
		File f= new File("Admin\\postToBeApprove\\postCount.txt");
		String hold="";
		int count=0, admCount=0;
		try {
			Scanner s= new Scanner(f);
			hold=s.nextLine();
			s.close();
			pendingCount.setText(hold);
			count=Integer.valueOf(hold);
			hold="";
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(aprovePost.this, " Exception Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		File f2= new File("Admin\\postToBeApprove\\postedBy.txt");
		try {
			Scanner s= new Scanner(f2);
			for(int i=0;i<count;i++) {
				hold=s.nextLine();
				name.add(hold);
				hold=s.nextLine();
				id.add(hold);
				hold=s.nextLine();
				post.add(hold);
			}
			s.close();

			File adm= new File("Admin\\admincount.txt");
			if(adm.canRead()) {
				Scanner s3= new Scanner(adm);
				admCount=Integer.valueOf(s3.next());
				s3.close();
			}

		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(aprovePost.this, " Exception Problem in resorse accessing!!!!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		flag fg= new flag();
		if(name.size()>0) {
			final int j=name.size()-1;
			if(fg.getI2()==0) {
				next.setEnabled(true);
				previous.setEnabled(false);
			}
			if(fg.getI2()==j) {
				next.setEnabled(false);
				previous.setEnabled(true);
			}
			if(fg.getI2()==j&&fg.getI2()==0) {
				next.setEnabled(false);
				previous.setEnabled(false);
			}

			postArea.setText(post.get(fg.getI2()));
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fg.inc();
					
					postArea.setText(post.get(fg.getI2()));
					if(fg.getI2()==j) {
						next.setEnabled(false);
						previous.setEnabled(true);
					}
					else {
						next.setEnabled(true);
						previous.setEnabled(true);
					}
				}
			});

			previous.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fg.dec();

					postArea.setText(post.get(fg.getI2()));
					if(fg.getI2()==0) {
						next.setEnabled(true);
						previous.setEnabled(false);
					}
					else {
						next.setEnabled(true);
						previous.setEnabled(true);
					}
				}
			});
		}
		else {
			btnConfirmPost.setEnabled(false);
			disagree.setEnabled(false);
			previous.setEnabled(false);
			next.setEnabled(false);
			


		}
		btnConfirmPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update(post.get(fg.getI2()), id.get(fg.getI2()),name.get(fg.getI2()),1);
				dispose();
				aprovePost a = new aprovePost(passedid,admin,sideid);
				a.setVisible(true);

			}
		});
		disagree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update(post.get(fg.getI2()), id.get(fg.getI2()),name.get(fg.getI2()),0);
				dispose();
				aprovePost a = new aprovePost(passedid,admin,sideid);
				a.setVisible(true);
			}
		});


	}  ///end of constructor



	public void update(String post, String id,String name,int flag) {
		String hold="";
		int admCount=0,vote=0;

		try {
			File adm= new File("Admin\\admincount.txt");
			if(adm.canRead()) {
				Scanner s3= new Scanner(adm);
				admCount=Integer.valueOf(s3.next());
				s3.close();
			}
			String []bool= new String[admCount];					

			//reading post
			File po= new File("Admin//postToBeApprove//"+id+".txt");
			Scanner s= new Scanner(po);
			for(int i=0;i<admCount;i++) {
				hold=s.nextLine();
				bool[i]=hold;
			}
			hold=s.nextLine();
			vote=Integer.valueOf(hold);
			s.close();

			///upgrading vote
			if(flag==1)bool[vote]="true";
			if(flag==0)bool[vote]="false";
			po.delete();
			File po2= new File("Admin//postToBeApprove//"+id+".txt");
			po2.createNewFile();
			PrintWriter p1= new PrintWriter(po);
			for(int i=0;i<admCount;i++) {
				p1.println(bool[i]);
			}
			++vote;
			p1.println(vote);
			p1.println(post);
			p1.close();
			boolean b= true;


			//Counting
			vote=0;
			int checked=0;
			File po3= new File("Admin//postToBeApprove//"+id+".txt");
			Scanner s3= new Scanner(po);
			for(int i=0;i<admCount;i++) {
				hold=s3.nextLine();
				if(hold.equals("true"))vote++;
			}
			hold=s3.nextLine();
			checked=Integer.valueOf(hold);
			post=s3.nextLine();
			s3.close();
			double needVote=Math.rint((90.0*admCount)/100);

			Calendar c= new GregorianCalendar();
			String time=""+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+" "+((c.get(Calendar.AM_PM)==0)?"AM":"PM")+"  "+c.get(Calendar.DATE)+
					"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR);
			if(checked==admCount) {
				if(needVote<=vote) {
					boolean c1= false;
					Scanner s7= new Scanner("Users//"+id+"//"+id+"post.txt");
					if(s7.hasNext())c1=true;
					s7.close();
					PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Users//"+id+"//"+id+"post.txt", true)));
					if(!c1)out.println();
					out.println(time);
					out.println(0);
					out.println(0);
					out.println(post);
					out.println();
					out.println("*nxtpost");
					out.flush();
					out.close();
					po3.delete();
					JOptionPane.showMessageDialog(aprovePost.this, " Post updated "," Sorry ..",JOptionPane.INFORMATION_MESSAGE);


					//updating
					File pc= new File("Admin\\postToBeApprove\\postCount.txt");
					Scanner s2 = new Scanner(pc);
					int count=Integer.valueOf(s2.next());
					s2.close();
					--count;
					pc.delete();
					if(!pc.exists()) {
						File pc1= new File("Admin\\postToBeApprove\\postCount.txt");
						pc1.createNewFile();
						PrintWriter p2= new PrintWriter(pc1);
						p2.println(count);
						p2.close();
					}

					ArrayList<String> name1= new ArrayList<>();
					ArrayList<String> id1= new ArrayList<>();
					ArrayList<String> post1= new ArrayList<>();
					File f2= new File("Admin\\postToBeApprove\\postedBy.txt");
					Scanner s4= new Scanner(f2);
					for(int i=0;i<count+1;i++) {
						hold=s4.nextLine();
						name1.add(hold);
						hold=s4.nextLine();
						id1.add(hold);
						hold=s4.nextLine();
						post1.add(hold);
					}
					s4.close();

					for(int i=0;i<name1.size();i++) {
						if(name.equals(name1.get(i))) {
							name1.remove(i);
							id1.remove(i);
							post1.remove(i);
							break;
						}

					}
					f2.delete();


					File f3= new File("Admin\\postToBeApprove\\postedBy.txt");
					f3.createNewFile();
					PrintWriter p2= new PrintWriter(f3);                                
					for(int i=0;i<name1.size();i++) {
						p2.println(name1.get(i));
						p2.println(id1.get(i));
						p2.println(post1.get(i));
					}
					p2.close();

					///account update
					allUser user= new allUser();
					hold="Users//"+id+"//"+id+".txt";
					File f5= new File(hold);
					if(f5.exists() && f5.canRead()){
						try {
							hold="";
							Scanner fs= new Scanner(f5);
							hold=fs.nextLine();
							user.setPass(hold);
							hold=fs.nextLine();
							user.setAdmin((hold.equals("true"))?true:false);
							hold=fs.nextLine();
							user.setName(hold);
							hold=fs.nextLine();
							user.setEmail(hold);
							hold=fs.nextLine();
							user.setNid(Integer.parseInt(hold));
							hold=fs.nextLine();
							user.setGender(hold);
							hold=fs.nextLine();
							user.setAge(hold);
							hold=fs.nextLine();
							user.setFname(hold);
							hold=fs.nextLine();
							user.setMname(hold);
							hold=fs.nextLine();
							user.setAddr(hold);
							hold=fs.nextLine();
							user.setPcount(hold);
							hold=fs.nextLine();
							user.setRcount(hold);
							hold=fs.nextLine();
							user.setRecount(hold);
							hold=fs.nextLine();
							user.setPecount(hold);
							fs.close();
						} catch (FileNotFoundException ez) {
							JOptionPane.showMessageDialog(aprovePost.this, " Exception Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
						}
					} //end of if
					try {
						count=Integer.valueOf(user.getPcount());
						++count;
						user.setPcount(Integer.toString(count));
						count=Integer.valueOf(user.getPecount());
						--count;
						user.setPecount(Integer.toString(count));
						f5.delete();
						hold="Users//"+id+"//"+id+".txt";
						File fz= new File(hold);
						if(user.creatNewId(fz)) {
							JOptionPane.showMessageDialog(aprovePost.this, " Account seccessfully updated.","Success",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(aprovePost.this, " Problem in account updating!!!!","Error",JOptionPane.ERROR_MESSAGE);
						}
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(aprovePost.this, " Exception Problem in resorse updating!!!!","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					
					PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("Admin\\approvedPost\\feed.txt", true)));
					out1.println();
					out1.println(name);
					out1.println(id);
					out1.println(time);
					out1.println(0);
					out1.println(0);
					out1.print(post);
					out1.flush();
					out1.close();
				}   
				
				
				///if ignored
				else {
					File po4= new File("Admin//postToBeApprove//"+id+".txt");
					po4.delete();

					File pc= new File("Admin\\postToBeApprove\\postCount.txt");
					Scanner s2 = new Scanner(pc);
					int count=Integer.valueOf(s2.next());
					s2.close();
					--count;
					pc.delete();
					if(!pc.exists()) {
						File pc1= new File("Admin\\postToBeApprove\\postCount.txt");
						pc1.createNewFile();
						PrintWriter p2= new PrintWriter(pc1);
						p2.println(count);
						p2.close();
					}

					ArrayList<String> name1= new ArrayList<>();
					ArrayList<String> id1= new ArrayList<>();
					ArrayList<String> post1= new ArrayList<>();
					File f2= new File("Admin\\postToBeApprove\\postedBy.txt");
					Scanner s4= new Scanner(f2);
					for(int i=0;i<count+1;i++) {
						hold=s4.nextLine();
						name1.add(hold);
						hold=s4.nextLine();
						id1.add(hold);
						hold=s4.nextLine();
						post1.add(hold);
					}
					s4.close();

					for(int i=0;i<name1.size();i++) {
						if(name.equals(name1.get(i))) {
							name1.remove(i);
							id1.remove(i);
							post1.remove(i);
							break;
						}

					}
					f2.delete();


					File f3= new File("Admin\\postToBeApprove\\postedBy.txt");
					f3.createNewFile();
					PrintWriter p2= new PrintWriter(f3);                                
					for(int i=0;i<name1.size();i++) {
						p2.println(name1.get(i));
						p2.println(id1.get(i));
						p2.println(post1.get(i));
					}
					p2.close();	

					///account update
					allUser user= new allUser();
					hold="Users//"+id+"//"+id+".txt";
					File f5= new File(hold);
					if(f5.exists() && f5.canRead()){
						try {
							hold="";
							Scanner fs= new Scanner(f5);
							hold=fs.nextLine();
							user.setPass(hold);
							hold=fs.nextLine();
							user.setAdmin((hold.equals("true"))?true:false);
							hold=fs.nextLine();
							user.setName(hold);
							hold=fs.nextLine();
							user.setEmail(hold);
							hold=fs.nextLine();
							user.setNid(Integer.parseInt(hold));
							hold=fs.nextLine();
							user.setGender(hold);
							hold=fs.nextLine();
							user.setAge(hold);
							hold=fs.nextLine();
							user.setFname(hold);
							hold=fs.nextLine();
							user.setMname(hold);
							hold=fs.nextLine();
							user.setAddr(hold);
							hold=fs.nextLine();
							user.setPcount(hold);
							hold=fs.nextLine();
							user.setRcount(hold);
							hold=fs.nextLine();
							user.setRecount(hold);
							hold=fs.nextLine();
							user.setPecount(hold);
							fs.close();
						} catch (FileNotFoundException ez) {
							JOptionPane.showMessageDialog(aprovePost.this, " Exception Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
						}
					} //end of if
					try {
						count=Integer.valueOf(user.getPecount());
						--count;
						user.setPecount(Integer.toString(count));
						f5.delete();
						hold="Users//"+id+"//"+id+".txt";
						File fz= new File(hold);
						if(user.creatNewId(fz)) {
							JOptionPane.showMessageDialog(aprovePost.this, " Account seccessfully updated.","Success",JOptionPane.INFORMATION_MESSAGE);

						}
						else {
							JOptionPane.showMessageDialog(aprovePost.this, " Problem in account updating!!!!","Error",JOptionPane.ERROR_MESSAGE);
						}
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(aprovePost.this, " Exception Problem in resorse updating!!!!","Error",JOptionPane.ERROR_MESSAGE);

					}
				}

			}

			if(b)JOptionPane.showMessageDialog(aprovePost.this, " Vote successfull "," Sorry ..",JOptionPane.INFORMATION_MESSAGE);
			return;
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(aprovePost.this, " Exception Problem in resorse updating!!!!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(aprovePost.this, " Exception Problem in resorse updating!!!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	class flag{
		private int i2=0;
		flag(){	
			i2=0;
		}

		public void inc() {
			i2=i2+1;
		}
		public void dec() {
			i2=i2-1;
		}
		public int getI2() {
			return i2;
		}
	}
}
