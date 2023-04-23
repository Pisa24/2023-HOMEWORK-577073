package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


public class ComandoVai implements Comando{
	private String direzione;
	private IO io;

	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	@Override
	public void esegui(Partita partita) {
		
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(direzione == null) {
			io.mostraMessaggio("Dove vuoi andare? Specifica la direzione.");
			return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza == null) {
			io.mostraMessaggio("Oh oh, di là non ci si può andare...");
		    return;
		}
		
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

	@Override
	public String getNome() {
		return "vai";
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}
}

