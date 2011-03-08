/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class ContributorCT
{
    private GlobalWithType globalWithType;
    private String value;
    private boolean canonical;
    private String file_as;
    private RoleType role;

    /**
     * @return the globalWithType
     */
    public GlobalWithType getGlobalWithType()
    {
        return globalWithType;
    }

    /**
     * @return the value
     */
    public String getValue()
    {
        return value;
    }

    /**
     * @return the canonical
     */
    public boolean isCanonical()
    {
        return canonical;
    }

    /**
     * @return the file_as
     */
    public String getFile_as()
    {
        return file_as;
    }

    /**
     * @return the role
     */
    public RoleType getRole()
    {
        return role;
    }

    /**
     * @param globalWithType the globalWithType to set
     */
    public void setGlobalWithType(GlobalWithType globalWithType)
    {
        this.globalWithType = globalWithType;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    /**
     * @param canonical the canonical to set
     */
    public void setCanonical(boolean canonical)
    {
        this.canonical = canonical;
    }

    /**
     * @param fileAs the file_as to set
     */
    public void setFile_as(String fileAs)
    {
        file_as = fileAs;
    }

    /**
     * @param role the role to set
     */
    public void setRole(RoleType role)
    {
        this.role = role;
    }
}
