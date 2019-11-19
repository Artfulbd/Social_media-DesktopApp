import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class writePost extends JFrame {

	private JPanel contentPane;
	private JTextField txtWriteYouePost;
	private JButton btnPost;
	private JScrollPane scrollPane;
	private JButton profile;
	private JButton logOut;
	
	public writePost(String passedid, int admin, int sideid,String name) {
		setTitle("Artful");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 84, 813, 475);
		contentPane.add(scrollPane);
		
		JTextArea postBox = new JTextArea();
		postBox.setFont(new Font("MS UI Gothic", Font.PLAIN, 30));
		scrollPane.setViewportView(postBox);
		
		txtWriteYouePost = new JTextField();
		txtWriteYouePost.setEditable(false);
		txtWriteYouePost.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		txtWriteYouePost.setText("Write your post here ...");
		txtWriteYouePost.setBounds(102, 25, 411, 49);
		contentPane.add(txtWriteYouePost);
		txtWriteYouePost.setColumns(10);
		
		btnPost = new JButton("Post");
		btnPost.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPost.setBounds(786, 581, 131, 43);
		contentPane.add(btnPost);
		
		profile = new JButton("My profile");
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile n=new UserProfile(passedid,admin,sideid);
				dispose();
				n.setVisible(true);
			}
		});
		profile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profile.setBounds(987, 10, 131, 36);
		contentPane.add(profile);
		
		logOut = new JButton("Log out");
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
		File po= new File("Admin//postToBeApprove//"+passedid+".txt");
		
		if(po.exists()) {
			btnPost.setEnabled(false);
			JOptionPane.showMessageDialog(writePost.this, " Already your post is processing by admin panel."+
			                         "\n You can write a new post after they purport your previous post.\n\tThank you"," Sorry ..",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		else {
			btnPost.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnPost.setEnabled(false);
					boolean b=false;
					try {
						int count=0;
						File adm= new File("Admin\\admincount.txt");
						if(adm.canRead()) {
							Scanner s= new Scanner(adm);
							count=Integer.valueOf(s.next());
							s.close();
						}
						po.createNewFile();
						if(po.exists()) {
							PrintWriter p1= new PrintWriter(po);
							for(int i=0;i<count;i++) {
								p1.println(false);
							}
							p1.println("0");
							p1.println(postBox.getText());
							p1.close();
							b=true;
						}
					} catch (IOException ez) {
						JOptionPane.showMessageDialog(writePost.this, " Exception Problem in resorse creating!!!!","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(b) {
						int count=0;
						File pc= new File("Admin\\postToBeApprove\\postCount.txt");
						if(pc.canRead()) {
							try {
								Scanner s = new Scanner(pc);
								count=Integer.valueOf(s.next());
								s.close();
								++count;
								pc.delete();
								if(!pc.exists()) {
									File pc1= new File("Admin\\postToBeApprove\\postCount.txt");
									pc1.createNewFile();
									PrintWriter p1= new PrintWriter(pc1);
									p1.println(count);
									p1.close();
								}
								
								PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Admin\\postToBeApprove\\postedBy.txt", true)));
								out.println(name);
								out.println(passedid);
								out.println(postBox.getText());
								out.flush();
								out.close();	
								if(b)if(b)postBox.setText("");
								
							} catch (FileNotFoundException e1) {
								JOptionPane.showMessageDialog(writePost.this, " Exception Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
								return;
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(writePost.this, " Exception Problem in resorse creating!!!!","Error",JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							allUser user= new allUser();
							String hold="Users//"+passedid+"//"+passedid+".txt";
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
									JOptionPane.showMessageDialog(writePost.this, " Exception Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
								}
							} //end of if
							try {
								count=Integer.valueOf(user.getPecount());
								++count;
								user.setPecount(Integer.toString(count));
								f5.delete();
								hold="Users//"+passedid+"//"+passedid+".txt";
								File fz= new File(hold);
								if(user.creatNewId(fz)) {
									JOptionPane.showMessageDialog(writePost.this, " Account seccessfully updated.","Success",JOptionPane.INFORMATION_MESSAGE);
			
								}
								else {
									JOptionPane.showMessageDialog(writePost.this, " Problem in account updating!!!!","Error",JOptionPane.ERROR_MESSAGE);
								}
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(writePost.this, " Exception Problem in resorse updating!!!!","Error",JOptionPane.ERROR_MESSAGE);

							}
							
						}
						JOptionPane.showMessageDialog(writePost.this, " Your post is successfully sent to admin panel.\n"+
					             " If aproved. it will be considared as public post.","Confirmation",JOptionPane.INFORMATION_MESSAGE);
						return;	
					}
				}
			});
		}
	}
}
