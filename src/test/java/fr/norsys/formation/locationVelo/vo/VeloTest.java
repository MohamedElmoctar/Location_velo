/**
 * 
 */
package fr.norsys.formation.locationVelo.vo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * @author technomaker04
 *
 */
public class VeloTest {
	private Velo velo;
	
	@Before
	public void initVelo() {
		 velo=new Velo();
	}
	
	/**
	 * -etant donné le vélo
	 * -quand je l'intialise
	 * -il doit etre different de null
	 */
	@Test
	public void InitVeloEtVerifierQuIlNePasNull() throws Exception {
		assertNotNull(velo);			
	}
	
	/**
	 * étant donné un velo initialisé
	 *  je l'attribus une matricule M0102
	 *  quand je retourne la matricule de ce velo alors la matricule est M0102
	 * @throws Exception
	 */
	@Test
	public void initVeloSetMatriculeM0102EtRetournObtiensM0102() throws Exception {
		velo.setMatricule("M0102");
		assertEquals("M0102", velo.getMatricule());
		
	}
	
}
