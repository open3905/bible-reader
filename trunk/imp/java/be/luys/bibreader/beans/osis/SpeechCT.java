/**
 * 
 */
package be.luys.bibreader.beans.osis;

import java.sql.Ref;

/**
 * @author fks/el
 * 
 */
public class SpeechCT extends Milestoneable
{
    private boolean canonical;
    private GlobalWithType globalWithType;
    private String marker;
    private String tEIform;

    private SpeechCT[] speech;
    private ACT[] a;
    private AbbrCT[] abbr;
    private ChapterCT[] chapter;
    private CloserCT[] closer;
    private DateCT[] date;
    private DivineNameCT[] divineName;
    private ForeignCT[] foreign;
    private HiCT[] hi;
    private IndexCT[] index;
    private InscriptionCT[] inscription;
    private LbCT[] lb;
    private LgCT[] lg;
    private ListCT[] list;
    private MentionedCT[] mentioned;
    private MilestoneCT[] milestone;
    private MilestoneEndCT[] milestoneEnd;
    private MilestoneStartCT[] milestoneStart;
    private NameCT[] name;
    private NoteCT[] note;
    private PCT[] p;
    private QCT[] q;
    private ReferenceCT[] reference;
    private SaluteCT[] salute;
    private SegCT[] seg;
    private SignedCT[] signed;
    private SpeakerCT[] speaker;
    private TableCT[] table;
    private TitleCT[] title;
    private TransChangeCT[] transChange;
    private VerseCT[] verse;
    private WCT[] w;
}
