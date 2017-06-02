/**
 * @author zacharydorcinville
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class DutchessHousing extends JFrame {
	private static final long serialVersionUID = 1L;
	private String[] suiteList = { "Dutchess Suites Double: $3688", "Hudson Suites Single: $4346",
			"Hudson Suites Double: $3688", "Hudson Suites Triple: $3316", "Falcon Suites Double: $3898",
			"Drumlin Suites Single: $4346", "Drumlin Suites Double: $3688" };
	private String[] mealList = { "10 meals per week: $1525", "14 meals per week: $1659", "21 meals per week: $1813" };
	private Container contents;
	private JLabel selections;
	private JLabel total;
	int cost = 0;
	int cost2 = 0;
	int totalCost = cost + cost2;

	private JList<String> suites;
	private JList<String> meals;

/**
 * Constructor
 */
	public DutchessHousing() {
		super("Plan options");
		contents = getContentPane();
		contents.setLayout(new BorderLayout());
		selections = new JLabel(suiteList[0]);

		meals = new JList<String>(mealList);
		total = new JLabel("Total: $");

		contents.add(selections, BorderLayout.WEST);
		contents.add(meals, BorderLayout.EAST);
		contents.add(total, BorderLayout.CENTER);
		addComponent();
		addComponent2();
		setSize(550, 500);
		contents.setBackground(Color.LIGHT_GRAY);
		meals.setBackground(Color.BLUE);
		setVisible(true);

	}
/**
 * Suite JList component
 */
	private void addComponent() {
		suites = new JList<String>(suiteList);
		suites.setVisibleRowCount(5);
		suites.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contents.add(suites, BorderLayout.WEST);
		ListHandler listHandler = new ListHandler();
		suites.addListSelectionListener(listHandler);

	}
/**
 * Meal JList component
 */
	private void addComponent2() {
		meals = new JList<String>(mealList);
		meals.setVisibleRowCount(3);
		meals.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contents.add(meals, BorderLayout.EAST);
		ListHandler listHandler = new ListHandler();
		meals.addListSelectionListener(listHandler);

	}
/**
 * Handler for both JLists
 */
	private class ListHandler implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent listEvent) {
			if (!listEvent.getValueIsAdjusting()) {

				int index;
				index = suites.getSelectedIndex();

				if (index == 0)
					cost = 3688;
				if (index == 1)
					cost = 4346;
				if (index == 2)
					cost = 3688;
				if (index == 3)
					cost = 3316;
				if (index == 4)
					cost = 3898;
				if (index == 5)
					cost = 4346;
				if (index == 6)
					cost = 5000;

				int index2;
				index2 = meals.getSelectedIndex();

				if (index2 == 0)
					cost2 = 1525;
				if (index2 == 1)
					cost2 = 1659;
				if (index2 == 2)
					cost2 = 2000;

				int totalCost = cost + cost2;

				total.setText("Total: $" + totalCost + " per semester");
			}

		}
	}

	public static void main(String[] args) {
		DutchessHousing frame = new DutchessHousing();
		frame.setBackground(Color.blue);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//frame.pack();
		

	}

}
