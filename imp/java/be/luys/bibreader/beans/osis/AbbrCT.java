/**
 * 
 */
package be.luys.bibreader.beans.osis;


/**
 * @author fks/el
 * 
 */
public class AbbrCT extends Milestoneable
{
    private GlobalWithType globalWithType;
    private AnnotateRefType annotateRef;
    private String annotateWork;
    private AnnotationType annotateType;
    private String[] editions;
    private String iD;
    private OsisIDType osisID;
    private String resp;
    private AttributeExtension type;
    private AttributeExtension subType;
    private String n;
    private String lang;
    private String space;
    private OsisScripts script;
    private boolean canonocal;
    private String tEIform;

    private ACT[] a;
    private DivineNameCT[] divineName;
    private ForeignCT[] foreign;
    private IndexCT[] index;
    private NameCT[] name;
    private NoteCT[] note;
    private ReferenceCT[] reference;
    private WCT[] w;

}
