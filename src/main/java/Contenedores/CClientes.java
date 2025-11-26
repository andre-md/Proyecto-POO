package Contenedores;

import Clases.Clientes;
import java.util.ArrayList;
import java.util.List;

public class CClientes {
    private static List<Clientes> Listcli = new ArrayList();
    
    public static void insertar(Clientes cli){
        Listcli.add(cli);
    }
    
    public static boolean buscar(Clientes cli){
        return Listcli.contains(cli);
    }
    
    public static void eliminar(Clientes cli){
        Listcli.remove(cli);
    }
    
    
}
