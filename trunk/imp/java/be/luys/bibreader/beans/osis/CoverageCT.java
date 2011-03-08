/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class CoverageCT
{
    private boolean canonical;
    private GlobalWithType globalWithType;
    private String value;

    /**
     * @return the globalWithType
     */
    public GlobalWithType getGlobalWithType()
    {
        return this.globalWithType;
    }

    /**
     * @return the value
     */
    public String getValue()
    {
        return this.value;
    }

    /**
     * @return the canonical
     */
    public boolean isCanonical()
    {
        return this.canonical;
    }

    /**
     * @param canonical the canonical to set
     */
    public void setCanonical(final boolean canonical)
    {
        this.canonical = canonical;
    }

    /**
     * @param globalWithType the globalWithType to set
     */
    public void setGlobalWithType(final GlobalWithType globalWithType)
    {
        this.globalWithType = globalWithType;
    }

    /**
     * @param value the value to set
     */
    public void setValue(final String value)
    {
        this.value = value;
    }

}
