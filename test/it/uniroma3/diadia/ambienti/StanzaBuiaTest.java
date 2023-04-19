package it.uniroma3.diadia.ambienti;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private Stanza s1;
	private Stanza s2;
	private StanzaBuia s3;
	private Attrezzo a1;
	private Attrezzo a2;
	
	@Before
	public void setUp() {
		this.s1=new Stanza("s1");
		this.s2= new Stanza("s2");
		this.a1=new Attrezzo("lanterna", 1);
		this.a2=new Attrezzo("a2", 2);
		this.s3= new StanzaBuia("s2", "lanterna");
	}
	
	@Test
	public void StanzaBuiaSenzaAttrezzoPresente() {
		this.s3.addAttrezzo(a2);
		System.out.println(this.s3.getDescrizione());
		
	}
	
	@Test
	public void StanzaBuiaConAttrezzoPresente() {
		this.s3.addAttrezzo(a1);
		System.out.println(this.s3.getDescrizione());
	}

}
