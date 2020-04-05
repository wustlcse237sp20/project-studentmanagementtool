import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Point;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JTree;


import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
//keep behavior of the UI out of this class (put it in the controller)
public class StudentManagerUI {

	private JFrame frame;
//	private JTextField textField; //add these to use an element like text fields or buttons
	private StudentToolController controller;
	private JTextField txtCovidStudentManagement;
	private JTextField txtNewsFeed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagerUI window = new StudentManagerUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public StudentManagerUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		controller = new StudentToolController();
		frame.getContentPane().setLayout(null);
		
		//empty panel for header
		JPanel header = new JPanel();
		header.setBounds(0, 0, 800, 42);
		FlowLayout fl_header = (FlowLayout) header.getLayout();
		header.setForeground(new Color(255, 255, 255));
		header.setBackground(new Color(0, 102, 0));
		frame.getContentPane().add(header);
		
		//text for header
		txtCovidStudentManagement = new JTextField();
		txtCovidStudentManagement.setBorder(null);
		txtCovidStudentManagement.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(txtCovidStudentManagement);
		txtCovidStudentManagement.setForeground(new Color(255, 255, 255));
		txtCovidStudentManagement.setBackground(new Color(0, 102, 0));
		txtCovidStudentManagement.setText("COVID-19 Student Management Tool");
		txtCovidStudentManagement.setColumns(20);
		
		
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
        JList<String> list;
//		JList list = new JList();
        
        //create list for scrollable rss feed data
        list = new JList<>(listModel);
        list.setBackground(Color.LIGHT_GRAY);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        listScroller.setBounds(0, 152, 234, 306);
        listScroller.setBackground(new Color(0, 102, 51));
        listScroller.setForeground(Color.LIGHT_GRAY);
		frame.getContentPane().add(listScroller);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		listScroller.setColumnHeaderView(tabbedPane);
		
		//create header for rss news feed
		txtNewsFeed = new JTextField();
		txtNewsFeed.setBounds(0, 134, 234, 23);
		frame.getContentPane().add(txtNewsFeed);
		txtNewsFeed.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //remove border
		txtNewsFeed.setBackground(new Color(51, 102, 0));
		txtNewsFeed.setText("News Feed");
		txtNewsFeed.setForeground(Color.white);
		txtNewsFeed.setColumns(10);
		txtNewsFeed.setHorizontalAlignment(JTextField.CENTER);


		
	}
}
