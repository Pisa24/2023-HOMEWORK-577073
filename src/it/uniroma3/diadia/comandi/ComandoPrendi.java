package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{
	
	private final static String NOME = "prendi";

	
	@Override
	public void esegui(Partita partita) {
		if(this.getParametro()==null)
			this.getIo().mostraMessaggio("Cosa?");
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(this.getParametro());
		if(a == null)
			this.getIo().mostraMessaggio("Non c'è un attrezzo con questo nome.");
		else {
			if(partita.getGiocatore().getBorsa().getPesoRimanente(a)>0) {
				partita.getStanzaCorrente().removeAttrezzo(a);
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				this.getIo().mostraMessaggio("Preso!");
				this.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
			}
			else
				this.getIo().mostraMessaggio("Troppo pesante!");
		}
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
