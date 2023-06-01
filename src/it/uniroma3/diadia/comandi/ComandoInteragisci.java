package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoInteragisci extends AbstractComando{

	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio() != null)
			partita.getStanzaCorrente().getPersonaggio().agisci(partita);
		else {
			this.getIo().mostraMessaggio("Non c'è nessuno qui in giro!\n");
		}
	}

}
