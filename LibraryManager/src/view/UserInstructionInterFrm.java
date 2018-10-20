package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;

public class UserInstructionInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInstructionInterFrm frame = new UserInstructionInterFrm();
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
	public UserInstructionInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("用户须知");
		setBounds(100, 100, 585, 556);
		
		JLabel label = new JLabel("图书借阅须知：");
		label.setFont(new Font("幼圆", Font.BOLD, 17));
		
		JLabel label_1 = new JLabel("用户最多只可同时借阅三本图书");
		
		JLabel label_2 = new JLabel("归还截至时间为借阅时间的一个月后");
		
		JLabel label_3 = new JLabel("关于我们：");
		label_3.setFont(new Font("幼圆", Font.BOLD, 17));
		label_3.setForeground(Color.BLACK);
		
		JLabel label_4 = new JLabel("管理员联系电话：");
		
		JLabel label_5 = new JLabel("4008-517-517");
		
		JLabel label_6 = new JLabel("成员：");
		
		JLabel label_7 = new JLabel("16110107 张  佑");
		
		JLabel lblxx = new JLabel("16110131 \u8303\u8D77\u5982");
		
		JLabel label_9 = new JLabel("16110218 孟祥俊");
		
		JLabel label_8 = new JLabel("如发现图书，图书类别错误，请致电管理员");
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7EED\u501F\u529F\u80FD\u53EA\u663E\u793A\u8DDD\u79BB\u5F52\u8FD8\u65E5\u671F3\u65E5\u4EE5\u5185\u7684\u56FE\u4E66\uFF0C\u8BF7\u8BFB\u8005\u6089\u77E5~");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_4)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_6)
									.addGap(102)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
										.addComponent(label_5)
										.addComponent(label_9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblxx, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addContainerGap(387, Short.MAX_VALUE))))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(115)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(label_8)
						.addComponent(label_2)
						.addComponent(label_1))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(label)
					.addGap(18)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_8)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(27)
					.addComponent(label_3)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_7)
								.addComponent(label_6)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4)
								.addComponent(label_5))))
					.addGap(18)
					.addComponent(label_9)
					.addGap(18)
					.addComponent(lblxx)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
