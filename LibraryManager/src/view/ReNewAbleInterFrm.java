package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import model.BookInfo;
import model.GiveBack;
import util.DbUtil;
import util.StringUtil;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BookManageDao;
import dao.GiveBackDao;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class ReNewAbleInterFrm extends JInternalFrame {
	private JTable ReNewAbleTable;
	private  DbUtil dbutil=new DbUtil();
	private BookManageDao bookmanagedao=new BookManageDao();
	private String selectedid;
	private GiveBackDao givebackdao=new GiveBackDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReNewAbleInterFrm frame = new ReNewAbleInterFrm();
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
	public ReNewAbleInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u53EF\u7EED\u501F\u56FE\u4E66");
		setEnabled(false);
		setBounds(100, 100, 1041, 539);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("\u56FE\u4E66\u7EED\u501F");
		btnNewButton.setIcon(new ImageIcon(ReNewAbleInterFrm.class.getResource("/images/borrow+20.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReNewActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(408)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 815, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(118, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		ReNewAbleTable = new JTable();
		ReNewAbleTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row=ReNewAbleTable.getSelectedRow();
				selectedid=(String)ReNewAbleTable.getValueAt(row, 0);
			}
		});
		ReNewAbleTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BB0\u5F55ID", "\u56FE\u4E66\u540D\u79F0", "\u501F\u9605\u65E5\u671F", "\u5F52\u8FD8\u65E5\u671F"
			}
		));
		ReNewAbleTable.getColumnModel().getColumn(1).setPreferredWidth(137);
		ReNewAbleTable.getColumnModel().getColumn(2).setPreferredWidth(237);
		ReNewAbleTable.getColumnModel().getColumn(3).setPreferredWidth(180);
		scrollPane.setViewportView(ReNewAbleTable);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new BookInfo());

	}
	private void ReNewActionPerformed(ActionEvent evt) {
			if(StringUtil.isEmpty(selectedid)){
				JOptionPane.showMessageDialog(null, "请选择需要续借的图书");
				return;
			}
			int give=JOptionPane.showConfirmDialog(null, "确定要续借该图书？");
			if(give==0){
				Connection con=null;
				try{
					con=dbutil.getcon();
					int newnum=givebackdao.renew(con, selectedid);
					if(newnum==1){
						JOptionPane.showMessageDialog(null, "续借成功！");
						this.fillTable(new BookInfo());
					}else{
						JOptionPane.showMessageDialog(null, "续借失败！");
					}
				}catch (Exception e){
					e.printStackTrace();
				}finally{
					try {
						dbutil.close(con);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				}
			}
		}
	

	private void fillTable(BookInfo bookinfo){
		DefaultTableModel dtm=  (DefaultTableModel) ReNewAbleTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbutil.getcon();
			ResultSet rs=bookmanagedao.renewablebook(con, bookinfo);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("ID"));
				v.add(rs.getString("bookname"));
				v.add(rs.getString("borrowtime"));
				v.add(rs.getString("backtime"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				dbutil.close(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

