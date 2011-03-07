/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 *
 */
public class OsisWorkPrefix extends AbstractPatternType
{

    /**
     * @param pattern
     */
    public OsisWorkPrefix()
    {
        super("((//((\\p{L}|\\p{N}|_|-|\\.|:)+))(/(\\p{L}|\\p{N}|_|-|\\.|:)+)?(/@(\\p{L}|\\p{N}|_|-|\\.|:)+))");
    }

}
