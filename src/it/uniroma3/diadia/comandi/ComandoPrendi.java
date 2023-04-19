package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String attrezzo;
	private IO io;
	private final static String NOME="prendi";

	@Override
	public void esegui(Partita partita) {

		//boolean bool = false;
		if(partita.getStanzaCorrente().hasAttrezzo(this.attrezzo)) {
			//if(this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo) != null) {
			if((partita.getGiocatore().getBorsa().getPeso() + partita.getStanzaCorrente().getAttrezzo(this.attrezzo).getPeso()) <= partita.getGiocatore().getBorsa().getDefaultPesoMaxBorsa()) {
				Attrezzo attr = partita.getStanzaCorrente().getAttrezzo(this.attrezzo);
				partita.getGiocatore().getBorsa().addAttrezzo(attr);
				partita.getStanzaCorrente().removeAttrezzo(attr);
				//bool = true;
				//System.out.println("attrezzo preso dalla stanza e aggiunto in borsa!");
				io.mostraMessaggio("attrezzo preso dalla stanza e aggiunto in borsa!");
			}
		}else
			io.mostraMessaggio("Attrezzo non presente nella stanza!");

		//}
		//return bool;


	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo=parametro;

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.NOME;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.attrezzo;
	}

	@Override
	public void setIo(IO io) {
		this.io=io;
		
	}

}
