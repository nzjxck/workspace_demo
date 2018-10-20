package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BookManageDao;
import dao.GiveBackDao;
import model.GiveBack;
import util.DbUtil;
import util.StringUtil;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class GiveBackInterFrm extends JInternalFrame {
	private JTable GiveBackTable;
	private  DbUtil dbutil=new DbUtil();
	private BookManageDao bookmanagedao=new BookManageDao();
	private String selectedid;
	private String selectedbookid;
	private GiveBackDao givebackdao=new GiveBackDao();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiveBackInterFrm frame = new GiveBackInterFrm();
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
	public GiveBackInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u5F52\u8FD8\u7CFB\u7EDF");
		setBounds(100, 100, 895, 705);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("\u56FE\u4E66\u5F52\u8FD8");
		btnNewButton.setIcon(new ImageIcon(GiveBackInterFrm.class.getResource("/images/giveback+20.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 831, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addGap(344))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addGap(96)
					.addComponent(btnNewButton)
					.addContainerGap(264, Short.MAX_VALUE))
		);
		
		GiveBackTable = new JTable();
		GiveBackTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GiveBackTableMousePressed(e);
			}
		});
		GiveBackTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BB0\u5F55ID", "\u501F\u9605\u56FE\u4E66ID", "\u56FE\u4E66\u540D\u79F0", "\u501F\u9605\u65E5\u671F", "\u5F52\u8FD8\u65E5\u671F"
			}
		));
		GiveBackTable.getColumnModel().getColumn(1).setPreferredWidth(106);
		GiveBackTable.getColumnModel().getColumn(2).setPreferredWidth(202);
		GiveBackTable.getColumnModel().getColumn(4).setPreferredWidth(197);
		scrollPane.setViewportView(GiveBackTable);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new GiveBack());

	}


	private void GiveBackTableMousePressed(MouseEvent e) {
		int row =GiveBackTable.getSelectedRow();
		selectedid=(String)GiveBackTable.getValueAt(row, 0);
		selectedbookid=(String)GiveBackTable.getValueAt(row, 1);
		
	}

	private void ReturnActionPerformed(ActionEvent evt) {
		if(StringUtil.isEmpty(selectedid)){
			JOptionPane.showMessageDialog(null, "请选择需要归还的图书");
			return;
		}
		int give=JOptionPane.showConfirmDialog(null, "确定要归还该图书？");
		if(give==0){
			Connection con=null;
			try{
				con=dbutil.getcon();
				int backnum1=givebackdao.giveback1(con, selectedid);
				int backnum2=givebackdao.giveback2(con, selectedbookid);
				if(backnum1+backnum2==2){
					JOptionPane.showMessageDialog(null, "归还成功！");
					this.fillTable(new GiveBack());
				}else{
					JOptionPane.showMessageDialog(null, "归还失败！");
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

	private void fillTable(GiveBack giveback){
		DefaultTableModel dtm=  (DefaultTableModel) GiveBackTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbutil.getcon();
			ResultSet rs=bookmanagedao.list(con, giveback);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("ID"));
				v.add(rs.getString("bookId"));
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
