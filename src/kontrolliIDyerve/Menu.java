package kontrolliIDyerve;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JFrame  implements ActionListener{

	JButton hyrja;
	JButton dalja;
	JPanel panel=new JPanel();
	JTextField userText;
	Menu(){
		this.setLayout(null);
		this.setTitle("Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(400,450);
		this.setLocationRelativeTo(null); //e vendos ne qender te ekranit guin
		this.getContentPane().setBackground(Color.yellow);
		
		JLabel label=new JLabel("JU LUTEM ZGJIDHNI VEPRIMIN QE DO TE KRYENI");
		label.setBounds(40,20,350,25);
		this.add(label);
		

		hyrja =new JButton("HYRE");
		hyrja.setBounds(152,70,70,30);
		hyrja.setFocusable(false);
		hyrja.addActionListener(this);
		this.add(hyrja);
		
		dalja =new JButton("DIL");
		dalja.setBounds(152,105,70,30);
		dalja.setFocusable(false);
		dalja.addActionListener(this);
		this.add(dalja);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==hyrja) {
			new Hyrja();
			this.setVisible(false);
		}
		if(e.getSource()==dalja) {
			new Dalja();
			this.setVisible(false);
		}
	}	
	
}
