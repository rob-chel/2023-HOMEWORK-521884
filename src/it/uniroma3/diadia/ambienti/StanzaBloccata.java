package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String dirBloccata;
	private String attrezzoSbloccante;
	static final private String messaggio="Sei bloccata nella stanza finche non metti in questa stanza un passpartout!!!";
	
	public StanzaBloccata(String nome, String attrSbloc, String dirBloc) {
		super(nome);
		this.attrezzoSbloccante=attrSbloc;
		this.dirBloccata=dirBloc;
		
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(super.hasAttrezzo(attrezzoSbloccante)) {
			return super.getStanzaAdiacente(direzione);
		}
		else
			return this;
	}
	
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(attrezzoSbloccante)) {
			return super.getDescrizione();
		}
		else
			return messaggio;
	}

}
