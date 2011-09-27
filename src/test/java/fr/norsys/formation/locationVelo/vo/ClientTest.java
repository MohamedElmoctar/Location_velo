/**
 * 
 */
package fr.norsys.formation.locationVelo.vo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author technomaker04
 *
 */
public class ClientTest {
	
private Client client;
	
	@Before
	public void initClient() {
		client=new Client();
	}
	
	/**
	 * -etant donn� le client
	 * -quand je l'intialise
	 * -il doit etre different de null
	 */
	@Test
	public void InitClientEtVerifierQuIlNePasNull() throws Exception {
		assertNotNull(client);			
	}
	
	/**
	 * �tant donn� un Client initialis�
	 *  je l'attribus un nom JACK
	 *  quand je retourne le nom de ce client alors le nom est JACK
	 * @throws Exception
	 */
	@Test
	public void initVeloSetMatriculeJACKEtRetournObtiensJACK() throws Exception {
		client.setNom("JACK");
		assertEquals("JACK", client.getNom());
		
	}


}
