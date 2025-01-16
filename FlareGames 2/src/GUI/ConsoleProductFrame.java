package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import ChildAndParentClasses.ConsoleProduct;
import MainAndSys.FlareSys;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsoleProductFrame extends JFrame {

	private JPanel contentPane;
	private JTextField brandField;
	private JTextField colorField;
	private AddFrame af;
	private JButton btnAdd;
	private JCheckBox chckbxFixed;
	private JSpinner spinner;
	private JButton btnClear;
	
	public ConsoleProductFrame(AddFrame af) {
		setTitle("Console Product");
		this.af=af;
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 366);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Brand");
		lblNewLabel.setBounds(34, 27, 71, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblGeneration = new JLabel("Generation");
		lblGeneration.setBounds(34, 66, 71, 13);
		contentPane.add(lblGeneration);
		
		JLabel OutputLabel = new JLabel("");
		OutputLabel.setBounds(34, 264, 376, 53);
		contentPane.add(OutputLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Color");
		lblNewLabel_1_1.setBounds(34, 141, 71, 13);
		contentPane.add(lblNewLabel_1_1);
		
		chckbxFixed = new JCheckBox("Fixed");
		chckbxFixed.setBounds(127, 98, 93, 21);
		contentPane.add(chckbxFixed);
		
		brandField = new JTextField();
		brandField.setBounds(127, 24, 172, 19);
		contentPane.add(brandField);
		brandField.setColumns(10);
		
		colorField = new JTextField();
		colorField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					btnAdd.doClick();
					
				}
				
			}
		});
		colorField.setColumns(10);
		colorField.setBounds(127, 138, 172, 19);
		contentPane.add(colorField);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, null, 6, 1));
		spinner.setBounds(127, 63, 37, 20);
		contentPane.add(spinner);
		
		btnAdd = new JButton("Add Product");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(areFieldsEmpty()) {
					int quantity = (int)af.getQuantitySelector().getValue();
					if(quantity >0) {
						String name = af.getNameField().getText();
						double price =0;
						
						try {
							price= Double.parseDouble(af.getPriceField().getText());
						}catch(NumberFormatException ex) {
							OutputLabel.setText("Enter valid value for price!");
							return;
						}
						
						boolean secondHand = af.getChckSecondhand().isSelected();
						boolean rentable = secondHand;
						String brand = brandField.getText();
						int generation = Integer.parseInt(spinner.getValue().toString());
						boolean fixed = chckbxFixed.isSelected();
						String color = colorField.getText();
						
						ConsoleProduct o = new ConsoleProduct(quantity, name, price, secondHand, rentable, brand, generation, fixed, color);
						
						
						FlareSys.addStock(o);
						
						OutputLabel.setText("Product added to stock!");
						
						clean();
					}
					else {
						OutputLabel.setText("Enter a valid quantity!");
					}
				}
				
				else {
					OutputLabel.setText("Fill the fields to operate!");
				}
				
				
				
			}
		});
		btnAdd.setBounds(124, 179, 133, 21);
		contentPane.add(btnAdd);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				af.enableButtons();
				af.getButtonNext().setEnabled(true);
				dispose();
				
			}
		});
		btnGoBack.setBounds(87, 210, 99, 21);
		contentPane.add(btnGoBack);
		
		btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {clean(); OutputLabel.setText("");}
		});
		btnClear.setBounds(218, 210, 99, 21);
		contentPane.add(btnClear);
		
		
	}
	
	private boolean areFieldsEmpty() {
		if(af.getNameField().getText().trim().isEmpty() || af.getPriceField().getText().trim().isEmpty()
				|| brandField.getText().trim().isEmpty() || colorField.getText().trim().isEmpty()) {
			return false;
		}
		return true; 
	}
	
	private void clean() {
		
		af.getNameField().setText("");
		af.getPriceField().setText("");
		af.getQuantitySelector().setValue(1);
		af.getChckSecondhand().setSelected(false);
		af.getChckRental().setSelected(false);
		
		spinner.setValue(1);
		chckbxFixed.setSelected(false);
		brandField.setText("");
		colorField.setText("");
	}
	
}
