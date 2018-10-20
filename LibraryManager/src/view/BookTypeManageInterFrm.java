package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BookTypeDao;
import model.BookType;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class BookTypeManageInterFrm extends JInternalFrame {
	private JTable bookTypeTable;
	
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private JTextField S_BookTypeName_text;
	private JTextField BookTypeName_text;
	private JTextField BookTypeID_text;
	private JTextField ID_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
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
	public BookTypeManageInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("图书类别管理");
		setBounds(100, 100, 712, 734);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblid = new JLabel("图书类别名称：");
		
		S_BookTypeName_text = new JTextField();
		S_BookTypeName_text.setColumns(10);
		
		JButton button = new JButton("查询");
		button.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/search+20.png")));
		button.setFont(new Font("宋体", Font.BOLD, 17));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton button_1 = new JButton("修改");
		button_1.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/edit+20.png")));
		button_1.setFont(new Font("宋体", Font.BOLD, 17));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeUpdateActionEvent(e);
			}
		});
		
		JButton button_2 = new JButton("删除");
		button_2.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/delete+20.png")));
		button_2.setFont(new Font("宋体", Font.BOLD, 17));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteActionEvent(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(64, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblid)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(S_BookTypeName_text, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
					.addGap(55))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(54, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(94)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(159))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid)
						.addComponent(S_BookTypeName_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(62)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(button_1))
					.addContainerGap(139, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("编号：");
		
		JLabel lblid_1 = new JLabel("图书类别ID：");
		
		JLabel label = new JLabel("图书类别名称：");
		
		BookTypeName_text = new JTextField();
		BookTypeName_text.setColumns(10);
		
		BookTypeID_text = new JTextField();
		BookTypeID_text.setColumns(10);
		
		ID_text = new JTextField();
		ID_text.setEditable(false);
		ID_text.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(lblid_1)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(ID_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(BookTypeID_text)
							.addComponent(BookTypeName_text, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(ID_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid_1)
						.addComponent(BookTypeID_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(BookTypeName_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			BookTypeTableMousePressed(e);
			}
		});
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522BID", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(170);
		bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(184);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new BookType());
		

	}
	
	/**
	 * 删除事件
	 * @param e
	 */
	private void bookTypeDeleteActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=ID_text.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getcon();
				int deleteNum=bookTypeDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new BookType());
				}else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
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
	 * 修改事件
	 * @param e
	 */
	private void BookTypeUpdateActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String ID=ID_text.getText();
		String bookTypeID=BookTypeID_text.getText();
		String bookTypeName=BookTypeName_text.getText();
		if(StringUtil.isEmpty(ID)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		BookType bookType=new BookType(Integer.parseInt(ID), Integer.parseInt(bookTypeID), bookTypeName);
		Connection con=null;
		try {
			dbUtil.getcon();
			int modifyNum=bookTypeDao.update(con, bookType);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new BookType());
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 行点击事件
	 * @param e
	 */
	private void BookTypeTableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row=bookTypeTable.getSelectedRow();
		ID_text.setText((String)bookTypeTable.getValueAt(row, 0));
		BookTypeID_text.setText((String)bookTypeTable.getValueAt(row, 1));
		BookTypeName_text.setText((String)bookTypeTable.getValueAt(row, 2));
	}

	/**
	 * 图书类别搜索事件
	 * @param evt
	 */
	private void bookTypeSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_bookTypeName=this.S_BookTypeName_text.getText();
		BookType bookType=new BookType();
		//int ss_bookTypeID=Integer.parseInt(s_bookTypeID);
		bookType.setBooktypename(s_bookTypeName);
		this.fillTable(bookType);
		
	}

	private void fillTable(BookType bookType) {
		DefaultTableModel dtm=(DefaultTableModel) bookTypeTable.getModel();
		dtm.setRowCount(0);//初始化
		Connection con=null;
		try {
			con=dbUtil.getcon();
			ResultSet rs=bookTypeDao.list(con, bookType);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("booktypeid"));
				v.add(rs.getString("booktypename"));
				dtm.addRow(v);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.ID_text.setText("");
		this.BookTypeID_text.setText("");
		this.BookTypeName_text.setText("");
		
	}
}
