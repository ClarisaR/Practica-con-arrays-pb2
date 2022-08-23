package dominio;

import java.util.Iterator;

public class SalaDeCine {
	private Integer cantidadDeButacas;
	private Integer cantidadDeFilas;
	private Butaca butacas[][];
	private Integer cantidadDeColumnas;
	
	public SalaDeCine(Integer cantidadDeButacas, Integer cantidadDeFilas) {
		this.cantidadDeButacas = cantidadDeButacas;
		this.cantidadDeFilas = cantidadDeFilas;
		this.cantidadDeColumnas = this.cantidadDeButacas/this.cantidadDeFilas;
		this.butacas = new Butaca [this.cantidadDeFilas][this.cantidadDeColumnas];
	}

	public boolean butacaOcupada(Integer fila, Integer asiento) {
		if(this.butacas[fila][asiento]!=null) {
			return true;
		}
		return false;
	}
	
	public boolean ocuparButaca(Integer fila, Integer asiento) {
		if(this.butacas[fila][asiento]==null) {
			this.butacas[fila][asiento] = new Butaca();
			return true;
		}
		return false;
	}
	
	public Integer calcularButacasOcupadas() {
		Integer cantidadDeButacasOcupadas = 0;
		for (int i = 0; i < this.cantidadDeFilas; i++) {
			for (int j = 0; j < this.cantidadDeColumnas; j++) {
				if(this.butacas[i][j]!=null) {
					cantidadDeButacasOcupadas++;
				}
			}
		}
		return cantidadDeButacasOcupadas;
	}
	
	public boolean hayEspacioPara(Integer cantidadDePersonas) {
		Integer cantidadDeAsientosDisponiblesPorFila = 0;
		for (int i = 0; i < this.cantidadDeFilas; i++) {
			for (int j = 0; j < this.cantidadDeColumnas; j++) {
				if(this.butacas[i][j]==null) {
					cantidadDeAsientosDisponiblesPorFila++;
					if(cantidadDeAsientosDisponiblesPorFila>=cantidadDePersonas) {
						return true;
					}
				}else {
					cantidadDeAsientosDisponiblesPorFila = 0;
				}
			}
			cantidadDeAsientosDisponiblesPorFila = 0;
		}
		return false;
	}

	

	public Integer getCantidadDeColumnas() {
		return cantidadDeColumnas;
	}

	public Integer getCantidadDeFilas() {
		return cantidadDeFilas;
	}
	
	
}
