import java.io.*;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField textnid;
	private JTextField textage;
	private JTextField textfn;
	private JTextField textnm;
	private JTextField textemail;
	private JTextField pass;
	private JTextField rpass;
	private JTextArea textaddr;
	public SignIn() {
		setTitle("Artful");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton male = new JRadioButton("Male");
		male.setSelected(true);
		JRadioButton female = new JRadioButton("Female");
		JRadioButton other = new JRadioButton("Other");
		ButtonGroup bg= new ButtonGroup();
		bg.add(male);
		bg.add(female);
		bg.add(other);

		txtname = new JTextField();
		txtname.setFont(new Font("Century751 SeBd BT", Font.PLAIN, 26));
		txtname.setBounds(180, 61, 342, 42);
		contentPane.add(txtname);
		txtname.setColumns(10);

		textnid = new JTextField();
		textnid.setFont(new Font("Century751 SeBd BT", Font.PLAIN, 26));
		textnid.setColumns(10);
		textnid.setBounds(180, 165, 342, 42);
		contentPane.add(textnid);

		textemail = new JTextField();
		textemail.setFont(new Font("Century751 SeBd BT", Font.PLAIN, 26));
		textemail.setColumns(10);
		textemail.setBounds(180, 113, 342, 42);
		contentPane.add(textemail);

		pass = new JTextField();
		pass.setFont(new Font("Century751 SeBd BT", Font.PLAIN, 20));
		pass.setBounds(245, 236, 304, 42);
		contentPane.add(pass);
		pass.setColumns(10);

		rpass = new JTextField();
		rpass.setFont(new Font("Century751 SeBd BT", Font.PLAIN, 20));
		rpass.setColumns(10);
		rpass.setBounds(246, 292, 304, 42);
		contentPane.add(rpass);

		textage = new JTextField();
		textage.setFont(new Font("Century751 SeBd BT", Font.PLAIN, 26));
		textage.setColumns(10);
		textage.setBounds(218, 412, 342, 42);
		contentPane.add(textage);

		textfn = new JTextField();
		textfn.setFont(new Font("Century751 SeBd BT", Font.PLAIN, 26));
		textfn.setColumns(10);
		textfn.setBounds(218, 464, 342, 42);
		contentPane.add(textfn);

		textnm = new JTextField();
		textnm.setFont(new Font("Century751 SeBd BT", Font.PLAIN, 26));
		textnm.setColumns(10);
		textnm.setBounds(218, 528, 342, 42);
		contentPane.add(textnm);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(641, 108, 601, 414);
		contentPane.add(scrollPane_1);
		
		String store;
		
		try {
			File f= new File("Admin\\agree.txt");
			Scanner s= new Scanner(f);
			store=" "+s.nextLine();
			while(s.hasNext()) {
				store+="\n "+s.nextLine();
			}
			s.close();
		} catch (FileNotFoundException e1) {
			store= " Error in reading data";
		}
		
		JTextArea txtrTest = new JTextArea(store);
		scrollPane_1.setViewportView(txtrTest);
		txtrTest.setEditable(false);
		txtrTest.setFont(new Font("Monospac821 BT", Font.PLAIN, 23));
		JButton btnCreat = new JButton("Create");
		btnCreat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkNid(textnid.getText())) {
					if(txtname.getText().equals("")) {
						JOptionPane.showMessageDialog(SignIn.this, " Name field cannot be blank","Invalid Inpute",JOptionPane.ERROR_MESSAGE);
						return;
					}
					else{
						if(checkNid(txtname.getText())){
							JOptionPane.showMessageDialog(SignIn.this, "Someone's name cannot be "+txtname.getText(),"Invalid Inpute",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					if(textemail.getText().equals("")) {
						JOptionPane.showMessageDialog(SignIn.this, " Email field cannot be blank","Invalid Inpute",JOptionPane.ERROR_MESSAGE);
						return;
					}
					else{
						if(checkNid(textemail.getText())){
							JOptionPane.showMessageDialog(SignIn.this, " Email cannot be "+textemail.getText(),"Invalid Inpute",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					if(!checkPass(pass.getText())) {
						JOptionPane.showMessageDialog(SignIn.this, " Password condition failed..\n Inpute new one.","Invalid Inpute",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(!pass.getText().equals(rpass.getText())) {
						JOptionPane.showMessageDialog(SignIn.this, " Both password is not same..!!","Invalid Inpute",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(textage.getText().equals("")) {
						JOptionPane.showMessageDialog(SignIn.this, " Age field cannot be blank","Invalid Inpute",JOptionPane.ERROR_MESSAGE);
						return;
					}
					else{
						if(!checkNid(textage.getText())){
							JOptionPane.showMessageDialog(SignIn.this, " Age field cannot be "+textage.getText(),"Invalid Inpute",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					if(textfn.getText().equals("")) {
						JOptionPane.showMessageDialog(SignIn.this, "Father's name field cannot be blank","Invalid Inpute",JOptionPane.ERROR_MESSAGE);
						return;
					}
					else{
						if(checkNid(textfn.getText())){
							JOptionPane.showMessageDialog(SignIn.this, " Father's name cannot be "+textfn.getText(),"Invalid Inpute",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					if(textnm.getText().equals("")) {
						JOptionPane.showMessageDialog(SignIn.this, " Mother's nam field cannot be blank","Invalid Inpute",JOptionPane.ERROR_MESSAGE);
						return;
					}
					else{
						if(checkNid(textnm.getText())){
							JOptionPane.showMessageDialog(SignIn.this, " Mother's nam cannot be "+textnm.getText(),"Invalid Inpute",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					if(textaddr.getText().equals("")) {
						JOptionPane.showMessageDialog(SignIn.this, " Address field cannot be blank","Invalid Inpute",JOptionPane.ERROR_MESSAGE);
						return;
					}
					else{
						if(checkNid(textaddr.getText())){
							JOptionPane.showMessageDialog(SignIn.this, " Address cannot be "+textaddr.getText(),"Invalid Inpute",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					String nid= textnid.getText();
					nid="Users//"+nid+"//"+nid+".txt";
					try {
						File f= new File(nid);
						if(f.exists()) {
							JOptionPane.showMessageDialog(SignIn.this, " This person already exist..!!","Ohh",JOptionPane.ERROR_MESSAGE);
							return;
						}
						else {
							allUser u= new allUser();
							u.setPass(pass.getText());
							u.setName(txtname.getText());
							u.setNid(Integer.decode(textnid.getText()));
							u.setEmail(textemail.getText());
							if(male.isSelected())u.setGender("Male");
							if(female.isSelected())u.setGender("Female");
							if(other.isSelected())u.setGender("Other");
							u.setAge(textage.getText());
							u.setFname(textfn.getText());
							u.setMname(textnm.getText());
							u.setAddr(textaddr.getText());	
							if(u.creatNewId(f)) {
								JOptionPane.showMessageDialog(SignIn.this, " Account seccessfully created.","Success",JOptionPane.INFORMATION_MESSAGE);
								return;
							}
							else {
								JOptionPane.showMessageDialog(SignIn.this, " Problem in account creating!!!!","Success",JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
					}catch(IOException exp) {
						JOptionPane.showMessageDialog(SignIn.this, " Problem in resorse creating!!!!","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}finally {
						dispose();
						LogIn n= new LogIn();
						n.setVisible(true);
					}

				}
				else {
					JOptionPane.showMessageDialog(SignIn.this, " NID cannot be :"+textnid.getText(),"Invalid Inpute",JOptionPane.ERROR_MESSAGE);
					return;
				}

			}
		});
		btnCreat.setFont(new Font("Times New Roman", Font.BOLD, 32));
		btnCreat.setBounds(854, 614, 202, 54);
		contentPane.add(btnCreat);
		
		
		JRadioButton disagree = new JRadioButton("Disagree");
		JRadioButton agree = new JRadioButton("Agree");
		disagree.setSelected(true);
		ButtonGroup bg2= new ButtonGroup();
		bg2.add(disagree);
		bg2.add(agree);
		if(disagree.isSelected())btnCreat.setEnabled(false);
		

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LogIn n= new LogIn();
				n.setVisible(true);
			}
		});
		btnBack.setToolTipText("Click here to go to main menu.");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 32));
		btnBack.setBounds(1040, 22, 202, 54);
		contentPane.add(btnBack);

		JLabel name1 = new JLabel("Name");
		name1.setBounds(65, 67, 105, 31);
		contentPane.add(name1);
		name1.setHorizontalAlignment(SwingConstants.CENTER);
		name1.setFont(new Font("Tahoma", Font.PLAIN, 23));

		JLabel nid1 = new JLabel("NID");
		nid1.setBounds(65, 171, 95, 31);
		contentPane.add(nid1);
		nid1.setHorizontalAlignment(SwingConstants.CENTER);
		nid1.setFont(new Font("Tahoma", Font.PLAIN, 23));

		JLabel email1 = new JLabel("Email");
		email1.setBounds(65, 120, 105, 29);
		contentPane.add(email1);
		email1.setHorizontalAlignment(SwingConstants.CENTER);
		email1.setFont(new Font("Tahoma", Font.PLAIN, 23));

		JLabel age1 = new JLabel("Age");
		age1.setBounds(142, 419, 66, 29);
		contentPane.add(age1);
		age1.setHorizontalAlignment(SwingConstants.RIGHT);
		age1.setFont(new Font("Tahoma", Font.PLAIN, 23));

		JLabel fn1 = new JLabel("Father's name");
		fn1.setBounds(62, 471, 157, 29);
		contentPane.add(fn1);
		fn1.setHorizontalAlignment(SwingConstants.CENTER);
		fn1.setFont(new Font("Tahoma", Font.PLAIN, 23));

		JLabel mn1 = new JLabel("Mother's name");
		mn1.setBounds(62, 531, 157, 37);
		contentPane.add(mn1);
		mn1.setHorizontalAlignment(SwingConstants.CENTER);
		mn1.setFont(new Font("Tahoma", Font.PLAIN, 23));

		JLabel addr1 = new JLabel("Address");
		addr1.setBounds(97, 586, 111, 31);
		contentPane.add(addr1);
		addr1.setHorizontalAlignment(SwingConstants.RIGHT);
		addr1.setFont(new Font("Tahoma", Font.PLAIN, 23));


		male.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		male.setFont(new Font("Tahoma", Font.PLAIN, 23));
		male.setBounds(213, 372, 83, 21);
		contentPane.add(male);

		female.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		female.setFont(new Font("Tahoma", Font.PLAIN, 23));
		female.setBounds(337, 372, 103, 21);
		contentPane.add(female);

		other.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		other.setFont(new Font("Tahoma", Font.PLAIN, 23));
		other.setBounds(457, 372, 103, 21);
		contentPane.add(other);

		JLabel pass1 = new JLabel("Password");
		pass1.setHorizontalAlignment(SwingConstants.CENTER);
		pass1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		pass1.setBounds(117, 237, 97, 28);
		contentPane.add(pass1);

		JLabel rpass1 = new JLabel("Confirm password");
		rpass1.setHorizontalAlignment(SwingConstants.CENTER);
		rpass1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		rpass1.setBounds(44, 292, 192, 28);
		contentPane.add(rpass1);

		JLabel lblWelcome = new JLabel("Welcome ");
		lblWelcome.setBounds(542, 22, 163, 40);
		contentPane.add(lblWelcome);
		lblWelcome.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblAtleastCharacterincluding = new JLabel("Atleast 7 character,including number and symbols(except SPACE)");
		lblAtleastCharacterincluding.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAtleastCharacterincluding.setBounds(245, 279, 342, 13);
		contentPane.add(lblAtleastCharacterincluding);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(218, 586, 342, 82);
		contentPane.add(scrollPane);

		textaddr =  new JTextArea();
		scrollPane.setViewportView(textaddr);
		textaddr.setFont(new Font("Century751 SeBd BT", Font.PLAIN, 21));
		textaddr.setColumns(10);
		
		
		disagree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCreat.setEnabled(false);
			}
		});
		disagree.setFont(new Font("Tahoma", Font.PLAIN, 20));
		disagree.setBounds(641, 544, 103, 21);
		contentPane.add(disagree);
		
		
		agree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCreat.setEnabled(true);
			}
		});
		agree.setFont(new Font("Tahoma", Font.PLAIN, 20));
		agree.setBounds(641, 586, 103, 21);
		contentPane.add(agree);
		
	}
	public boolean checkPass(String p) {
		int ch=0,num=0,sy=0;
		int i=0,s;
		do {
			try {
				s=p.charAt(i);
				if(s>47&&s<58)num++;
				if((s>64&&s<91)||(s>96&&s<123))ch++;
				if((s>32&&s<48)||(s>57&&s<64)||(s>90&&s<97)||(s>122&&s<127))sy++;
				i++;
			}catch(java.lang.StringIndexOutOfBoundsException a) {
				break;
			}
		}while(true);
		return ((num>0)&&(ch>0)&&(sy>0))? true:false;

	}
	public boolean checkNid(String nid) {
		boolean b=false;
		int i=0,s;
		do {
			try {
				s=nid.charAt(i);
				if(s>47&&s<58)b=true;
				else b=false;
			}catch(java.lang.StringIndexOutOfBoundsException a) {
				break;
			}
			i++;
		}while(b);

		return b;	
	}
}
