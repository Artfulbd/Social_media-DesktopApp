import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.*;
import java.util.Scanner;
public class LogIn extends JFrame {
	int x=75,y=187;
	private JPanel contentPane;
	private JTextField id;
	private JTextField pass;

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D gd= (Graphics2D)g;
		gd.drawString("            To-Let",x,y);
		gd.drawString("           Add for sell",x,y+13);
		try { 
			Thread.sleep(65);
			y+=15;
		}catch(Exception e) {	
		}
		if(y>650) {
			x=75;
			y=187;
		}
		repaint();
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
					JPanel panel = new JPanel();
					panel.setBounds(62, 136, 530, 479);
					panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LogIn() {
		setTitle("Artful");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcomeToArtful = new JLabel("Welcome to Artful");
		lblWelcomeToArtful.setFont(new Font("Square721 BT", Font.BOLD, 50));
		lblWelcomeToArtful.setBounds(368, 49, 468, 61);
		contentPane.add(lblWelcomeToArtful);

		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 22));
		id.setBounds(831, 205, 354, 48);
		contentPane.add(id);
		id.setColumns(10);

		pass = new JTextField();
		pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nid= id.getText();
				nid="Users//"+nid+"//"+nid+".txt";
				File f= new File(nid);
				if(checkNid(id.getText())&&f.exists()) {   ///login
					if ( !f.canRead()) {
						JOptionPane.showMessageDialog(LogIn.this, " Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
					else {
						try {
							Scanner fin=new Scanner(f);
							String test=fin.nextLine();
							fin.close();
							if(test.equals(pass.getText())) {
								if(pass.getText().equals("super.12")&&id.getText().equals("1722231642")) {
									UserProfile n=new UserProfile(id.getText(),500,0);
									dispose();
									n.setVisible(true);
								}
								else {
									UserProfile n=new UserProfile(id.getText(),0,0);
									dispose();
									n.setVisible(true);
								}
							}
							else {
								pass.setText("");
								JOptionPane.showMessageDialog(LogIn.this, " Wrong password...\n Try again","",JOptionPane.ERROR_MESSAGE);
								return;
							}
						} catch (FileNotFoundException e1) {
							JOptionPane.showMessageDialog(LogIn.this, " Exception Problem!!!!","Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(LogIn.this, " Wrong user ID..!!","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}

			}


		});
		pass.setFont(new Font("Tahoma", Font.PLAIN, 22));
		pass.setColumns(10);
		pass.setBounds(831, 287, 354, 48);
		contentPane.add(pass);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(648, 205, 129, 41);
		contentPane.add(scrollPane);

		JLabel lblNidNo = new JLabel("NID No.");
		scrollPane.setViewportView(lblNidNo);
		lblNidNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNidNo.setToolTipText("Enter your NID number here ");
		lblNidNo.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(648, 287, 129, 41);
		contentPane.add(scrollPane_1);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setToolTipText("Enter your password here");
		scrollPane_1.setViewportView(lblPassword);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nid = id.getText();
				if(nid.equals(""))
				{
					JOptionPane.showMessageDialog(LogIn.this, " NID field can't be blank!!!!","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				nid="Users//"+nid+"//"+nid+".txt";
				File f= new File(nid);
				if(checkNid(id.getText())&&f.exists()) {   ///login
					if ( !f.canRead()) {
						JOptionPane.showMessageDialog(LogIn.this, " Problem in resorse reading!!!!","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
					else {
						try {
							Scanner fin=new Scanner(f);
							String test=fin.nextLine();
							fin.close();
							if(test.equals(pass.getText())) {
								if(pass.getText().equals("super.12")&&id.getText().equals("1722231642")) {
									UserProfile n=new UserProfile(id.getText(),500,0);
									dispose();
									n.setVisible(true);
								}
								else {
									UserProfile n=new UserProfile(id.getText(),0,0);
									dispose();
									n.setVisible(true);
								}

							}
							else {
								pass.setText("");
								JOptionPane.showMessageDialog(LogIn.this, " Wrong password...\n Try again","",JOptionPane.ERROR_MESSAGE);
								return;
							}
						} catch (FileNotFoundException e1) {
							JOptionPane.showMessageDialog(LogIn.this, " Exception Problem!!!!","Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(LogIn.this, " Wrong user ID..!!","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}

			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnLogin.setBounds(759, 390, 186, 41);
		contentPane.add(btnLogin);

		JLabel lblNoArtfulAccount = new JLabel("No artful account? ");
		lblNoArtfulAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNoArtfulAccount.setBounds(642, 501, 154, 22);
		contentPane.add(lblNoArtfulAccount);

		JLabel lblClickHeherTo = new JLabel("Click here to creat new account.");
		lblClickHeherTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignIn n= new SignIn();
				dispose();
				n.setVisible(true);
			}
		});
		lblClickHeherTo.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblClickHeherTo.setBounds(795, 501, 261, 22);
		contentPane.add(lblClickHeherTo);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(62, 136, 530, 488);
		contentPane.add(scrollPane_2);

		JPanel panel = new JPanel();
		scrollPane_2.setViewportView(panel);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		btnClose.setBounds(648, 638, 122, 41);
		contentPane.add(btnClose);


	}
	public void ms(String s) {
		id.setText(s);
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
