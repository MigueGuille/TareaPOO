package Clase5;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoPersona {

	public static void main(String[] args) {

		Empleados Empleado_1 = new Empleados("Miguel",200.21,2013,7,14,1);
		System.out.println(Empleado_1.DameNombre());
		System.out.println(Empleado_1.dameDescripcion());
		System.out.println(Empleado_1.damefechaContrato());
		System.out.println(Empleado_1.dameSueldo());
		
		Empleados Empleado_2 = new Empleados("Rafael",230.11,2021,6,16,2);
		System.out.println(Empleado_2.DameNombre());
		System.out.println(Empleado_2.dameDescripcion());
		System.out.println(Empleado_2.damefechaContrato());
		System.out.println(Empleado_2.dameSueldo());
		
		Empleados Empleado_3 = new Empleados("Alejandro",530.25,2015,2,34,3);
		System.out.println(Empleado_3.DameNombre());
		System.out.println(Empleado_3.dameDescripcion());
		System.out.println(Empleado_3.damefechaContrato());
		System.out.println(Empleado_3.dameSueldo());
		
		Empleados Empleado_4 = new Empleados("Paola",352.62,2006,9,25,4);
		System.out.println(Empleado_4.DameNombre());
		System.out.println(Empleado_4.dameDescripcion());
		System.out.println(Empleado_4.damefechaContrato());
		System.out.println(Empleado_4.dameSueldo());
		
		Empleados Empleado_5 = new Empleados("Isabella",469.23,2012,4,22,5);
		System.out.println(Empleado_5.DameNombre());
		System.out.println(Empleado_5.dameDescripcion());
		System.out.println(Empleado_5.damefechaContrato());
		System.out.println(Empleado_5.dameSueldo());

	}

}


abstract class Persona {
	
	String nombre;
	
	public Persona(String nom) {	
		this.nombre = nom;
		
	}
	
	public String DameNombre() {
		return this.nombre;
		
	}
	
	public abstract String dameDescripcion();
	
}

 class Empleados extends Persona {
	
	private double sueldo;
	private Date altaContrato;
	private int Id;
	
	public Empleados(String nom, double sue, int agno, int mes, int dia, int Id) {
		super(nom);
		this.sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);
		altaContrato = calendario.getTime();
		this.Id = Id;
		}
	
	public String dameDescripcion() {
		return "Este empleado tiene un Id "+ Id+" con un sueldo de "+ sueldo;
		
	}
	public String devuelveDatos() {
		return "El nombre es: "+ " y su Id es: "+ Id;
	}
	
	public double dameSueldo() {
		return sueldo;
	}
	
	public Date damefechaContrato() {
		return altaContrato;
	}
	
	public void subSueldo(double porcentaje) {
		double aumento = (sueldo*porcentaje)/100;
		
		sueldo += aumento;
	}
	
	
}