package cl.ucn.disc.dsm.news.model;


import org.threeten.bp.ZonedDateTime;

public class Noticia {

    /**
     * Title
     */
    private final String titulo;

    /**
     * Fuente. ej:Soy Antofagasta
     *
     */
    private final String fuente;


    /**
     * El que escribio la noticia
     */

    private final String autor;

    /**
     *
     */

    private final String url;


    /**
     * Lugar donde se encuentra la foto
     */
    private final String urlFoto;

    /**
     * Contenido
     */

    private final String contenido;

    /**
     * Fecha de la noticia
     */

    private final ZonedDateTime fecha;


    /**
     *  @param titulo
     * @param fuente
     * @param autor
     * @param url
     * @param urlFoto
     * @param contenido
     * @param fecha
     */

    public Noticia(final String titulo,final String fuente, final String autor, final String url,
                   final String urlFoto,final String contenido,final ZonedDateTime fecha)
    {
        this.titulo = titulo;
        this.fuente = fuente;
        this.autor = autor;
        this.url = url;
        this.urlFoto = urlFoto;
        this.contenido = contenido;
        this.fecha = fecha;
    }




    public String getTitulo() {
        return titulo;
    }

    public String getFuente() {
        return fuente;
    }

    public String getAutor() {
        return autor;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public String getContenido() {
        return contenido;
    }

    public String getUrl() {
        return url;
    }

    public ZonedDateTime getFecha() {
        return fecha;
    }
}
