package it.uniroma3.diadia.personaggi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio{

	Scanner sc;
	private IO io =  new IOConsole(sc);
	private Attrezzo a;
	private static final String  MESSAGGIO_DONO = "'O mio bel viandante che sperduto ti ritrovi"
			+ "quest'oggetto ti farà vincere le più ardue sfide, spero ti giovi.\n";
	private static final String MESSAGGIO_SCUSE = "'O mio bel viandante che sperduto ti ritrovi"
			+ " nun c'ho piu nulla, non mi buttar nei rovi...\n";

	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.a = attrezzo;
	}

	@Override
	public String agisci(Partita p) {
		
		if(a != null) {
			p.getStanzaCorrente().addAttrezzo(a);    //posa un attrezzo nella stanza
			this.a = null;
			io.mostraMessaggio(MESSAGGIO_DONO + p.getStanzaCorrente().getDescrizioneAttrezzi()); 
		}
		else
			io.mostraMessaggio(MESSAGGIO_SCUSE);;  //non fa nulla
			return "";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita p) {
		if(attrezzo == null)
			io.mostraMessaggio("non mi hai dato nulla...");
		else {
			if(attrezzo.getPeso()==1)
				io.mostraMessaggio("o mio bel viandante questo attrezzo è gia leggerissimo!");
			else {
				attrezzo.setPeso(attrezzo.getPeso()/2);
				io.mostraMessaggio("'O mio bel viandante che sperduto ti ritrovi, "
						+ "grazie del bel dono, ricambio dimezzandogli il peso, spero ti giovi");
				p.getStanzaCorrente().addAttrezzo(attrezzo);
				io.mostraMessaggio(p.getStanzaCorrente().getDescrizioneAttrezzi());
			}
		}
		return "";
	}



}
