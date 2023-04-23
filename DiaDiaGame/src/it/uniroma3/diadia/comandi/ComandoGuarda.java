package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/*
 * comando che stampa le informazioni sulla stanza corrent e sullo stato della partita
 */
public class ComandoGuarda implements Comando {
	private IO io;

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Ti trovi nella stanza: ");
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Attualmente hai: " + partita.getGiocatore().getCfu()+ " CFU");
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getNome() {
		return "guarda";
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
