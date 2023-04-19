package it.uniroma3.diadia.ambienti;



import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata s1;
	private StanzaBloccata s2;
	private Attrezzo a1;
	private Attrezzo a2;
	
	@Before
	public void setUp() {
		this.s1=new StanzaBloccata("s1", "a1", "sud");
		this.a1=new Attrezzo("a1", 2);
		this.a2=new Attrezzo("a2", 1);
		
	}
	
	@Test
	public void getStanzaAdiacenteTrue() {
		this.s1.addAttrezzo(a1);
		this.s1.impostaStanzaAdiacente("sud", s2);
		assertSame(s2, this.s1.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void getStanzaAdiacente() {//essendo che non c'è l'attrezzo sblocca rimane in s1
		this.s1.addAttrezzo(a2);
		this.s1.impostaStanzaAdiacente("sud", s2);
		assertSame(s1,this.s1.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void getStanzaAdiacenteFalse() {
		this.s1.addAttrezzo(a2);
		this.s1.impostaStanzaAdiacente("sud", s2);
		assertNotSame(s2, this.s1.getStanzaAdiacente("sud"));
		
	}
	
	@Test 
	public void getDescrizioneConAttrezzo() {
		this.s1.addAttrezzo(a1);
		this.s1.impostaStanzaAdiacente("sud", s2);
		System.out.println(s1.getDescrizione());
	}
	
	@Test
	public void getDescrizioneSenzaAttrezzo() {
		this.s1.addAttrezzo(a2);
		this.s1.impostaStanzaAdiacente("sud", s2);
		System.out.println(s1.getDescrizione());
	}

}
