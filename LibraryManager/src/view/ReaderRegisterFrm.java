package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ReaderDao;
import model.Reader;
import util.DbUtil;
import util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ReaderRegisterFrm extends JFrame {

	private JPanel contentPane;
	private JTextField SecurityQuestionAnswer_text;
	private JTextField SecurityQuestion_text;
	private JTextField PaperNO_text;
	private JPasswordField Password_text;
	private JPasswordField PasswordConfirm_text;
	private DbUtil dbUtil=new DbUtil();
	private ReaderDao readerDao=new ReaderDao();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderRegisterFrm frame = new ReaderRegisterFrm();
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
	public ReaderRegisterFrm() {
		setTitle("\u7528\u6237\u6CE8\u518C\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 583, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("密保答案：");
		
		JButton button = new JButton("注册");
		button.setIcon(new ImageIcon(ReaderRegisterFrm.class.getResource("/images/register+20.png")));
		button.setFont(new Font("幼圆", Font.BOLD, 17));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("重置");
		button_1.setIcon(new ImageIcon(ReaderRegisterFrm.class.getResource("/images/reset+20.png")));
		button_1.setFont(new Font("幼圆", Font.BOLD, 17));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetActionPerformed(e);
			}
		});
		
		SecurityQuestionAnswer_text = new JTextField();
		SecurityQuestionAnswer_text.setColumns(10);
		
		SecurityQuestion_text = new JTextField();
		SecurityQuestion_text.setColumns(10);
		
		JLabel label_1 = new JLabel("密保问题：");
		
		JLabel label_2 = new JLabel("确认密码：");
		
		JLabel label_3 = new JLabel("学    号：");
		
		JLabel label_4 = new JLabel("密    码：");
		
		PaperNO_text = new JTextField();
		PaperNO_text.setColumns(10);
		
		Password_text = new JPasswordField();
		
		PasswordConfirm_text = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(75, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(PaperNO_text, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(Password_text, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(PasswordConfirm_text, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(SecurityQuestion_text, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(SecurityQuestionAnswer_text, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
					.addGap(50))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(198, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(PaperNO_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(Password_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(PasswordConfirm_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addComponent(label_1)
					.addGap(12)
					.addComponent(SecurityQuestion_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(label)
					.addGap(12)
					.addComponent(SecurityQuestionAnswer_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * 读者注册
	 * @param evt
	 */
	protected void RegisterActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String paperNO=this.PaperNO_text.getText();
		String password=new String(this.Password_text.getPassword());
		String passwordConfirm=new String(this.PasswordConfirm_text.getPassword());
		String SecurityQuestion=this.SecurityQuestion_text.getText();
		String SecurityQuestionAnswer=this.SecurityQuestionAnswer_text.getText();
		
		if(StringUtil.isEmpty(paperNO)){
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		if(StringUtil.isEmpty(passwordConfirm)){
			JOptionPane.showMessageDialog(null, "密码确认不能为空");
			return;
		}
		if(StringUtil.isEmpty(SecurityQuestion)){
			JOptionPane.showMessageDialog(null, "密保问题不能为空");
			return;
		}
		if(StringUtil.isEmpty(SecurityQuestionAnswer)){
			JOptionPane.showMessageDialog(null, "密保答案不能为空");
			return;
		}
		if(!password.equals(passwordConfirm)) {
			JOptionPane.showMessageDialog(null, "两次密码输入不一致");
			return;
		}
		Reader reader=new Reader(paperNO,password,SecurityQuestion,SecurityQuestionAnswer);
		Connection con=null;
		try{
			con=dbUtil.getcon();
			if(!(readerDao.checkpaperNO(con, Integer.parseInt(paperNO)))) {
				JOptionPane.showMessageDialog(null, "您已注册过或学号输入错误");
				return;
			}
			else {
				int register=readerDao.register(con, reader);
				if(register==1){
					JOptionPane.showMessageDialog(null, "注册成功！");
				}else{
					JOptionPane.showMessageDialog(null, "注册失败！");
				}
			}
		}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "注册失败！");
					e.printStackTrace();
				}finally{
					try {
						dbUtil.close(con);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

	/**
	 * 重置
	 * @param evt
	 */
	private void ResetActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.PaperNO_text.setText("");
		this.Password_text.setText("");
		this.PasswordConfirm_text.setText("");
		this.SecurityQuestion_text.setText("");
		this.SecurityQuestionAnswer_text.setText("");
	}
}
