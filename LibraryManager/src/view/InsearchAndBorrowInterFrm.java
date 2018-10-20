package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.BookManageDao;
import dao.BorrowDao;
import model.BookInfo;
import util.DbUtil;
import javax.swing.ImageIcon;

public class InsearchAndBorrowInterFrm extends JInternalFrame {
	
	private DbUtil dbutil=new DbUtil();
	private int selectedid;
	private BookManageDao bookManageDao=new BookManageDao();
	private JTextField BookNameSearch_text;
	private JTable BookInfoTable;
	private BorrowDao borrowDao=new BorrowDao();
	String bt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsearchAndBorrowInterFrm frame = new InsearchAndBorrowInterFrm();
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
	public InsearchAndBorrowInterFrm() {
		setTitle("\u67E5\u8BE2\u5E76\u501F\u9605");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 853, 688);
		
		JLabel label = new JLabel("图书名称或部分：");
		
		BookNameSearch_text = new JTextField();
		BookNameSearch_text.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnwButton = new JButton("查询");
		btnwButton.setIcon(new ImageIcon(InsearchAndBorrowInterFrm.class.getResource("/images/search+20.png")));
		btnwButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnwButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookInfoSearchActionPerformed(e);
			}
		});
		
		JButton button = new JButton("借阅");
		button.setIcon(new ImageIcon(InsearchAndBorrowInterFrm.class.getResource("/images/borrow+20.png")));
		button.setFont(new Font("宋体", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					Connection con=dbutil.getcon();
					String sql="select backtime from tb_borrow where PaperNo=? and ifback=0 order by backtime";
				   PreparedStatement ps=con.prepareStatement(sql);
				   ps.setString(1, LogOnFrm.currentreader.getPaperNO());
				   ResultSet rs=ps.executeQuery();
				   if(rs.next()) { bt=rs.getString("backtime");
				   Date date=new Date();
				   SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				   Date date1=df.parse(bt);
					   if(date1.after(date)) {
						   bookBorrowActionPerformed(selectedid);
				   }
				   else  
						JOptionPane.showMessageDialog(null, "帅哥我提醒你一句：请先把逾期图书归还之后再来借阅，谢谢~");
				   }
				   else{
					   bookBorrowActionPerformed(selectedid);
				   }
				   }
				
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(BookNameSearch_text, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(btnwButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap(77, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(BookNameSearch_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(button)
						.addComponent(btnwButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		
		BookInfoTable = new JTable();
		BookInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SelectBookMousePressed(e);
			}
		});
		BookInfoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66ID", "\u4E66\u540D", "\u7C7B\u522B", "\u4F5C\u8005\u540D", "\u53EF\u501F\u6570\u91CF"
			}
		));
		BookInfoTable.getColumnModel().getColumn(0).setPreferredWidth(93);
		BookInfoTable.getColumnModel().getColumn(3).setPreferredWidth(112);
		BookInfoTable.getColumnModel().getColumn(4).setPreferredWidth(118);
		scrollPane.setViewportView(BookInfoTable);
		getContentPane().setLayout(groupLayout);

	}
	/**
	 * 图书借阅
	 * @param selectedid2
	 * @throws Exception
	 */
	private void bookBorrowActionPerformed(int selectedid2) throws Exception {
		Connection con=null;
		try {
			con = dbutil.getcon();
			int currentreader = Integer.parseInt(LogOnFrm.currentreader.getPaperNO());
			if((BorrowDao.countID(con, currentreader)<3)){
				if((BorrowDao.countStorage(con, selectedid2)>0)){
					int resultInsert=borrowDao.borrowInsert(con, selectedid2);
					int resultUpdate=borrowDao.borrowUpdate(con, selectedid2);
					if(resultInsert+resultUpdate==2) {
						JOptionPane.showMessageDialog(null, "借阅成功");
						this.fillTable(new BookInfo());
					}else {
						JOptionPane.showMessageDialog(null, "借阅失败");
					}		
				}else {
					JOptionPane.showMessageDialog(null, "没有库存");
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "超出数量");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "借阅失败");
		}finally {
			dbutil.close(con);
		}
		
	}

	/**
	 * 借阅图书选择
	 * @param evt
	 * @return
	 */
	private void SelectBookMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row=BookInfoTable.getSelectedRow();
		selectedid=Integer.parseInt((String)BookInfoTable.getValueAt(row, 0));
	}
	
	/**
	 * 图书查询
	 * @param evt
	 */
	private void bookInfoSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_bookTypeName=this.BookNameSearch_text.getText();
		BookInfo bookInfo=new BookInfo();
		bookInfo.setBookname(s_bookTypeName);
		this.fillTable(bookInfo);
		
	}

	/**
	 * 表单填充
	 * @param bookinfo
	 */
	private void fillTable(BookInfo bookinfo) {
		DefaultTableModel dtm=(DefaultTableModel) BookInfoTable.getModel();
		dtm.setRowCount(0);//初始化
		Connection con=null;
		try {
			con=dbutil.getcon();
			ResultSet rs=bookManageDao.list(con, bookinfo);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("bookid"));
				v.add(rs.getString("typeid"));
				v.add(rs.getString("bookname"));
				v.add(rs.getString("author"));
				v.add(rs.getString("storage"));

				dtm.addRow(v);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbutil.close(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
