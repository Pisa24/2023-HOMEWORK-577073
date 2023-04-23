package it.uniroma3.diadia.ambienti;

/*
 * stanza buia: non permette di leggere la descrizione della stanza ammeno che
 * non si abbia lo strumento adatto;
 */
public class StanzaBuia extends Stanza{
	private String fonteDiLuce;
	private String buio = "qui c'è un buio pesto...";

	public StanzaBuia(String nome, String fonteDiLux) {
		super(nome);
		this.fonteDiLuce = fonteDiLux;
	}

	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(this.fonteDiLuce))
			return super.getDescrizione();
		else
			return buio;
	}
}
