/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class OsisTextCT
{
    private AnnotateRefType annotateRef;
    private boolean canonical;
    private DivCT[] div;
    private HeaderCT header;
    private String iD;
    private String lang;
    private OsisIDType osisID;
    private OsisWorkType osisIDWork;
    private OsisWorkType osisRefWork;
    private String space;
    private AttributeExtension subType;
    private final String tEIform = "text";
    private TitlePageCT titlePage;
    private AttributeExtension type;

    /**
     * @return the annotateRef
     */
    public AnnotateRefType getAnnotateRef()
    {
        return this.annotateRef;
    }

    /**
     * @return the div
     */
    public DivCT[] getDiv()
    {
        return this.div;
    }

    /**
     * @return the header
     */
    public HeaderCT getHeader()
    {
        return this.header;
    }

    /**
     * @return the iD
     */
    public String getiD()
    {
        return this.iD;
    }

    /**
     * @return the lang
     */
    public String getLang()
    {
        return this.lang;
    }

    /**
     * @return the osisID
     */
    public OsisIDType getOsisID()
    {
        return this.osisID;
    }

    /**
     * @return the osisRefWork
     */
    public OsisWorkType getOsisRefWork()
    {
        return this.osisRefWork;
    }

    /**
     * @return the space
     */
    public String getSpace()
    {
        return this.space;
    }

    /**
     * @return the subType
     */
    public AttributeExtension getSubType()
    {
        return this.subType;
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
     * @return the type
     */
    public AttributeExtension getType()
    {
        return this.type;
    }

    /**
     * @return the canonical
     */
    public boolean isCanonical()
    {
        return this.canonical;
    }

    /**
     * @param annotateRef the annotateRef to set
     */
    public void setAnnotateRef(final AnnotateRefType annotateRef)
    {
        this.annotateRef = annotateRef;
    }

    /**
     * @param canonical the canonical to set
     */
    public void setCanonical(final boolean canonical)
    {
        this.canonical = canonical;
    }

    /**
     * @param div the div to set
     */
    public void setDiv(final DivCT[] div)
    {
        this.div = div;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(final HeaderCT header)
    {
        this.header = header;
    }

    /**
     * @param iD the iD to set
     */
    public void setiD(final String iD)
    {
        this.iD = iD;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(final String lang)
    {
        this.lang = lang;
    }

    /**
     * @param osisID the osisID to set
     */
    public void setOsisID(final OsisIDType osisID)
    {
        this.osisID = osisID;
    }

    /**
     * @param osisRefWork the osisRefWork to set
     */
    public void setOsisRefWork(final OsisWorkType osisRefWork)
    {
        this.osisRefWork = osisRefWork;
    }

    /**
     * @param space the space to set
     */
    public void setSpace(final String space)
    {
        this.space = space;
    }

    /**
     * @param subType the subType to set
     */
    public void setSubType(final AttributeExtension subType)
    {
        this.subType = subType;
    }

    /**
     * @param titlePage the titlePage to set
     */
    public void setTitlePage(final TitlePageCT titlePage)
    {
        this.titlePage = titlePage;
    }

    /**
     * @param type the type to set
     */
    public void setType(final AttributeExtension type)
    {
        this.type = type;
    }

    /**
     * @param osisIDWork the osisIDWork to set
     */
    public void setOsisIDWork(OsisWorkType osisIDWork)
    {
        this.osisIDWork = osisIDWork;
    }

    /**
     * @return the osisIDWork
     */
    public OsisWorkType getOsisIDWork()
    {
        return osisIDWork;
    }

}
