package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerNumberModel;

public class AddFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField priceField;
	private JRadioButton radioGame;
	private JRadioButton radioConsole;
	private JRadioButton radioAccessory;
	private JCheckBox chckSecondhand;
	private JCheckBox chckRental;
	private JSpinner quantitySelector;
	private JButton buttonNext;
	




	FlareFrame ff;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	JFrame childFrame;
	
	private void disableButtons() { 
		
		radioGame.setEnabled(false);
		radioConsole.setEnabled(false);
		radioAccessory.setEnabled(false);
		
	}
	
	public void enableButtons() { //to be able to enable the buttons from the child class
		
		radioGame.setEnabled(true);
		radioConsole.setEnabled(true);
		radioAccessory.setEnabled(true);
	}
	
	
	
	public AddFrame(FlareFrame ff) {
		setTitle("Add Frame");
		
		this.ff=ff;
		
		AddFrame af = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameField = new JTextField();
		nameField.setBounds(147, 24, 191, 26);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel ProductNameLabel = new JLabel("Product Name:");
		ProductNameLabel.setBounds(28, 28, 107, 16);
		contentPane.add(ProductNameLabel);
		
		JLabel QuantityLabel = new JLabel("Quantity:");
		QuantityLabel.setBounds(28, 103, 73, 16);
		contentPane.add(QuantityLabel);
		
		quantitySelector = new JSpinner();
		quantitySelector.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		quantitySelector.setBounds(147, 99, 34, 26);
		contentPane.add(quantitySelector);
		
		JLabel PriceLabel = new JLabel("Price Per Quantity:");
		PriceLabel.setBounds(28, 64, 107, 16);
		contentPane.add(PriceLabel);
		
		priceField = new JTextField();
		priceField.setBounds(147, 60, 191, 26);
		contentPane.add(priceField);
		priceField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Type of Product:");
		lblNewLabel.setBounds(28, 141, 107, 13);
		contentPane.add(lblNewLabel);
		
		radioGame = new JRadioButton("Game");
		radioGame.setSelected(true);
		buttonGroup.add(radioGame);
		radioGame.setBounds(147, 137, 73, 21);
		contentPane.add(radioGame);
		
		radioConsole = new JRadioButton("Console");
		buttonGroup.add(radioConsole);
		radioConsole.setBounds(222, 137, 73, 21);
		contentPane.add(radioConsole);
		
		radioAccessory = new JRadioButton("Accessory");
		buttonGroup.add(radioAccessory);
		radioAccessory.setBounds(297, 137, 100, 21);
		contentPane.add(radioAccessory);
		
		buttonNext = new JButton("Next");
		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(radioGame.isSelected())
				{
					childFrame = new GameProductFrame(af); //dynamically get a new frame of 
														   //the necessary type
					
				}
				
				else if(radioConsole.isSelected())
				{
					childFrame = new ConsoleProductFrame(af);
					
				}
				
				else
				{
					childFrame = new AccessoryProductFrame(af);
					
				}
				
				
				disableButtons(); //to prevent changing the type after the child-frame was opened
				buttonNext.setEnabled(false); //to prevent the user from opening multiple child-frames
				childFrame.setVisible(true); //set the acquired frame's visibility to true
				
			}
		});
		buttonNext.setBounds(105, 240, 85, 21);
		contentPane.add(buttonNext);
		
		chckSecondhand = new JCheckBox("Secondhand");
		chckSecondhand.setBounds(28, 173, 117, 21);
		contentPane.add(chckSecondhand);
		
		chckRental = new JCheckBox("Rentable");
		chckRental.setBounds(28, 196, 117, 21);
		contentPane.add(chckRental);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				if(childFrame!=null)
					childFrame.dispose(); //to dispose the child-frame if the parent is closed
				
				ff.setVisible(true);
				
			}
		});
		btnGoBack.setBounds(248, 240, 85, 21);
		contentPane.add(btnGoBack);
	}


	public JTextField getNameField() {
		return nameField;
	}



	public JTextField getPriceField() {
		return priceField;
	}
	

	public JCheckBox getChckSecondhand() {
		return chckSecondhand;
	}



	public JCheckBox getChckRental() {
		return chckRental;
	}



	public JRadioButton getRadioGame() {
		return radioGame;
	}



	public JRadioButton getRadioConsole() {
		return radioConsole;
	}



	public JRadioButton getRadioAccessory() {
		return radioAccessory;
	}
	
	
	public JSpinner getQuantitySelector() {
		return quantitySelector;
	}


	public JButton getButtonNext() {
		return buttonNext;
	}


	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}
	
	
	
	
}
