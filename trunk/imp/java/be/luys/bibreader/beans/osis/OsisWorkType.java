/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 *
 */
public class OsisWorkType extends AbstractPatternType
{

    /**
     * @param pattern
     */
    public OsisWorkType()
    {
        super("((\\p{L}|\\p{N}|_)+)((\\.(\\p{L}|\\p{N}|_)+)*)?");
    }

}
