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
    /**
     * 1
     */
    private HeaderCT header;
    /**
     *  0 - 1
     */
    private TitlePageCT titlePage;
    /**
     * 0 - ...
     */
    private DivCT div;
    private AnnotateRefType annotateRef;
    private boolean canonical;
    private String iD;
    private OsisIDType osisID;
    private OsisWorkType osisWork;
    private OsisWorkType osisRefWork;
    private AttributeExtension type;
    private AttributeExtension subType;
    private String lang;
    private String space;
    private static final String TEIform = "text";

}
