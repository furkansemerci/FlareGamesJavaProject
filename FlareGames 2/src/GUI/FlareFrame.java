package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainAndSys.FlareSys;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlareFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public FlareFrame() {
		
		FlareFrame ff = this;
		
		setTitle("Flare Games System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("Add Product to System");
		btnAdd.setBounds(38, 41, 230, 21);
		contentPane.add(btnAdd);
		
		JButton btnOrder = new JButton("Place Order");
		btnOrder.setBounds(38, 102, 230, 21);
		contentPane.add(btnOrder);
		
		JButton btnDisplay = new JButton("Display Information");
		
		btnDisplay.setBounds(38, 165, 230, 21);
		contentPane.add(btnDisplay);
		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				(new AddFrame(ff)).setVisible(true);
				
			}
		});
		
		btnOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				(new OrderFrame(ff)).setVisible(true); //in order to reset the frame each time
				
			}
		});
		
		btnDisplay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				(new DisplayFrame(ff)).setVisible(true);
				
			}
		});
	}
}
