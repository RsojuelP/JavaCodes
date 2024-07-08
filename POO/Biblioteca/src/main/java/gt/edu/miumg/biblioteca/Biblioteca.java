/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package gt.edu.miumg.biblioteca;

import java.util.ArrayList;

/**
 *
 * @author EMPAQUE
 */
public class Biblioteca {

    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }
    
    public void registrarLibro(String titulo, String autor, String isbn){
        libros.add(new Libro(titulo, autor, isbn));
    }
    
    public void registrarUsuario(String nombre, String id){
        usuarios.add(new Usuario(nombre, id));
    }
    
    public boolean prestarLibro(String isbn, String usuarioId){
        Libro libro = buscarLibro(isbn);
        Usuario usuario = buscarUsuario(usuarioId);
        
        if(libro != null && usuario != null && !libro.estaPrestado()){
            libro.prestar();
            usuario.prestarLibro(libro);
            return true;
        }
        return false;
    }
    
    public boolean devolverLibro(String isbn, String usuarioId){
        Libro libro = buscarLibro(isbn);
        Usuario usuario = buscarUsuario(usuarioId);
        
        if(libro != null && usuario != null && libro.estaPrestado()){
            libro.devolver();
            usuario.devolverLibro(libro);
            return true;
        }
        return false;
    }
    
    private Libro buscarLibro(String isbn){
        for(Libro libro:libros){
            if(libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }
    
    private Usuario buscarUsuario(String id){
        for(Usuario usuario : usuarios){
            if(usuario.getId().equals(id)){
                return usuario;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.registrarLibro("El Quijote", "Miguel de Cervantes", "123456");
        biblioteca.registrarUsuario("Juan Perez", "001");
        
        biblioteca.prestarLibro("123456", "001");
        biblioteca.devolverLibro("123456", "001");
    }
}
