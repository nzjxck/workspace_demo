package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.BookTypeDao;
import model.BookType;
import util.DbUtil;
import util.StringUtil;
import java.awt.Font;
import javax.swing.ImageIcon;

public class BookTypeAddInterFrm extends JInternalFrame {
	private JTextField BookTypeName_text;
	private JTextField BookTypeID_text;
	
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
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
	public BookTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("图书类别添加");
		setBounds(100, 100, 699, 485);
		
		JLabel label = new JLabel("图书类别名称：");
		
		JLabel lblNewLabel = new JLabel("图书类别ID：");
		
		BookTypeName_text = new JTextField();
		BookTypeName_text.setColumns(10);
		
		BookTypeID_text = new JTextField();
		BookTypeID_text.setColumns(10);
		
		JButton button = new JButton("添加");
		button.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/blue\u52A0+20.png")));
		button.setFont(new Font("宋体", Font.BOLD, 17));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bookTypeAddActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton button_1 = new JButton("重置");
		button_1.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/reset+20.png")));
		button_1.setFont(new Font("宋体", Font.BOLD, 17));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetValueActionPerformed(e);
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(89)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(lblNewLabel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(123)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(BookTypeID_text, Alignment.LEADING, 292, 292, 292)
						.addComponent(BookTypeName_text, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(136, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(110)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(BookTypeName_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(116)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(BookTypeID_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addGap(36))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	/**
	 * 图书类别添加
	 * @param e
	 * @throws Exception 
	 */
	private void bookTypeAddActionPerformed(ActionEvent evt) throws Exception {
		// TODO Auto-generated method stub
		String bookTypeName=this.BookTypeName_text.getText();
		String S_bookTypeID=this.BookTypeID_text.getText();
		int bookTypeID=Integer.parseInt(S_bookTypeID);
		if(StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "不能为空");
		}
		else if(StringUtil.isEmpty(S_bookTypeID)) {
			JOptionPane.showMessageDialog(null, "不能为空");
		}
		BookType bookType=new BookType(bookTypeID,bookTypeName);
		Connection con=null;
		con=dbUtil.getcon();
		if(!(bookTypeDao.checkid(con, bookTypeID)&&bookTypeDao.checkname(con, bookTypeName))){
			JOptionPane.showMessageDialog(null, "类别ID或名称已存在");
			return;
		}
		else {
			try {
				int n=bookTypeDao.add(con, bookType);
				if(n==1) {
					JOptionPane.showMessageDialog(null, "图书类别添加成功");
					resetValue();
				}else {
					JOptionPane.showMessageDialog(null, "图书类别添加失败");
				}
			}catch(Exception e) {
				
			}finally {
				try {
					dbUtil.close(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
		

	/**
	 * 重置事件处理
	 * @param evt
	 */
	private void ResetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.BookTypeID_text.setText("");
		this.BookTypeName_text.setText("");
	}
}
