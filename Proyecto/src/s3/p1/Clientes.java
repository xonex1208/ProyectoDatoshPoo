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
public class Clientes extends DatosH
{

    private double credito;
    private char tipo;

    public Clientes()
    {
        super();
    }

    public Clientes(double credito, char tipo)
    {
        super();
        this.credito = credito;
        this.tipo = tipo;
    }

    /**
     * @return the credito
     */
    public double getCredito()
    {
        return credito;
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(double credito)
    {
        this.credito = credito;
    }

    /**
     * @return the tipo
     */
    public char getTipo()
    {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(char tipo)
    {
        this.tipo = tipo;
    }

    @Override
    public String desp()
    {

        return "Credito " + getCredito() + "\n"
                + "Tipo " + getTipo();
    }

    //Creamos un constructor que reciba los datos necesarios para construir un Cliente.
    public Clientes(String nombre, String direccion, String correo, int tel,
            String rfc, double credito, char tipo)
    {
        super(nombre, direccion, correo, rfc, tel);
        this.credito = credito;
        this.tipo = tipo;
    }
}
