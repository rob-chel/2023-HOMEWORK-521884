package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
	
	private Stanza s1;
	private Stanza s2;
	private Comando vai;
	private Partita p;
	private IOConsole io;
	
	@Before
	public void setUp() {
		this.s1=new Stanza("s1");
		this.s2=new Stanza("s2");
		vai = new ComandoVai();
		p = new Partita();
		this.io=new IOConsole();
		vai.setIo(io);
		
	}
	
	@Test
	public void VaiSudTrue() {
		
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud", s2);
		vai.setParametro("sud");
		vai.esegui(p);
		assertEquals(s2, p.getStanzaCorrente());
		
	}
	
	@Test
	public void testVaiNull() {
		p.setStanzaCorrente(s1);
		vai.esegui(p);
		assertEquals(s1, p.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneInesistente() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("nord", s2);
		vai.setParametro("est");
		vai.esegui(p);
		assertNotEquals(s2, p.getStanzaCorrente());
		
	}

}
