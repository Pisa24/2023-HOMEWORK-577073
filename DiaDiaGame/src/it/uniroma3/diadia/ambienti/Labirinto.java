package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.attrezzi.Attrezzo;

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
	
    public void creaStanze() {
		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo piatto = new Attrezzo ("piatto", 1);
		Attrezzo tazzina = new Attrezzo ("tazzina", 1);
		Attrezzo arco = new Attrezzo ("arco", 2);
		Attrezzo incudine = new Attrezzo("incudine", 15);
		
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza ("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza mensa = new Stanza("Mensa");
		Stanza bar = new Stanza("Bar");
		StanzaMagica gabinetto = new StanzaMagica("Gabinetto",3);
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN10.impostaStanzaAdiacente("sud", mensa);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		laboratorio.impostaStanzaAdiacente("sud", gabinetto);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		mensa.impostaStanzaAdiacente("nord", aulaN10);
		mensa.impostaStanzaAdiacente("sud", bar);
		bar.impostaStanzaAdiacente("nord", mensa);
		gabinetto.impostaStanzaAdiacente("nord", laboratorio);
		gabinetto.impostaStanzaAdiacente("est", aulaN10);
		

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		mensa.addAttrezzo(piatto);
		bar.addAttrezzo(tazzina);
		gabinetto.addAttrezzo(arco);
		aulaN11.addAttrezzo(incudine);

		// il gioco comincia nell'atrio
		stanzaInizio = atrio;
		this.stanzaVincente = biblioteca;
    }
    
    public Stanza getStanzaVincente() {
		return stanzaVincente;
    }
    
    public void setStanzaInizio(Stanza atrio) {
    	this.stanzaInizio = atrio;
    }
    
    public Stanza getStanzaInizio() {
    	return stanzaInizio;
    }
	
}
