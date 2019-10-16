package cl.ucn.disc.dsm.news.newsapi;

import org.threeten.bp.ZonedDateTime;

import cl.ucn.disc.dsm.news.Transformer;
import cl.ucn.disc.dsm.news.model.Noticia;

/**
 * Implementacion de un {@link Article} to {@link cl.ucn.disc.dsm.news.model.Noticia}.
 *
 * @author Eduardo Alvarez S.
 * */
public final class ArticleNoticiaTransformer implements Transformer.NoticiaTrasformer<Article> {

    /**
     * @see Transformer.NoticiaTrasformer
     */
    @Override
    public Noticia transform(final Article article) {

        // The date.
        final ZonedDateTime publishedAt = ZonedDateTime.parse(article.publishedAt);

        // Builder! TODO: Check if any of these fields are optional or empty ?!?
        return new Noticia(
                article.title,
                article.source.name,
                article.author,
                article.url,
                article.urlToImage,
                article.description,
                article.content,
                publishedAt
        );

    }

}
