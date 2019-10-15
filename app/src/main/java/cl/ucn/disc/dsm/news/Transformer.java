package cl.ucn.disc.dsm.news;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import cl.ucn.disc.dsm.news.model.Noticia;

/**
 * @author Eduardo ALvarez S
 */

public class Transformer <T>{
    /**
     * El transformador de Noticias
     */
    private final NoticiaTransformer<T> noticiaTransformer;

    /**
     * The constructor
     * @param noticiaTransformer
     */

    public Transformer(final NoticiaTransformer<T> noticiaTransformer) {
        Objects.requireNonNull(noticiaTransformer,"Se requiere un transformador de Noticias");

        this.noticiaTransformer = noticiaTransformer;
    }

    /**
     * Transforma una{@Link Collection} de T en un {@Link List} de {@Link Noticia}
     *
     * @param collection
     * @return the List of Noticia.
     */

    public List<Noticia> transform(final Collection<T> collection){

        Objects.requireNonNull(collection,"No se permite una Collection null ");

        //Microo ptimizacion : Tamanio de la coleccion igual a la lista
        final List<Noticia> noticias = new ArrayList<>(collection.size());

        for (final T t : collection){

            final Noticia noticia =
                    this.noticiaTransformer.transform(t);
            noticias.add(noticia);


        }

        return noticias;

    }

    /**
     * Responsable de transformar una T en una {@link Noticia}.
     *
     * @param <T> a usar como base.
     */

    public interface NoticiaTransformer<T> {

        /**
         *
         * @param t a transformar
         * @return the Noticia a partir de t.
         */
        Noticia transform(T t);

    }

    /**
     * La exception en caso de algun error en la transformacion.
     */
    public static class NoticiaTransformerException extends RuntimeException {

        /**
         * @see RuntimeException
         */
        public NoticiaTransformerException(final String message) {
            super(message);
        }

        /**
         * @see RuntimeException
         */
        public NoticiaTransformerException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }



}
