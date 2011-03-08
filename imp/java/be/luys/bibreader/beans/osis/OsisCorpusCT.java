/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class OsisCorpusCT
{
    private CorpusHeaderCT header;
    private OsisTextCT[] osisText;
    private final String tEIform = "teiCorpus.2";
    private TitlePageCT titlePage;

    /**
     * @return the header
     */
    public CorpusHeaderCT getHeader()
    {
        return this.header;
    }

    /**
     * @return the osisText
     */
    public OsisTextCT[] getOsisText()
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
     * @return the titlePage
     */
    public TitlePageCT getTitlePage()
    {
        return this.titlePage;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(final CorpusHeaderCT header)
    {
        this.header = header;
    }

    /**
     * @param osisText the osisText to set
     */
    public void setOsisText(final OsisTextCT[] osisText)
    {
        this.osisText = osisText;
    }

    /**
     * @param titlePage the titlePage to set
     */
    public void setTitlePage(final TitlePageCT titlePage)
    {
        this.titlePage = titlePage;
    }

}
