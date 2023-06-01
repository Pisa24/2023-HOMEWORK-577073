package it.uniroma3.diadia.personaggi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	Scanner sc;
	private IO io=  new IOConsole(sc);
	
	private static final String MESSAGGIO_CHILL = "Hi hi hi... allontanati sgorbio..";
	private static final String MESSAGGIO_ARRABBIATA = "Hi hi hi, non mi saluti nemmeno??? te la sei cercata, hi hi hi.";

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita p) {
		if(getHaSalutato()) 
			io.mostraMessaggio(MESSAGGIO_CHILL);  //non ti fa nulla
		else {
			io.mostraMessaggio(MESSAGGIO_ARRABBIATA);;
			this.stregaArrabbiata(p);
		}
		return "";
	}

	private void stregaArrabbiata(Partita p) {
		p.setStanzaCorrente(p.getLabirinto().getStanzaIniziale());//ti rimanda nella stanza iniziale
		io.mostraMessaggio(p.getStanzaCorrente().toString());
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita p) {
		io.mostraMessaggio("Hi hi hi hi, Sciocco, Sciocco!");
		return "";
	}

}
