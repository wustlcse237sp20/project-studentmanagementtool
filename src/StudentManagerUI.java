import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.*;
import javax.swing.JTextField;
import java.awt.Desktop;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.lang.reflect.*;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;


//keep behavior of the UI out of this class (put it in the controller)

public class StudentManagerUI implements ActionListener{

	private JFrame frame;
	private StudentToolController toolController;
	private JTextField txtCovidStudentManagement;
	private JTextField txtNewsFeed;
	
	//GPA Calc things
	private JPanel GPAPanel;
	private JButton GPAbutton;
	private JTextField numCourses;
	private JLabel coursesLabel;
	private JLabel finalGPA;
	
	//Activity Tracker things
	private JPanel ActivityPanel;
	private JPanel ActivityDisplayPanel;
	private JButton ActivityButton;
	private JTextField numActivities;
	private JLabel activitiesLabel;
	private Checkbox checkbox;

	//RSS feed things
	private JButton runGpaButton;
	private JTabbedPane tabbedPane;
	private JList<String> rssFeed1;
	private JList<String> rssFeed2;
	private JTextField covidStatsHeaderText;
	private JTable covidStatsTable;
	private DefaultListModel<String> rssContainer2;



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

		toolController = new StudentToolController();
		frame.getContentPane().setLayout(null);

		//empty panel for header
		JPanel header = new JPanel();
		header.setBounds(0, 0, 800, 42);
		FlowLayout fl_header = (FlowLayout) header.getLayout();
		header.setForeground(new Color(255, 255, 255));
		header.setBackground(new Color(0, 102, 0));
		frame.getContentPane().add(header);

		//text for window header
		txtCovidStudentManagement = new JTextField();
		txtCovidStudentManagement.setBorder(null);
		txtCovidStudentManagement.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(txtCovidStudentManagement);
		txtCovidStudentManagement.setForeground(new Color(255, 255, 255));
		txtCovidStudentManagement.setBackground(new Color(51, 102, 0));
		txtCovidStudentManagement.setText("COVID-19 Student Management Tool");
		txtCovidStudentManagement.setColumns(20);

		
		//test elements for the jlist 
		DefaultListModel<String> rssContainer1 = toolController.getHeadlinesFeed1();

		
		//test elements for the jlist 

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setAutoscrolls(true);
		tabbedPane.setBounds(0, 157, 234, 301);
		frame.getContentPane().add(tabbedPane);
		tabbedPane.addTab("NPR News", generateNewsFeed(1));
		tabbedPane.addTab("BBC News", generateNewsFeed(2));
		
		//refresh button to get updated news feeds    

		JButton refreshNewsButton = new JButton();
		Image icon = new ImageIcon(this.getClass().getResource("refreshIcon.png")).getImage();
		Image sizedIcon = icon.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		refreshNewsButton.setIcon(new ImageIcon(sizedIcon));
		refreshNewsButton.setBounds(174, 134, 44, 23);
		frame.getContentPane().add(refreshNewsButton);
		refreshNewsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				refreshFeeds();
			}
		});

		//CREATE RSS FEED
		txtNewsFeed = new JTextField();
		txtNewsFeed.setBounds(0, 134, 234, 23);
		frame.getContentPane().add(txtNewsFeed);
		txtNewsFeed.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //remove border
		txtNewsFeed.setBackground(new Color(51, 102, 0));
		txtNewsFeed.setText("News Feed");
		txtNewsFeed.setForeground(Color.white);
		txtNewsFeed.setColumns(10);
		txtNewsFeed.setHorizontalAlignment(JTextField.CENTER);
		
		
		Image iconStats = new ImageIcon(this.getClass().getResource("refreshIcon.png")).getImage();
		Image sizedIconStats = iconStats.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		JButton refreshButtonStats = new JButton();
		refreshButtonStats.setIcon(new ImageIcon(sizedIconStats));
		refreshButtonStats.setBounds(190, 45, 44, 23);
		frame.getContentPane().add(refreshButtonStats);
		refreshButtonStats.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				refreshStats();
			}
		});
		
		//CREATE COVID STATS HEADER
		covidStatsHeaderText = new JTextField();
		covidStatsHeaderText.setBounds(0, 47, 234, 18);
		frame.getContentPane().add(covidStatsHeaderText);
		covidStatsHeaderText.setColumns(10);
		covidStatsHeaderText.setBackground(new Color(51, 102, 0));
		covidStatsHeaderText.setText("U.S. Covid-19 Statistics");
		covidStatsHeaderText.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //remove border
		covidStatsHeaderText.setForeground(Color.white);
		covidStatsHeaderText.setColumns(10);
		covidStatsHeaderText.setHorizontalAlignment(JTextField.CENTER);

		
		//add Covid Stats to UI
		frame.getContentPane().add(generateCovidStats());

	
		
		//CREATING PANEL FOR GPA CALCULATOR
		GPAbutton = new JButton("Run GPA Calculator");
		GPAbutton.addActionListener(this);
		runGpaButton = new JButton("Run GPA Calculator");
		runGpaButton.addActionListener(this);
		numCourses = new JTextField(16);
		coursesLabel = new JLabel("Enter the number of courses you are taking");
		GPAPanel = new JPanel();
		GPAPanel.setBounds(240, 350, 550, 100);
		frame.getContentPane().add(GPAPanel);
		GPAPanel.add(coursesLabel);
		GPAPanel.add(numCourses);
		GPAPanel.add(GPAbutton);
		
		//CREATING PANEL FOR ACTIVITY TRACKER
		ActivityButton = new JButton("Run Activity Tracker");
		ActivityButton.addActionListener(this);
		numActivities = new JTextField(16);
		activitiesLabel = new JLabel("Enter the number of activities you want to complete today: ");
		ActivityPanel = new JPanel();
		ActivityPanel.setBounds(240, 50, 550, 100);
		frame.getContentPane().add(ActivityPanel);
		ActivityPanel.add(activitiesLabel);
		ActivityPanel.add(numActivities);
		ActivityPanel.add(ActivityButton);
		ActivityDisplayPanel = new JPanel();
		ActivityDisplayPanel.setLayout(new BoxLayout(ActivityDisplayPanel, BoxLayout.Y_AXIS));
		ActivityDisplayPanel.setBounds(240, 150, 550, 200);
		frame.getContentPane().add(ActivityDisplayPanel);
	}
	
	//ACTION LISTENER - IF WE ADD MORE BUTTONS PUT THEM IN HERE IN AN ELSE-IF
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GPACalculator gpac = new GPACalculator();

		ActivityTracker at = new ActivityTracker();

		String action = e.getActionCommand();
		if(action.equals("Run GPA Calculator")) {
			finalGPA = new JLabel("Your GPA for the semester is: " + GPACalculator.calculateGPA(Integer.parseInt(numCourses.getText())));
			GPAPanel.add(finalGPA);

			frame.getContentPane().repaint();
			frame.getContentPane().revalidate();
		}
		else if(action.equals("Run Activity Tracker")) {
			ActivityDisplayPanel.removeAll();
			ArrayList<String> actHolder = new ArrayList<String>();
			actHolder = ActivityTracker.trackActivities(Integer.parseInt(numActivities.getText()));
			
			for(int i = 0; i < Integer.parseInt(numActivities.getText()); i++) {
				activitiesLabel = new JLabel(actHolder.get(i));
				checkbox = new Checkbox(actHolder.get(i));
				ActivityDisplayPanel.add(checkbox);
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
			}
		}
	}
	
	/** generates a list of headlines in a separate method so they can be refreshed as needed
	 * 
	 * @param feedNumber - the value of the feed to be generated
	 * @return JList object containing headlines for a newsfeed
	 */
	private JList generateNewsFeed(int feedNumber){
		//initialize news feeds
		if(feedNumber == 1) {
			DefaultListModel<String> rssContainer1 = toolController.getHeadlinesFeed1();

			rssFeed1 = new JList<>(rssContainer1);
			rssFeed1.setBackground(Color.LIGHT_GRAY);	

			//mouselistener to open url of double clicked news item in feed 1 
			rssFeed1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					JList list = (JList)evt.getSource();
					if (evt.getClickCount() == 2) {

						// Double-click detected
						int index = list.locationToIndex(evt.getPoint());
						String itemUrl = toolController.getItemUrl(rssContainer1.elementAt(index));
						try {
							Desktop.getDesktop().browse(new URI(itemUrl));
						} catch (IOException | URISyntaxException e) {
							e.printStackTrace();
						}
					} 
				}
			});
			return rssFeed1;
		}
		else {
			DefaultListModel<String> rssContainer2 = toolController.getHeadlinesFeed2();

			rssFeed2 = new JList<>(rssContainer2);
			rssFeed2.setBackground(Color.LIGHT_GRAY);

			//mouselistener to open url of double clicked news item in feed 2
			rssFeed2.addMouseListener(new MouseAdapter() {

			    public void mouseClicked(MouseEvent evt) {
			        JList list = (JList)evt.getSource();
			        if (evt.getClickCount() == 2) {
	
			            // Double-click detected
			            int index = list.locationToIndex(evt.getPoint());
			            
						String itemUrl = toolController.getItemUrl(rssContainer2.elementAt(index));
			            try {

							Desktop.getDesktop().browse(new URI(itemUrl));
						} catch (IOException | URISyntaxException e) {
							e.printStackTrace();
						}
					} 
				}
			});
			return rssFeed2;
		}

	};
	
	/** refreshes news feeds by removing the panel then calling methods to regenerate the JLists
	 * 
	 */
	private void refreshFeeds() {

		tabbedPane.remove(rssFeed1);
		tabbedPane.remove(rssFeed2);
			 
		tabbedPane.addTab("NPR News", generateNewsFeed(1));
		tabbedPane.addTab("BBC News", generateNewsFeed(2));
			 
		frame.getContentPane().repaint();
		frame.getContentPane().revalidate();
	};
	
	/** generates covid stats as a JTable to allow for refresh
	 * 
	 * @return covidStatsTable - a JTable
	 */
	private JTable generateCovidStats() {
		String[][] covidData = toolController.pullCovidStats();
		String columnSpacer[]={"","",""};         
		covidStatsTable = new JTable(covidData,columnSpacer);
		covidStatsTable.setGridColor(Color.DARK_GRAY);
		covidStatsTable.setBackground(Color.LIGHT_GRAY);
		covidStatsTable.setBounds(6, 67, 224, 64);
		return covidStatsTable;
		
	}
	
	/** refreshes  by removing the panel then calling methods to regenerate the JLists
	 * 
	 */
	private void refreshStats() {
		frame.getContentPane().remove(covidStatsTable);
		frame.getContentPane().add(generateCovidStats());
	}


}
