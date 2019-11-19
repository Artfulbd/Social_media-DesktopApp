import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class message extends JFrame {

	private JPanel checkProfile;
	private JTextField id;

	public message(String passedid, int admin, int sideid) {
		setTitle("Artful");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		checkProfile = new JPanel();
		checkProfile.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(checkProfile);
		checkProfile.setLayout(null);
		
		JLabel Message = new JLabel("Message");
		Message.setHorizontalAlignment(SwingConstants.CENTER);
		Message.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Message.setBounds(113, 204, 155, 44);
		checkProfile.add(Message);
		
		JButton send = new JButton("Send");
		send.setFont(new Font("Tahoma", Font.PLAIN, 18));
		send.setBounds(716, 566, 113, 44);
		checkProfile.add(send);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(278, 207, 545, 337);
		checkProfile.add(scrollPane);
		
		JTextArea text = new JTextArea();
		scrollPane.setViewportView(text);
		text.setFont(new Font("MS PGothic", Font.PLAIN, 30));
		
		JLabel lblFrom = new JLabel("From : ");
		lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFrom.setBounds(101, 84, 187, 44);
		checkProfile.add(lblFrom);
		
		id = new JTextField();
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setFont(new Font("MS Gothic", Font.PLAIN, 28));
		id.setBounds(295, 86, 507, 52);
		checkProfile.add(id);
		id.setColumns(10);
		
		JButton profile = new JButton("My profile");
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile n=new UserProfile(passedid,admin,sideid);
				dispose();
				n.setVisible(true);
			}
		});
		profile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profile.setBounds(987, 10, 131, 36);
		checkProfile.add(profile);
		
		JButton logout = new JButton("Log out");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LogIn n= new LogIn();
				n.setVisible(true);
			}
		});
		logout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		logout.setBounds(1138, 10, 104, 31);
		checkProfile.add(logout);
		
		JButton button_1 = new JButton("Check profile");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_1.setBounds(647, 148, 155, 31);
		checkProfile.add(button_1);
		
		JButton next = new JButton("Next ");
		next.setFont(new Font("Tahoma", Font.PLAIN, 19));
		next.setBounds(1006, 435, 131, 42);
		checkProfile.add(next);
		
		JButton previous = new JButton("Previous");
		previous.setFont(new Font("Tahoma", Font.PLAIN, 19));
		previous.setBounds(878, 383, 131, 42);
		checkProfile.add(previous);
	}

}
