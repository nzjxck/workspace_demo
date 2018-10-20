package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.TabSet;

import dao.ReaderDao;
import model.Reader;
import util.DbUtil;
import util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ForgetPasswordConfirmFrm extends JFrame {

	private JPanel contentPane;
	private JTextField PaperNO_text;
	private JTextField SecurityQuestion_text;
	private JTextField SecurityQuestionAnswer_text;
	private DbUtil dbUtil=new DbUtil();
	private StringUtil stringUtil=new StringUtil();
	private ReaderDao readerDao=new ReaderDao();
	public static Reader freader=null;

	private String InputedSecurityAnswer=null;
	private String CorrectAnswer=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPasswordConfirmFrm frame = new ForgetPasswordConfirmFrm();
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
	public ForgetPasswordConfirmFrm() {
		setTitle("忘记密码");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 583, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("学号：");
		
		PaperNO_text = new JTextField();
		PaperNO_text.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setIcon(new ImageIcon(ForgetPasswordConfirmFrm.class.getResource("/images/search+20.png")));
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaperNoCheckActionPerformed(e);
			}
		});
		
		JLabel label_1 = new JLabel("密保问题：");
		
		SecurityQuestion_text = new JTextField();
		SecurityQuestion_text.setEditable(false);
		SecurityQuestion_text.setColumns(10);
		
		JLabel label_2 = new JLabel("密保答案：");
		
		SecurityQuestionAnswer_text = new JTextField();
		SecurityQuestionAnswer_text.setColumns(10);
		
		JButton button = new JButton("确认");
		button.setIcon(new ImageIcon(ForgetPasswordConfirmFrm.class.getResource("/images/confirm+20.png")));
		button.setFont(new Font("幼圆", Font.BOLD, 17));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecurityQuestionAnswerCheckActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(66)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(label_2)
								.addComponent(label_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(PaperNO_text, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(SecurityQuestion_text)
								.addComponent(SecurityQuestionAnswer_text)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(338)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(PaperNO_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SecurityQuestion_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SecurityQuestionAnswer_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(button)
					.addContainerGap(206, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void SecurityQuestionAnswerCheckActionPerformed(ActionEvent e) {
		InputedSecurityAnswer=this.SecurityQuestionAnswer_text.getText();
		CorrectAnswer=freader.getSecurityquestionanswer();
		if(InputedSecurityAnswer.equals(CorrectAnswer)){
			new PasswordChangeFrm().setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "密保问题输入错误");
		}
	}

	protected void PaperNoCheckActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=null;
		String PaperNO=this.PaperNO_text.getText();
		int paperNO=Integer.parseInt(PaperNO);
		if(stringUtil.isNotEmpty(PaperNO)) {
			try {
				con=dbUtil.getcon();
				freader=readerDao.paperNOsearch(con, paperNO);
				if(freader!=null) {
					this.SecurityQuestion_text.setText(freader.getSecurityquestion());
				}else {
					JOptionPane.showMessageDialog(null, "学号不存在或者输入错误");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "失败");
			}finally {
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "不能输入学号为空");
		}

		//this.SecurityQuestion_text.setText(reader.getSecurityquestion());
	}
}
