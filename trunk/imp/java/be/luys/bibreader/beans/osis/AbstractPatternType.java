/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public abstract class AbstractPatternType
{
    private String pattern;
    private String value;

    public AbstractPatternType(String pattern)
    {
        this.pattern = pattern;
    }
}
