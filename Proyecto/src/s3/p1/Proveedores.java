/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.p1;

/**
 *
 * @author deivi
 */
public class Proveedores extends DatosH
{

    private int clave;
    private String producto;

    public Proveedores()
    {
        super();
    }

    public Proveedores(int clave, String producto)
    {
        this.clave = clave;
        this.producto = producto;
    }

    //Creamos constructor que reciba los datos necesarios para un Proveedor.
    public Proveedores(String nombre, String direccion, String correo, int tel,
            String rfc, int clave, String producto)
    {
        super(nombre, direccion, correo, rfc, tel);
        this.clave = clave;
        this.producto = producto;
    }

    /**
     * @return the clave
     */
    public int getClave()
    {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(int clave)
    {
        this.clave = clave;
    }

    /**
     * @return the producto
     */
    public String getProducto()
    {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto)
    {
        this.producto = producto;
    }

    @Override
    public String desp()
    {

        return "Clave " + getClave() + "\n"
                + "Producto " + getProducto();
    }
}
