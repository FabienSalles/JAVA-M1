package planetarium;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class PlaneteWindow extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private Planete pl;

	public PlaneteWindow() {
		super("Planetarium");
		// get screen dimensions
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		// set frame width, heigth and let platform pick screen location
		setSize(width / 4, height / 4);
		setLocationByPlatform(true);
		// Title and closing behavior
		setTitle("Planetarium");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Initialize view
		PlaneteView pv = new PlaneteView(this);
		pl = new Planete();
		pl.addObserver(pv);

		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setContentPane(pv);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sPlanet = (String) ((JComboBox) e.getSource()).getSelectedItem();
		// System.out.println(sRadio);
		pl.setSelectedPlanet(Enum.valueOf(PlaneteSolaire.class, sPlanet.toUpperCase()));
	}
}
