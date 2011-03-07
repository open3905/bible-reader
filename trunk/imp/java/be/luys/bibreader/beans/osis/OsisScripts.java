/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 *
 */
public class OsisScripts extends AbstractPatternType
{

    /**
     * @param pattern
     */
    public OsisScripts()
    {
        super("([A-Z][a-z]{3}|x-[A-Za-z0-9]+)");
    }

}
