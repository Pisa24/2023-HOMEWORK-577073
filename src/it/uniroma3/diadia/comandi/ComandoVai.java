package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;


public class ComandoVai extends AbstractComando{
	
	private final static String NOME = "vai";

	@Override
	public void esegui(Partita partita) {
		
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(this.getParametro() == null) {
			this.getIo().mostraMessaggio("Dove vuoi andare? Specifica la direzione.");
			return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
		if(prossimaStanza == null) {
			this.getIo().mostraMessaggio("Oh oh, di là non ci si può andare...");
		    return;
		}
		
		partita.setStanzaCorrente(prossimaStanza);
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

	@Override
	public String getNome() {
		return NOME;
	}

}

