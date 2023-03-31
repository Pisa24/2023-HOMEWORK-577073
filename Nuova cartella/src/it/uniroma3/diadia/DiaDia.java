package it.uniroma3.diadia;

import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine"};

	private Partita partita;
	private IOConsole io;

	public DiaDia(IOConsole console) {
		this.io = console;
		this.partita = new Partita();
	}

	public void setPartita(Partita p) {
		this.partita = p;
	}

	public Partita getPartita() {
		return this.partita;
	}

	public void gioca() {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if(comandoDaEseguire.getNome()==null) {
			io.mostraMessaggio("Non hai inserito alcun comando!");
			return false;
		}
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		}
		else
			if(comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
			else
				if(comandoDaEseguire.getNome().equals("posa"))
					this.posa(comandoDaEseguire.getParametro());
				else
					if (comandoDaEseguire.getNome().equals("vai"))
						this.vai(comandoDaEseguire.getParametro());
					else
						if (comandoDaEseguire.getNome().equals("aiuto"))
							this.aiuto();
						else
							io.mostraMessaggio("Non è un comando valido! >:/ ");
		if (this.partita.vinta()) {
			io.mostraMessaggio("You Won!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		io.mostraMessaggio("I comandi disponibili sono:");
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ?");
			return;
		}
		Stanza prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Oh oh, di là non ci si può andare...");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
			io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}
	}

	/**
	 * gli attrezzi presi vengono rimossi dalla stanza e aggiunti alla borsa
	 */
	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			io.mostraMessaggio("Cosa?");
			return;
		}
		if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo att = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			this.partita.getGiocatore().getBorsa().addAttrezzo(att);
			this.partita.getStanzaCorrente().removeAttrezzo(att);
			io.mostraMessaggio("Attrezzo preso!");
			io.mostraMessaggio("Ora in borsa hai: ");
			io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		}
		else
			io.mostraMessaggio("Attrezzo insesistente!");
	}

	/**
	 * gli attrezzi posati vengono rimossi dalla borsa e aggiunti alla stanza
	 */
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			io.mostraMessaggio("Cosa?");
			return;
		}
		if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo att = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			this.partita.getStanzaCorrente().addAttrezzo(att);
			this.getPartita().getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			io.mostraMessaggio("Attrezzo posato!");
			io.mostraMessaggio("Ora in borsa hai: ");
			io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		}
		else
			io.mostraMessaggio("Non hai quest'attrezzo!");
	}
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("L'importante è partecipare!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}