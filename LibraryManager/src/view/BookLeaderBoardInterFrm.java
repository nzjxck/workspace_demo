package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BookManageDao;
import model.BookInfo;
import model.GiveBack;
import util.DbUtil;

public class BookLeaderBoardInterFrm extends JInternalFrame {
	private JTable BookLeaderBoardTable;
	private DbUtil dbutil=new DbUtil();
	private BookManageDao bookmanagedao=new BookManageDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookLeaderBoardInterFrm frame = new BookLeaderBoardInterFrm();
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
	public BookLeaderBoardInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u70ED\u5EA6\u6392\u884C\u5E2E");
		setBounds(100, 100, 919, 600);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(104)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 684, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(115, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(151, Short.MAX_VALUE))
		);
		
		BookLeaderBoardTable = new JTable();
		BookLeaderBoardTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u540D\u79F0", "\u501F\u9605\u6B21\u6570"
			}
		));
		BookLeaderBoardTable.getColumnModel().getColumn(0).setPreferredWidth(152);
		BookLeaderBoardTable.getColumnModel().getColumn(1).setPreferredWidth(187);
		scrollPane.setViewportView(BookLeaderBoardTable);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new BookInfo());
	}
	private void fillTable(BookInfo bookinfo){
		DefaultTableModel dtm=  (DefaultTableModel) BookLeaderBoardTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbutil.getcon();
			ResultSet rs=bookmanagedao.bookleader(con, bookinfo);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("bookname"));
				v.add(rs.getString(2));
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
