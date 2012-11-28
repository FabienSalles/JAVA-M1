package poo.convertisseur;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


// Completer ce programme...

public class convertisseurGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JComboBox dev1;
	private JComboBox dev2;

	private JTextField tfdev1;
	private JTextField tfdev2;
	
	private Devises devise1 = Devises.DOLLAR_US;
	private Devises devise2 = Devises.DOLLAR_US;

	private String[] listeDevises = { Devises.DOLLAR_US.getName(),
			Devises.DOLLAR_CAN.getName(), Devises.EURO.getName() };
	
	JLabel msg; 

	public convertisseurGUI() {

		// Creates and sets up the window.
		Dimension fixedSize = new Dimension(300, 300);
		this.setSize(fixedSize);
		this.setTitle("Convertisseur de devises");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JButton clButton = new JButton("clear");
		clButton.setPreferredSize(new Dimension(100, 40));
		clButton.addActionListener(new resetFields());

		JLabel appName = new JLabel(
				"Choissisez les devises, puis le montant de la devise de départ");
		JLabel egale = new JLabel("=");
		
		msg = new JLabel("");

		dev1 = new JComboBox(listeDevises);
		dev1.addActionListener(new ChoixDevise1());
		
		tfdev1 = new JTextField("Entrez un montant", 20);
		
		dev2 = new JComboBox(listeDevises);
		dev2.addActionListener(new ChoixDevise2());
		
		tfdev2 = new JTextField("Entrez un montant", 20);

		JPanel container = new JPanel();

		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(280, 50));
		topPanel.add(appName);

		JPanel midPanel = new JPanel();
		midPanel.setPreferredSize(new Dimension(560, 150));
		JPanel listPanel = new JPanel();
		listPanel.setPreferredSize(new Dimension(560, 50));
		listPanel.add(dev1, BorderLayout.WEST);
		listPanel.add(dev2, BorderLayout.EAST);

		midPanel.add(listPanel, BorderLayout.NORTH);
		midPanel.add(tfdev1);
		midPanel.add(egale);
		midPanel.add(tfdev2);
		midPanel.add(msg, BorderLayout.SOUTH);

		JPanel botPanel = new JPanel();
		botPanel.setPreferredSize(new Dimension(280, 50));
		botPanel.add(clButton);

		container.setLayout(new BorderLayout());
		container.add(topPanel, BorderLayout.NORTH);
		container.add(midPanel, BorderLayout.CENTER);
		container.add(botPanel, BorderLayout.SOUTH);

		this.setContentPane(container);
		this.pack();
	}

	class ChoixDevise1 implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			devise1 = Enum.valueOf(Devises.class, Devises.getDeviseFromString(devise1.getName()).toString());
		} 
	}
	
	class ChoixDevise2 implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			devise2 = Enum.valueOf(Devises.class, Devises.getDeviseFromString(devise2.getName()).toString());
			//System.out.println(devise);

		}

	}
	
	class devise1 implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			String myDev = ((JTextField) arg0.getSource()).getText();
			try{
				
				} catch (NumberFormatException nfe) {
					msg.setText("Le texte rentré n'est pas un nombre");
				}
			//System.out.println(myDev);

		}

	}

	class devise2 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String myDev = ((JTextField) e.getSource()).getText();
			try{
		
			} catch (NumberFormatException nfe) {
				msg.setText("Le texte rentré n'est pas un nombre");
			}
			//System.out.println(myDev);
		}
	}

	class resetFields implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			tfdev1.setText("");
			tfdev2.setText("");
			msg.setText("");
		}
	}

}
