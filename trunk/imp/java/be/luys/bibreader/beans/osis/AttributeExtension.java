/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class AttributeExtension extends AbstractPatternType
{
    /**
     * @param pattern
     */
    public AttributeExtension()
    {
        super("x-([^\\s])+");
    }

}
