//package Daniel;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
public class Biblioteca {
    private String nombre;
    private String ciudad;
    private List<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<Libro>();
    }
//**************  Getters y Setter  *************************************************************************************************
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    // ************ METODOS *******************************************************************************************
    public Boolean libroDisponible(String titulo){
        Libro libro=new Libro(false);

        if(libros!=null){
            for(Libro l:libros) {
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    libro=l;
                    break;
                }
            }
        }

        return libro.getDisponible();
    }

    public Libro busquedaTitulo(String tit) {
        Libro libro=null;

        if (libros!=null) {
            for (Libro l:libros){
                if (l.getTitulo().equalsIgnoreCase(tit)){
                    libro=l;
                    break;
                }
            }
        }
        return libro;
    }

    public Libro libroMasAntiguo() {
        Libro libroAntiguo = null;
        boolean primerIteracion = true;
        for(Libro l:libros){
            if(primerIteracion){      //Este condicional que solo se ejecuta en la primer iteracion
                libroAntiguo=l;         //del bucle sirve para meter el primer elemento de la lista en la variable libroAntiguo
                primerIteracion = false;
            }

            if(l.getPubYear()<libroAntiguo.getPubYear()){
                libroAntiguo=l;
            }
        }
        return libroAntiguo;
    }

    public Libro ultimoLibroAdquirido() {
        Libro ulAdquirido = null;
        boolean primerIteracion = true;
        for(Libro l:libros){
            if(primerIteracion){
                ulAdquirido=l;
                primerIteracion=false;
            }
            if(l.getFechaAd().after(ulAdquirido.getFechaAd())){
                ulAdquirido=l;
            }

        }
        return ulAdquirido;
    }

    public Integer obtenerTotalLibros() {
        return (libros!=null?libros.size():0);
    }

    public Integer obtenerTotalLibPrest() {
        Integer total = 0;

         if (libros!=null) {
             for(Libro l:libros){
                 if (!l.getDisponible()) {
                     total++;
                 }
             }
         }
         return total;
    }

}
