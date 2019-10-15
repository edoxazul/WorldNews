package cl.ucn.disc.dsm.news.newsapi;

import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dsm.news.model.Noticia;


public class Articles2Noticias {

    /**
     *
     * @param articles
     * @return the {@link List} of {@Link Noticia}
     */

    public static final List<Noticia> toNoticias(final List<Article> articles) {
        //No se permiten nulls!
        if (articles == null){
            throw new IllegalArgumentException("Lista null?");
        }

        //Listado de las noticias
        //Microoptimizacion : Tamanio del listado

        final List<Noticia> noticias = new ArrayList<>(articles.size());

        for(final Article article : articles){

            //Creo la noticia ...
            //final Noticia noticia = new Noticia();

            // ... la agrego al contenedor
            //noticias.add(noticia);
        }

        return noticias;
    }


}
