/* 
	Ime datoteke:	Miza.java
	Avtor:		  	Domen Koprivnik
	Vhodni podatki: /
	Opis: 			Aplikacija z grafičnim uporabniškim vmesnikom za delo s steklenicami
	Izhodni podatki: Okno grafičnega vmesnika
*/

//Uvozimo pakete za delo z GUI
import javax.swing.*;

//uvozimo paket za delo z dogodki
import java.awt.event.*;
import java.awt.Font;

// Deklariramo javni razred
public class Miza extends JFrame implements ActionListener {
	
	// Deklariramo zasebne lastnosti
	private JPanel povrsina;
	private JButton dodajJButton;
	private JTextField znamkaPolje, alkoholPolje;
	private JTable tabela;
	private PivskaSteklenicaTableModel modelTabele;
	
	// Deklariramo javno statično metodo, ki se izvede ob zagonu programa
	// Vhodni parametri: vhodni parametri iz konzole
	// Potek/opis: ustvari novo okno
	// Vrne vrednost: n/
	public static void main(String[] args) {
		
	
		Miza m = new Miza("miza s pivskimi steklenicami");
	}
	
	// Javni konstruktor
	// Vhodni parametri: n - naslov okna
	// Potek/opis: vrne objekt tipa Miza
	// Vrne vrednost: vrne objekt tipa Miza
	public Miza(String n) {
		
		// Kličemo konstruktor nadrazreda
		super(n);
		
		// Inicializiramo lastnosti
		povrsina = new JPanel() ;
		povrsina.setBackground(UIManager.getColor("Menu.selectionBackground"));
		dodajJButton = new JButton("Dodaj steklenico");
		dodajJButton.setBackground(UIManager.getColor("Menu.selectionBackground"));
		znamkaPolje = new JTextField(32);
		znamkaPolje.setFont(new Font("Tahoma", Font.BOLD, 12));
		znamkaPolje.setToolTipText("Sem vnesete znamko piva");
		alkoholPolje = new JTextField(8);
		modelTabele = new PivskaSteklenicaTableModel();
		tabela = new JTable(modelTabele);
		
		// površino dodamo na mizo
		getContentPane().add(povrsina);
		
		// Gumbu za dodajanje dodamo action listener
		dodajJButton.addActionListener(this);
		
		// dodamo gumb, vnosna polja in tabelo na površino
		JLabel label = new JLabel ("Znamka:");
		label.setLabelFor(znamkaPolje);
		povrsina.add(label);
		povrsina.add(znamkaPolje);
		JLabel label_1 = new JLabel ("Stopnja alkohola:");
		label_1.setLabelFor(alkoholPolje);
		povrsina.add(label_1);
		povrsina.add(alkoholPolje);
		povrsina.add(dodajJButton);
		povrsina.add(tabela);
		
		
		// Pokažemo okno
		setVisible(true);
		
		// Nastavimo velikost
		setSize(800,600);
		
		//Nastavimo obnašanje križca
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		System.out.println("Ustvarjam nov objekt Miza");
	}
	
	// Metoda, ki jo predpisuje vmesnik ActionListener
	// Vhodni parametri: dogodek
	// Potek/opis: doda steklenico na seznam - v tabelo
	// Vrne vrednost: /
	
	public void actionPerformed(ActionEvent ae) {
		
		System.out.println("Dodajam steklenico....");
		System.out.println("Znamka je " + znamkaPolje.getText());
		System.out.println("Stopnja alkohola je " + alkoholPolje.getText());
		
		//Ustvarimo lokalno spremenljivko flasa
		//double d = Double.parseDouble(alkoholPolje.getText());
		//PivskaSteklenica flasa = new PivskaSteklenica(znamkaPolje.getText(), 500, d);
		
		// Dodamo objekt v seznam
		//modelTabele.addPivskaSteklenica(flasa);
		modelTabele.addPivskaSteklenica(new PivskaSteklenica(znamkaPolje.getText(), 500, Double.parseDouble(alkoholPolje.getText())));
		
	}
}