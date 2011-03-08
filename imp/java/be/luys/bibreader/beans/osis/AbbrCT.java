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
    private ACT[] a;
    private boolean canonocal;
    private DivineNameCT[] divineName;
    private String expansion;

    private ForeignCT[] foreign;
    private GlobalWithType globalWithType;
    private IndexCT[] index;
    private NameCT[] name;
    private NoteCT[] note;
    private ReferenceCT[] reference;
    private final String tEIform = "abbr";
    private WCT[] w;

    /**
     * @return the a
     */
    public ACT[] getA()
    {
        return this.a;
    }

    /**
     * @return the divineName
     */
    public DivineNameCT[] getDivineName()
    {
        return this.divineName;
    }

    /**
     * @return the expansion
     */
    public String getExpansion()
    {
        return this.expansion;
    }

    /**
     * @return the foreign
     */
    public ForeignCT[] getForeign()
    {
        return this.foreign;
    }

    /**
     * @return the globalWithType
     */
    public GlobalWithType getGlobalWithType()
    {
        return this.globalWithType;
    }

    /**
     * @return the index
     */
    public IndexCT[] getIndex()
    {
        return this.index;
    }

    /**
     * @return the name
     */
    public NameCT[] getName()
    {
        return this.name;
    }

    /**
     * @return the note
     */
    public NoteCT[] getNote()
    {
        return this.note;
    }

    /**
     * @return the reference
     */
    public ReferenceCT[] getReference()
    {
        return this.reference;
    }

    /**
     * @return the tEIform
     */
    public String gettEIform()
    {
        return this.tEIform;
    }

    /**
     * @return the w
     */
    public WCT[] getW()
    {
        return this.w;
    }

    /**
     * @return the canonocal
     */
    public boolean isCanonocal()
    {
        return this.canonocal;
    }

    /**
     * @param a the a to set
     */
    public void setA(final ACT[] a)
    {
        this.a = a;
    }

    /**
     * @param canonocal the canonocal to set
     */
    public void setCanonocal(final boolean canonocal)
    {
        this.canonocal = canonocal;
    }

    /**
     * @param divineName the divineName to set
     */
    public void setDivineName(final DivineNameCT[] divineName)
    {
        this.divineName = divineName;
    }

    /**
     * @param expansion the expansion to set
     */
    public void setExpansion(final String expansion)
    {
        this.expansion = expansion;
    }

    /**
     * @param foreign the foreign to set
     */
    public void setForeign(final ForeignCT[] foreign)
    {
        this.foreign = foreign;
    }

    /**
     * @param globalWithType the globalWithType to set
     */
    public void setGlobalWithType(final GlobalWithType globalWithType)
    {
        this.globalWithType = globalWithType;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(final IndexCT[] index)
    {
        this.index = index;
    }

    /**
     * @param name the name to set
     */
    public void setName(final NameCT[] name)
    {
        this.name = name;
    }

    /**
     * @param note the note to set
     */
    public void setNote(final NoteCT[] note)
    {
        this.note = note;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(final ReferenceCT[] reference)
    {
        this.reference = reference;
    }

    /**
     * @param w the w to set
     */
    public void setW(final WCT[] w)
    {
        this.w = w;
    }

}
