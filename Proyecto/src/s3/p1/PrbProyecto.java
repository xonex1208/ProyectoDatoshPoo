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
public class PrbProyecto
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int opc = 0;
        DatosH d[] = null;
        //Nombre del archivo que vamos a crear.
        String nombre = "Proyecto.dat";

        //Abrimos archivo.
        d = (DatosH[]) Archivos.carga(nombre);
        String menu[] =
        {
            "Clientes", "Proveedores", "Salir"
        };
        String menu2[] =
        {
            "Altas", "Bajas", "Consultas", "Modificaciones", "Salir"
        };

        int opc2;

        do
        {
            //mandamos menu[]
            opc = ABCProyecto.menu(menu, "General");
            //Muestra 3 opciones 1.Clientes 2.Proveedores 3.Salir
            switch (opc)
            {
                //case 1 y case 2 entran al mismo metodo ya que el metodo creaObj 
                //valida la opcion.

                case 1:

                case 2:
                    do
                    {
                        //mandamos menu2[]
                        //opc-1 si no ponemos -1, se saltara el menu Clientes,
                        //porque inicia desde la pos 1 y lo recorremos una posicion con -1
                        //De lo contrario se cicla pidiendo datos
                        opc2 = ABCProyecto.menu(menu2, menu[opc - 1]);
                        //Muestra 5 opciones 1.Altas 2.Bajas 3.Consultas 4.Modificaciones 5.Salir
                        switch (opc2)
                        {
                            
                                
                            case 1://Altas
                                //d recibe el dato insertado pero antes crea el tipo de objeto
                                //segun sea Cliente o Proveedor
                                d = ABCProyecto.inserta(d, ABCProyecto.creaObj(opc));
                                System.out.println("Dato insertado correctamente!");
                                break;
                            case 2:
                                //Bajas
                                //Primero buscamos el dato a eliminar si esque existe
                                //y si fue instanciado como Cliente o Proveedor
                                int posicion = ABCProyecto.busca(d, opc, "eliminar");
                                //si nos retorna un -1 quiere decir que no existe el dato
                                if (posicion != -1)
                                {
                                    //Mandamos llamar el metodo eliminar
                                    //y le pasamos el arreglo con los objetos y
                                    //la posicion para que directamente elimine el dato
                                    d = ABCProyecto.elimina(d, posicion);
                                }
                                break;
                            case 3:
                                String s="";
                                //Consultas
                                //Mostramos los datos que tenemos guardados
                                System.out.println(ABCProyecto.consulta(d, opc));
                                break;
                            case 4:
                                //Modificaciones
                                int posMod = ABCProyecto.busca(d, opc, "modificar");
                                if (posMod != -1)
                                {
                                    //Mandamos llamar el metodo eliminar
                                    //y le pasamos el arreglo con los objetos y
                                    //la posicion para que directamente elimine el dato
                                    //  d = ABCProyecto.elimina(d, posMod);
                                    //d = ABCProyecto.modifica(d, posMod, opc);
                                    d = ABCProyecto.modifica(d, posMod, opc);
                                }
                                break;
                            case 5:

                                break;
                            default:
                                System.out.println("Opcion incorrecta!");

                        }

                    } while (opc2 != menu2.length);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;

            }

        } while (opc != menu.length);
        Archivos.guarda(d, nombre);
        System.out.println("Informacion guardada exitosamente!");
    }

}
