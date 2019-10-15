package cl.ucn.disc.dsm.news.newsapi;

import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import cl.ucn.disc.dsm.news.Transformer;
import cl.ucn.disc.dsm.news.model.Noticia;

public class ArticleNoticiaTransformer
        implements Transformer.NoticiaTransformer<Article> {


    @Override
    public Noticia transform(final Article article) {
        return new Noticia(
                article.getTitle(),
                article.getSource().getName(), //FIXME : NPE?
                article.getAuthor(),
                article.getUrl(),
                article.getUrlToImage(),
                article.getContent(),
                ZonedDateTime.parse(article.getPublishedAt(),
                        DateTimeFormatter.ISO_ZONED_DATE_TIME)

        );

    }
}
