package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/*
 * comando che stampa le informazioni sulla stanza corrent e sullo stato della partita
 */
public class ComandoGuarda extends AbstractComando {
	
	private final static String NOME = "guarda";

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Ti trovi nella stanza: ");
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.getIo().mostraMessaggio("Attualmente hai: " + partita.getGiocatore().getCfu()+ " CFU");
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
