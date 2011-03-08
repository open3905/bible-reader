/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class CreatorCT
{
    private boolean canonical;
    private GlobalWithType globalWithType;
    private RoleType role;
    private String value;

    /**
     * @return the globalWithType
     */
    public GlobalWithType getGlobalWithType()
    {
        return this.globalWithType;
    }

    /**
     * @return the role
     */
    public RoleType getRole()
    {
        return this.role;
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
     * @param role the role to set
     */
    public void setRole(final RoleType role)
    {
        this.role = role;
    }

    /**
     * @param value the value to set
     */
    public void setValue(final String value)
    {
        this.value = value;
    }
}
