package kontrolliIDyerve;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dalja extends JFrame implements ActionListener {
	
	JButton logInButton;
	JPanel panel=new JPanel();
	JTextField userText,userText2;
	JButton ktheu;
	Dalja(){
		this.setLayout(null);
		this.setTitle("DALJA");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(450,450);
		this.setLocationRelativeTo(null); 
		
		JLabel label=new JLabel("Vendosni ID e deres");
		label.setBounds(10,20,150,25);
		this.add(label);
		
		userText =new JTextField(20);
		userText.setBounds(152,20,150,25);
		this.add(userText);
		System.out.println(userText.getText());
		
		JLabel label2=new JLabel("Vendosni ID e kartes");
		label2.setBounds(10,50,150,25);
		this.add(label2);
		
		userText2 =new JTextField(20);
		userText2.setBounds(152,50,150,25);
		this.add(userText2);
		System.out.println(userText2.getText());
		
		logInButton =new JButton("DIL");
		logInButton.setBounds(152,100,70,30);
		logInButton.setFocusable(false);
		logInButton.addActionListener(this);
		this.add(logInButton);

		
		ktheu =new JButton("Ktheu");
		ktheu.setBounds(152,140,70,30);
		ktheu.setFocusable(false);
		ktheu.addActionListener(this);
		this.add(ktheu);

		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logInButton) {
			try {
				String dera=userText.getText();
				String punonjesi=userText2.getText();
				//Kontrollojme nese ekziston kjo dere
				if(DbConnection.kontrolloDeren(dera)!=0) {
					//Kontrollojme nese ky punonjes ka te drejte te perdore kete dere
					if(DbConnection.kontrolloPunonjesin(dera,punonjesi)!=0 ) {
						//Kontrollojme nese karta eshte akoma e vlefshme  kontrolloVlefshmerineEKartes
						if(DbConnection.kontrolloVlefshmerineEKartes(punonjesi)) {
							//Kontrollo nese ka hyre 
							if(DbConnection.kontrolloNeseKaHyre(punonjesi)) {
								//Inserto daten e hyrjes se fundit
								DbConnection.updateDatenEDaljes(punonjesi);
								JOptionPane.showMessageDialog(null,"Dera u hap! Mirupafshim!");
							}else {
								JOptionPane.showMessageDialog(null,"Ju nuk keni te drejte per kete dere!Duhet te hyni fillimisht");
							}
							
						}	
						else {
							JOptionPane.showMessageDialog(null,"Ju nuk keni te drejte per kete dere!Karta juaj ka skaduar");
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"Ju nuk keni te drejte per kete dere!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Nuk u gjet asnje dere me id: "+dera);
				}		
				
			} catch ( HeadlessException e1) {
				MesazhPerPerjashtim mesazhPerPerjashtim=new MesazhPerPerjashtim("Ky program nuk mund te ekzekutohen ne nje paisje pa tasier");
				JOptionPane.showMessageDialog(null,mesazhPerPerjashtim.getMesazh());
			}
		
			catch (Exception e1) {
				MesazhPerPerjashtim mesazhPerPerjashtim=new MesazhPerPerjashtim("Programi nuk mund te ekzekutohet");
				JOptionPane.showMessageDialog(null,mesazhPerPerjashtim.getMesazh());
			}
		}
	if(e.getSource()==ktheu) {
		new Menu();
		this.setVisible(false);
	}
	}
}
