/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class DescriptionType
{
    private OsisDescription description;
    private AttributeExtension extension;

    /**
     * @param value
     */
    public void setValue(String value)
    {
        OsisDescription[] enums = OsisDescription.values();
        boolean found = false;
        for (OsisDescription d : enums)
        {
            if (d.equals(value))
            {
                description = d;
                found = true;
                break;
            }
        }
        if (!found)
        {
            AttributeExtension extension = new AttributeExtension();
            if (extension.setValue(value))
            {
                this.extension = extension;
            }
        }
    }

    /**
     * @return the description
     */
    public OsisDescription getDescription()
    {
        return description;
    }

    /**
     * @return the extension
     */
    public AttributeExtension getExtension()
    {
        return extension;
    }
}
