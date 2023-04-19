package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	private IO io;
	private final static String NOME="aiuto";
	
	

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< partita.getElencocomandi().length; i++) 
			io.mostraMessaggio(partita.getElencocomandi()[i]+" ");
			//ioConsole.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("\n");
		//ioConsole.mostraMessaggio("\n");

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.NOME;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub
		this.io=io;
	}

}
