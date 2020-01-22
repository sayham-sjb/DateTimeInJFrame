import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;

public class DateTimeClock {

	private JFrame frame;
	private JLabel lblClock;
	private JLabel lblDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateTimeClock window = new DateTimeClock();
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
	public DateTimeClock() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 359, 125);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblClock = new JLabel("Clock");
		lblClock.setBackground(Color.BLUE);
		lblClock.setFont(new Font("Times New Roman", Font.BOLD, 30));
		frame.getContentPane().add(lblClock, BorderLayout.CENTER);
		
		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 30));
		frame.getContentPane().add(lblDate, BorderLayout.NORTH);
	}
	
	/**
	 * Initialize clock
	 */
	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while(true) {
						Calendar calendar = new GregorianCalendar();
						int date = calendar.get(Calendar.DAY_OF_MONTH);
						int month = calendar.get(Calendar.MONTH);
						int year = calendar.get(Calendar.YEAR);
						int second = calendar.get(Calendar.SECOND);
						int minute = calendar.get(Calendar.MINUTE);
						int hour = calendar.get(Calendar.HOUR);
						
						lblDate.setText("Date - " + month + "/" + date + "/" + year);
						lblClock.setText("Time - " + hour + ":" + minute + ":" + second);
						sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

}
