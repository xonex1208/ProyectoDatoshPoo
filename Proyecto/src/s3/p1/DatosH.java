/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.p1;

import java.io.Serializable;

/**
 *
 * @author deivi
 */
public class DatosH
        implements Serializable
{

    private String nombre;
    private String direccion;
    private String correo;
    private String rfc;
    private int telefono;
    //para que vaya cambiando la version
    public static final long SerialVersionUID = 1l;

    public DatosH()
    {
        super();
    }

    public DatosH(String nombre, String direccion, String correo, String rfc, int telefono)
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.rfc = rfc;
        this.telefono = telefono;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion()
    {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    /**
     * @return the correo
     */
    public String getCorreo()
    {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    /**
     * @return the rfc
     */
    public String getRfc()
    {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc)
    {
        this.rfc = rfc;
    }

    /**
     * @return the telefono
     */
    public int getTelefono()
    {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono)
    {
        this.telefono = telefono;
    }

    public String desp()
    {

        return "Nombre " + getNombre() + "\n"
                + "Direccion " + getDireccion() + "\n"
                + "Correo " + getCorreo() + "\n"
                + "Telefono " + getTelefono() + "\n"
                + "RFC " + getRfc();
    }

    /**
     * Constructor que muestra los datos guardados dependiendo de la opcion
     * previamente selecciona el el metodo consulta()
     *
     * @return Las propiedades de la clase
     */
    public String muestra()
    {

        return "\nNombre " + getNombre() + "\n"
                + "Direccion " + getDireccion() + "\n"
                + "Correo " + getCorreo() + "\n"
                + "Telefono " + getTelefono() + "\n"
                + "RFC " + getRfc() + "\n"
                + "============";

    }
}
