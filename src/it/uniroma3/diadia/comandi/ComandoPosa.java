package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String attrezzo;
	private IO io;
	private final static String NOME = "posa";

	@Override
	public void esegui(Partita partita) {
		//boolean bool = false;
		if(partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzo)) {
			Attrezzo attrDaBorsa = partita.getGiocatore().getBorsa().getAttrezzo(this.attrezzo);
			if(partita.getStanzaCorrente().getNumeroAttrezzi() < partita.getStanzaCorrente().getNumeroMassimoAttrezzi() ) {
				partita.getStanzaCorrente().addAttrezzo(attrDaBorsa);
				partita.getGiocatore().getBorsa().removeAttrezzo(this.attrezzo);
				//bool = true;
				//System.out.println("attrezzo posato nella stanza e tolto dalla borsa!");
				io.mostraMessaggio("attrezzo posato nella stanza e tolto dalla borsa!");
			}

		}else
			io.mostraMessaggio("Attrezzo non presente in borsa!!!");
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
		return this.attrezzo;
		
	}

	@Override
	public void setIo(IO io) {
		this.io=io;
		
	}

}
