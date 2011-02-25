/**
 * 
 */
package be.luys.bibreader.beans.osis;

import java.io.Serializable;

/**
 * @author fks/el
 * 
 */
public class RevisionDescCT implements Serializable
{
    private DateCT date;
    private PCT p;
    private boolean canonical;
    private GlobalWithType globalWithType;
    public static final String TEIform = "revisionDesc";
}
