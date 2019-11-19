import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Feed extends JFrame {
	private JPanel contentPane;
	private JLabel name1;
	private JTextField total;


	public Feed(String passedid, int admin, int sideid) {
		setTitle("Artful");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 1252, 689);
		contentPane.add(panel);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LogIn n= new LogIn();
				n.setVisible(true);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogOut.setBounds(1138, 13, 104, 33);
		panel.add(btnLogOut);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(124, 117, 767, 307);
		panel.add(scrollPane_1);

		JTextArea txt = new JTextArea();
		scrollPane_1.setViewportView(txt);
		txt.setEditable(false);
		txt.setFont(new Font("MS PGothic", Font.PLAIN, 29));

		JLabel timeLabel = new JLabel();
		timeLabel.setText("Time");
		timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		timeLabel.setBounds(521, 85, 200, 22);
		panel.add(timeLabel);

		JLabel reviewCount = new JLabel();
		reviewCount.setText("Total review:");
		reviewCount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		reviewCount.setBounds(932, 173, 145, 20);
		panel.add(reviewCount);

		JButton btnpPost = new JButton("Previous post");
		btnpPost.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnpPost.setBounds(932, 400, 156, 42);
		panel.add(btnpPost);

		JButton btnNextPost = new JButton("Next post");
		btnNextPost.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNextPost.setBounds(932, 348, 156, 42);
		panel.add(btnNextPost);

		JButton msg = new JButton("Check profile");
		msg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		msg.setBounds(746, 60, 145, 36);
		panel.add(msg);

		JLabel name1;
		name1 = new JLabel("");
		name1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		name1.setBounds(124, 39, 387, 68);
		panel.add(name1);

		JLabel lblAgree = new JLabel("Total agree:");
		lblAgree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgree.setBounds(932, 233, 125, 20);
		panel.add(lblAgree);

		JLabel lblDisagree = new JLabel("Total disagree:");
		lblDisagree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDisagree.setBounds(932, 203, 145, 20);
		panel.add(lblDisagree);

		JButton btnMyProfile = new JButton("My profile");
		btnMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile n=new UserProfile(passedid,0,0);
				dispose();
				n.setVisible(true);
			}
		});
		btnMyProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMyProfile.setBounds(997, 10, 131, 36);
		panel.add(btnMyProfile);
		
		JLabel label = new JLabel("Total posts:  ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(538, 24, 94, 20);
		panel.add(label);
		
		total = new JTextField();
		total.setText("0");
		total.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 16));
		total.setEditable(false);
		total.setColumns(10);
		total.setBackground(Color.WHITE);
		total.setBounds(631, 24, 96, 22);
		panel.add(total);

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
			JOptionPane.showMessageDialog(Feed.this, " Exception Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		total.setText(Integer.toString(name.size()));
		flag fg= new flag();
		if(name.size()>0) {
			final int j=name.size()-1;
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

			name1.setText(name.get(fg.getI2()));
			timeLabel.setText("at "+time.get(fg.getI2()));
			txt.setText(post.get(fg.getI2()));
			reviewCount.setText("Total review: 0");
			lblDisagree.setText("Total disagree: "+agCount.get(fg.getI2()));
			lblAgree.setText("Total agree: "+agCount.get(fg.getI2()));
			btnNextPost.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fg.inc();
					name1.setText(name.get(fg.getI2()));
					timeLabel.setText("at "+time.get(fg.getI2()));
					txt.setText(post.get(fg.getI2()));
					reviewCount.setText("Total review: 0");
					lblDisagree.setText("Total disagree: "+agCount.get(fg.getI2()));
					lblAgree.setText("Total agree: "+agCount.get(fg.getI2()));
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
					name1.setText(name.get(fg.getI2()));
					timeLabel.setText("at "+time.get(fg.getI2()));
					txt.setText(post.get(fg.getI2()));
					reviewCount.setText("Total review: 0");
					lblDisagree.setText("Total disagree: "+agCount.get(fg.getI2()));
					lblAgree.setText("Total agree: "+agCount.get(fg.getI2()));
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
		}
		else {
			btnpPost.setEnabled(false);
			btnNextPost.setEnabled(false);
			msg.setEnabled(false);
		}
		msg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile u= new UserProfile(id.get(fg.getI2()),2,Integer.valueOf(passedid));
				dispose();
				u.setVisible(true);
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
