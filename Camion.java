package clase3;

public class Camion {
	private int Cauchos;
	private double Motor;
	private int largo;
	private int CanBateria;
	private int peso;
	private int pesot;
	private boolean Carga, ReservaGasolina;
	
	public Camion() {
		Cauchos = 8;
		Motor = 2400;
		largo = 20;
		CanBateria = 2;
		peso = 7;	
	}
	
	public String DatosG() {
		return "El Camion tiene " +Cauchos+ " Ruedas, tiene un largo de "+largo+" metros y un motor de "+Motor+" con "+CanBateria+" Baterias";
	}
	
	public void ConfiCarga(String Carga) {
		if(Carga.equalsIgnoreCase("Si")) {
			this.Carga = true;
		}
	}
	
	public String GetCarga() {
		if(Carga == true) {
			return " tiene una carga añadida ";
		}else {
			return " No tiene una Carga añadida ";
		}
		
	}
	
	public void ConfiGaso(String ReservaGasolina) {
		if(ReservaGasolina.equalsIgnoreCase("Si")) {
			this.ReservaGasolina = true;
		}
	}
	
	public String GetGasolina() {
		if(ReservaGasolina == true) {
			return " tiene una Reserva de Gasolina ";
		}else {
			return " No tiene una Reserva de Gasolina ";
		}
	}
	
	public String GetPesoCamion() {
		int pesoRemolque = 1;
		pesot = pesoRemolque + peso;
		
		if(Carga == true) {
			pesot = pesot + 4;
		}
		if(ReservaGasolina == true) {
			pesot = peso + 1;
		}
		return " el Peso del Camion es: "+ pesot+ "Toneladas";
	}
	
	
}
