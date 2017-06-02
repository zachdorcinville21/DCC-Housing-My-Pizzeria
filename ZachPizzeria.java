
// Zachary Dorcinville

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class ZachPizzeria extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;
	private JPanel controlPanel, sizePanel, toppingPanel, buttonPanel;
	private JRadioButton small, medium, large;
	private JButton order;
	private JCheckBox sas, oliv, pep, mash, sal, anch, soda, bread;
	private JLabel head, price, size, toppings; 

	public ZachPizzeria() {
		prepareGUI();
	} 

	public static void main(String[] args)

	{
		ZachPizzeria po = new ZachPizzeria();
		po.showCalculations();
			

	}

	public void prepareGUI() {
		mainFrame = new JFrame("Zach's Pizza");

		mainFrame.setSize(280, 400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		controlPanel = new JPanel(new GridLayout(7, 1));

		sizePanel = new JPanel(new GridLayout(1, 3));
		toppingPanel = new JPanel(new GridLayout(4, 2));
		buttonPanel = new JPanel(new GridLayout(2, 1));
 
		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);

	}

	public void showCalculations() {
		head = new JLabel("Zach's Pizza Order", JLabel.CENTER);
		price = new JLabel("Price : ");
		size = new JLabel("Size");
		toppings = new JLabel("Toppings");

		controlPanel.add(head);
		controlPanel.add(size);

		small = new JRadioButton("Small - $4.00");
		medium = new JRadioButton("Medium - $6.00");
		large = new JRadioButton("Large - $8.00");

		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);

		ButtonGroup sizeGroup = new ButtonGroup();

		sizeGroup.add(small);
		sizeGroup.add(medium);
		sizeGroup.add(large);

		controlPanel.add(sizePanel);

		controlPanel.add(toppings);

		sas = new JCheckBox("Sausage - $1.00");
		oliv = new JCheckBox("Olives - $1.00");
		pep = new JCheckBox("Pepperoni - $1.00");
		mash = new JCheckBox("Mashrooms - $1.00");
		sal = new JCheckBox("Salamy - $1.00");
		anch = new JCheckBox("Anchomies - $1.00");
		soda = new JCheckBox("Soda - $1.00");
		bread = new JCheckBox("Bread - $1.00");

		toppingPanel.add(sas);
		toppingPanel.add(oliv);
		toppingPanel.add(pep);
		toppingPanel.add(mash);
		toppingPanel.add(sal);
		toppingPanel.add(anch);
		toppingPanel.add(soda);
		toppingPanel.add(bread);

		controlPanel.add(toppingPanel);

		order = new JButton("Order ");
		order.addActionListener(new MyListener());

		buttonPanel.add(order);

		controlPanel.add(buttonPanel);

		controlPanel.add(price);

		mainFrame.add(controlPanel);

		mainFrame.setVisible(true);

	}

	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			int cost = 0;

			if (ae.getSource() == order) {

				if (small.isSelected() == true)
					cost += 4;
				else if (medium.isSelected() == true)
					cost += 6;
				else
					cost += 8;

				if (sas.isSelected() == true)
					cost += 1;
				if (oliv.isSelected() == true)
					cost += 1;
				if (pep.isSelected() == true)
					cost += 1;
				if (mash.isSelected() == true)
					cost += 1;
				if (sal.isSelected() == true)
					cost += 1;
				if (anch.isSelected() == true)
					cost += 1;
				if (soda.isSelected() == true)
					cost += 1;
				if (bread.isSelected() == true)
					cost += 1;

				price.setText("Price : " + cost + "$");

			}

		}
	}

}