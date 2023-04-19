package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	
	private String comando;
	private IO io;
	private final static String NOME="ComandoNonValido";

	@Override
	public void esegui(Partita partita) {
		boolean bool=false;
		int i=0;
		while(i<partita.getElencocomandi().length && !bool) {
			if(partita.getElencocomandi()[i]==comando) 
				bool=true;
			else
				i++;
		}
		if(bool)
			return;
		else
			System.out.println("Comando non valido!!!");
		

	}

	@Override
	public void setParametro(String parametro) {
		this.comando=parametro;

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.NOME;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.comando;
	}

	@Override
	public void setIo(IO io) {
		this.io=io;
		
	}

}
