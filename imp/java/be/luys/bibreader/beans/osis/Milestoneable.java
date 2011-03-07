/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public abstract class Milestoneable
{
    private String sID;
    private String eID;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "sID=" + sID + ", eID=" + eID;
    }

    /**
     * @return the sID
     */
    public String getsID()
    {
        return sID;
    }

    /**
     * @return the eID
     */
    public String geteID()
    {
        return eID;
    }

    /**
     * @param sID the sID to set
     */
    public void setsID(String sID)
    {
        this.sID = sID;
    }

    /**
     * @param eID the eID to set
     */
    public void seteID(String eID)
    {
        this.eID = eID;
    }
}
