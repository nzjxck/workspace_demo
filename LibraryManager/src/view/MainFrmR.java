package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainFrmR extends JFrame {

	private static final String JDesktopPane = null;
	private JPanel contentPane;
	private  JDesktopPane table=null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrmR frame = new MainFrmR();
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
	public MainFrmR() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("\u56FE\u4E66\u9986\u7BA1\u7406\u7CFB\u7EDF\uFF08\u7528\u6237\u754C\u9762\uFF09");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 618);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u67E5\u8BE2\u53CA\u501F\u9605");
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrmR.class.getResource("/images/borrow+20.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsearchAndBorrowInterFrm insearchAndBorrowInterFrm=new InsearchAndBorrowInterFrm();
				insearchAndBorrowInterFrm.setVisible(true);
				table.add(insearchAndBorrowInterFrm);
			}
		});
		
		JMenu menu = new JMenu("       \u6392\u884C\u699C       ");
		menu.setIcon(new ImageIcon(MainFrmR.class.getResource("/images/leaderboard.png")));
		menu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		menuBar.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u70ED\u5EA6\u6392\u884C\u699C");
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookLeaderBoardInterFrm bookLeaderBoardInterFrm =new BookLeaderBoardInterFrm();
				bookLeaderBoardInterFrm.setVisible(true);
				table.add(bookLeaderBoardInterFrm);
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u8BFB\u8005\u501F\u9605\u6392\u884C\u699C");
		menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderLeaderBoardInterFrm readerLeaderBoardInterFrm=new ReaderLeaderBoardInterFrm();
				readerLeaderBoardInterFrm.setVisible(true);
				table.add(readerLeaderBoardInterFrm);
			}
		});
		menu.add(menuItem_2);
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		
		menuBar.add(mntmNewMenuItem);

		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u5F52\u8FD8");
		menuItem.setIcon(new ImageIcon(MainFrmR.class.getResource("/images/giveback+20.png")));
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiveBackInterFrm giveBackInterFrm=new GiveBackInterFrm();
				giveBackInterFrm.setVisible(true);
				table.add(giveBackInterFrm);
			}
		});
		menuBar.add(menuItem);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u7EED\u501F");
		menuItem_3.setIcon(new ImageIcon(MainFrmR.class.getResource("/images/logon+20.png")));
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReNewAbleInterFrm reNewAbleInterFrm=new ReNewAbleInterFrm();
				reNewAbleInterFrm.setVisible(true);
				table.add(reNewAbleInterFrm);
			}
		});
		menuItem_3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		menuBar.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u7528\u6237\u987B\u77E5");
		menuItem_4.setIcon(new ImageIcon(MainFrmR.class.getResource("/images/attention+20.png")));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInstructionInterFrm userInstructionInterFrm=new UserInstructionInterFrm();
				userInstructionInterFrm.setVisible(true);
				table.add(userInstructionInterFrm);
			}
		});
		menuItem_4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		menuBar.add(menuItem_4);
		contentPane = new JPanel();
		contentPane.getMaximumSize();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		table = new JDesktopPane();
		//table.setOpaque(false);
		table.setBackground(Color.GRAY);
		contentPane.add(table, BorderLayout.CENTER);
		
		ImageIcon icon = new ImageIcon("D:\\workspace\\LibraryManager\\src\\images\\main.jpg");
		JLabel l = new JLabel(icon);
        l.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        table.add(l, new Integer(Integer.MIN_VALUE));	
	}

}