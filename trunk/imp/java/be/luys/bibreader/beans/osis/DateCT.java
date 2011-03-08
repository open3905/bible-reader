/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class DateCT
{
    private ACT[] a;
    private boolean canonical;
    private EventType event;
    private GlobalWithType globalWithType;
    private IndexCT[] index;
    private NoteCT[] note;
    private final String tEIformat = "date";
    private Calendar type;
    private WCT[] w;

    /**
     * @return the a
     */
    public ACT[] getA()
    {
        return this.a;
    }

    /**
     * @return the event
     */
    public EventType getEvent()
    {
        return this.event;
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
     * @return the note
     */
    public NoteCT[] getNote()
    {
        return this.note;
    }

    /**
     * @return the tEIformat
     */
    public String gettEIformat()
    {
        return this.tEIformat;
    }

    /**
     * @return the type
     */
    public Calendar getType()
    {
        return this.type;
    }

    /**
     * @return the w
     */
    public WCT[] getW()
    {
        return this.w;
    }

    /**
     * @return the canonical
     */
    public boolean isCanonical()
    {
        return this.canonical;
    }

    /**
     * @param a the a to set
     */
    public void setA(final ACT[] a)
    {
        this.a = a;
    }

    /**
     * @param canonical the canonical to set
     */
    public void setCanonical(final boolean canonical)
    {
        this.canonical = canonical;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(final EventType event)
    {
        this.event = event;
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
     * @param note the note to set
     */
    public void setNote(final NoteCT[] note)
    {
        this.note = note;
    }

    /**
     * @param type the type to set
     */
    public void setType(final Calendar type)
    {
        this.type = type;
    }

    /**
     * @param w the w to set
     */
    public void setW(final WCT[] w)
    {
        this.w = w;
    }
}
