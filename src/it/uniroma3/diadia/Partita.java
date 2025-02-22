package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	//static final private int CFU_INIZIALI = 20;
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi" , "guarda"};

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	//private int cfu;
	private Labirinto labirinto;
	private Giocatore giocatore;

	public Partita() {
		//creaStanze();
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
		this.finita = false;
		this.stanzaCorrente= this.labirinto.getStanzaIniziale();
		this.stanzaVincente= this.labirinto.getStanzaFinale();
		//this.cfu = CFU_INIZIALI;
	}

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	/*
	 * private void creaStanze() {
	 * 
	 * crea gli attrezzi Attrezzo lanterna = new Attrezzo("lanterna",3); Attrezzo
	 * osso = new Attrezzo("osso",1);
	 * 
	 * crea stanze del labirinto Stanza atrio = new Stanza("Atrio"); Stanza aulaN11
	 * = new Stanza("Aula N11"); Stanza aulaN10 = new Stanza("Aula N10"); Stanza
	 * laboratorio = new Stanza("Laboratorio Campus"); Stanza biblioteca = new
	 * Stanza("Biblioteca");
	 * 
	 * collega le stanze atrio.impostaStanzaAdiacente("nord", biblioteca);
	 * atrio.impostaStanzaAdiacente("est", aulaN11);
	 * atrio.impostaStanzaAdiacente("sud", aulaN10);
	 * atrio.impostaStanzaAdiacente("ovest", laboratorio);
	 * aulaN11.impostaStanzaAdiacente("est", laboratorio);
	 * aulaN11.impostaStanzaAdiacente("ovest", atrio);
	 * aulaN10.impostaStanzaAdiacente("nord", atrio);
	 * aulaN10.impostaStanzaAdiacente("est", aulaN11);
	 * aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
	 * laboratorio.impostaStanzaAdiacente("est", atrio);
	 * laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
	 * biblioteca.impostaStanzaAdiacente("sud", atrio);
	 * 
	 * pone gli attrezzi nelle stanze aulaN10.addAttrezzo(lanterna);
	 * atrio.addAttrezzo(osso);
	 * 
	 * // il gioco comincia nell'atrio stanzaCorrente = atrio; stanzaVincente =
	 * biblioteca; }
	 */

	/*
	 * public Stanza getStanzaVincente() { return stanzaVincente; }
	 * 
	 * public void setStanzaCorrente(Stanza stanzaCorrente) { this.stanzaCorrente =
	 * stanzaCorrente; }
	 * 
	 * public Stanza getStanzaCorrente() { return this.stanzaCorrente; }
	 */
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * 
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.stanzaCorrente == this.stanzaVincente;
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * 
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	/*
	 * public int getCfu() { return this.cfu; }
	 * 
	 * public void setCfu(int cfu) { this.cfu = cfu; }
	 */

	public Labirinto getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public boolean giocatoreIsVivo() {//metodo aggiunto
		return this.getGiocatore().getCfu()>0;
		
	}

	public static String[] getElencocomandi() {
		return elencoComandi;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("CFU giocatore:"+this.giocatore.getCfu());
		return sb.toString();
	}
	
	
	
	
	
}
