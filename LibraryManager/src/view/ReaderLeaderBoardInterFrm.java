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

import dao.GiveBackDao;
import model.BookInfo;
import model.GiveBack;
import util.DbUtil;

public class ReaderLeaderBoardInterFrm extends JInternalFrame {
	private JTable ReaderleaderTable;
	private GiveBackDao givebackdao=new GiveBackDao();
	private  DbUtil dbutil=new DbUtil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderLeaderBoardInterFrm frame = new ReaderLeaderBoardInterFrm();
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
	public ReaderLeaderBoardInterFrm() {
		setTitle("\u8BFB\u8005\u501F\u9605\u6392\u884C\u699C");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1047, 511);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(129)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 748, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(154, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(81, Short.MAX_VALUE))
		);
		
		ReaderleaderTable = new JTable();
		ReaderleaderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFB\u8005ID", "\u501F\u9605\u6570\u76EE"
			}
		));
		ReaderleaderTable.getColumnModel().getColumn(0).setPreferredWidth(153);
		ReaderleaderTable.getColumnModel().getColumn(1).setPreferredWidth(239);
		scrollPane.setViewportView(ReaderleaderTable);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new GiveBack());
	}
	private void fillTable(GiveBack giveback){
		DefaultTableModel dtm=  (DefaultTableModel) ReaderleaderTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbutil.getcon();
			ResultSet rs=givebackdao.readerleader(con, giveback);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("paperNO"));
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
