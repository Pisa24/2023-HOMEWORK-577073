package it.uniroma3.diadia.personaggi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	
	Scanner sc;
	private IO io =  new IOConsole(sc);

	private static final String  MESSAGGIO_BAU = "Bau bau bau.. bau!\n";
	private static final String MESSAGGIO_BAUBAU = "WOOOf WOOf woooof!!(Basta ti tolgo un CFU)";

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita p) {
		if(!getHaSalutato())
			io.mostraMessaggio(MESSAGGIO_BAU);
		else {
			io.mostraMessaggio(MESSAGGIO_BAUBAU) ;
			int a = p.getGiocatore().getCfu()-1;
			p.getGiocatore().setCfu(a);
			io.mostraMessaggio("cfu: ["+ p.getGiocatore().getCfu()+"]");
		}
		return "";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita p) {
		Attrezzo osso = new Attrezzo("Osso", 2);
		Attrezzo a = new Attrezzo("palla", 1);
		if(attrezzo.equals(osso)) {
			io.mostraMessaggio("Bau Bau wooof(grazie chicco! Tieni questa pallina)");
			p.getStanzaCorrente().addAttrezzo(a);
			io.mostraMessaggio(p.getStanzaCorrente().getDescrizioneAttrezzi());
		}
		else {
			io.mostraMessaggio("BaU bau BBAAAu!(ma che m'hai dato?)");
			int b = p.getGiocatore().getCfu()-1;
			p.getGiocatore().setCfu(b);
			io.mostraMessaggio("cfu: ["+ p.getGiocatore().getCfu()+"]");
		}
		return "";
	}

}