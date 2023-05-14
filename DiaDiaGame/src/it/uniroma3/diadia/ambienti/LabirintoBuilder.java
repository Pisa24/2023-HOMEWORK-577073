package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	
	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> nomeStanze;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nomeStanze = new HashMap<String, Stanza>();
	}
	
	public Map<String, Stanza> getNomeStanze(){
		return nomeStanze;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public LabirintoBuilder addStanzaIniziale(String iniziale) {
		Stanza i = new Stanza(iniziale);
		this.labirinto.setStanzaInizio(i);
		this.ultimaStanzaAggiorna(i);
		return this;
	}
	
	public LabirintoBuilder addStanzaFinale(String finale) {
		Stanza i = new Stanza(finale);
		this.labirinto.setStanzaVincente(i);
		this.ultimaStanzaAggiorna(i);
		return this;
	}
	
	public LabirintoBuilder addStanza(String s) {
		Stanza i = new Stanza(s);
		this.ultimaStanzaAggiorna(i);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		Attrezzo a = new Attrezzo(nome, peso);
		if(this.ultimaStanzaAggiunta == null)
			return this;
		this.ultimaStanzaAggiunta.addAttrezzo(a);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, String direzione) {
		Stanza c = this.nomeStanze.get(stanzaCorrente);
		Stanza a = this.nomeStanze.get(stanzaAdiecente);
		c.impostaStanzaAdiacente(direzione, a);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String magic) {
		Stanza i = new StanzaMagica(magic);
		this.ultimaStanzaAggiorna(i);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nome, String fonteLux) {
		Stanza i = new StanzaBuia(nome,fonteLux);
		this.ultimaStanzaAggiorna(i);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nome, String direzioneBlock, String chiave) {
		Stanza i = new StanzaBloccata(nome,direzioneBlock, chiave);
		this.ultimaStanzaAggiorna(i);
		return this;
	}
	
	
	public void ultimaStanzaAggiorna(Stanza s) {
		this.ultimaStanzaAggiunta = s;
		this.nomeStanze.put(s.getNome(), s);
	}
}
