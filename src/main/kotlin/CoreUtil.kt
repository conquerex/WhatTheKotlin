import java.util.logging.Logger

/**
 * @author Jongkook
 * @date : 2020/10/15
 */

public fun <R : Any> R.logger() : Lazy<Logger> {
    return lazy { Logger.getLogger(this.javaClass.name) }
}