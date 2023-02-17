package clase3;

public class Main {

	public static void main(String[] args) {
	 Camion Mack = new Camion();
	 
	 Mack.ConfiCarga("No");
	 Mack.ConfiGaso("Si");
	 
	 System.out.println(Mack.DatosG() +" " + Mack.GetCarga() + Mack.GetGasolina() + Mack.GetPesoCamion());

	 
	 Camion volvo = new Camion();
	 
	 volvo.ConfiCarga("Si");
	 volvo.ConfiGaso("No");
	 
	 System.out.println(volvo.DatosG() +" " + volvo.GetCarga() + volvo.GetGasolina() + volvo.GetPesoCamion());
	 
	 moto suzuki = new moto();
	 suzuki.setcolor("Azul");
	 suzuki.setcascos("Si");
	 
	 System.out.println(suzuki.DatosGM());
	 
	 
	}

}
