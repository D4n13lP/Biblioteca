//package Daniel;
import java.util.Date;
import java.util.List;

public class Libro {
    private String titulo;
    private String editorial;
    private String isbn;
    private Date fechaAd;
    private Integer pubYear;
    private String paisPub;
    private List<Autor> autores;
    private Boolean disponible;

    public Libro(boolean disponible){
        this.disponible=false;
    }

    public Libro(String titulo, String editorial, String isbn, Date fechaAd, Integer pubYear, String paisPub, List<Autor> autores, Boolean disponible) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.isbn = isbn;
        this.fechaAd = fechaAd;
        this.pubYear = pubYear;
        this.paisPub = paisPub;
        this.autores = autores;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getFechaAd() {
        return fechaAd;
    }

    public void setFechaAd(Date fechaAd) {
        this.fechaAd = fechaAd;
    }

    public Integer getPubYear() {
        return pubYear;
    }

    public void setPubYear(Integer pubYear) {
        this.pubYear = pubYear;
    }

    public String getPaisPub() {
        return paisPub;
    }

    public void setPaisPub(String paisPub) {
        this.paisPub = paisPub;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
