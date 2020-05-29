package kayttoliittyma;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tietokanta.Tietovarasto;


public class JFrPaaikkuna extends JFrame {

	private JPanel paPohja = new JPanel(new GridLayout(5,1));
	
	private JButton btLisaa = new JButton("Lisaa opiskelija");
	private JButton btHaeOpiskelija = new JButton("Hae opiskelijan tiedot");
	private JButton btPoista = new JButton("Poista opiskelija");
	private JButton btMuuta = new JButton("Muuta opiskelijan tiedot");
	
	private Tietovarasto rekisteri = new Tietovarasto();
	
	public JFrPaaikkuna(){
	    this.setTitle("Paaikkuna");
	    this.setLocation(100,300);
	    this.setSize(200,250);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    asetteleKomponentit();
	    this.setVisible(true);
	  }

	  private void asetteleKomponentit(){
	    paPohja.add(btLisaa);
	    paPohja.add(btHaeOpiskelija);
	    paPohja.add(btPoista);
	    paPohja.add(btMuuta);
	    

	    this.add(paPohja);
	    
	    btLisaa.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		lisaaOpiskelija();
	    	}
	    });
	    
	    btHaeOpiskelija.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		haeOpiskelija();
	    	}
	    });
            
            btPoista.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                        poistaOpiskelija();
                }
            });
            
	  }//asetteleKomponentit lopetus
         private void poistaOpiskelija(){
		 new JFrPoista(rekisteri).setVisible(true);
	 }
	  
	 private void lisaaOpiskelija(){
		 new JFrLisays(rekisteri).setVisible(true);
	 }
	 
	 private void haeOpiskelija(){
		 new JFrHaku(rekisteri).setVisible(true);
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrPaaikkuna ikkuna = new JFrPaaikkuna();

	}

}
