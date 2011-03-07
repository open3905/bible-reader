/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class OsisGenRegex extends AbstractPatternType
{

    /**
     * @param pattern
     */
    public OsisGenRegex()
    {
        super("((((\\p{L}|\\p{N}|_)+)(\\.(\\p{L}|\\p{N}|_))*:)?([^:\\s])+)");
    }

}
