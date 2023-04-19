package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;
import junit.framework.Assert;

public class ComandoPosaTest {

	private Stanza s1;
	private Stanza s2;
	private Partita p;
	private Comando posa;
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
		this.posa=new ComandoPosa();
		this.a1=new Attrezzo("a1", 1);
		this.a2=new Attrezzo("a2", 2);
		this.s1.addAttrezzo(a2);
		//this.g=new Giocatore();
		this.b=new Borsa();
		this.io = new IOConsole();
		posa.setIo(io);
		
	}
	
	@Test
	public void PosaTrue() {
		
		//g.setBorsa(b);
		//b.addAttrezzo(a1);
		//p.setGiocatore(g);
		p.getGiocatore().getBorsa().addAttrezzo(a1);
		p.setStanzaCorrente(s1);
		posa.setParametro("a1");
		posa.esegui(p);
		assertSame(a1,this.s1.getAttrezzo("a1"));
	}
	
	@Test
	public void PosaNotSame() {
		p.getGiocatore().getBorsa().addAttrezzo(a1);
		p.setStanzaCorrente(s1);
		posa.setParametro("a2");
		posa.esegui(p);
		
	}
	
	
	
}
