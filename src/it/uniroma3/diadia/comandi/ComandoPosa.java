package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando{

	private final static String NOME = "posa";

	@Override
	public void esegui(Partita partita) {
		if(getParametro() == null)
			this.getIo().mostraMessaggio("cosa?");
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
		if(a==null) {
			this.getIo().mostraMessaggio("Questo Attrezzo non c'è.");
			return;
		}
		if(partita.getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
			this.getIo().mostraMessaggio("Posato!"
					+ "Ora hai:\n");
			this.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		}
		else {
			this.getIo().mostraMessaggio("Stanza piena, impossibile posare nulla qua in mezzo.");
		}
	}

	@Override
	public String getNome() {
		return NOME;
	}
}