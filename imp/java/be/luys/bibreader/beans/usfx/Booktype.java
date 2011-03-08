/**
 * 
 */
package be.luys.bibreader.beans.usfx;

/**
 * @author fks/el
 * 
 */
public class Booktype
{
    private String id;

    private IdType idType;
    private IdeType ideType;

    private String[] rem;
    private HType[] h;
    private String[] cl;
    private PType[] p;
    private PType[] q;
    private PType[] mt;
    private PType[] d;
    private PType[] s;
    private SectionBoundaryType[] sectionBoundary;
    private BType[] b;
    private GeneratedType[] generated;
    private CType[] c;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("--- Booktype ---");
        if (id != null)
        {
            sb.append("id:").append(this.id);
        }
        if (idType != null)
        {
            sb.append("idType:").append(this.idType);
        }
        if (ideType != null)
        {
            sb.append("ideType:").append(this.ideType);
        }
        if (rem != null)
        {
            int i =1;
            for (Object o : rem)
            {
                sb.append("rem ").append(i++).append(":").append(o);
            }
        }
        if (h != null)
        {
            int i =1;
            for (Object o : h)
            {
                sb.append("h ").append(i++).append(":").append(o);
            }
        }
        if (cl != null)
        {
            int i =1;
            for (Object o :cl)
            {
                sb.append("cl ").append(i++).append(":").append(o);
            }
        }
        if (p != null)
        {
            int i =1;
            for (Object o :p)
            {
                sb.append("p ").append(i++).append(":").append(o);
            }
        }
        if (q != null)
        {
            int i =1;
            for (Object o :q)
            {
                sb.append("q ").append(i++).append(":").append(o);
            }
        }
        if (mt != null)
        {
            int i =1;
            for (Object o :mt)
            {
                sb.append("mt ").append(i++).append(":").append(o);
            }
        }
        if (d != null)
        {
            int i =1;
            for (Object o :d)
            {
                sb.append("d").append(i++).append(":").append(o);
            }
        }
        if (s != null)
        {
            int i =1;
            for (Object o :s)
            {
                sb.append("s ").append(i++).append(":").append(o);
            }
        }
        if (sectionBoundary != null)
        {
            int i =1;
            for (Object o :sectionBoundary)
            {
                sb.append("sectionBoundary ").append(i++).append(":").append(o);
            }
        }
        if (b != null)
        {
            int i =1;
            for (Object o :b)
            {
                sb.append("b ").append(i++).append(":").append(o);
            }
        }
        if (generated != null)
        {
            int i =1;
            for (Object o :generated)
            {
                sb.append("generated ").append(i++).append(":").append(o);
            }
        }
        if (c != null)
        {
            int i =1;
            for (Object o :c)
            {
                sb.append("c ").append(i++).append(":").append(o);
            }
        }
        sb.append("---  ---");
        return sb.toString();
    }

}
