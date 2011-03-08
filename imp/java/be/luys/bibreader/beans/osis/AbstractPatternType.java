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

    public boolean setValue(String value)
    {
        if (pattern == null)
        {
            this.value = value;
            return true;
        }
        if (value == null || value.matches(pattern))
        {
            this.value = value;
            return true;
        }
        System.err.println("FAILED TO PARSE "+value);
        this.value = null;
        return false;
    }

    /**
     * @return the value
     */
    public String getValue()
    {
        return value;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return value;
    }
}
