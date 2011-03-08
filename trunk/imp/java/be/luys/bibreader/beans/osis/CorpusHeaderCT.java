/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class CorpusHeaderCT
{
    private boolean canonical;
    private RevisionDescCT[] revisionDesc;
    private final String tEIformat = "teiHeader";
    private WorkCT[] work;

    /**
     * @return the revisionDesc
     */
    public RevisionDescCT[] getRevisionDesc()
    {
        return this.revisionDesc;
    }

    /**
     * @return the tEIformat
     */
    public String gettEIformat()
    {
        return this.tEIformat;
    }

    /**
     * @return the work
     */
    public WorkCT[] getWork()
    {
        return this.work;
    }

    /**
     * @return the canonical
     */
    public boolean isCanonical()
    {
        return this.canonical;
    }

    /**
     * @param canonical the canonical to set
     */
    public void setCanonical(final boolean canonical)
    {
        this.canonical = canonical;
    }

    /**
     * @param revisionDesc the revisionDesc to set
     */
    public void setRevisionDesc(final RevisionDescCT[] revisionDesc)
    {
        this.revisionDesc = revisionDesc;
    }

    /**
     * @param work the work to set
     */
    public void setWork(final WorkCT[] work)
    {
        this.work = work;
    }
}
