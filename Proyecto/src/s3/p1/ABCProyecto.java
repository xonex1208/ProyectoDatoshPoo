/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.p1;

import s3.Lecturas;

/**
 *
 * @author deivi
 */
public class ABCProyecto
{

    /**
     * recibe el arreglo con el contenido del menu y el tipo de menu
     *
     * @param menu es el arreglo que recibe con las opciones guardadas
     * @param tipoMenu menu general, menu de ABC etc...
     * @return la opcion seleccionada por el usuario
     */
    public static int menu(String[] menu, String tipoMenu)
    {
        /**
         * Despliega el contenido del arreglo mostrando las opc.
         */
        System.out.println("======Menu " + tipoMenu + "======");
        for (int i = 0; i < menu.length; i++)
        {
            System.out.println((i + 1) + "=" + menu[i]);
        }

        System.out.println("Elige una opcion: ");
        return Lecturas.entero();

    }

    /**
     * Metodo que crea un objeto de tipo Cliente o Proveedor.
     *
     * @param opc Recibimos la opcion 1.Clientes o 2.Proveedores.
     * @return el objeto creado de tipo Cliente o Proveedor.
     */
    public static DatosH creaObj(int opc)
    {
        String nombre;
        String direccion;
        String correo;
        String rfc;
        int telefono;
        double credito;
        char tipo;
        int clave;
        String producto;
        int resp;
        int tTipo;
        //Estos datos los comparten Cliente y Proveedor
        System.out.println("Nombre: ");
        nombre = Lecturas.cadena();
        System.out.println("Direccion: ");
        direccion = Lecturas.cadena();
        System.out.println("Correo: ");
        correo = Lecturas.cadena();

        do
        {
            System.out.println("Telefono: ");
            telefono = Lecturas.entero();
            resp = validaDigitos(telefono);
        } while (resp != 1);

        do
        {

            System.out.println("RFC: ");
            rfc = Lecturas.cadena();

            resp = validaRfc(rfc);
        } while (resp != 1);

        //si la opcion es 1 entonces pedimos datos especiales para un Cliente.
        if (opc == 1)
        {

            System.out.println("Credito: ");
            credito = Lecturas.doble();

            do
            {
                System.out.println("Tipo (H,M,L): ");
                tipo = Lecturas.caracter();
                tTipo = validaTipo(tipo);

            } while (tTipo != 1);

            //Creamos un objeto de tipo Cliente.
            return new Clientes(nombre, direccion, correo, telefono, rfc, credito, tipo);

        } else
        //Pedimos datos especiales para el Proveedor.
        {
            System.out.println("Clave: ");
            clave = Lecturas.entero();
            System.out.println("Producto: ");
            producto = Lecturas.cadena();
            //Creamos un objeto de tipo Proveedor.
            return new Proveedores(nombre, direccion, correo, telefono, rfc, clave, producto);
        }

    }

    /**
     * Metodo que inserta un espacio mas en el arreglo para agregar Cliente o
     * Proveedor.
     *
     * @param d es el arreglo que crea un espacio mas para Cliente o Proveedor.
     * @param obj Es el objeto con las propiedades de Cliente o Proveedor.
     * @return un dato insertado en un nuevo espacio para Cliente o Proveedor.
     */
    public static DatosH[] inserta(DatosH d[], DatosH obj)
    {

        //Si no existe ningun dato guardado anteriormente
        if (d == null)
        {
            //Creamos array de una posicion
            d = new DatosH[1];
            //asignamos el contenido de ese objeto a la primera posicion[0]
            d[0] = obj;

        } else
        {
            //Creamos un espacio temporal para el dato a guardar +1.
            DatosH tmp[] = new DatosH[d.length + 1];
            //copiamos el array desde tmp hasta la longitud de d.
            System.arraycopy(d, 0, tmp, 0, d.length);
            //tmp se situa en la ultima posicion y le agrega su 
            // contenido temporala obj
            tmp[d.length] = obj;
            //lo que tiene el array temporal se pasa al array d.
            //de lo contrario no guardaria el siguiente dato
            d = tmp;
        }

        return d;

    }

    /**
     * Metodo que manda llamar al constructor de DatosH y muestra la informacion
     * de Clientes o Proveedores dependiendo de la opcion seleccionada. Recibe
     * el arreglo de los datos y la opcion 1.Clientes 2.Proveedores
     *
     * @return una cadena si esque no existen datos
     */
    public static String consulta(DatosH[] d, int opc)
    {
        String s = "";
        if (d == null)
        {

            s = "No existen datos...";
        } else
        {
            for (int i = 0; i < d.length; i++)
            {
                if (d[i] instanceof Clientes && opc == 1)
                {

                    s += d[i].muestra();
                } else
                {
                    if (d[i] instanceof Proveedores && opc == 2)
                    {
                        s += d[i].muestra();
                    }
                }

            }
            if (s == " ")
            {
                s = "No hay datos de este tipo";
            }

        }
        return s;

    }

    public static int busca(DatosH[] d, int opc, String s)
    {
        if (d == null)
        {
            s = "No existen datos a " + s;

        } else
        {
            System.out.println("Nombre del dato a " + s);
            String dato = Lecturas.cadena();
            for (int i = 0; i < d.length; i++)
            {
//                si lo que recorre el array fue instanciado como un Cliente
//                        y la opc fue 1 y el dato que estamos buscando es igual al
//                                dato encontrado, entonces obtenemos su nombre
//                                        y lo retornamos a PrbProyecto
                if (d[i] instanceof Clientes && opc == 1 && dato.equals(d[i].getNombre()))
                {
                    return i;
                } else
                {
//                si lo que recorre el array fue instanciado como un Proveedor
//                        y la opc fue 2 y el dato que estamos buscando es igual al
//                                dato encontrado, entonces obtenemos su nombre
//                                        y lo retornamos a PrbProyecto
                    if (d[i] instanceof Proveedores && opc == 2 && dato.equals(d[i].getNombre()))
                    {
                        return i;
                    }
                }

            }
        }
        System.out.println("No se encontraron datos");
        //Si busca retorna -1 quiere decir que no se encontro el dato
        return -1;

    }

    /**
     * Metodo que elimina el dato en la posicion antes buscada
     *
     * @param d es el arreglo que contiene los datos gurdados
     * @param posicion la posicion donde esta alojado el dato a eliminar
     * @return el arreglo temporal
     */
    public static DatosH[] elimina(DatosH[] d, int posicion)
    {
        if (posicion == 0 && d.length == 1)
        {
            return null;
        } else
        {
            //Creamos un array temporal y a este le quitamos una posicion
            //menos, para despues meter los datos que no fueron eliminados
            DatosH tmp[] = new DatosH[d.length - 1];
            int j = 0;
            for (int i = 0; i < d.length; i++)
            {
                if (posicion != j)
                {
                    tmp[j++] = d[i];
                }

            }
            return tmp;
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Metodo que crea un objeto de tipo Cliente o Proveedor.
     *
     *
     * @param opc Recibimos la opcion 1.Clientes o 2.Proveedores. y la posicion
     * donde se encuentra ese dato.
     * @return el objeto creado de tipo Cliente o Proveedor.
     */
    public static DatosH[] modifica(DatosH[] d, int posicion, int opc)
    {
        //si la opcion fue un Cliente.
        if (opc == 1)
        {
            //lo que tenemos en dicha posicion del arreglo
            //mandamos llamar el metodo modificaC mandando el arreglo y la posicion
            //en la que se encuentra ese dato.
            d[posicion] = modificaC(d[posicion]);

            //Retornamos el objeto ya modificado.
            return d;
        } else
        {
            //si la opcion fue un Proveedor.
            if (opc == 2)
            {
                //lo que tenemos en dicha posicion del arreglo
                //mandamos llamar el metodo modificaP mandando el arreglo y la posicion
                //en la que se encuentra ese dato.
                d[posicion] = modificaP(d[posicion]);
                //Retornamos el objeto ya modificado.
                return d;
            }
        }

        //Si no cae en ningun if retornamos el objeto sin modificar.
        return d;

    }

    /**
     * Metodo que modifica los datos de un Cliente.
     *
     * @param d es el objeto de Cliente.
     * @return El dato modificado.
     */
    public static DatosH modificaC(DatosH d)
    {
        int resp;
        //Creamos un objeto de tipo Cliente temporal
        //y reemplazamos la info que tiene el obj d por la de tmpC.
        Clientes tmpC = new Clientes();
        d = tmpC;
        int num;
        int tTipo;
        System.out.println("Nombre: ");
        tmpC.setNombre(Lecturas.cadena());
        System.out.println("Direccion: ");
        tmpC.setDireccion(Lecturas.cadena());
        System.out.println("Correo: ");
        tmpC.setCorreo(Lecturas.cadena());

        do
        {
            System.out.println("Telefono: ");
            tmpC.setTelefono(Lecturas.entero());
            num = validaDigitos(tmpC.getTelefono());

        } while (num != 1);
        do
        {
            System.out.println("RFC: ");
            tmpC.setRfc(Lecturas.cadena());
            resp = validaRfc(tmpC.getRfc());

        } while (resp != 1);
        System.out.println("Credito: ");
        tmpC.setCredito(Lecturas.doble());

        do
        {
            System.out.println("Tipo (H,M,L): ");
            tmpC.setTipo(Lecturas.caracter());

            tTipo = validaTipo(tmpC.getTipo());

        } while (tTipo != 1);

        //Retorna obj modificado.
        return d;

    }

    public static DatosH modificaP(DatosH d)
    {
        //Creamos un objeto de tipo Proveedor temporal
        //y reemplazamos la info que tiene el obj d por la de tmpP.
        Proveedores tmpP = new Proveedores();
        d = tmpP;
        int resp;
        int num;
        System.out.println("Nombre: ");
        tmpP.setNombre(Lecturas.cadena());
        System.out.println("Direccion: ");
        tmpP.setDireccion(Lecturas.cadena());
        System.out.println("Correo: ");
        tmpP.setCorreo(Lecturas.cadena());
        do
        {
            System.out.println("Telefono: ");
            tmpP.setTelefono(Lecturas.entero());
            num = validaDigitos(tmpP.getTelefono());

        } while (num != 1);
        do
        {
            System.out.println("RFC: ");
            tmpP.setRfc(Lecturas.cadena());
            resp = validaRfc(tmpP.getRfc());

        } while (resp != 1);
        System.out.println("Clave: ");
        tmpP.setClave(Lecturas.entero());
        System.out.println("Producto: ");
        tmpP.setProducto(Lecturas.cadena());

        //Retorna el obj modificado.
        return d;

    }

    public static int validaRfc(String rfc)
    {
        //validar los 10 digitos
        char arr[];
        arr = rfc.toCharArray();
        if (arr.length == 10)
        {
            //Convertimos caracteres en mayusculas y recorremos los primeros
            //4 lugares buscando un caracter y los ultimos buscando numeros.
            arr = rfc.toUpperCase().toCharArray();
            for (int i = 0; i < 4; i++)
            {
                if (arr[i] >= 'A' && arr[i] <= 'Z')
                {
                    for (int j = 4; j < arr.length; j++)
                    {
                        if (arr[i] >= 0 && arr[i] <= 9)
                        {
                            System.out.println("RFC valido");
                        }
                    }

                }
            }
            return 1;
        } else
        {
            System.out.println("Error, los primeros 4 campos deben ser letras seguido de 6 numeros");
            return -1;
        }

    }

    public static int validaDigitos(int numeros)
    {
        //convertimos int a cadena para comprobar su longitud == 10.
        String cadena;
        cadena = String.valueOf(numeros);
        char arr[];
        arr = cadena.toCharArray();

        if (cadena.length() == 10)
        {

            return 1;
        } else
        {
            System.out.println("El numero telefonico debe tener 10 digitos...");
            return -1;
        }

    }

    public static int validaTipo(char caracter)
    {
        if (caracter == 'h' || caracter == 'H' || caracter == 'm'
                || caracter == 'M' || caracter == 'l' || caracter == 'l')
        {
            return 1;
        } else
        {
            System.out.println("solo se admiten (H,M,L)");
            return -1;
        }

    }
}
