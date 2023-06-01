package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando{
	
	private IO io;
	private final static String NOME = "fine";
	public static final String MESSAGGIO_FINE = "L'importante è partecipare!";
	
	@Override 
	public void esegui(Partita partita) {
		partita.setFinita();
		 io.mostraMessaggio(MESSAGGIO_FINE);;  // si desidera smettere
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
