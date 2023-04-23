package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private final Labirinto labirinto;
	public Stanza stanzaCorrente;
	private final Giocatore giocatore;
	private boolean finita;
	
	
	public Partita(){
		this.finita = false;
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
		labirinto.creaStanze();
		this.stanzaCorrente = labirinto.getStanzaInizio();
	}
	

	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return getStanzaCorrente() == labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (getGiocatore().getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}


	public boolean giocatoreIsVivo() {
		if(getGiocatore().getCfu() == 0) 
			return false;
		else
			return true;
	}

}
