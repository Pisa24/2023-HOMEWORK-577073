package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	private IO io;

	static final private String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine"};


	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("I comandi disponibili sono:");
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		 io.mostraMessaggio("");
	}

	@Override
	public String getNome() {
		return "aiuto";
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
