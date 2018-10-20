 package view;

import java.awt.EventQueue;
import java.awt.Font;
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

import dao.BookManageDao;
import model.BookInfo;
import util.DbUtil;
import util.StringUtil;
import javax.swing.ImageIcon;

public class AddBookInterFrm extends JInternalFrame {
	private JTextField AddbooknameTxt;
	private JTextField AddtypeidTxt;
	private JTextField AddauthorTxt;
	private JTextField AddisbnTxt;
	private JTextField AddpriceTxt;
	private JTextField AddstorgeTxt;
	private DbUtil dbutil=new DbUtil();
	private BookManageDao addbookdao=new BookManageDao();
	private BookManageDao bookManageDao=new BookManageDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookInterFrm frame = new AddBookInterFrm();
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
	public AddBookInterFrm() {
		setTitle("\u6DFB\u52A0\u56FE\u4E66\u754C\u9762");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 546, 355);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u540D\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u7C7B\u578BID\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005\uFF1A");
		
		JLabel lblNewLabel_3 = new JLabel("ISBN:");
		
		JLabel lblNewLabel_4 = new JLabel("\u4EF7\u683C\uFF1A");
		
		JLabel lblNewLabel_5 = new JLabel("\u5E93\u5B58\u5BB9\u91CF\uFF1A");
		
		AddbooknameTxt = new JTextField();
		AddbooknameTxt.setColumns(10);
		
		AddtypeidTxt = new JTextField();
		AddtypeidTxt.setColumns(10);
		
		AddauthorTxt = new JTextField();
		AddauthorTxt.setColumns(10);
		
		AddisbnTxt = new JTextField();
		AddisbnTxt.setColumns(10);
		
		AddpriceTxt = new JTextField();
		AddpriceTxt.setColumns(10);
		
		AddstorgeTxt = new JTextField();
		AddstorgeTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setIcon(new ImageIcon(AddBookInterFrm.class.getResource("/images/blue\u52A0+20.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 15));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(AddBookInterFrm.class.getResource("/images/reset+20.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5))
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(AddbooknameTxt, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(AddtypeidTxt)
						.addComponent(AddauthorTxt)
						.addComponent(AddisbnTxt)
						.addComponent(AddpriceTxt)
						.addComponent(AddstorgeTxt))
					.addContainerGap(119, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(155)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(49))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(AddbooknameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(AddtypeidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(AddauthorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(AddisbnTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(AddpriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(AddstorgeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}

	private void AddActionPerformed(ActionEvent evt) throws Exception{
		BookManageDao adb=new BookManageDao();
		String bookname=this.AddbooknameTxt.getText();
		int typeid=Integer.parseInt(this.AddtypeidTxt.getText());
		String author=this.AddauthorTxt.getText();
		String isbn=this.AddisbnTxt.getText();
		float price= Float.parseFloat(this.AddpriceTxt.getText());
		int storage=Integer.parseInt(this.AddstorgeTxt.getText());
		if(StringUtil.isEmpty(bookname)){
			JOptionPane.showMessageDialog(null, "书名不能为空！");
		return;
		}if(StringUtil.isEmpty(isbn)){
			JOptionPane.showMessageDialog(null, "ISBN不能为空！");
			return;
		}
		BookInfo addbook=new BookInfo(bookname,typeid,author,isbn,price,storage);
		Connection con=null;
		con=dbutil.getcon();
		if(!(bookManageDao.checkISBN(con, isbn)&&bookManageDao.checkname(con, bookname))){
			JOptionPane.showMessageDialog(null, "ISBN或者书名已存在");
			return;
		}
		else {
			try {
				int a=adb.addbook(con, addbook);
				if(a==1){
					JOptionPane.showMessageDialog(null, "添加成功！");
				}else{
					JOptionPane.showMessageDialog(null, "添加失败！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					dbutil.close(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	private  void ResetValueActionPerformed(ActionEvent evt) {
		this.AddbooknameTxt.setText("");
		this.AddtypeidTxt.setText("");
		this.AddauthorTxt.setText("");
		this.AddisbnTxt.setText("");
		this.AddpriceTxt.setText("");
		this.AddstorgeTxt.setText("");
		
	}
}
