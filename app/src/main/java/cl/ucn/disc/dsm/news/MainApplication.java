package cl.ucn.disc.dsm.news;

import android.app.Application;
import android.content.Context;

import org.acra.ACRA;
import org.acra.BuildConfig;
import org.acra.annotation.AcraCore;
import org.acra.annotation.AcraMailSender;
import org.acra.annotation.AcraToast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Main Application.
 *
 * @author Diego Urrutia-Astorga
 * @version 2019.
 */
@AcraCore(buildConfigClass = BuildConfig.class)
@AcraMailSender(mailTo = "durrutia@ucn.cl")
public final class MainApplication extends Application {

    /**
     * The Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(MainApplication.class);

    /**
     * @param base context.
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        log.atDebug().log("Initializing ACRA ..");
        ACRA.init(this);
        log.atDebug().log(".. ACRA initialized !!");

    }
}