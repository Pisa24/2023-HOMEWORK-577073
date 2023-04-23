package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public interface Comando {
	
	/**
	* esecuzione del comando
	*/
	public void esegui(Partita partita);

	/**
	* set parametro del comando
	*/
	public void setParametro(String parametro);
	
	/*
	 * restituisce il nome del comando
	 */
	public String getNome();
	
	/*
	 * restituisce il parametro, se c'è
	 */
	public String getParametro();
	
	/*
	 * 
	 */
	public void setIo(IO io);
}
