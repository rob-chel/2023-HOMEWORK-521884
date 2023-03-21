package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza stanza;
	private Stanza stanza1;
	private Attrezzo attr1;
	private Attrezzo attr2;
	private Attrezzo attr3;
	
	
	@Before
	public void setUpStanze() {
		this.stanza = new Stanza("StanzaProva");
		this.stanza1 = new Stanza("StanzaProva1");
	}
	
	@Before
	public void setUpAttrezzi() {
		this.attr1 = new Attrezzo("provaAttrezzo1", 1);
		this.attr2 = new Attrezzo("provaAttrezzo2", 2);
		this.attr3 = new Attrezzo("provaAttrezzo3", 3);
		
		
	}

	@Test
	public void testGetStanzaAdiacente() {
		this.stanza1.impostaStanzaAdiacente("sud", stanza);
		assertEquals(stanza,this.stanza1.getStanzaAdiacente("sud"));
	}
	@Test
	public void testImpostaStanzaAdiacente() {
		this.stanza.impostaStanzaAdiacente("nord", stanza1);
		assertEquals(stanza1, this.stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testAddAttrezzo() {
		this.stanza.addAttrezzo(this.attr1);
		//System.out.println(this.stanza.getAttrezzi());
		assertEquals(attr1, this.stanza.getAttrezzo("provaAttrezzo1"));
		//assertEquals(attr1., stanza.getAttrezzo("provaAttrezzo1"));
	}
	
	@Test
	public void testHasAttrezzo() {
		this.stanza.addAttrezzo(this.attr1);
		assertTrue(stanza.hasAttrezzo("provaAttrezzo1"));
	}
	
	@Test
	public void testGetAttrezzo() {
		this.stanza1.addAttrezzo(attr2);
		assertSame(attr2,this.stanza1.getAttrezzo("provaAttrezzo2"));
	}
	
	@Test
	public void testRemoveAttrezzoVero() {
		this.stanza1.addAttrezzo(attr1);
		assertTrue(this.stanza1.removeAttrezzo(attr1));
		assertNull(stanza1.getAttrezzi()[0]);
	}
	
	/*@Test
	public void testRemoveAttrezzoFalso() {
		this.stanza1.addAttrezzo(attr2);
		assertFalse(this.stanza1.removeAttrezzo(attr1));
	}*/
	
	

}
