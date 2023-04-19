package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	private IO io;
	private final static String NOME="vai";

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossinaStanza=null;
		
		if(this.direzione==null) {
			io.mostraMessaggio("Dove vuoi andate? Devi specificare una direzione");
			return;
		}
		prossinaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossinaStanza==null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
			
		}
		partita.setStanzaCorrente(prossinaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.NOME;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.direzione;
	}

	@Override
	public void setIo(IO io) {
		this.io=io;
		
	}

}
