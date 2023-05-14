package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	protected static final int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	protected List <Attrezzo> attrezzi;
	protected int numeroAttrezzi;
	private Map<String, Stanza> stanzeAdiacenti;
	private int numeroStanzeAdiacenti;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public StanzaProtected(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.stanzeAdiacenti = new HashMap<String, Stanza>();
		this.attrezzi = new ArrayList<Attrezzo>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	
	
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		boolean verificaNuovaDirezione = false;
		if(this.stanzeAdiacenti.containsKey(direzione)) {
			this.stanzeAdiacenti.put(direzione, stanza);
			verificaNuovaDirezione = true;
		}
		if(!verificaNuovaDirezione) {
			if(this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.stanzeAdiacenti.put(direzione, stanza);
				this.numeroStanzeAdiacenti++;
			}
		}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		if(this.stanzeAdiacenti.containsKey(direzione))
			stanza = this.stanzeAdiacenti.get(direzione);
			return stanza;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Collection<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI) {
			this.numeroAttrezzi++;
			return this.attrezzi.add(attrezzo);
		}
		else
			return false;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nPuoi andare: ");
		for (String direzione : this.getDirezioni())
			if (direzione!=null)
				risultato.append(" " + direzione);
		if(numeroAttrezzi != 0) {
			risultato.append("\nAttrezzi nella stanza: ");
			for (Attrezzo attrezzo : this.attrezzi) {
				if(attrezzo != null)
					risultato.append(attrezzo.toString()+" ");
			}
		}
		else
			risultato.append("\nLa stanza non contiene attrezzi.");

		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a: this.attrezzi) {
			if(a.getNome().equals(nomeAttrezzo))
				return true;
		}
		return false;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a : this.attrezzi) {
			if(a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null) {
			this.attrezzi.remove(attrezzo);
			return true;
		}
		else
		return false;
	}
	
	
	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}
	
	@Override
	public boolean equals(Object o) {
		Stanza that = (Stanza)o;
		return this.getNome().equals(that.getNome());
	}
	
	@Override
	public int hashCode() {
		return numeroAttrezzi + numeroStanzeAdiacenti;
	}
	
}