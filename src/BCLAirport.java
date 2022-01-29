import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import java.awt.SystemColor;

public class BCLAirport extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BCLAirport frame = new BCLAirport();
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
	public BCLAirport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel button_panel = new JPanel();
		button_panel.setForeground(new Color(0, 0, 128));
		button_panel.setBackground(Color.WHITE);
		contentPane.add(button_panel, BorderLayout.NORTH);
		button_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton flightsButton = new JButton("Flights");
		flightsButton.setForeground(Color.BLACK);
		flightsButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		flightsButton.setBackground(Color.WHITE);
		button_panel.add(flightsButton);
		
		JButton restuarantButton = new JButton("Restuarant");
		restuarantButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_panel.add(restuarantButton);
		
		JButton financeButton = new JButton("New button");
		financeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_panel.add(financeButton);
		
		JButton departureButton = new JButton("Departures");
		departureButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_panel.add(departureButton);
		
		JButton arrivalButton = new JButton("Arrivals");
		arrivalButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_panel.add(arrivalButton);
		
		JPanel main_panel = new JPanel();
		main_panel.setBackground(Color.WHITE);
		contentPane.add(main_panel, BorderLayout.CENTER);
		main_panel.setLayout(null);
		
		JPanel items_panel = new JPanel();
		items_panel.setBounds(30, 76, 476, 353);
		main_panel.add(items_panel);
		items_panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		items_panel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		items_panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		items_panel.add(panel_2);
		
		JPanel info_panel = new JPanel();
		info_panel.setBackground(SystemColor.menu);
		info_panel.setBounds(530, 25, 150, 353);
		main_panel.add(info_panel);
		info_panel.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Brunel City");
		lblNewLabel_2_1.setBounds(10, 10, 130, 42);
		lblNewLabel_2_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		info_panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Restaurant");
		lblNewLabel_2_1_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_1_1.setBounds(10, 43, 130, 42);
		info_panel.add(lblNewLabel_2_1_1);
		
		JPanel title_panel = new JPanel();
		title_panel.setBounds(29, 25, 476, 41);
		main_panel.add(title_panel);
		title_panel.setLayout(null);
		
		JLabel meal_Label = new JLabel("Meals");
		meal_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		meal_Label.setForeground(new Color(0, 0, 128));
		meal_Label.setBounds(51, 14, 62, 19);
		title_panel.add(meal_Label);
		
		JLabel snack_Label = new JLabel("Snacks");
		snack_Label.setForeground(new Color(0, 0, 128));
		snack_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		snack_Label.setBounds(205, 14, 103, 19);
		title_panel.add(snack_Label);
		
		JLabel drinks_Label = new JLabel("Drinks");
		drinks_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		drinks_Label.setForeground(new Color(0, 0, 128));
		drinks_Label.setBounds(366, 14, 72, 19);
		title_panel.add(drinks_Label);
		
		JButton purchaseButton = new JButton("Purchase");
		purchaseButton.setBackground(Color.WHITE);
		purchaseButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		purchaseButton.setBounds(530, 388, 150, 41);
		main_panel.add(purchaseButton);
	}
}
