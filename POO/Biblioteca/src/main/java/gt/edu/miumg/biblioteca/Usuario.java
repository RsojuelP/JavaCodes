/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.miumg.biblioteca;

import java.util.ArrayList;

/**
 *
 * @author EMPAQUE
 */
public class Usuario {
    private String nombre;
    private String id;
    private ArrayList<Libro> librosPrstados;

    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.librosPrstados = new ArrayList<>();
    }
    
    public String getId(){
        return id;
    }
    
    public void prestarLibro(Libro libro){
        librosPrstados.add(libro);
    }
    
    public void devolverLibro(Libro libro){
        librosPrstados.remove(libro);
    }
}
