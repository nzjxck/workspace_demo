package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.PLAIN, 16));
		setTitle("\u56FE\u4E66\u9986\u7BA1\u7406\u7CFB\u7EDF\uFF08\u7BA1\u7406\u5458\u754C\u9762\uFF09");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/tushuguanli+20.png")));
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("添加图书");
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/blue\u52A0+20.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookInterFrm addBookInterFrm=new AddBookInterFrm();
				addBookInterFrm.setVisible(true);
				table.add(addBookInterFrm);
			}
		});
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_3 = new JMenuItem("查询并修改图书");
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/chilun+20.png")));
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsAndDelBookInterFrm insAndDelBookInterFrm=new InsAndDelBookInterFrm();
				insAndDelBookInterFrm.setVisible(true);
				table.add(insAndDelBookInterFrm);
			}
		});
		menuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		mnNewMenu.add(menuItem_3);
		
		JMenu menu = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/tushuleibieguanli.png")));
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("图书类别添加");
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/blue\u52A0+20.png")));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm bookTypeAddInterFrm=new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("图书类别修改");
		menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/chilun+20.png")));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManageInterFrm bookTypeManageInterFrm=new BookTypeManageInterFrm();
				bookTypeManageInterFrm.setVisible(true);
				table.add(bookTypeManageInterFrm);
			}
		});
		menu.add(menuItem_2);
		
		JMenuItem menuItem_9 = new JMenuItem("      \u5B89\u5168\u9000\u51FA");
		menuItem_9.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit+20.png")));
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result =JOptionPane.showConfirmDialog(null, "确认是否退出系统？");
				if(result == 0){
					dispose();
				}
			}
		});
		menuItem_9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(menuItem_9);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		table.setBackground(Color.GRAY);
		contentPane.add(table, BorderLayout.CENTER);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon icon = new ImageIcon("D:\\workspace\\LibraryManager\\src\\images\\mainr.png");
		JLabel l = new JLabel(icon);
        l.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        table.add(l, new Integer(Integer.MIN_VALUE));	
	}
}
