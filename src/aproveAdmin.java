import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class aproveAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField namef;
	private JTextField adminCount;

	public aproveAdmin(String passedid, int admin) {
		setTitle("Artful");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		JButton button_1 = new JButton("My profile");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile n=new UserProfile(passedid,admin,0);
				dispose();
				n.setVisible(true);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBounds(987, 10, 131, 36);
		contentPane.add(button_1);

		JLabel lblNewLabel = new JLabel("Postulant name :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(147, 127, 171, 44);
		contentPane.add(lblNewLabel);

		namef = new JTextField();
		namef.setBackground(Color.WHITE);
		namef.setEditable(false);
		namef.setFont(new Font("Tahoma", Font.PLAIN, 22));
		namef.setBounds(370, 128, 372, 44);
		contentPane.add(namef);
		namef.setColumns(10);

		JButton btnNext = new JButton("Next ");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNext.setBounds(587, 262, 131, 42);
		contentPane.add(btnNext);

		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnPrevious.setBounds(407, 262, 131, 42);
		contentPane.add(btnPrevious);

		JButton btnCheckProfile = new JButton("Check profile");
		btnCheckProfile.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCheckProfile.setBounds(587, 183, 155, 31);
		contentPane.add(btnCheckProfile);

		JLabel lblSendMeggage = new JLabel("Write a  message");
		lblSendMeggage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSendMeggage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSendMeggage.setBounds(131, 387, 187, 44);
		contentPane.add(lblSendMeggage);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(325, 397, 555, 170);
		contentPane.add(scrollPane);

		JTextArea sms = new JTextArea();
		scrollPane.setViewportView(sms);
		sms.setFont(new Font("MS PGothic", Font.PLAIN, 25));

		JButton sent = new JButton("Send");
		sent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sent.setBounds(767, 572, 113, 44);
		contentPane.add(sent);

		JButton btnConfarmAdmin = new JButton("Confirm admin");
		btnConfarmAdmin.setForeground(Color.RED);
		btnConfarmAdmin.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnConfarmAdmin.setBounds(832, 127, 272, 55);
		contentPane.add(btnConfarmAdmin);

		JButton btnDeleteRequest = new JButton("Delete request");
		btnDeleteRequest.setForeground(Color.RED);
		btnDeleteRequest.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnDeleteRequest.setBounds(832, 208, 241, 44);
		contentPane.add(btnDeleteRequest);
		
		JLabel lblTotalAdmin = new JLabel("Total admin:  ");
		lblTotalAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalAdmin.setBounds(81, 204, 113, 20);
		contentPane.add(lblTotalAdmin);
		
		adminCount = new JTextField();
		adminCount.setText("0");
		adminCount.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 16));
		adminCount.setEditable(false);
		adminCount.setColumns(10);
		adminCount.setBackground(Color.WHITE);
		adminCount.setBounds(193, 203, 96, 22);
		contentPane.add(adminCount);
		
		JLabel lblCurrentAdminList = new JLabel("Current Admin list ");
		lblCurrentAdminList.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCurrentAdminList.setBounds(931, 280, 251, 31);
		contentPane.add(lblCurrentAdminList);
		
		//set window
		try {
			File f5= new File("Admin\\admincount.txt");
			Scanner s2 = new Scanner(f5);
			int count= Integer.valueOf(s2.next());
			s2.close();
			adminCount.setText(Integer.toString(count));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(930, 315, 298, 341);
			contentPane.add(scrollPane_1);
			
			JTextArea adminlist = new JTextArea();
			adminlist.setText("Shipu");
			adminlist.setBackground(new Color(255, 250, 250));
			scrollPane_1.setViewportView(adminlist);
			adminlist.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 30));
			adminlist.setEditable(false);
			File f6= new File("Admin\\adminList.txt");
			Scanner s3= new Scanner(f6);
			String holder="";
			for(int i=0;i<count;i++) {
				if(i==0)holder+=s3.nextLine();
				else holder+="\n"+s3.nextLine();
			}
			adminlist.setText(holder);
			s3.close();
		} catch (FileNotFoundException e3) {
			JOptionPane.showMessageDialog(aproveAdmin.this, " Exception Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		File f= new File("Admin\\adminToBeApprove.txt");
		ArrayList<String> name= new ArrayList<>();
		ArrayList<String> id= new ArrayList<>();
		String hold="";
		try {
			Scanner s= new Scanner(f);
			while(s.hasNext()) {
				hold=s.nextLine();
				name.add(hold);
				hold=s.nextLine();
				id.add(hold);
			}
			s.close();
		} catch (FileNotFoundException e2) {
			JOptionPane.showMessageDialog(aproveAdmin.this, " Exception Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		flag fg= new flag();
		if(name.size()>0) {
			final int j=name.size()-1;
			if(fg.getI2()==0) {
				btnNext.setEnabled(true);
				btnPrevious.setEnabled(false);
			}
			if(fg.getI2()==j) {
				btnNext.setEnabled(false);
				btnPrevious.setEnabled(true);
			}
			if(fg.getI2()==j&&fg.getI2()==0) {
				btnNext.setEnabled(false);
				btnPrevious.setEnabled(false);
			}
			namef.setText(name.get(fg.getI2()));
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fg.inc();
					namef.setText(name.get(fg.getI2()));

					if(fg.getI2()==j) {
						btnNext.setEnabled(false);
						btnPrevious.setEnabled(true);
					}
					else {
						btnNext.setEnabled(true);
						btnPrevious.setEnabled(true);
					}
				}
			});

			btnPrevious.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fg.dec();
					namef.setText(name.get(fg.getI2()));

					if(fg.getI2()==0) {
						btnNext.setEnabled(true);
						btnPrevious.setEnabled(false);
					}
					else {
						btnNext.setEnabled(true);
						btnPrevious.setEnabled(true);
					}
				}
			});
		}
		else {
			btnCheckProfile.setEnabled(false);
			btnConfarmAdmin.setEnabled(false);
			btnDeleteRequest.setEnabled(false);
			btnPrevious.setEnabled(false);
			btnNext.setEnabled(false);
			sms.setEditable(false);
			sent.setEnabled(false);
			namef.setText(" No request to show.");
		}

		btnCheckProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile u= new UserProfile(id.get(fg.getI2()),1,1722231642);
				dispose();
				u.setVisible(true);				
			}
		});

		btnConfarmAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hold;
				allUser user= new allUser();
				hold="Users//"+id.get(fg.getI2())+"//"+id.get(fg.getI2())+".txt";
				File f2= new File(hold);
				if(f2.exists() && f2.canRead()){
					try {
						hold="";
						Scanner fs= new Scanner(f2);
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
						JOptionPane.showMessageDialog(aproveAdmin.this, " Exception Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
				} //end of if
				try {
					user.setAdmin(true);
					f2.delete();
					hold="Users//"+id.get(fg.getI2())+"//"+id.get(fg.getI2())+".txt";
					File fz= new File(hold);
					if(user.creatNewId(fz)) {
						JOptionPane.showMessageDialog(aproveAdmin.this, " Account seccessfully updated.\n Now "+name.get(fg.getI2())+
								" is one of admin","Success",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else {
						JOptionPane.showMessageDialog(aproveAdmin.this, " Problem in account updating!!!!","Success",JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(aproveAdmin.this, " Exception Problem in resorse updating!!!!","Error",JOptionPane.ERROR_MESSAGE);
					return;

				}finally {
					try {
						
						PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Admin\\adminList.txt", true)));
						out.println(name.get(fg.getI2()));
						out.flush();
						out.close();
						
						File f= new File("Admin\\adminToBeApprove.txt");
						name.remove(fg.getI2());
						id.remove(fg.getI2());
						f.delete();
						File f4 = new File("Admin\\adminToBeApprove.txt");
						f4.createNewFile();
						PrintWriter p1= new PrintWriter(f);                                
						for(int i=0;i<name.size();i++) {
							p1.println(name.get(i));
							p1.println(id.get(i));
						}
						p1.close();	
						File f5= new File("Admin\\admincount.txt");
						Scanner s= new Scanner(f5);
						int count= Integer.valueOf(s.next());
						++count;
						s.close();
						f5.delete();
						File f6= new File("Admin\\admincount.txt");
						PrintWriter p2= new PrintWriter(f6);                                
						p2.println(count);
						p2.close();						
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(aproveAdmin.this, " Exception Problem in resorse updating!!!!","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}finally {
						dispose();
						aproveAdmin a= new aproveAdmin(passedid,admin);
						a.setVisible(true);
					}
				}
			}//end of listener
		});
		
		btnDeleteRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File f= new File("Admin\\adminToBeApprove.txt");
					name.remove(fg.getI2());
					id.remove(fg.getI2());
					f.delete();
					File f4 = new File("Admin\\adminToBeApprove.txt");
					f4.createNewFile();
					PrintWriter p1= new PrintWriter(f);                                
					for(int i=0;i<name.size();i++) {
						p1.println(name.get(i));
						p1.println(id.get(i));
					}
					p1.close();	
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(aproveAdmin.this, " Exception Problem in resorse updating!!!!","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}finally {
					dispose();
					aproveAdmin a= new aproveAdmin(passedid,admin);
					a.setVisible(true);
				}
				
			}
		});

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
