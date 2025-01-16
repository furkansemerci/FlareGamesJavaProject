package GUI;

import java.awt.EventQueue;
import hasAClasses.*;
import hasAClasses.Customer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChildAndParentClasses.*;
import MainAndSys.FlareSys;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField CustNameField;
	private JTextField AddressField;
	private final ButtonGroup ProductType = new ButtonGroup();
	private JComboBox comboBox;
	private JCheckBox RentCheck;

	FlareFrame ff;
	
	/**
	 * Create the frame.
	 */
	public OrderFrame(FlareFrame ff) {
		setTitle("Order Frame");
		this.ff=ff;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CustNameField = new JTextField();
		CustNameField.setBounds(216, 25, 130, 26);
		contentPane.add(CustNameField);
		CustNameField.setColumns(10);
		
		JLabel CustName = new JLabel("Customer Name:");
		CustName.setBounds(38, 30, 109, 16);
		contentPane.add(CustName);
		
		AddressField = new JTextField();
		AddressField.setBounds(216, 53, 413, 26);
		contentPane.add(AddressField);
		AddressField.setColumns(10);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setBounds(38, 58, 96, 16);
		contentPane.add(addressLabel);
		
		JButton OrderBtn = new JButton("ORDER");
		
		
		
		OrderBtn.setBounds(94, 330, 117, 29);
		contentPane.add(OrderBtn);
		
		JLabel ProductLabel = new JLabel("Product:");
		ProductLabel.setBounds(38, 217, 61, 16);
		contentPane.add(ProductLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(173, 213, 440, 27);
		contentPane.add(comboBox);
		
		JRadioButton GameRadio = new JRadioButton("Game");
		
		ProductType.add(GameRadio);
		GameRadio.setBounds(220, 124, 141, 23);
		contentPane.add(GameRadio);
		
		JRadioButton ConsoleRadio = new JRadioButton("Console");
		ProductType.add(ConsoleRadio);
		ConsoleRadio.setBounds(38, 124, 141, 23);
		contentPane.add(ConsoleRadio);
		
		JRadioButton AccessoryRadio = new JRadioButton("Accessory");
		ProductType.add(AccessoryRadio);
		AccessoryRadio.setBounds(404, 124, 141, 23);
		contentPane.add(AccessoryRadio);
		
		RentCheck = new JCheckBox("Do you want to rent?");
		RentCheck.setBounds(38, 168, 210, 23);
		contentPane.add(RentCheck);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ff.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(416, 330, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel OutputLabel = new JLabel("");
		OutputLabel.setBounds(38, 260, 575, 48);
		contentPane.add(OutputLabel);
		
		GameRadio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//dynamically fill the combobox according to the type
				getComboBox().setModel(new DefaultComboBoxModel(FlareSys.getStockAsArray(1)));
				
			}
		});
		
		ConsoleRadio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
		
				getComboBox().setModel(new DefaultComboBoxModel(FlareSys.getStockAsArray(0)));
				
			}
		});
		
		AccessoryRadio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				getComboBox().setModel(new DefaultComboBoxModel(FlareSys.getStockAsArray(2)));				
			}
		});
		
		OrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			if(areFieldsEmpty() && (comboBox.getSelectedItem())!=null) {
				Customer cust = new Customer(CustNameField.getText(), AddressField.getText());
				
				//get the product by using the first 3 characters of the 
				//String in the comboBox
				Product prod = FlareSys.findProductByID(Integer.parseInt(((String)comboBox.getSelectedItem()).substring(0,3)));
				
				prod.decrementQuantity();
				if(prod.getQuantity()==0) //if the stock runs out, remove the item
					FlareSys.removeProduct(prod.getId());
				
				
				Order temp = new Order(prod,cust);
				FlareSys.addOrder(temp);
				OutputLabel.setText("Order No: " + temp.getOrderId() + " added!");
				
				clear(); //clear after completion
			}
			else
				OutputLabel.setText("Please fill all the fields");
			}

	});

	}
	
	private boolean areFieldsEmpty() {
		if(CustNameField.getText().trim().isEmpty() || AddressField.getText().trim().isEmpty())
			return false;
		return true;
	}
	
	private void clear() {
		CustNameField.setText("");
		AddressField.setText("");
		ProductType.clearSelection(); //clear the selection of the button group
		RentCheck.setSelected(false);
		getComboBox().setModel(new DefaultComboBoxModel()); //reset the combobox
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	
	
}
