package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	private Attrezzo att1;
	private Attrezzo att2;
	private Attrezzo att3;
	private Attrezzo att4;
	private Attrezzo att5;
	private Borsa borsaProva;

	@Before
	public void setUpAttrezziEBorsa() {
		att1= new Attrezzo("attr1", 2);
		att2= new Attrezzo("attr2", 3);
		att3= new Attrezzo("attr3", 7);
		att4= new Attrezzo("attr4", 9);
		att5= new Attrezzo("attr5", 11);
		borsaProva = new Borsa(); 

	}

	@Test
	public void addAttrezzoTrueTest() {
		assertTrue(this.borsaProva.addAttrezzo(att1));
	}

	@Test
	public void addAttrezzoFalseTest() {
		assertFalse(this.borsaProva.addAttrezzo(att5));
	}

	@Test
	public void addAttrezzoDueAttrezziTrueTest() {
		this.borsaProva.addAttrezzo(att2);
		assertTrue(this.borsaProva.addAttrezzo(att3));

	}

	@Test
	public void addAttrezzoDueAttrezziFalseTest() {
		this.borsaProva.addAttrezzo(att1);
		assertFalse(this.borsaProva.addAttrezzo(att5));

	}
	
	@Test
	public void getAttrezzoTrueTest() {
		this.borsaProva.addAttrezzo(att1);
		assertEquals(att1, this.borsaProva.getAttrezzo("attr1"));
	}
	
	@Test
	public void getAttrezzoFalseTest() {
		this.borsaProva.addAttrezzo(att1);
		assertNotEquals(att2, this.borsaProva.getAttrezzo("attr1"));
	}
	
	@Test
	public void removeAttrezzoTest() {
		this.borsaProva.addAttrezzo(att1);
		assertEquals(att1, this.borsaProva.removeAttrezzo("attr1"));
	}
	
	@Test
	public void removeAttrezzoNotEqualsTest() {
		this.borsaProva.addAttrezzo(att1);
		assertNotEquals(att2, this.borsaProva.removeAttrezzo("attr1"));
	}
	




}
