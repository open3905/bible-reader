/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class ACT
{
    private GlobalWithType globalWithType;
    private boolean canonical;
    private String href;
    private IndexCT[] index;

    /**
     * @return the globalWithType
     */
    public GlobalWithType getGlobalWithType()
    {
        return globalWithType;
    }

    /**
     * @return the canonical
     */
    public boolean isCanonical()
    {
        return canonical;
    }

    /**
     * @return the href
     */
    public String getHref()
    {
        return href;
    }

    /**
     * @return the index
     */
    public IndexCT[] getIndex()
    {
        return index;
    }

    /**
     * @param globalWithType the globalWithType to set
     */
    public void setGlobalWithType(GlobalWithType globalWithType)
    {
        this.globalWithType = globalWithType;
    }

    /**
     * @param canonical the canonical to set
     */
    public void setCanonical(boolean canonical)
    {
        this.canonical = canonical;
    }

    /**
     * @param href the href to set
     */
    public void setHref(String href)
    {
        this.href = href;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(IndexCT[] index)
    {
        this.index = index;
    }

}
