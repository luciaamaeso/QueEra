package Proyecto;

public class Casilla 
{
	// Atributos
	private int coordenadas;
	private String descripcion;
	private boolean visible;
	
	// Constructora
	public Casilla(int pCoordenadas, String pDescripcion, boolean pVisible)
	{
		this.coordenadas = pCoordenadas;
		this.descripcion = pDescripcion;
		this.visible = pVisible;
	}
	
	public void setVisible(boolean pVisible)
	{
		this.visible = pVisible;
	}
	
	public boolean verSiTransitable()
	{
		return this.visible;
	}
	
	public void pasarCosas()
	{
		System.out.println(descripcion);
	}
}
