/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class DescriptionCT
{
    private boolean canonical;
    private DescriptionType descriptionType;
    private GlobalWithoutType globalWithoutType;
    private String value;

    /**
     * @return the descriptionType
     */
    public DescriptionType getDescriptionType()
    {
        return this.descriptionType;
    }

    /**
     * @return the globalWithoutType
     */
    public GlobalWithoutType getGlobalWithoutType()
    {
        return this.globalWithoutType;
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
     * @param descriptionType the descriptionType to set
     */
    public void setDescriptionType(final DescriptionType descriptionType)
    {
        this.descriptionType = descriptionType;
    }

    /**
     * @param globalWithoutType the globalWithoutType to set
     */
    public void setGlobalWithoutType(final GlobalWithoutType globalWithoutType)
    {
        this.globalWithoutType = globalWithoutType;
    }

    /**
     * @param value the value to set
     */
    public void setValue(final String value)
    {
        this.value = value;
    }

}
