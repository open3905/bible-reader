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
    private HeaderCT header;
    private TitlePageCT titlePage;
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
