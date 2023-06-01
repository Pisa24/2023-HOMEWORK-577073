package it.uniroma3.diadia.ambienti;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;


/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	private static final int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Set<Attrezzo> attrezzi;
	private Map<Direzione, Stanza> stanzeAdiacenti;
	private int numeroAttrezzi;
	private int numeroStanzeAdiacenti;
	private AbstractPersonaggio p;
	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.attrezzi = new TreeSet<>();
		this.stanzeAdiacenti = new HashMap<>();
		this.numeroAttrezzi = 0;
		this.numeroStanzeAdiacenti = 0;
	}

	public List<Stanza> getStanzeAdiacenti() {
		return (List<Stanza>) stanzeAdiacenti.values();
	}

	public void setStanzeAdiacenti(Map<Direzione, Stanza> stanzeAdiacenti) {
		this.stanzeAdiacenti = stanzeAdiacenti;
	}

	public int getNumeroStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}

	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) {
		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
	}

	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		boolean aggiornato = false;

		if (stanzeAdiacenti.containsKey(direzione)) {
			this.stanzeAdiacenti.put(direzione,stanza);
			aggiornato = true;
		}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.stanzeAdiacenti.put(direzione,stanza);
				this.numeroStanzeAdiacenti++;
			}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(Direzione direzione) {
		Stanza stanza = null;
		if (this.stanzeAdiacenti.containsKey(direzione))
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
		if(this.numeroAttrezzi<NUMERO_MASSIMO_ATTREZZI) {
			this.numeroAttrezzi++;
			return this.attrezzi.add(attrezzo);
		}
		else
			return false;
	}
	
	public String getDescrizioneAttrezzi() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("\nAttrezzi:");
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo != null)
				risultato.append(attrezzo.toString()+" ");
			risultato.append("\n");
		}
		return risultato.toString();
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
		risultato.append(this.getDirezioni().toString());
		if(this.attrezzi.size() == 0)
			risultato.append("\nStanza senza attrezzi.\n");
		else {
			risultato.append("\nAttrezzi:");
			for (Attrezzo attrezzo : this.attrezzi) {
				if(attrezzo != null)
					risultato.append(attrezzo.toString()+" ");
				risultato.append("\n");
			}
		}
		if(this.p != null)
			risultato.append("Intravedo: " + p.toString() + ". Sarà amichevole?\n");
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a: attrezzi) {
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
		for(Attrezzo a : attrezzi) {
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


	public Set<Direzione> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}
	
	public void setPersonaggio(AbstractPersonaggio p) {
		this.p = p;	
	}
	
	public AbstractPersonaggio getPersonaggio() {
		return this.p;
	}
	
	
	@Override
	public boolean equals(Object o) {
		Stanza that = (Stanza)o;
		return this.getNome().equals(that.getNome());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode() + this.getDescrizione().hashCode();
	}
	
}