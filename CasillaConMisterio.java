package Proyecto;

public class CasillaConMisterio extends Casilla
{
	// Atributos
	private int solucion; // Más los de la super no olvidemos
	
	// Constructora
	public CasillaConMisterio(int pCoordenadas, String pDescripcion, boolean pVisible, int pSolucion)
	{
		super(pCoordenadas, pDescripcion, pVisible);
		this.solucion = pSolucion;
	}

	public boolean verSiTransitable()
	{
		return super.verSiTransitable();
	}
	
	public void pasarCosas()
	{
		super.pasarCosas();
		// Comprobar si en el inventario hay un objeto con la misma solución
		Jugador jugador = getMiJugador;
		if (jugador.solucionEncontrada(this.solucion))
		{
			
		}
	}
}
