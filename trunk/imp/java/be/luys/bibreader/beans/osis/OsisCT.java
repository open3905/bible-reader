/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class OsisCT
{
    private OsisCorpusCT osisCorpus;
    private OsisTextCT osisText;
    private final String tEIform = "TEI.2";

    /**
     * @return the osisCorpus
     */
    public OsisCorpusCT getOsisCorpus()
    {
        return this.osisCorpus;
    }

    /**
     * @return the osisText
     */
    public OsisTextCT getOsisText()
    {
        return this.osisText;
    }

    /**
     * @return the tEIform
     */
    public String gettEIform()
    {
        return this.tEIform;
    }

    /**
     * @param osisCorpus the osisCorpus to set
     */
    public void setOsisCorpus(final OsisCorpusCT osisCorpus)
    {
        this.osisCorpus = osisCorpus;
    }

    /**
     * @param osisText the osisText to set
     */
    public void setOsisText(final OsisTextCT osisText)
    {
        this.osisText = osisText;
    }

}
