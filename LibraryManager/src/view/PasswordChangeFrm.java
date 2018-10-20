package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ReaderDao;
import model.Reader;
import util.DbUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PasswordChangeFrm extends JFrame {

	private JPanel contentPane;
	private JPasswordField NewPassword_text;
	private JPasswordField NewPasswordConfirm_text;
	private DbUtil dbUtil=new DbUtil();
	private ReaderDao readerDao=new ReaderDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordChangeFrm frame = new PasswordChangeFrm();
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
	public PasswordChangeFrm() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 581, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("请输入新密码：");
		
		JLabel label = new JLabel("请确认新密码：");
		
		NewPassword_text = new JPasswordField();
		
		NewPasswordConfirm_text = new JPasswordField();
		
		JButton button = new JButton("确认");
		button.setIcon(new ImageIcon(PasswordChangeFrm.class.getResource("/images/confirm+20.png")));
		button.setFont(new Font("幼圆", Font.BOLD, 17));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordChangeActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addGap(69)
							.addComponent(NewPasswordConfirm_text, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
							.addComponent(NewPassword_text, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addComponent(button, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
					.addGap(80))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(NewPassword_text, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(NewPasswordConfirm_text, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(93)
					.addComponent(button)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void PasswordChangeActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		Reader reader=ForgetPasswordConfirmFrm.freader;
		String newpassword=this.NewPassword_text.getText();
		String newpasswordconfirm=this.NewPasswordConfirm_text.getText();
		Connection con=null;
		if(newpassword.equals(newpasswordconfirm)) {
			try {
				con=dbUtil.getcon();
				int result=readerDao.PasswordChange(con, reader, newpassword);
				if(result==1) {
					JOptionPane.showMessageDialog(null,"修改成功");
				}else {
					JOptionPane.showMessageDialog(null,"修改失败");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null,"失败");
			}finally {
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else {
			JOptionPane.showMessageDialog(null,"两次密码输入不一致");
		}
	}

}
