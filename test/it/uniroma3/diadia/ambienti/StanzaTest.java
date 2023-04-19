package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	/*
	 * private Stanza stanza; private Stanza stanza1; private Attrezzo attr1;
	 * private Attrezzo attr2; private Attrezzo attr3;
	 * 
	 * 
	 * @Before public void setUpStanze() { this.stanza = new Stanza("StanzaProva");
	 * this.stanza1 = new Stanza("StanzaProva1"); }
	 * 
	 * @Before public void setUpAttrezzi() { this.attr1 = new
	 * Attrezzo("provaAttrezzo1", 1); this.attr2 = new Attrezzo("provaAttrezzo2",
	 * 2); this.attr3 = new Attrezzo("provaAttrezzo3", 3);
	 * 
	 * 
	 * }
	 * 
	 * @Test public void testGetStanzaAdiacente() {
	 * this.stanza1.impostaStanzaAdiacente("sud", stanza);
	 * assertEquals(stanza,this.stanza1.getStanzaAdiacente("sud")); }
	 * 
	 * @Test public void testImpostaStanzaAdiacente() {
	 * this.stanza.impostaStanzaAdiacente("nord", stanza1); assertEquals(stanza1,
	 * this.stanza.getStanzaAdiacente("nord")); }
	 * 
	 * @Test public void testAddAttrezzo() { this.stanza.addAttrezzo(this.attr1);
	 * //System.out.println(this.stanza.getAttrezzi()); assertEquals(attr1,
	 * this.stanza.getAttrezzo("provaAttrezzo1")); //assertEquals(attr1.,
	 * stanza.getAttrezzo("provaAttrezzo1")); }
	 * 
	 * @Test public void testHasAttrezzo() { this.stanza.addAttrezzo(this.attr1);
	 * assertTrue(stanza.hasAttrezzo("provaAttrezzo1")); }
	 * 
	 * @Test public void testGetAttrezzo() { this.stanza1.addAttrezzo(attr2);
	 * assertSame(attr2,this.stanza1.getAttrezzo("provaAttrezzo2")); }
	 * 
	 * @Test public void testRemoveAttrezzoVero() { this.stanza1.addAttrezzo(attr1);
	 * assertTrue(this.stanza1.removeAttrezzo(attr1));
	 * assertNull(stanza1.getAttrezzi()[0]); }
	 * 
	 * @Test public void testRemoveAttrezzoFalso() {
	 * this.stanza1.addAttrezzo(attr2);
	 * assertFalse(this.stanza1.removeAttrezzo(attr1)); }
	 */



























	private Stanza s1;
	private Stanza s2;
	private Attrezzo[] attrezzi;
	private Attrezzo f;


	@Before
	public void setUp10AttrezziInUnArrayEUnaStanza() {
		//this.s1=new Stanza("s1");
		//this.a1=new Attrezzo("a1", 10);
		this.attrezzi= new Attrezzo[10];
		for(int i=0;i<10;i++) {
			this.attrezzi[i]= new Attrezzo("a"+ (i+1), (i+1));
		}
		s1=new Stanza("s1");
		s2=new Stanza("s2");
		f=new Attrezzo("f", 3);

	}
	
	@Test
	public void addAttrezzoTrue() {
		assertTrue(this.s1.addAttrezzo(attrezzi[0]));
	}
	
	@Test
	public void addAttrezzoFalse() {
		for(int i=0;i<this.s1.getNumeroMassimoAttrezzi();i++) {
			this.s1.addAttrezzo(this.attrezzi[i]);
		}
		assertFalse(this.s1.addAttrezzo(f));
		
	}
	
	@Test
	public void hasAttrezzoTrue() {
		this.s1.addAttrezzo(f);
		assertTrue(this.s1.hasAttrezzo("f"));
	}
	
	@Test
	public void hasAttrezzoFalse() {
		assertFalse(this.s1.hasAttrezzo("f"));
	}
	
	@Test
	public void removeAttrezzoFalseSuStanzaVuota() {
		assertFalse(this.s1.removeAttrezzo(f));
	}
	
	@Test
	public void removeAttrezzoFalseInesistente() {
		this.s1.addAttrezzo(attrezzi[0]);
		assertFalse(this.s1.removeAttrezzo(f));
	}
	
	@Test
	public void removeAttrezoTrue() {
		this.s1.addAttrezzo(attrezzi[0]);
		assertTrue(this.s1.removeAttrezzo(attrezzi[0]));
	}
	
	@Test
	public void removeAttrezzoTrueFraPiùAttrezzi() {
		this.s1.addAttrezzo(f);
		this.s1.addAttrezzo(attrezzi[0]);
		this.s1.addAttrezzo(attrezzi[1]);
		assertTrue(this.s1.removeAttrezzo(attrezzi[0]));
	}
	
	@Test
	public void getAttrezzoTrue() {
		this.s1.addAttrezzo(f);
		assertSame(f,this.s1.getAttrezzo("f"));
	}
	
	@Test
	public void getAttrezzoTrue2() {//prova per vedere se gli elementi nel setUp sono corretti
		this.s1.addAttrezzo(this.attrezzi[0]);
		assertSame(this.attrezzi[0],this.s1.getAttrezzo("a1"));
	}
	
	@Test
	public void getAttrezzoFalse() {
		this.s1.addAttrezzo(attrezzi[0]);
		assertNotSame(f, this.s1.getAttrezzo("a1"));
	}
	
	@Test
	public void impostaStanzaAdiacente() {
		this.s1.impostaStanzaAdiacente("sud", s2);
		assertSame(s2, this.s1.getStanzaAdiacente("sud"));
		
	}
	
	@Test
	public void impostaStanzaAdiacenteNull() {
		this.s1.impostaStanzaAdiacente("nord", s2);
		assertNull(this.s1.getStanzaAdiacente("sud"));
	}
	
	


}
