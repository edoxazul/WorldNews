package cl.ucn.disc.dsm.news.newsapi;

import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import cl.ucn.disc.dsm.news.Transformer;
import cl.ucn.disc.dsm.news.model.Noticia;

public class ArticleNoticiaTransformer
        implements Transformer.NoticiaTransformer<Article> {
    /**
     *
     * @see Transformer.NoticiaTransformer
     */

    @Override
    public Noticia transform(final Article article) {

        //The date
        final ZonedDateTime publishedAt = ZonedDateTime.parse(article.getPublishedAt());

        return new Noticia(
                article.getTitle(),
                article.getSource().getName(),
                article.getAuthor(),
                article.getUrl(),
                article.getUrlToImage(),
                article.getContent(),
                publishedAt

        );

    }
}
