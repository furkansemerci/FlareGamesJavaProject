package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChildAndParentClasses.Order;
import ChildAndParentClasses.Product;
import MainAndSys.FlareSys;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;

public class DisplayFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idField;

	FlareFrame ff;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * Create the frame.
	 */
	public DisplayFrame(FlareFrame ff) {
		setTitle("Display Frame");
		this.ff=ff;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 507, 312);
		contentPane.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		idField = new JTextField();
		idField.setBounds(296, 33, 96, 19);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Product ID:");
		lblNewLabel.setBounds(296, 10, 142, 13);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnOrder = new JRadioButton("Order");
		buttonGroup.add(rdbtnOrder);
		rdbtnOrder.setBounds(99, 32, 67, 21);
		contentPane.add(rdbtnOrder);
		
		JRadioButton rdbtnProduct = new JRadioButton("Product");
		buttonGroup.add(rdbtnProduct);
		rdbtnProduct.setSelected(true);
		rdbtnProduct.setBounds(10, 32, 74, 21);
		contentPane.add(rdbtnProduct);
		
		JButton btnDisplayAll = new JButton("Display All");
		
		btnDisplayAll.setBounds(172, 32, 101, 21);
		contentPane.add(btnDisplayAll);
		
		JButton btnSearchById = new JButton("Search by ID");
		
		btnSearchById.setBounds(402, 33, 115, 21);
		contentPane.add(btnSearchById);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ff.setVisible(true);
				
			}
		});
		btnGoBack.setBounds(212, 413, 85, 21);
		contentPane.add(btnGoBack);
		
		JLabel lblMsg = new JLabel("");
		lblMsg.setBounds(330, 62, 121, 13);
		contentPane.add(lblMsg);
		
		btnDisplayAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				output.setText("");
				
				if(rdbtnOrder.isSelected())
				{
					for (Order o : FlareSys.getOrders()) {
						output.setText(output.getText() + o.toString());
					}
					
				}
				
				else {
					for (Product o : FlareSys.getStock()) {
						output.setText(output.getText() + o.toString());
					}
				}
				

				if(output.getText().equals(""))
					output.setText("No Item Found");
			}
		});
		
		btnSearchById.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblMsg.setText("");
				output.setText("");
				
				if(idField.getText().isEmpty())
					lblMsg.setText("Please enter an ID");
				else {
					Product temp = FlareSys.findProductByID(Integer.parseInt(idField.getText()));
					
					if(temp==null)
						output.setText("ID not found");
					
					else
						output.setText(temp.toString());
				}
				
			}
		});
	}
}
