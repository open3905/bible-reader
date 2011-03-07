/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class OsisIDRegex extends AbstractPatternType
{

    /**
     * @param pattern
     */
    public OsisIDRegex()
    {
        super("(((\\p{L}|\\p{N}|_)+)((\\.(\\p{L}|\\p{N}|_)+)*)?:)?((\\p{L}|\\p{N}|_|(\\\\[^\\s]))+)((\\.(\\p{L}|\\p{N}|_|(\\\\[^\\s]))+)*)?(!((\\p{L}|\\p{N}|_|(\\\\[^\\s]))+)((\\.(\\p{L}|\\p{N}|_|(\\\\[^\\s]))+)*)?)?");
    }

}
