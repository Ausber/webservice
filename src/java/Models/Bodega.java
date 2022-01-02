/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Usuario
 */
public class Bodega {
    
    private int id;
    private String nombre;
    private boolean externa;
    private int estantes;

    public Bodega() {
    }

    public Bodega(int id, String nombre, boolean externa, int estantes) {
        this.id = id;
        this.nombre = nombre;
        this.externa = externa;
        this.estantes = estantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isExterna() {
        return externa;
    }

    public void setExterna(boolean externa) {
        this.externa = externa;
    }

    public int getEstantes() {
        return estantes;
    }

    public void setEstantes(int estantes) {
        this.estantes = estantes;
    }
}
