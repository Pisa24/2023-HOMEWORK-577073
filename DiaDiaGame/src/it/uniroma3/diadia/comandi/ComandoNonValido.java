package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	private IO io;
	
	@Override
	public void setParametro(String parametro) {
	}
	
	@Override 
	public void esegui(Partita partita) {
		io.mostraMessaggio("Mi dispiace ma questo non è un comando valido.");  // si desidera smettere
	}

	@Override
	public String getNome() {
		return "comando non valido";
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
}
