package cl.ucn.disc.dsm.news;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import cl.ucn.disc.dsm.news.model.Noticia;

/**
 * Transformador de T a Noticia.
 *
 * @author Diego Urrutia-Astorga.
 */
public final class Transformer<T> {

    /**
     * The Logger
     */
    private static final Logger log = LoggerFactory.getLogger(Transformer.class);

    /**
     * El transformador de Noticias.
     */
    private final NoticiaTrasformer<T> noticiaTrasformer;

    /**
     * The Constructor.
     *
     * @param noticiaTrasformer a usar para la conversion.
     */
    public Transformer(final NoticiaTrasformer<T> noticiaTrasformer) {
        Objects.requireNonNull(noticiaTrasformer, "Se requiere un transformador de noticias");
        this.noticiaTrasformer = noticiaTrasformer;
    }

    /**
     * Transforma una {@link Collection} de T en un {@link List} de {@link Noticia}.
     *
     * @param collection fuente de T.
     * @return the List of Noticia.
     */
    public List<Noticia> transform(final Collection<T> collection) {

        // No se permiten nulls
        Objects.requireNonNull(collection, "No se permite una Collection null");

        // MICROOPT: Tamanio de la coleccion igual a la lista
        final List<Noticia> noticias = new ArrayList<>(collection.size());

        for (final T t : collection) {

            try {
                final Noticia noticia = this.noticiaTrasformer.transform(t);
                noticias.add(noticia);
            } catch (NoticiaTransformerException ex) {
                log.warn("Article skipped: {}", ex.getMessage(), ex);
            }

        }

        return noticias;

    }


    /**
     * Responsable de transformar una T en una {@link Noticia}.
     *
     * @param <T> a usar como base.
     */
    public interface NoticiaTrasformer<T> {

        /**
         * @param t a transformar.
         * @return the Noticia a partir de t.
         */
        Noticia transform(T t);

    }

    /**
     * La exception en caso de algun error en la transformacion.
     */
    public static final class NoticiaTransformerException extends RuntimeException {

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