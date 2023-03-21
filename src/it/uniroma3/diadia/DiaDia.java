package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi"};

	private Partita partita;
	private IOConsole ioConsole;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		//Scanner scannerDiLinee;
		
		ioConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
		//System.out.println(MESSAGGIO_BENVENUTO);
		//scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = ioConsole.leggiRiga();//scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if(comandoDaEseguire.getNome() != null) {
			if(comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
			else if(comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine(); 
				return true;
			} else if (comandoDaEseguire.getNome().equals("vai"))
				this.vai(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
			else
				//System.out.println("Comando sconosciuto");
				ioConsole.mostraMessaggio("Comando sconosciuto");


			if (this.partita.vinta()) {
				//System.out.println("Hai vinto!");
				ioConsole.mostraMessaggio("Hai vinto!");
				return true;
			} else
				return false;}
		else return false;
	}   

	// implementazioni dei comandi dell'utente:

	private boolean prendi(String nomeAttrezzo) {
		boolean bool = false;
		if(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			//if(this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo) != null) {
				if((this.partita.getGiocatore().getBorsa().getPeso() + this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo).getPeso()) <= this.partita.getGiocatore().getBorsa().getDefaultPesoMaxBorsa()) {
					Attrezzo attr = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
					this.partita.getGiocatore().getBorsa().addAttrezzo(attr);
					this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attr);
					bool = true;
					//System.out.println("attrezzo preso dalla stanza e aggiunto in borsa!");
					ioConsole.mostraMessaggio("attrezzo preso dalla stanza e aggiunto in borsa!");
				}
			}

		//}
		return bool;

	}

	private boolean posa(String nomeAttrezzo) {
		boolean bool = false;
		if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrDaBorsa = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			if(this.partita.getLabirinto().getStanzaCorrente().getNumeroAttrezzi() < this.partita.getLabirinto().getStanzaCorrente().getNumeroMassimoAttrezzi() ) {
				this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrDaBorsa);
				this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				bool = true;
				//System.out.println("attrezzo posato nella stanza e tolto dalla borsa!");
				ioConsole.mostraMessaggio("attrezzo posato nella stanza e tolto dalla borsa!");
			}

		}
		return bool;
	}

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			//System.out.print(elencoComandi[i]+" ");
			ioConsole.mostraMessaggio(elencoComandi[i]+" ");
		//System.out.println();
		ioConsole.mostraMessaggio("\n");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			//System.out.println("Dove vuoi andare ?");
			ioConsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			//System.out.println("Direzione inesistente");
			ioConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		//System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		ioConsole.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		//System.out.println("Grazie di aver giocato!");  // si desidera smettere
		ioConsole.mostraMessaggio("Grazie di aver giocato!");
	}

	public static void main(String[] argc) {
		IOConsole ioConsole = new IOConsole();
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}