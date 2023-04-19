package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {

	private Stanza s1;
	private Stanza s2;
	private Partita p;
	private Comando prendi;
	private Attrezzo a1;
	private Attrezzo a2;
	//private Giocatore g;
	private Borsa b;
	private IOConsole io;
	
	@Before
	public void setUp() {
		this.s1=new Stanza("s1");
		this.s2=new Stanza("s2");
		this.p=new Partita();
		this.prendi=new ComandoPrendi();
		this.a1=new Attrezzo("a1", 1);
		this.a2=new Attrezzo("a2", 2);
		this.s1.addAttrezzo(a2);//STANZA 1 CONTIENE a2
		//this.g=new Giocatore();
		this.b=new Borsa();
		this.io = new IOConsole();
		prendi.setIo(io);
		
	}
	
	@Test
	public void PrendiTrue() {
		p.setStanzaCorrente(s1);
		s1.addAttrezzo(a1);
		prendi.setParametro("a1");
		prendi.esegui(p);
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("a1"));
	}
	
	@Test
	public void prendiFalse() {
		p.setStanzaCorrente(s1);
		prendi.setParametro("a1");
		prendi.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("a1"));
	}
	
	
}

