package planetarium;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class PlaneteView extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private static final String msgAcc = "Bienvenu dans le planétarium ! \n\n"
			+ "Choisissez une planète dans la liste déroulante en haut pour voir son image et lire sa descrition.";
	private static String[] listePlanetes;
	private ActionListener planeteWindow;

	private JLabel planeteImage;
	private JTextArea description;

	public PlaneteView(ActionListener planeteWindow) {
		this.planeteWindow = planeteWindow;
		listePlanetes = PlanetesLoader.getListeNomsPlanetes();
		initComponents();
	}

	private void initComponents() {
		// Panel de selection d'une planete dans une liste
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBackground(new Color(76, 95, 204));
		Font police = new Font("Helvetica", Font.BOLD, 15);
		JLabel selectionlabel = new JLabel("Choose a planet");
		selectionPanel.setFont(police);
		selectionPanel.setForeground(Color.white);
		selectionPanel.add(selectionlabel);
		JComboBox myPlanetes = new JComboBox(listePlanetes);
		myPlanetes.setEditable(false);
		myPlanetes.addActionListener(planeteWindow);
		selectionPanel.add(myPlanetes);

		// Panel d'affichage de l'image de la planete selectionnee
		JPanel imagePanel = new JPanel();
		planeteImage = new JLabel(new ImageIcon(getClass().getClassLoader()
				.getResource("images/accueil.png")));
		planeteImage.setToolTipText("Logo");
		imagePanel.add(planeteImage);

		// Panel d'affichage de la description d'une planete
		description = new JTextArea(msgAcc);
		description.setLineWrap(false);
		description.setEditable(false);
		description.setPreferredSize(new Dimension(200, 300));
		description.setToolTipText("Message d'acceuil");
		JScrollPane descPanel = new JScrollPane(description);
		descPanel
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		descPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Border etched = BorderFactory.createEtchedBorder();
		Border titled = BorderFactory.createTitledBorder(etched, "Description");
		descPanel.setBorder(titled);
		descPanel.setBackground(new Color(150, 191, 234));
		// descPanel.setLayout(new BorderLayout());

		this.setLayout(new BorderLayout());
		this.add(selectionPanel, BorderLayout.NORTH);
		this.add(imagePanel, BorderLayout.CENTER);
		this.add(descPanel, BorderLayout.EAST);
	}

	@Override
	public void update(Observable o, Object arg) {
		Planete pl = (Planete) o;
		planeteImage.setIcon(new ImageIcon(pl.getSelectedPlanetImageURL()));
		planeteImage.setToolTipText(pl.getSelectedPlanetName());
		description.setText(pl.getSelectedPlanetDescription());
		description.setToolTipText("Description de la planete "
				+ pl.getSelectedPlanetName());
	}

}
