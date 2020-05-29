/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import data.Opiskelija;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tietokanta.Tietovarasto;

/**
 *
 * @author s2000317
 */
public class JFrPoista extends JFrAbstraktiLisaysJaMuut {

    public JFrPoista(Tietovarasto rekisteri) {
        	super(rekisteri);
		btNappi.setText("Poista");
		this.setTitle("Poista opiskelija");
	}
	@Override
	protected void kasitteleNappi() {
		try{
			int opiskelijaID = Integer.parseInt(tfId.getText());
			rekisteri.poistaOpiskelija(opiskelijaID);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e, "Virhe",JOptionPane.ERROR_MESSAGE);
		}
    }
    
}
