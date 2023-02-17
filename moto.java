package clase3;

public class moto {
	private int cauchos;
	private String color;
	private int capgaso;
	private boolean cascos;
	private int precioi;
	private int preciof;
	
	public moto() {
		cauchos = 2;
		capgaso = 20;
		precioi = 1200;
	}
	
	public String DatosGM() {
		return "La moto tiene "+cauchos+" Ruedas, tiene una capacidad de "+capgaso+" Litros y un precio de "+ preciomoto();
	}
	
	public void setcolor(String colorC) {
		color = colorC;
		
	}
	
	public String getcolor() {
		return "el color de la moto es: "+ color;
	}
	
	public void setcascos(String cascos) {
		if(cascos.equalsIgnoreCase("Si")) {
			this.cascos = true;
		}
	}
		public int preciomoto() {
			preciof = precioi;
			if(cascos == true) {
				preciof = precioi + 200;
			}
				return preciof;
		}
	

}
