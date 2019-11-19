import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ScrollPane;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JInternalFrame;
import java.awt.SystemColor;
import java.awt.event.AdjustmentListener;

import java.awt.Component;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import javax.swing.border.BevelBorder;

import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UserProfile extends JFrame {

	private JPanel contentPane;
	private JTextField pcount;
	private JTextField pencount;
	private JTextField rcount;
	private JTextField recount;

	public UserProfile(String passedid, int admin, int sideid) {
		setTitle("Artful");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LogIn n= new LogIn();
				n.setVisible(true);
			}
		});
		btnLogOut.setBounds(1138, 10, 104, 31);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnLogOut);

		JLabel lblTotalPosts = new JLabel("Total posts:  ");
		lblTotalPosts.setBounds(487, 10, 94, 20);
		lblTotalPosts.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblTotalPosts);

		pcount = new JTextField();
		pcount.setBackground(Color.WHITE);
		pcount.setEditable(false);
		pcount.setBounds(580, 10, 96, 22);
		pcount.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 16));
		contentPane.add(pcount);
		pcount.setColumns(10);

		JLabel lblTotalPending = new JLabel("Total Pending:");
		lblTotalPending.setBounds(466, 40, 104, 20);
		lblTotalPending.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblTotalPending);

		JLabel lblTotalReviewed = new JLabel("Total reviewed:");
		lblTotalReviewed.setBounds(459, 70, 113, 20);
		lblTotalReviewed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblTotalReviewed);

		pencount = new JTextField();
		pencount.setBackground(Color.WHITE);
		pencount.setEditable(false);
		pencount.setBounds(580, 40, 96, 22);
		pencount.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 16));
		pencount.setColumns(10);
		contentPane.add(pencount);

		rcount = new JTextField();
		rcount.setBackground(Color.WHITE);
		rcount.setEditable(false);
		rcount.setBounds(580, 69, 96, 22);
		rcount.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 16));
		rcount.setColumns(10);
		contentPane.add(rcount);


		String hold;
		allUser user= new allUser();
		hold="Users//"+passedid+"//"+passedid+".txt";
		File f2= new File(hold);
		if(f2.exists() && f2.canRead()){
			try {
				hold="";
				Scanner fs= new Scanner(f2);
				hold=fs.nextLine();
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
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(UserProfile.this, " Exception Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
		else {
			dispose();
			LogIn n= new LogIn();
			n.setVisible(true);
		}
		int postCount=0;
		cmntUser u[]= new cmntUser[50];
		if(Integer.parseInt(user.getPcount())>0) {
			hold="Users//"+passedid+"//"+passedid+"post.txt";		
			File f= new File(hold);           ///usrID+post
			if(f.exists()) {
				if (!(f.isFile() && f.canRead())) {
					JOptionPane.showMessageDialog(UserProfile.this, " Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {                                       ///////reading
					Scanner fin=new Scanner(f);
					int i=0; 
					String stop="";	
					hold="";
					while(fin.hasNext()) {
						u[i]=new cmntUser();
						hold=fin.nextLine();
						u[i].setTime(hold);
						hold=fin.nextLine();
						u[i].setaCount(Integer.parseInt(hold));
						hold=fin.nextLine();
						u[i].setdCount(Integer.parseInt(hold));
						stop=fin.nextLine();
						hold="";
						while((!(stop.equals("*cmnt")))&&(!(stop.equals("*nxtpost")))) {  
							hold+="\n"+stop;
							if(!(fin.hasNext()))break;
							stop=fin.nextLine();
							if(!(stop.equals("*nxtpost")))break;
						}
						u[i].setPost(hold);
						postCount++;
						int j=0;
						if(!(stop.equals("*nxtpost")))stop=fin.nextLine();
						if(!(fin.hasNext()))break;
						while((!(stop.equals("*nxtpost")))) {
							u[i].name[j]=stop;
							hold="";
							stop=fin.nextLine();
							while(!(stop.equals("*nxtcmnt"))&&!(stop.equals("*nxtpost"))) {
								hold+="\n\t"+stop;
								stop=fin.nextLine();
								if(!(fin.hasNext()))break;
							}
							u[i].cmnt[j]=hold;
							++j;
							if(stop.equals("*nxtpost")||!(fin.hasNext()))break;
							stop=fin.nextLine();
							hold="";
						}
						u[i].setReviewCount(j);
						++i;
					}

					fin.close();                //////endcmnt
				} catch (IOException e) {
					JOptionPane.showMessageDialog(UserProfile.this, " Exception Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch (java.lang.NullPointerException e2) {
					JOptionPane.showMessageDialog(UserProfile.this, " Exception Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}

			}
			else {
				JOptionPane.showMessageDialog(UserProfile.this, " Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		JButton nxtReview = new JButton("Next Review");
		nxtReview.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nxtReview.setBounds(2484, -89, 131, 42);
		contentPane.add(nxtReview);



		JButton btnpPost = new JButton("Previous post");
		btnpPost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnpPost.setBounds(870, 329, 131, 42);
		contentPane.add(btnpPost);

		JButton btnNextPost = new JButton("Next post");
		btnNextPost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNextPost.setBounds(983, 381, 131, 42);
		contentPane.add(btnNextPost);

		JLabel name = new JLabel("");
		name.setFont(new Font("MS Gothic", Font.PLAIN, 50));
		name.setBounds(73, 130, 454, 65);
		contentPane.add(name);

		JLabel lblTotalRejected = new JLabel("Total rejected:");
		lblTotalRejected.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalRejected.setBounds(466, 100, 106, 20);
		contentPane.add(lblTotalRejected);

		recount = new JTextField();
		recount.setBackground(Color.WHITE);
		recount.setEditable(false);
		recount.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 16));
		recount.setColumns(10);
		recount.setBounds(580, 101, 96, 22);
		contentPane.add(recount);

		JButton about = new JButton("About");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyBio m= new MyBio(passedid, admin, user,sideid);
				dispose();
				m.setVisible(true);
			}
		});
		about.setFont(new Font("Tahoma", Font.PLAIN, 18));
		about.setBounds(270, 7, 131, 36);
		contentPane.add(about);

		JLabel lblAgree = new JLabel("Total agree:");
		lblAgree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgree.setBounds(1811, -33, 125, 20);
		contentPane.add(lblAgree);

		JLabel lblDisagree = new JLabel("Total disagree:");
		lblDisagree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDisagree.setBounds(1791, -6, 145, 20);
		contentPane.add(lblDisagree);

		JButton btnSentRequsetFor = new JButton("Send request to be admin");
		btnSentRequsetFor.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnSentRequsetFor.setBounds(707, 10, 275, 50);
		contentPane.add(btnSentRequsetFor);
		
		JLabel tAgree = new JLabel("Total agree:");
		tAgree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tAgree.setBounds(805, 247, 165, 20);
		contentPane.add(tAgree);

		JLabel tDisagree = new JLabel("Total disagree:");
		tDisagree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tDisagree.setBounds(805, 277, 165, 20);
		contentPane.add(tDisagree);

		JLabel tReview = new JLabel();   
		tReview.setText("Total review:");
		tReview.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tReview.setBounds(805, 218, 145, 20);
		contentPane.add(tReview);

		JButton btnSeePosts = new JButton("Public post");
		btnSeePosts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Feed n= new Feed(passedid,admin,sideid);
				dispose();
				n.setVisible(true);
			}
		});
		btnSeePosts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSeePosts.setBounds(270, 90, 136, 29);
		contentPane.add(btnSeePosts);

		JButton btnWriteAPost = new JButton("Write a new post");
		btnWriteAPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				writePost w= new  writePost( passedid,admin,sideid,user.getName());
				w.setVisible(true);
			}
		});
		btnWriteAPost.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnWriteAPost.setBounds(270, 53, 186, 32);
		contentPane.add(btnWriteAPost);
		
		///set profile
		name.setText(user.getName());
		pcount.setText(user.getPcount());
		pencount.setText(user.getPecount());
		rcount.setText(user.getRcount());
		recount.setText(user.getRecount());
		
		if(admin==500&&user.isAdmin()&&sideid==0) {
			btnSentRequsetFor.setText(" Approve admins");
			btnSentRequsetFor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					aproveAdmin a = new aproveAdmin(passedid,admin);
					a.setVisible(true);
				}
			});
		}
		else if(user.isAdmin()&&admin==0&&sideid==0) {
			btnSentRequsetFor.setText(" Approve posts");
			btnSentRequsetFor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					aprovePost a = new aprovePost(passedid,admin,sideid);
					a.setVisible(true);
				}
			});
		}
		else if(admin==1&&sideid==1722231642) {
			btnSentRequsetFor.setEnabled(true);
			btnSentRequsetFor.setText("Back");
			btnWriteAPost.setEnabled(false);
			btnSeePosts.setEnabled(false);
			btnSentRequsetFor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					aproveAdmin a= new aproveAdmin("1722231642",500);
					a.setVisible(true);
				}
			});
		}
		else if(admin==1) {
			btnSentRequsetFor.setEnabled(true);
			btnSentRequsetFor.setText("Back");
			btnWriteAPost.setEnabled(false);
			btnSeePosts.setEnabled(false);
			btnSentRequsetFor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					aprovePost a= new aprovePost(Integer.toString(sideid),1,0);
					a.setVisible(true);
				}
			});
		}
		else if(admin==2) {
			btnSentRequsetFor.setEnabled(true);
			btnSentRequsetFor.setText("Back");
			btnWriteAPost.setEnabled(false);
			btnSeePosts.setEnabled(false);
			btnSentRequsetFor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Feed a= new Feed(Integer.toString(sideid),1,0);
					a.setVisible(true);
				}
			});
		}
		else {
			File f= new File("Admin\\adminToBeApprove.txt");
			hold="";
			boolean found=false;
			try {
				Scanner s= new Scanner(f);
				while(s.hasNext()) {
					hold=s.nextLine();
					if(hold.equals(user.getName())) {
						found=true;
						break;
					}
					hold=s.nextLine();
				}
				s.close();
			} catch (FileNotFoundException e2) {
				JOptionPane.showMessageDialog(UserProfile.this, " Exception Problem in resorse checking!!!!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(found) {
				btnSentRequsetFor.setText(" Admin request sent.");
				btnSentRequsetFor.setEnabled(false);	
			}
			else {
				btnSentRequsetFor.setText("Sent requset to be admin");
				btnSentRequsetFor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						final boolean b;
						if(f.canRead()) {
							try {
								PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Admin\\adminToBeApprove.txt", true)));
								out.println(user.getName());
								out.println(Integer.toString(user.getNid()));
								out.flush();
								out.close();
								b=true;

							} catch (IOException e1) {
								JOptionPane.showMessageDialog(UserProfile.this, " Exception Problem in resorse updating!!!!","Error",JOptionPane.ERROR_MESSAGE);
								return;
							}
							if(b) {
								btnSentRequsetFor.setText(" Admin request sent.");
								btnSentRequsetFor.setEnabled(false);
							}
						}							
					}
				});

			}
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 205, 682, 461);
		contentPane.add(scrollPane);

		JTextArea txt = new JTextArea();
		txt.setBackground(SystemColor.menu);
		scrollPane.setViewportView(txt);
		txt.setEditable(false);
		txt.setFont(new Font("MS UI Gothic", Font.PLAIN, 30));

		

		///
		if(postCount==0) {
			btnNextPost.setEnabled(false);
			btnpPost.setEnabled(false);
			txt.setText(" No post exists..");

		}
		flag fg= new flag();
		if(postCount>0) {
			final int j=postCount-1;
			if(fg.getI2()==0) {
				btnNextPost.setEnabled(true);
				btnpPost.setEnabled(false);
			}
			if(fg.getI2()==j) {
				btnNextPost.setEnabled(false);
				btnpPost.setEnabled(true);
			}
			if(fg.getI2()==j&&fg.getI2()==0) {
				btnNextPost.setEnabled(false);
				btnpPost.setEnabled(false);
			}
			printCmnt(u,fg.getI2() , txt, tReview, tAgree, tDisagree);
			btnNextPost.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fg.inc();
					printCmnt(u,fg.getI2() , txt, tReview, tAgree, tDisagree);


					if(fg.getI2()==j) {
						btnNextPost.setEnabled(false);
						btnpPost.setEnabled(true);
					}
					else {
						btnNextPost.setEnabled(true);
						btnpPost.setEnabled(true);
					}
				}
			});

			btnpPost.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fg.dec();
					printCmnt(u,fg.getI2() , txt, tReview, tAgree, tDisagree);


					if(fg.getI2()==0) {
						btnNextPost.setEnabled(true);
						btnpPost.setEnabled(false);
					}
					else {
						btnNextPost.setEnabled(true);
						btnpPost.setEnabled(true);
					}
				}
			});
		} ////end of if

	}
	void printCmnt(cmntUser u[], int i,JTextArea txt,JLabel tReview,JLabel tAgree,  JLabel tDisagree) {
		String big="";
		big+=" At "+u[i].getTime();
		big+=u[i].getPost();
		big+="\n#Reviewes: \n";
		for(int k=0;k<u[i].reviewCount;k++) {
			big+="\n\t"+u[i].name[k];
			big+="\t"+u[i].cmnt[k];
		}
		big+="\n\n";
		txt.setText(big);
		u[i].getReviewCount();
		tReview.setText(" Total review: "+Integer.toString(u[i].getReviewCount()));
		tAgree.setText(" Total agree : "+Integer.toString(u[i].getaCount()));
		tDisagree.setText(" Total disagree : "+Integer.toString(u[i].getdCount()));
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