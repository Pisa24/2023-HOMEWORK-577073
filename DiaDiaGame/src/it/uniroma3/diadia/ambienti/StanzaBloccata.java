package it.uniroma3.diadia.ambienti;

import java.util.Iterator;


import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String passePartTout;


	public StanzaBloccata(String nome, String direzioneBloccata, String chiave) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.passePartTout = chiave;
	}


	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.direzioneBloccata.equals(direzione) && !super.hasAttrezzo(passePartTout))
			return this;
		else
			return super.getStanzaAdiacente(direzione);
	}


	@Override
	public String getDescrizione() {
	
		String Bloccata = "Ma non nella direzione " + this.direzioneBloccata
				+ ".\nSe vuoi sbloccare la direzione devi prendere: " + this.passePartTout;
		
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.getNome());
		risultato.append("\nPuoi andare: \n");
		
		for(Iterator<String> it = super.getDirezioni().iterator(); it.hasNext();) {
			String tmp = it.next();
			if(tmp.equals(this.direzioneBloccata)) {
				if(!super.hasAttrezzo(passePartTout))
				risultato.append(Bloccata);
				else
					risultato.append(tmp+"\n");
			}
			else 
			  risultato.append(tmp+"\n");
		}
	
		if(super.getAttrezzi().size() != 0) {
			risultato.append("\nAttrezzi nella stanza: ");
			for (Attrezzo attrezzo : super.getAttrezzi()) {
				if(attrezzo != null)
					risultato.append(attrezzo.toString()+" ");
			}
		}
		else
			risultato.append("\nLa stanza non contiene attrezzi.");

		return risultato.toString();
	}

}
