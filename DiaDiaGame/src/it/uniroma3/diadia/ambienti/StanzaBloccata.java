package it.uniroma3.diadia.ambienti;


public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String passePartTout;


	public StanzaBloccata(String nome, String direzioneNone, String chiave) {
		super(nome);
		this.direzioneBloccata = direzioneNone;
		this.passePartTout = chiave;
	}


	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(direzioneBloccata) && !super.hasAttrezzo(passePartTout))
			return this;
		else
			return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String bloccata = "Non puoi guardare nella direzione " + this.direzioneBloccata
				           + ".\nSe vuoi sbloccare la direzione devi prendere: " + this.passePartTout;
		if(!super.hasAttrezzo(this.passePartTout))
			return bloccata;
		else
			return super.getDescrizione();
	}
}
