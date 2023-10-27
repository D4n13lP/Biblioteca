//package Daniel;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class PruebaBiblioteca {

    public static void main(String[] args) {
        Biblioteca library1=new Biblioteca();

        library1.setLibros(new ArrayList<Libro>());  //crear la lista de libros

        //agregar libro 1
        List<Autor> autores = new ArrayList<Autor>();
        autores.add(new Autor("Antoine de Saint-Exupéry"));
        autores.add(new Autor("Autor2"));
        library1.getLibros().add(new Libro("El Principito", "Advanced Marketing", "ISBN 978-6076189498", transformaStringADate("22/08/2022"),
                2021, "Mexico", autores, true ));

        //agregar libro 2
        autores = new ArrayList<Autor>();
        autores.add(new Autor("George Orwell"));
        autores.add(new Autor(" "));
        library1.getLibros().add(new Libro("1984", "Mirlo", "ISBN 09786071437501", transformaStringADate("22/07/2023"),
                2022, "Mexico", autores, true ));

        //agregar libro 3
        autores = new ArrayList<Autor>();
        autores.add(new Autor("Leo Tolstoi"));
        autores.add(new Autor(" "));
        library1.getLibros().add(new Libro("Anna Karenina", "Wordsworth Editions", "ISBN 978-1853262715", transformaStringADate("19/01/2000"),
                1995, "United Kingdom", autores, true ));

        //agregar libro 4
        autores = new ArrayList<Autor>();
        autores.add(new Autor("George Orwell"));
        autores.add(new Autor(" "));
        library1.getLibros().add(new Libro("1984", "Mirlo", "ISBN 09786071437501", transformaStringADate("22/07/2023"),
                2022, "Mexico", autores, true ));

        //agregar libro 5
        autores = new ArrayList<Autor>();
        autores.add(new Autor("J.K. Rowling"));
        autores.add(new Autor(" "));
        library1.getLibros().add(new Libro("Harry Potter y la Piedra Filosofal", "Ediciones Salamandra", "ISBN 1234567890", transformaStringADate("15/11/1997"),
                1997, "Reino Unido", autores, false ));

        // Agregar libro 6
        autores = new ArrayList<Autor>();
        autores.add(new Autor("George R.R. Martin"));
        autores.add(new Autor(" "));
        library1.getLibros().add(new Libro("Juego de Tronos", "Ediciones Gigamesh", "ISBN 9788416035256", transformaStringADate("01/01/1996"),
                1996, "Estados Unidos", autores, true ));

        // Agregar libro 7
        autores = new ArrayList<Autor>();
        autores.add(new Autor("J.R.R. Tolkien"));
        library1.getLibros().add(new Libro("El Hobbit", "Minotauro", "ISBN 9788445073808", transformaStringADate("21/09/1937"),
                1937, "Reino Unido", autores, true ));

        // Agregar libro 8 con 2 autores
        autores = new ArrayList<Autor>();
        autores.add(new Autor("Charlotte Brontë"));
        autores.add(new Autor("Emily Brontë"));
        library1.getLibros().add(new Libro("Cumbres Borrascosas", "Thomas Cautley Newby", "ISBN 9780141439556", transformaStringADate("01/01/1847"),
                1847, "Reino Unido", autores, true));

        // Agregar libro 9 con 2 autores
        autores = new ArrayList<Autor>();
        autores.add(new Autor("Mary Shelley"));
        autores.add(new Autor("Percy Bysshe Shelley"));
        library1.getLibros().add(new Libro("Frankenstein", "Lackington, Hughes, Harding, Mavor & Jones", "ISBN 9780199537150", transformaStringADate("01/01/1818"),
                1818, "Reino Unido", autores, true));

        // Agregar libro 10 con 2 autores
        autores = new ArrayList<Autor>();
        autores.add(new Autor("F. Scott Fitzgerald"));
        autores.add(new Autor("Zelda Fitzgerald"));
        library1.getLibros().add(new Libro("El Gran Gatsby", "Scribner", "ISBN 9780743273565", transformaStringADate("10/04/1925"),
                1925, "Estados Unidos", autores, true));






        menu(library1);

    }

    public static Date transformaStringADate(String fecha) {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Date fechaD=new Date(0, 0, 0); // Crea una fecha con todos los valores en cero


        try{
            fechaD=sdf.parse(fecha);
        } catch (ParseException e){
            JOptionPane.showMessageDialog(null, "Formato Fecha Incorrecto"+fecha);
            fechaD=fechaD = new Date(0, 0, 0); // En caso de error, asigna una fecha con valores en cero
        }
        return fechaD;
    }

    public static void menu(Biblioteca library){
        Integer opcion=0;
        do{

            try {
                // Intentar convertir la cadena de texto a un entero
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de opcion que desees realizar:\n\n" +
                        "1. Consultar disponibilidad para préstamo\n" +
                        "2. Búsqueda de libro por titulo\n" +
                        "3. Consultar libro mas antiguo\n" +
                        "4. Consultar ultimo libro adquirido\n" +
                        "5. Acervo total de libros\n" +
                        "6. Total de libros en préstamo\n" +
                        "7. Salir"));

            } catch (NumberFormatException e) {
                // Manejar una excepción si la entrada no es un número válido
                JOptionPane.showMessageDialog(null, "Entrada no válida. Introduce un número entero.");
            }

            switch (opcion){
                case 1: String titulo = JOptionPane.showInputDialog("Ingresa el titulo de libro");
                        boolean availability=library.libroDisponible(titulo);
                        String a= (availability)? "¡Libro disponible!" : "Lo siento, no esta disponible actualmente";
                        JOptionPane.showMessageDialog(null, a);
                    break;
                case 2: String titulob = JOptionPane.showInputDialog("Ingresa el titulo del libro a buscar.");
                        if(library.busquedaTitulo(titulob)!=null){
                            Libro resultado = library.busquedaTitulo(titulob);
                            //Creamos una cadena con los nombres de los autores del libro
                            StringBuilder autores = new StringBuilder();
                            for(Autor autor: resultado.getAutores()){
                                autores.append(autor.getNombre()).append("\n");
                            }
                            //Creamos una variable con un mensaje que indicara la disponibilidad
                            String av = (resultado.getDisponible()==true)? "Disponible": "No disponible por el momento";
                            JOptionPane.showMessageDialog(null, "Titulo: "+resultado.getTitulo()+"\n"
                            +"Editorial "+resultado.getEditorial()+"\n"
                            +resultado.getIsbn()+"\n"
                            +"Fecha de Adquisición: "+resultado.getFechaAd()+"\n"
                            +"Año de publicación: "+resultado.getPubYear()+"\n"
                            +"Pais de publicación: "+resultado.getPaisPub()+"\n"
                            +"Autor: "+autores+av);
                        }
                    break;
                case 3: Libro antiqueBook = library.libroMasAntiguo();
                        //Creamos una cadena con los nombres de los autores del libro
                        StringBuilder autoresAB = new StringBuilder();
                        for(Autor autorAB: antiqueBook.getAutores()){
                            autoresAB.append(autorAB.getNombre()).append("\n");
                        }
                        //Creamos una variable con un mensaje que indicara la disponibilidad
                        String avAB = (antiqueBook.getDisponible()==true)? "Disponible": "No disponible por el momento";
                        JOptionPane.showMessageDialog(null, "LIBRO MAS ANTIGUO\n\n"
                                +"Titulo: "+antiqueBook.getTitulo()+"\n"
                                +"Editorial "+antiqueBook.getEditorial()+"\n"
                                +antiqueBook.getIsbn()+"\n"
                                +"Fecha de Adquisición: "+antiqueBook.getFechaAd()+"\n"
                                +"Año de publicación: "+antiqueBook.getPubYear()+"\n"
                                +"Pais de publicación: "+antiqueBook.getPaisPub()+"\n"
                                +"Autor: "+autoresAB+avAB);
                    break;
                case 4: Libro newerBook = library.ultimoLibroAdquirido();
                    //Creamos una cadena con los nombres de los autores del libro
                    StringBuilder autoresNB = new StringBuilder();
                    for(Autor autorNB: newerBook.getAutores()){
                        autoresNB.append(autorNB.getNombre()).append("\n");
                    }
                    //Creamos una variable con un mensaje que indicara la disponibilidad
                    String avNB = (newerBook.getDisponible()==true)? "Disponible": "No disponible por el momento";
                    JOptionPane.showMessageDialog(null, "ULTIMO LIBRO ADQUIRIDO\n\n"
                            +"Titulo: "+newerBook.getTitulo()+"\n"
                            +"Editorial "+newerBook.getEditorial()+"\n"
                            +newerBook.getIsbn()+"\n"
                            +"Fecha de Adquisición: "+newerBook.getFechaAd()+"\n"
                            +"Año de publicación: "+newerBook.getPubYear()+"\n"
                            +"Pais de publicación: "+newerBook.getPaisPub()+"\n"
                            +"Autor: "+autoresNB+avNB);
                    break;
                case 5: Integer booksTotal=library.obtenerTotalLibros();
                        String total = booksTotal.toString();
                        JOptionPane.showMessageDialog(null, "Existen "+total+" libros registrados en total");

                    break;
                case 6: Integer lentBooks = library.obtenerTotalLibPrest();
                        String totalLB = lentBooks.toString();
                        JOptionPane.showMessageDialog(null, "Existen "+totalLB+" libros prestados actualmente");
                    break;

            }

        }while(opcion!=7);
    }
}
