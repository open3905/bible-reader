/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class OsisAnnotateRefType
{
    private OsisRefRegex refRegex;
    private OsisGenRegex genRegex;

    public OsisAnnotateRefType(String value)
    {
        OsisRefRegex refRegex = new OsisRefRegex();
        if (refRegex.setValue(value))
        {
            this.refRegex = refRegex;
        }
        else
        {
            OsisGenRegex genRegex = new OsisGenRegex();
            if (genRegex.setValue(value))
            {
                this.genRegex = genRegex;
            }
        }
    }

    /**
     * @return the refRegex
     */
    public OsisRefRegex getRefRegex()
    {
        return refRegex;
    }

    /**
     * @return the genRegex
     */
    public OsisGenRegex getGenRegex()
    {
        return genRegex;
    }
}
