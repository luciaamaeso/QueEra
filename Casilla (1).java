package src;

public class Casilla 
{
	// Atributos
	private String descripcion;
	private boolean transitable;
	
	// Constructora
	public Casilla(String pDescripcion, boolean pTransitable)
	{
		this.descripcion = pDescripcion;
		this.transitable = pTransitable;
	}
	
	public void setVisible(boolean pTransitable)
	{
		this.transitable = pTransitable;
	}
	
	public boolean verSiTransitable()
	{
		return this.transitable;
	}
	
	public void pasarCosas()
	{
		System.out.println(descripcion);
	}

	public String getDescripcion()
	{
		return this.descripcion;
	}
}
