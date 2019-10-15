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
        Objects.requireNonNull(noticiaTransformer,"Se requiere Noticia");

        this.noticiaTransformer = noticiaTransformer;
    }

    /**
     * Transforma una{@Link Collection} de T en un {@Link List} de {@Link Noticia}
     * @param collection
     * @return the List of Noticia.
     */

    public List<Noticia> transform(final Collection<T> collection){

        Objects.requireNonNull(collection,"No se permite una Collection ");

        //Microo ptimizacion : Tamanio de la coleccion igual a la lista
        final List<Noticia> noticias = new ArrayList<>(collection.size());

        for (final T t : collection){

            final Noticia noticia =
                    this.noticiaTransformer.transform(t);
            noticias.add(noticia);


        }

        return noticias;

    }

    public interface NoticiaTransformer<T> {

        /**
         *
         * @param t a transformar
         * @return the Noticia a partir de t.
         */
        Noticia transform(T t);

    }


}
