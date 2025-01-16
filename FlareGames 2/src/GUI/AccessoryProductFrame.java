package GUI;

import java.awt.EventQueue;
import ChildAndParentClasses.*;
import MainAndSys.FlareSys;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AccessoryProductFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_type;
	private JTextField textField_brand;
	private AddFrame af;
	private JCheckBox chckOriginal;

	
	public AccessoryProductFrame(AddFrame af) {
		setTitle("Accessory Product");
		this.af=af;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type of Accessory");
		lblNewLabel.setBounds(10, 45, 157, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblBrandOfAccessory = new JLabel("Brand of Accessory");
		lblBrandOfAccessory.setBounds(10, 84, 157, 13);
		contentPane.add(lblBrandOfAccessory);
		
		textField_type = new JTextField();
		textField_type.setBounds(192, 42, 171, 19);
		contentPane.add(textField_type);
		textField_type.setColumns(10);
		
		textField_brand = new JTextField();
		textField_brand.setColumns(10);
		textField_brand.setBounds(192, 81, 171, 19);
		contentPane.add(textField_brand);
		
		chckOriginal = new JCheckBox("Original");
		chckOriginal.setSelected(true);
		chckOriginal.setBounds(40, 129, 93, 21);
		contentPane.add(chckOriginal);
		
		JButton btnNewButton = new JButton("Add");
		
		
		btnNewButton.setBounds(136, 156, 110, 21);
		contentPane.add(btnNewButton);
		
		JButton btnGoBack = new JButton("Go Back");
		
		btnGoBack.setBounds(82, 199, 85, 21);
		contentPane.add(btnGoBack);
		
		JLabel OutputLabel = new JLabel("");
		OutputLabel.setBounds(28, 230, 346, 48);
		contentPane.add(OutputLabel);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {clean(); OutputLabel.setText("");}
		});
		btnClear.setBounds(211, 199, 85, 21);
		contentPane.add(btnClear);
		
		
		
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				af.enableButtons();
				af.getButtonNext().setEnabled(true);
				dispose();
				
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(areFieldsEmpty()) {
					
					int quantity = (int)af.getQuantitySelector().getValue();
					if(quantity > 0) {
						String name = af.getNameField().getText();
						double price= 0;
						
						try {
							price = Double.parseDouble(af.getPriceField().getText());
						}catch(NumberFormatException ex) {
							OutputLabel.setText("Enter a number for price!");
							return;
						}
						
						
						boolean secondHand = af.getChckSecondhand().isSelected();
						boolean rentable = af.getChckRental().isSelected();
						
						FlareSys.addStock(new AccessoryProduct(quantity, name, price, secondHand,
								rentable, textField_type.getText(), textField_brand.getText() , (chckOriginal.isSelected())));
						
						OutputLabel.setText("Product added to the stock");
						clean();
					}
					OutputLabel.setText("Enter a valid quantity");
				}
				
				else
					OutputLabel.setText("Please fill all the fields!");
				
				
			}
		});
	}
	
	private boolean areFieldsEmpty() {
		if(af.getNameField().getText().trim().isEmpty() || af.getPriceField().getText().trim().isEmpty()
				|| textField_type.getText().trim().isEmpty()|| textField_brand.getText().trim().isEmpty()) {
			return false;
		}
		return true;
	}
	
	private void clean() {
		af.getNameField().setText("");
		af.getPriceField().setText("");
		af.getQuantitySelector().setValue(1);
		af.getChckRental().setSelected(false);
		af.getChckSecondhand().setSelected(false);
		textField_type.setText("");
		textField_brand.setText("");
		chckOriginal.setSelected(true);
	}
}
