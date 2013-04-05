package sphere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class SphereWindow extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sphere sph;
	public SphereWindow() {
		super("Spheres: volume and surface area");
		sph = new Sphere(0, 0, 0);
		SphereView view = new SphereView(this);
		sph.addObserver(view);
		
		this.setSize(240, 160);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setContentPane(view);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField t = (JTextField) e.getSource();
		double r = Double.parseDouble(t.getText());
		sph.setRadius(r);
	}

}
