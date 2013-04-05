package sphere;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SphereView extends JPanel implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField radiusIn, volumeOut, areaOut;

	private DecimalFormat f3 = new DecimalFormat("0.000");

	public SphereView(ActionListener sw) {
		this.setLayout(new GridLayout(0, 2, 10, 10));
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.add(new JLabel("Radius = ", SwingConstants.CENTER));
		radiusIn = new JTextField(8);
		radiusIn.setBackground(Color.yellow);
		radiusIn.addActionListener(sw);
		this.add(radiusIn);

		this.add(new JLabel("Volume = ", SwingConstants.CENTER));
		volumeOut = new JTextField(8);
		volumeOut.setBackground(Color.white);
		this.add(volumeOut);

		this.add(new JLabel("Surface area = ", SwingConstants.CENTER));
		areaOut = new JTextField(8);
		areaOut.setBackground(Color.white);
		this.add(areaOut);
	}

	@Override
	public void update(Observable o, Object arg) {
		Sphere balloon = (Sphere) o;
		radiusIn.setText(String.valueOf(f3.format(balloon.getRadius())));
		volumeOut.setText(String.valueOf(f3.format(balloon.volume())));
		areaOut.setText(String.valueOf(f3.format(balloon.surfaceArea())));
	}

}
