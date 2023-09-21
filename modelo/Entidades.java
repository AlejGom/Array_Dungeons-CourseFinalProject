package modelo;

public class Entidades {

	protected String url;
	protected String id;
	protected String corazon;
	protected int vida;
	protected int danyoArma;
	
	//Constructor
	public Entidades(String url, String id, int vida, int danyoArma, String corazon) {
		super();
		this.url = url;
		this.id = id;
		this.vida = vida;
		this.danyoArma = danyoArma;
		this.corazon = corazon;
	}
	
	//Getter and Setters
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDanyoArma() {
		return danyoArma;
	}

	public void setDanyoArma(int danyoArma) {
		this.danyoArma = danyoArma;
	}
	public String getCorazon() {
		return corazon;
	}

	public void setCorazon(String corazon) {
		this.corazon = corazon;
	}
}
