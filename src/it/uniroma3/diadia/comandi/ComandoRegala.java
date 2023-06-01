package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{
	Scanner sc;
	private IO io = new IOConsole(sc);

	@Override
	public void esegui(Partita partita) {
		if(this.getParametro()==null) {
			io.mostraMessaggio("cosa?");
			return;
		}
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
		io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita));
		partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
	}

	
}
