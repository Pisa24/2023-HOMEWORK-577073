package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private IO io;
	private String nomeAttrezzo;

	public ComandoPrendi(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}

	@Override
	public void setParametro(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			io.mostraMessaggio("Cosa?");
			return;
		}
		if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			if(partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo).getPeso()+partita.getGiocatore().getBorsa().getPeso()<=partita.getGiocatore().getBorsa().getPesoMax()) {
				Attrezzo att = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
				partita.getGiocatore().getBorsa().addAttrezzo(att);
				partita.getStanzaCorrente().removeAttrezzo(att);
				io.mostraMessaggio("Attrezzo preso!");
				io.mostraMessaggio("Ora in borsa hai: ");
				io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
			}
			else
				io.mostraMessaggio("Attrezzo troppo pesante!");
		}
		else
			io.mostraMessaggio("Attrezzo insesistente!");
	}

	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
}
