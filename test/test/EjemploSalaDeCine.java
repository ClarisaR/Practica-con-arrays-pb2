package test;

import java.util.Scanner;

import dominio.SalaDeCine;

public class EjemploSalaDeCine {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Integer opcion;
		Integer asiento;
		Integer fila;
		Integer cantidadDePersonas;
		
		SalaDeCine cineMark = new SalaDeCine(20, 5);
		
		
		opcion = menuSalaDeCine(teclado);
		while(opcion!=5) {
			switch (opcion) {
			case 1:{
				do {
				System.out.println("Fila:");
				fila = teclado.nextInt();
				System.out.println("Asiento: ");
				asiento = teclado.nextInt();
				}while(fila>=cineMark.getCantidadDeFilas() || asiento>=cineMark.getCantidadDeColumnas());
				
				if(!cineMark.butacaOcupada(fila, asiento)) {
					System.out.println("El asiento indicado se encuentra disponible.");
				}else {
					System.out.println("El asiento indicado esta ocupado.");
				}
				
				break;
			}
			case 2:{
				do {
					System.out.println("Fila:");
					fila = teclado.nextInt();
					System.out.println("Asiento: ");
					asiento = teclado.nextInt();
					}while(fila>=cineMark.getCantidadDeFilas() || asiento>=cineMark.getCantidadDeColumnas());
				
				if(cineMark.ocuparButaca(fila, asiento)) {
					System.out.println("Butaca asignada con exito.");
				}else {
					System.out.println("La butaca ya esta ocupada.");
				}
				break;
			}

			case 3:{
				System.out.println("La cantidad total de butacas ocupadas es: "+cineMark.calcularButacasOcupadas());
				break;
			}

			case 4:{
				System.out.println("Ingrese cantidad de personas: ");
				cantidadDePersonas = teclado.nextInt();
				if(cineMark.hayEspacioPara(cantidadDePersonas)) {
					System.out.println("Hay asientos contiguos disponibles para "+ cantidadDePersonas + " personas.");
				}else {
					System.out.println("No hay asientos contiguos disponibles para "+cantidadDePersonas+ " personas.");
				}
				break;
			}
			default:
				break;
			}
			
			opcion = menuSalaDeCine(teclado);
		}
		
		
	
	}

	private static Integer menuSalaDeCine(Scanner teclado) {
		Integer opcionElegida = 0;
		System.out.println("Bienvenido a la Sala de Cine");
		System.out.println("1-Consultar si una butaca esta ocupada.");
		System.out.println("2-Ocupar butaca.");
		System.out.println("3-Consultar la cantidad total de butacas ocupadas.");
		System.out.println("4-Ubicar personas en la misma fila.");
		System.out.println("5-Salir");
		
		opcionElegida = teclado.nextInt();
		
		return opcionElegida;
	}
}
