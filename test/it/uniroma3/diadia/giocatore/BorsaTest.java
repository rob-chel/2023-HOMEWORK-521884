package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	/*
	 * private Attrezzo att1; private Attrezzo att2; private Attrezzo att3; private
	 * Attrezzo att4; private Attrezzo att5; private Borsa borsaProva;
	 * 
	 * @Before public void setUpAttrezziEBorsa() { att1= new Attrezzo("attr1", 2);
	 * att2= new Attrezzo("attr2", 3); att3= new Attrezzo("attr3", 7); att4= new
	 * Attrezzo("attr4", 9); att5= new Attrezzo("attr5", 11); borsaProva = new
	 * Borsa();
	 * 
	 * }
	 * 
	 * @Test public void addAttrezzoTrueTest() {
	 * assertTrue(this.borsaProva.addAttrezzo(att1)); }
	 * 
	 * @Test public void addAttrezzoFalseTest() {
	 * assertFalse(this.borsaProva.addAttrezzo(att5)); }
	 * 
	 * @Test public void addAttrezzoDueAttrezziTrueTest() {
	 * this.borsaProva.addAttrezzo(att2);
	 * assertTrue(this.borsaProva.addAttrezzo(att3));
	 * 
	 * }
	 * 
	 * @Test public void addAttrezzoDueAttrezziFalseTest() {
	 * this.borsaProva.addAttrezzo(att1);
	 * assertFalse(this.borsaProva.addAttrezzo(att5));
	 * 
	 * }
	 * 
	 * @Test public void getAttrezzoTrueTest() { this.borsaProva.addAttrezzo(att1);
	 * assertEquals(att1, this.borsaProva.getAttrezzo("attr1")); }
	 * 
	 * @Test public void getAttrezzoFalseTest() { this.borsaProva.addAttrezzo(att1);
	 * assertNotEquals(att2, this.borsaProva.getAttrezzo("attr1")); }
	 * 
	 * @Test public void removeAttrezzoTest() { this.borsaProva.addAttrezzo(att1);
	 * assertEquals(att1, this.borsaProva.removeAttrezzo("attr1")); }
	 * 
	 * @Test public void removeAttrezzoNotEqualsTest() {
	 * this.borsaProva.addAttrezzo(att1); assertNotEquals(att2,
	 * this.borsaProva.removeAttrezzo("attr1")); }
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private Borsa borsa;
	private Attrezzo a1;
	private Attrezzo a2;
	private Attrezzo a3;
	private Attrezzo a4;
	
	@Before
	public void setUp() {
		this.borsa= new Borsa(10);
		this.a1= new Attrezzo("a1", 11);
		this.a2= new Attrezzo("a2", 5);
		this.a3= new Attrezzo("a3", 4);
		this.a4= new Attrezzo("a4", 6);
		
	}
	
	@Test
	public void hasAttrezzoFalse() {
		assertFalse(this.borsa.hasAttrezzo("a1"));
	}
	
	@Test
	public void addAttrezzoFalse() {
		assertFalse(this.borsa.addAttrezzo(a1));
	}
	
	@Test
	public void addAttrezzoTrue() {
		assertTrue(this.borsa.addAttrezzo(a2));
	}
	
	@Test
	public void addAttrezzoTrueSecondoAttrezzoRiempieBorsa() {
		this.borsa.addAttrezzo(a3);
		assertTrue(this.borsa.addAttrezzo(a4));
		//assertFalse(this.borsa.addAttrezzo(a1));
	}
	
	@Test
	public void hasAttrezzoTrue() {
		this.borsa.addAttrezzo(a2);
		assertTrue(this.borsa.hasAttrezzo("a2"));
	}
	
	@Test
	public void getAttrezzoTrue() {
		this.borsa.addAttrezzo(a2);
		assertSame(this.a2, this.borsa.getAttrezzo("a2"));
	}
	
	@Test
	public void getAttrezzoFalse() {
		this.borsa.addAttrezzo(a2);
		assertNotSame(this.a3, this.borsa.getAttrezzo("a2"));
	}
	
	@Test
	public void getAttrezzoNull() {
		this.borsa.addAttrezzo(a2);
		assertNull(this.borsa.getAttrezzo("a3"));
	}
	
	@Test 
	public void removeAttrezzoTrue() {
		this.borsa.addAttrezzo(a2);
		assertSame(this.a2,this.borsa.removeAttrezzo("a2"));
		assertFalse(this.borsa.hasAttrezzo("a2"));
	}
	
	@Test 
	public void removeAttrezzoFalseNull() {
		assertNull(this.borsa.removeAttrezzo("a2"));
		
		
	}
	
	
	
	




}
