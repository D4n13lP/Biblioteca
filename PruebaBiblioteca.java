package Daniel;

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
        autores.add(new Autor("George Orwell"));
        autores.add(new Autor(" "));
        library1.getLibros().add(new Libro("1984", "Mirlo", "ISBN 09786071437501", transformaStringADate("22/07/2023"),
                2022, "Mexico", autores, true ));

        //agregar libro 3
        autores.add(new Autor("Lev Tolstoi"));
        autores.add(new Autor(" "));
        library1.getLibros().add(new Libro("Anna Karenina", "Wordsworth Editions", "ISBN 978-1853262715", transformaStringADate("19/01/2000"),
                1995, "United Kingdom", autores, true ));

        //agregar libro 4
        autores.add(new Autor("George Orwell"));
        autores.add(new Autor(" "));
        library1.getLibros().add(new Libro("1984", "Mirlo", "ISBN 09786071437501", transformaStringADate("22/07/2023"),
                2022, "Mexico", autores, true ));

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
                    try {
                        String a= (availability)? "¡Libro disponible!" : "Lo siento, no esta disponible actualmente";
                    }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, "Lo siento, no esta disponible actualmente");
                    }

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;

            }

        }while(opcion!=7);
    }
}
