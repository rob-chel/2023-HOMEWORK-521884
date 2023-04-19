package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String nomeAttrezzoDescrizione;
	static final private String messaggio="Qui c'è buio pesto!!!"; 
	//static final private String attrVedi="lanterna";

	public StanzaBuia(String nome,String attrDescr) {
		super(nome);
		this.nomeAttrezzoDescrizione=attrDescr;
	}

	@Override
	public String getDescrizione() {

		for(int i=0;i<this.getAttrezzi().length ;i++) {
			if(this.getAttrezzi()[i] != null) {
				if(this.getAttrezzi()[i].getNome().equals(nomeAttrezzoDescrizione))
					return super.getDescrizione();
			}

		}
		return this.messaggio;
	}

	public String getNomeAttrezzoDescrizione() {
		return nomeAttrezzoDescrizione;
	}



}
