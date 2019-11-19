package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class writePost extends JFrame {

	private JPanel contentPane;;
	private JTextField txtWriteYouePost;
	private JButton btnPost;
	private JScrollPane scrollPane;
	private JButton profile;
	private JButton logOut;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					writePost frame = new writePost("520",0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public writePost(String passedid, int admin) {
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
		txtWriteYouePost.setText("Write youe post here ...");
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
				//UserProfile n=new UserProfile(passedid,admin);
				dispose();
				//n.setVisible(true);
			}
		});
		profile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profile.setBounds(987, 10, 131, 36);
		contentPane.add(profile);
		
		logOut = new JButton("Log out");
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				//LogIn n= new LogIn();
				//n.setVisible(true);
			}
		});
		logOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		logOut.setBounds(1138, 10, 104, 31);
		contentPane.add(logOut);
	}

}
