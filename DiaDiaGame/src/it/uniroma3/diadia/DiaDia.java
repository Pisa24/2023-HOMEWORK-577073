package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

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
			"Per conoscere le istruzioni usa il comando 'aiuto'.\n\n"+ 
			"La tua posizione è:\n";

	private Partita partita;
	private IO io;

	public DiaDia(IO io, Labirinto labirinto) {
		this.io = io;
		this.partita = new Partita(labirinto);
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
		this.getPartita().setStanzaCorrente(this.getPartita().getLabirinto().getStanzaInizio());
		io.mostraMessaggio(this.getPartita().getStanzaCorrente().toString());
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

		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(this.io);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			io.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}


	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 2)
				.addStanza("Aula N11")
				.addAttrezzo("incudine", 15)
				.addStanza("Aula N10")
				.addAttrezzo("lanterna", 3)
				.addStanza("Laboratorio Campus")
				.addStanza("Mensa")
				.addAttrezzo("piatto", 1)
				.addStanza("Bar")
				.addAttrezzo("tazzina", 1)
				.addStanzaMagica("Bagno")
				.addAttrezzo("arco", 2)
				.addStanzaBloccata("Giardino", "est", "osso")
				.addAttrezzo("pistola ad acqua", 2)
				.addStanza("AulaMagna")
				.addAttrezzo("santoGraal", 4)
				.addStanzaBuia("Stanzino", "santoGraal")
				.addAttrezzo("cacciavite inutile", 1)
				.addStanzaFinale("Biblioteca")
				.addAdiacenza("Atrio", "Aula N11", "est")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Atrio", "Aula N10", "sud")
				.addAdiacenza("Atrio", "Laboratorio Campus", "ovest")
				.addAdiacenza("Aula N11", "Laboratorio Campus", "est")
				.addAdiacenza("Aula N11", "Atrio", "ovest")
				.addAdiacenza("Aula N11", "Giardino", "nord")
				.addAdiacenza("Aula N10", "Atrio", "nord")
				.addAdiacenza("Aula N10", "Aula N11", "est")
				.addAdiacenza("Aula N10", "Laboratorio Campus", "ovest")
				.addAdiacenza("Aula N10", "Mensa", "sud")
				.addAdiacenza("Laboratorio Campus", "Atrio", "est")
				.addAdiacenza("Laboratorio Campus", "Aula N11", "ovest")
				.addAdiacenza("Laboratorio Campus", "Bagno", "sud")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.addAdiacenza("Mensa", "Aula N11", "nord")
				.addAdiacenza("Mensa", "Bar", "sud")
				.addAdiacenza("Mensa", "Stanzino", "ovest")
				.addAdiacenza("Bar", "Mensa", "nord")
				.addAdiacenza("Bagno", "Laboratorio Campus", "nord")
				.addAdiacenza("Bagno", "Aula N10", "est")
				.addAdiacenza("Bagno", "Stanzino", "sud")
				.addAdiacenza("Giardino", "Aula N11", "sud")
				.addAdiacenza("Giardino", "AulaMagna", "est")
				.addAdiacenza("AulaMagna", "Giardino", "ovest")
				.addAdiacenza("Stanzino", "Mensa", "est")
				.addAdiacenza("Stanzino", "Bagno", "nord")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
	}
}