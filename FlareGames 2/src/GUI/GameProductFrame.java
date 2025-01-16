package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChildAndParentClasses.ConsoleProduct;
import ChildAndParentClasses.GameProduct;
import MainAndSys.FlareSys;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameProductFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField countryField;
	private AddFrame af;
	private JButton btnAdd;
	private JComboBox consoleCMB;
	private JComboBox genreCMB;
	private JComboBox ageCMB;
	private JSpinner spinner;


	/**
	 * Create the frame.
	 */
	public GameProductFrame(AddFrame af) {
		this.af=af;
		
		setTitle("Game Product Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supported Console");
		lblNewLabel.setBounds(10, 10, 147, 13);
		contentPane.add(lblNewLabel);
		
		consoleCMB = new JComboBox();
		consoleCMB.setModel(new DefaultComboBoxModel(new String[] {"XBOX Series X", "XBOX One", "XBOX 360", "Playstation 3", "Playstation 4", "Playstation 5", "Playstation 5 Pro"}));
		consoleCMB.setSelectedIndex(0);
		consoleCMB.setBounds(184, 10, 137, 21);
		contentPane.add(consoleCMB);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(10, 44, 109, 13);
		contentPane.add(lblGenre);
		
		genreCMB = new JComboBox();
		genreCMB.setModel(new DefaultComboBoxModel(new String[] {"Action", "RPG", "FPS", "TPS", "Horror", "Arcade", "Sports", "MOBA", "MMORPG"}));
		genreCMB.setSelectedIndex(0);
		genreCMB.setBounds(184, 44, 137, 21);
		contentPane.add(genreCMB);
		
		JLabel lblNewLabel_1 = new JLabel("Release Year");
		lblNewLabel_1.setBounds(10, 83, 109, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAgeRating = new JLabel("Age Rating");
		lblAgeRating.setBounds(10, 121, 109, 13);
		contentPane.add(lblAgeRating);
		
		ageCMB = new JComboBox();
		ageCMB.setModel(new DefaultComboBoxModel(new String[] {"18+", "13+", "7+", "3+"}));
		ageCMB.setSelectedIndex(0);
		ageCMB.setBounds(184, 121, 137, 21);
		contentPane.add(ageCMB);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPublisher.setBounds(139, 164, 52, 13);
		contentPane.add(lblPublisher);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 196, 109, 13);
		contentPane.add(lblName);
		
		nameField = new JTextField();
		nameField.setBounds(184, 197, 137, 19);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(10, 231, 109, 13);
		contentPane.add(lblCountry);
		
		countryField = new JTextField();
		countryField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					btnAdd.doClick();
				}
				
			}
		});
		countryField.setColumns(10);
		countryField.setBounds(184, 232, 137, 19);
		contentPane.add(countryField);
		
		btnAdd = new JButton("Add");
		
		
		btnAdd.setBounds(115, 275, 109, 21);
		contentPane.add(btnAdd);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				af.enableButtons();
				af.getButtonNext().setEnabled(true);
				dispose();
				
			}
		});
		
		
		btnGoBack.setBounds(82, 306, 85, 21);
		contentPane.add(btnGoBack);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(15, 0, 24, 1));
		spinner.setBounds(184, 84, 137, 20);
		contentPane.add(spinner);
		
		JLabel OutputLabel = new JLabel("");
		OutputLabel.setBounds(49, 340, 250, 59);
		contentPane.add(OutputLabel);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {clean(); OutputLabel.setText("");}
		});
		btnClear.setBounds(181, 306, 85, 21);
		contentPane.add(btnClear);
		
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(areFieldsEmpty()) {
					int quantity = (int)af.getQuantitySelector().getValue();
					String name = af.getNameField().getText();
					double price =0;
					try {
						price = Double.parseDouble(af.getPriceField().getText());
					}catch(NumberFormatException ex) {
						OutputLabel.setText("Enter a numeric value for price field!");
						return;
					}
					
					boolean secondHand = af.getChckSecondhand().isSelected();
					boolean rentable = af.getChckRental().isSelected();
					
					//of sub-class
					String supportedConsole = (String)consoleCMB.getSelectedItem();
					String genre = (String)genreCMB.getSelectedItem();
					int year = 2000 + (int)spinner.getValue();
					String ageRating = (String)ageCMB.getSelectedItem();
					String pName = nameField.getText();
					String pCountry = countryField.getText();
					
					
					FlareSys.addStock(new GameProduct(quantity, name, price, secondHand, rentable, supportedConsole, genre, year, ageRating, pName, pCountry));
					
					
					OutputLabel.setText("Product added to stock!");
					
					clean();
					
				}
				else {
					OutputLabel.setText("Please fill all the fields!");
				}
				
				
			}
		});
	}
	
	public boolean areFieldsEmpty() {
		if(af.getNameField().getText().trim().isEmpty() || af.getPriceField().getText().trim().isEmpty()
				|| nameField.getText().trim().isEmpty() || countryField.getText().trim().isEmpty())
			return false;
		
		return true;
	}
	
	private void clean() {
		
		af.getNameField().setText("");
		af.getPriceField().setText("");
		af.getQuantitySelector().setValue(1);
		af.getChckSecondhand().setSelected(false);
		af.getChckRental().setSelected(false);
		
		consoleCMB.setSelectedIndex(0);
		ageCMB.setSelectedIndex(0);
		genreCMB.setSelectedIndex(0);
		spinner.setValue(15);
		
		nameField.setText("");
		countryField.setText("");
		
	}
	
}
