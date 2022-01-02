/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Models.Bodega;
import Models.BodegaDAO;
import Models.Conexion;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "Servicios")
public class Servicios {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listar")
    public List<Bodega> listar() {
       BodegaDAO b = new BodegaDAO();
       return b.listar();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultar")
    public Bodega consultar(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
     BodegaDAO b = new BodegaDAO();
     return b.consultarbodega(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarbodega")
    public String agregarbodega(@WebParam(name = "nombre") String nombre, @WebParam(name = "externa") boolean externa, @WebParam(name = "estantes") int estantes) {
        //TODO write your implementation code here:
            Bodega bod = new Bodega();
            BodegaDAO b = new BodegaDAO();
            bod.setNombre(nombre);
            bod.setExterna(externa);
            bod.setEstantes(estantes);
            return b.addBodega(bod);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminar")
    public String eliminar(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        BodegaDAO b = new BodegaDAO();
        return b.deleteBodega(id);
    }
}
