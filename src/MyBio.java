import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MyBio extends JFrame {

	private JPanel contentPane;
	public MyBio(String passedid, int admin, allUser u,int sideid) {
		setTitle("Artful");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel(u.getName());
		name.setFont(new Font("MS Gothic", Font.PLAIN, 35));
		name.setBounds(99, 74, 434, 97);
		contentPane.add(name);
		
		JLabel age = new JLabel("Email: "+u.getEmail());
		age.setFont(new Font("MS PGothic", Font.PLAIN, 28));
		age.setBounds(99, 219, 602, 50);
		contentPane.add(age);
		
		JLabel lblFathersName = new JLabel("Fathers name: "+u.getFname());
		lblFathersName.setFont(new Font("MS PGothic", Font.PLAIN, 28));
		lblFathersName.setBounds(99, 326, 602, 50);
		contentPane.add(lblFathersName);
		
		JLabel gender = new JLabel(u.getGender());
		gender.setFont(new Font("MS PGothic", Font.PLAIN, 28));
		gender.setBounds(629, 113, 218, 58);
		contentPane.add(gender);
		
		JLabel lblMothersName = new JLabel("Mothers name: "+u.getMname());
		lblMothersName.setFont(new Font("MS PGothic", Font.PLAIN, 28));
		lblMothersName.setBounds(99, 391, 602, 50);
		contentPane.add(lblMothersName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 482, 411, 129);
		contentPane.add(scrollPane);
		
		JTextArea address = new JTextArea(" "+u.getAddr());
		scrollPane.setViewportView(address);
		address.setFont(new Font("MS PGothic", Font.PLAIN, 28));
		
		JLabel lblAddres = new JLabel("Addres");
		lblAddres.setFont(new Font("MS PGothic", Font.PLAIN, 28));
		lblAddres.setBounds(173, 473, 82, 29);
		contentPane.add(lblAddres);
		
		JLabel lblAge = new JLabel("Age: "+u.getAge());
		lblAge.setFont(new Font("MS PGothic", Font.PLAIN, 28));
		lblAge.setBounds(99, 268, 602, 50);
		contentPane.add(lblAge);
		
		JButton button = new JButton("My profile");
		if(sideid==1722231642||sideid!=0||sideid!=2)button.setText("Profile");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile n=new UserProfile(passedid,admin,sideid);
				dispose();
				n.setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(1111, 10, 131, 36);
		contentPane.add(button);
		
		
	}

}
