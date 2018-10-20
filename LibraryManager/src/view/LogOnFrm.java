package view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import dao.ReaderDao;
import dao.Userdao;
import model.Reader;
import model.User;
import util.DbUtil;
import util.StringUtil;  

public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField usernametxt;
	private JPasswordField passwordtxt;
	private DbUtil dbutil=new DbUtil();
	private Userdao userdao=new Userdao();
	private ReaderDao readerdao=new ReaderDao();
	public static Reader currentreader;
	private JDesktopPane table=null;
	private URL url;
	private AudioClip ac;
	
	JRadioButton glyNewRadioButton = new JRadioButton("\u7BA1\u7406\u5458");
	
	JRadioButton xsNewRadioButton = new JRadioButton("\u5B66\u751F");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		playMusic();
		setBg();
		setTitle("\u56FE\u4E66\u9986\u767B\u5F55\u7CFB\u7EDF");
		setResizable(false);
		setBounds(100, 100, 646, 399);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u9986\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/book_books_64px_558952_easyicon.net.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("华文细黑", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/person_24px_1182112_easyicon.net.png")));
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setForeground(Color.white);
		label.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/key_lock_password_privacy_24px_1511_easyicon.net.png")));
		label.setFont(new Font("华文细黑", Font.BOLD, 15));
		
		usernametxt = new JTextField();
		usernametxt.setColumns(10);
		
		passwordtxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/logon+20.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/reset+20.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnNewButton_2 = new JButton("\u5B66\u751F\u8D26\u53F7\u6CE8\u518C");
		btnNewButton_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/register+20.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnNewButton_3 = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		btnNewButton_3.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/forget+20.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgetPasswordActionPerformed(e);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 13));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordtxt, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addComponent(usernametxt, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton_2)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(243, Short.MAX_VALUE)
							.addComponent(lblNewLabel)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(152)
					.addComponent(glyNewRadioButton)
					.addPreferredGap(ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
					.addComponent(xsNewRadioButton)
					.addGap(123))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(usernametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(passwordtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(glyNewRadioButton)
							.addGap(5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(xsNewRadioButton)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(42))
		);
		glyNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 17));
		xsNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 17));
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}

	protected void ForgetPasswordActionPerformed(ActionEvent e) {
		new ForgetPasswordConfirmFrm().setVisible(true);
	}

	protected void RegisterActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		new ReaderRegisterFrm().setVisible(true);
	}

	private  void loginActionPerformed(ActionEvent evt) {
		if(glyNewRadioButton.isSelected()&&xsNewRadioButton.isSelected()){
			JOptionPane.showMessageDialog(null, "不能以两种身份登录！");	
			return;
		}
		if(glyNewRadioButton.isSelected()){
		String username=this.usernametxt.getText();
		String password=new String(this.passwordtxt.getPassword());
		if(StringUtil.isEmpty(username)){
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		User user=new User(username,password);
		Connection con=null;
		try {
			con=dbutil.getcon();
			User currentuser=userdao.login(con, user);
			if(currentuser!=null){
				new MainFrm().setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "登陆失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		else if(xsNewRadioButton.isSelected()){
			String paperNO=usernametxt.getText();
			String password=new String(this.passwordtxt.getPassword());
			if(StringUtil.isEmpty(paperNO)){
				JOptionPane.showMessageDialog(null, "用户名不能为空！");
				return;
			}
			if(StringUtil.isEmpty(password)){
				JOptionPane.showMessageDialog(null, "密码不能为空！");
				return;
			}
			Reader reader=new Reader(paperNO,password);
			Connection con=null;
			try {
				con=dbutil.getcon();
				currentreader=readerdao.login(con, reader);
				if(currentreader!=null){
					new MainFrmR().setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "登陆失败");
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void resetValueActionPerformed(ActionEvent evt) {
	this.usernametxt.setText("");
	this.passwordtxt.setText("");
		
	}
	public void setBg(){   
		((JPanel)this.getContentPane()).setOpaque(false);   
		ImageIcon img = new ImageIcon  
		("D:\\workspace\\LibraryManager\\src\\images\\log.jpg");   
		JLabel background = new JLabel(img);  
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));   
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());   
		}  
	public void playMusic(){

		File f1 = new File("D:\\workspace\\LibraryManager\\src\\images\\陈一发儿+-+阿婆说.wav");
		   try {
		    url= f1.toURL();
		} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
		   ac= Applet.newAudioClip(url);
		   ac.loop();
	}
}
