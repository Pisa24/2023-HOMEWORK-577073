package it.uniroma3.diadia.personaggi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	Scanner sc;
	private IO io = new IOConsole(sc);
	private String nome;
	private String presentazione;
	private boolean haSalutato;

	public AbstractPersonaggio(String nome, String presentazione) {
		this.nome = nome;
		this.presentazione = presentazione;
		this.haSalutato = false;
	}

	public String getNome() {
		return this.nome;
	}

	public String getPresentazione() {
		return this.presentazione;
	}
	
	public boolean getHaSalutato() {
		return this.haSalutato;
	}

	public void saluta() {
		io.mostraMessaggio("Ciao, io sono ");
		io.mostraMessaggio(this.getNome()+".");
		if (!haSalutato)
			io.mostraMessaggio(this.presentazione);
		else
			io.mostraMessaggio("Ci siamo già presentati...");

		this.haSalutato = true;
	}
	
	
	public abstract String agisci(Partita p);
	
	public abstract String riceviRegalo(Attrezzo attrezzo, Partita p);
	
	@Override
	public String toString() {
		return this.getNome();
	}
}
