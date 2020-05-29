package tietokanta;

import java.sql.*;

import data.Opiskelija;

public class Tietovarasto {

    private String ajuri = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/koulu";
    private String kayttajatunnus = "tomi";
    private String salasana = "tomi";

    private String sqlLisaaOpiskelija = "INSERT INTO Opiskelija(opiskelijaID, etunimi, sukunimi, "
            + "opintoviikot) VALUES (?,?,?,?)";

    private String sqlHaeOpiskelija = "SELECT * FROM Opiskelija WHERE opiskelijaID = ?";
    private String sqlPoistaOpiskelija = "UPDATE Opiskelija SET etunimi = 'NULL', sukunimi = 'NULL', opintoviikot = 0 WHERE opiskelijaID = ?";

    public Opiskelija haeOpiskelija(int opiskelijaID) throws Exception {
        Connection yhteys = null;
        try {
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
        } catch (Exception e) {
            throw new Exception("Tietovarasto ei ole auki.", e);
        }

        PreparedStatement haeOpiskelija = null;
        ResultSet tulos = null;
        try {
            haeOpiskelija = yhteys.prepareStatement(sqlHaeOpiskelija);
            haeOpiskelija.setInt(1, opiskelijaID);
            tulos = haeOpiskelija.executeQuery();
            if (tulos.next()) {
                return new Opiskelija(tulos.getInt(1), tulos.getString(2), tulos.getString(3), tulos.getInt(4));
            } else {
                throw new Exception("Opiskelijaa ei l�ydy");
            }

        } catch (SQLException sqle) {
            throw new Exception("Hakuvirhe", sqle);
        } finally {
            YhteydenHallinta.suljeYhteys(yhteys);
        }

    }

    public void lisaaOpiskelija(Opiskelija uusiOpiskelija) throws Exception {
        int opiskelijaID = uusiOpiskelija.getOpiskelijaID();

        Connection yhteys = null;
        try {
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
        } catch (Exception e) {
            throw new Exception("Tietovarasto ei ole auki.", e);
        }
        PreparedStatement opiskelijanLisays = null;
        try {
            opiskelijanLisays = yhteys.prepareStatement(sqlLisaaOpiskelija);
            opiskelijanLisays.setInt(1, uusiOpiskelija.getOpiskelijaID());// ensimmainen kysymysmerkki
            opiskelijanLisays.setString(2, uusiOpiskelija.getEtunimi());// toinen kysymysmerkki
            opiskelijanLisays.setString(3, uusiOpiskelija.getSukunimi());// jne
            opiskelijanLisays.setInt(4, uusiOpiskelija.getOpintoviikot());// jne
            opiskelijanLisays.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new Exception("Opiskelijan lisays ei onnistu.", sqle);
        }
    }

    public void poistaOpiskelija(int opiskelijaID) throws Exception {

        Connection yhteys = null;
        try {
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
        } catch (Exception e) {
            throw new Exception("Tietovarasto ei ole auki.", e);
        }
        PreparedStatement poistaOpiskelija = null;
        try {
            poistaOpiskelija = yhteys.prepareStatement(sqlPoistaOpiskelija);
            System.out.println("1");
            poistaOpiskelija.setInt(1, opiskelijaID);
            System.out.println("2");
            poistaOpiskelija.executeUpdate();
            System.out.println("3");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new Exception("Opiskelijan poisto ei onnistu.", sqle);
        }
    }
}
/*  
        
	public Opiskelija poistaOpiskelija(int opiskelijaID)throws Exception {
		Connection yhteys = null;
		try{
			yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
		}catch (Exception e){
			throw new Exception("Tietovarasto ei ole auki.", e);
		}
		
		PreparedStatement poistaOpiskelija = null;
		//ResultSet tulos = null;
		try{
			poistaOpiskelija=yhteys.prepareStatement(sqlPoistaOpiskelija);
			poistaOpiskelija.setInt(1, opiskelijaID);
		//	tulos = poistaOpiskelija.executeQuery();
                        
			poistaOpiskelija.executeUpdate();
                        
                        
		//	if(tulos.next()){
				return new Opiskelija(tulos.getInt(1),tulos.getString(2),tulos.getString(3),tulos.getInt(4));
			//}else{
				//throw new Exception("Opiskelijaa ei l�ydy");
			//}
			
		}catch (SQLException e){
			throw new Exception("Hakuvirhe", e);
		}finally{
			YhteydenHallinta.suljeYhteys(yhteys);
		}
		
	}
}
 */
