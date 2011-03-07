/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 *
 */
public class OsisRefRegex extends AbstractPatternType
{

    /**
     * @param pattern
     */
    public OsisRefRegex()
    {
        super("(((\\p{L}|\\p{N}|_)+)((\\.(\\p{L}|\\p{N}|_)+)*)?:)?((\\p{L}|\\p{N}|_|(\\\\[^\\s]))+)(\\.(\\p{L}|\\p{N}|_|(\\\\[^\\s]))*)*(!((\\p{L}|\\p{N}|_|(\\\\[^\\s]))+)((\\.(\\p{L}|\\p{N}|_|(\\\\[^\\s]))+)*)?)?(@(cp\\[(\\p{Nd})*\\]|s\\[(\\p{L}|\\p{N})+\\](\\[(\\p{N})+\\])?))?(\\-((((\\p{L}|\\p{N}|_|(\\\\[^\\s]))+)(\\.(\\p{L}|\\p{N}|_|(\\\\[^\\s]))*)*)+)(!((\\p{L}|\\p{N}|_|(\\\\[^\\s]))+)((\\.(\\p{L}|\\p{N}|_|(\\\\[^\\s]))+)*)?)?(@(cp\\[(\\p{Nd})*\\]|s\\[(\\p{L}|\\p{N})+\\](\\[(\\p{N})+\\])?))?)?");
    }

}
