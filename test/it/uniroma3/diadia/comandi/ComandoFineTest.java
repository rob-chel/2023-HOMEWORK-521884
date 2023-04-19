package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoFineTest {

	private Stanza s1;
	private Stanza s2;
	private Partita p;
	private Comando fine;
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
		this.fine=new ComandoFine();
		this.a1=new Attrezzo("a1", 1);
		this.a2=new Attrezzo("a2", 2);
		this.s1.addAttrezzo(a2);
		//this.g=new Giocatore();
		this.b=new Borsa();
		this.io = new IOConsole();
		fine.setIo(io);
		
	}
	@Test
	public void FineTest() {
		fine.esegui(p);
	}

}
