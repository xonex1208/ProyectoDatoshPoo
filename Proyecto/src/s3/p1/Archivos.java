/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.p1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author deivi
 */
public class Archivos
{

    //ARCHIVOS BINARIOS
    public static void guarda(Object[] arr, String s)
    {
        try
        {
            //recibe un arrego y un string
            //declaración de clase que nos permite saber en donde esta el archivo
            FileOutputStream fos = new FileOutputStream(s);//try catch
            try
            {
                ObjectOutputStream arch = new ObjectOutputStream(fos);
                arch.writeObject(arr);
                arch.close();
            } catch (Exception ex)
            {
                System.out.println("No se pudo abrir el archivo.");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("No encuentro el archivo.");
        } catch (Exception ex)
        {
            System.out.println("Error..." + ex.toString());
        }
    }

    public static Object[] carga(String s)
    {
        Object arr[] = null; //declaro arreglo
        try
        {
            FileInputStream fis = new FileInputStream(s);
            try
            {
                ObjectInputStream arch = new ObjectInputStream(fis);
                arr = (Object[]) arch.readObject();
                arch.close();
            } catch (Exception ex)
            {
                System.out.println("No se pudo abrir el archivo.");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("No encuentro el archivo.");
        } catch (Exception ex)
        {
            System.out.println("Error..." + ex.toString());
        }
        return arr;
    }
}
