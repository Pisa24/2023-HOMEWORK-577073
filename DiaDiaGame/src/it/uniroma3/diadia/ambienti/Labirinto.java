package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.Partita;

/**
* Questa classe modella la mappa del gioco
*
* @author  pisa
* @see Stanza
* @see Partita
*/

public class Labirinto {
	private Stanza stanzaInizio;
	private Stanza stanzaVincente;
    /**
     * Crea tutte le stanze e le porte di collegamento
     */
	public Labirinto() {
		stanzaInizio = getStanzaInizio();
		this.stanzaVincente = getStanzaVincente();
	}

	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}
    
    public Stanza getStanzaVincente() {
		return stanzaVincente;
    }
    
    public void setStanzaInizio(Stanza s) {
    	this.stanzaInizio = s;
    }
    
    public Stanza getStanzaInizio() {
    	return stanzaInizio;
    }

	public void setStanzaVincente(Stanza biblio) {
		this.stanzaVincente = biblio;
	}
	
}
