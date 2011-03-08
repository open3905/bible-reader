/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class DivCT extends Milestoneable
{
    private ACT[] a;
    private AbbrCT[] abbr;
    private boolean canonical;
    private ChapterCT[] chapter;
    private CloserCT[] closer;
    private DateCT[] date;
    private DivCT[] div;
    private DivineNameCT[] divineName;
    private FigureCT[] figure;
    private ForeignCT[] foreign;
    private GlobalWithoutType globalWithoutType;
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
    private OsisRefType osisRef;
    private PCT[] p;
    private QCT[] q;
    private ReferenceCT[] reference;
    private SaluteCT[] salute;
    private OsisRefType scope;
    private SegCT[] seg;
    private SignedCT[] signed;
    private SpeakerCT[] speaker;
    private SpeechCT[] speech;
    private TableCT[] table;
    private final String tEIform = "div";
    private TitleCT[] title;
    private TitlePageCT titlePage;
    private TransChangeCT[] transChange;
    private DivType type;
    private VerseCT[] verse;
    private WCT[] w;

    /**
     * @return the a
     */
    public ACT[] getA()
    {
        return this.a;
    }

    /**
     * @return the abbr
     */
    public AbbrCT[] getAbbr()
    {
        return this.abbr;
    }

    /**
     * @return the chapter
     */
    public ChapterCT[] getChapter()
    {
        return this.chapter;
    }

    /**
     * @return the closer
     */
    public CloserCT[] getCloser()
    {
        return this.closer;
    }

    /**
     * @return the date
     */
    public DateCT[] getDate()
    {
        return this.date;
    }

    /**
     * @return the div
     */
    public DivCT[] getDiv()
    {
        return this.div;
    }

    /**
     * @return the divineName
     */
    public DivineNameCT[] getDivineName()
    {
        return this.divineName;
    }

    /**
     * @return the figure
     */
    public FigureCT[] getFigure()
    {
        return this.figure;
    }

    /**
     * @return the foreign
     */
    public ForeignCT[] getForeign()
    {
        return this.foreign;
    }

    /**
     * @return the globalWithoutType
     */
    public GlobalWithoutType getGlobalWithoutType()
    {
        return this.globalWithoutType;
    }

    /**
     * @return the hi
     */
    public HiCT[] getHi()
    {
        return this.hi;
    }

    /**
     * @return the index
     */
    public IndexCT[] getIndex()
    {
        return this.index;
    }

    /**
     * @return the inscription
     */
    public InscriptionCT[] getInscription()
    {
        return this.inscription;
    }

    /**
     * @return the lb
     */
    public LbCT[] getLb()
    {
        return this.lb;
    }


    /**
     * @return the list
     */
    public ListCT[] getList()
    {
        return this.list;
    }

    /**
     * @return the mentioned
     */
    public MentionedCT[] getMentioned()
    {
        return this.mentioned;
    }

    /**
     * @return the milestone
     */
    public MilestoneCT[] getMilestone()
    {
        return this.milestone;
    }

    /**
     * @return the milestoneEnd
     */
    public MilestoneEndCT[] getMilestoneEnd()
    {
        return this.milestoneEnd;
    }

    /**
     * @return the milestoneStart
     */
    public MilestoneStartCT[] getMilestoneStart()
    {
        return this.milestoneStart;
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
     * @return the osisRef
     */
    public OsisRefType getOsisRef()
    {
        return this.osisRef;
    }

    /**
     * @return the p
     */
    public PCT[] getP()
    {
        return this.p;
    }

    /**
     * @return the q
     */
    public QCT[] getQ()
    {
        return this.q;
    }

    /**
     * @return the reference
     */
    public ReferenceCT[] getReference()
    {
        return this.reference;
    }

    /**
     * @return the salute
     */
    public SaluteCT[] getSalute()
    {
        return this.salute;
    }

    /**
     * @return the scope
     */
    public OsisRefType getScope()
    {
        return this.scope;
    }

    /**
     * @return the seg
     */
    public SegCT[] getSeg()
    {
        return this.seg;
    }

    /**
     * @return the signed
     */
    public SignedCT[] getSigned()
    {
        return this.signed;
    }

    /**
     * @return the speaker
     */
    public SpeakerCT[] getSpeaker()
    {
        return this.speaker;
    }

    /**
     * @return the speech
     */
    public SpeechCT[] getSpeech()
    {
        return this.speech;
    }

    /**
     * @return the table
     */
    public TableCT[] getTable()
    {
        return this.table;
    }

    /**
     * @return the tEIform
     */
    public String gettEIform()
    {
        return this.tEIform;
    }

    /**
     * @return the title
     */
    public TitleCT[] getTitle()
    {
        return this.title;
    }

    /**
     * @return the titlePage
     */
    public TitlePageCT getTitlePage()
    {
        return this.titlePage;
    }

    /**
     * @return the transChange
     */
    public TransChangeCT[] getTransChange()
    {
        return this.transChange;
    }

    /**
     * @return the type
     */
    public DivType getType()
    {
        return this.type;
    }

    /**
     * @return the verse
     */
    public VerseCT[] getVerse()
    {
        return this.verse;
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
     * @param abbr the abbr to set
     */
    public void setAbbr(final AbbrCT[] abbr)
    {
        this.abbr = abbr;
    }

    /**
     * @param canonical the canonical to set
     */
    public void setCanonical(final boolean canonical)
    {
        this.canonical = canonical;
    }

    /**
     * @param chapter the chapter to set
     */
    public void setChapter(final ChapterCT[] chapter)
    {
        this.chapter = chapter;
    }

    /**
     * @param closer the closer to set
     */
    public void setCloser(final CloserCT[] closer)
    {
        this.closer = closer;
    }

    /**
     * @param date the date to set
     */
    public void setDate(final DateCT[] date)
    {
        this.date = date;
    }

    /**
     * @param div the div to set
     */
    public void setDiv(final DivCT[] div)
    {
        this.div = div;
    }

    /**
     * @param divineName the divineName to set
     */
    public void setDivineName(final DivineNameCT[] divineName)
    {
        this.divineName = divineName;
    }

    /**
     * @param figure the figure to set
     */
    public void setFigure(final FigureCT[] figure)
    {
        this.figure = figure;
    }

    /**
     * @param foreign the foreign to set
     */
    public void setForeign(final ForeignCT[] foreign)
    {
        this.foreign = foreign;
    }

    /**
     * @param globalWithoutType the globalWithoutType to set
     */
    public void setGlobalWithoutType(final GlobalWithoutType globalWithoutType)
    {
        this.globalWithoutType = globalWithoutType;
    }

    /**
     * @param hi the hi to set
     */
    public void setHi(final HiCT[] hi)
    {
        this.hi = hi;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(final IndexCT[] index)
    {
        this.index = index;
    }

    /**
     * @param inscription the inscription to set
     */
    public void setInscription(final InscriptionCT[] inscription)
    {
        this.inscription = inscription;
    }

    /**
     * @param lb the lb to set
     */
    public void setLb(final LbCT[] lb)
    {
        this.lb = lb;
    }


    /**
     * @param list the list to set
     */
    public void setList(final ListCT[] list)
    {
        this.list = list;
    }

    /**
     * @param mentioned the mentioned to set
     */
    public void setMentioned(final MentionedCT[] mentioned)
    {
        this.mentioned = mentioned;
    }

    /**
     * @param milestone the milestone to set
     */
    public void setMilestone(final MilestoneCT[] milestone)
    {
        this.milestone = milestone;
    }

    /**
     * @param milestoneEnd the milestoneEnd to set
     */
    public void setMilestoneEnd(final MilestoneEndCT[] milestoneEnd)
    {
        this.milestoneEnd = milestoneEnd;
    }

    /**
     * @param milestoneStart the milestoneStart to set
     */
    public void setMilestoneStart(final MilestoneStartCT[] milestoneStart)
    {
        this.milestoneStart = milestoneStart;
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
     * @param osisRef the osisRef to set
     */
    public void setOsisRef(final OsisRefType osisRef)
    {
        this.osisRef = osisRef;
    }

    /**
     * @param p the p to set
     */
    public void setP(final PCT[] p)
    {
        this.p = p;
    }

    /**
     * @param q the q to set
     */
    public void setQ(final QCT[] q)
    {
        this.q = q;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(final ReferenceCT[] reference)
    {
        this.reference = reference;
    }

    /**
     * @param salute the salute to set
     */
    public void setSalute(final SaluteCT[] salute)
    {
        this.salute = salute;
    }

    /**
     * @param scope the scope to set
     */
    public void setScope(final OsisRefType scope)
    {
        this.scope = scope;
    }

    /**
     * @param seg the seg to set
     */
    public void setSeg(final SegCT[] seg)
    {
        this.seg = seg;
    }

    /**
     * @param signed the signed to set
     */
    public void setSigned(final SignedCT[] signed)
    {
        this.signed = signed;
    }

    /**
     * @param speaker the speaker to set
     */
    public void setSpeaker(final SpeakerCT[] speaker)
    {
        this.speaker = speaker;
    }

    /**
     * @param speech the speech to set
     */
    public void setSpeech(final SpeechCT[] speech)
    {
        this.speech = speech;
    }

    /**
     * @param table the table to set
     */
    public void setTable(final TableCT[] table)
    {
        this.table = table;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(final TitleCT[] title)
    {
        this.title = title;
    }

    /**
     * @param titlePage the titlePage to set
     */
    public void setTitlePage(final TitlePageCT titlePage)
    {
        this.titlePage = titlePage;
    }

    /**
     * @param transChange the transChange to set
     */
    public void setTransChange(final TransChangeCT[] transChange)
    {
        this.transChange = transChange;
    }

    /**
     * @param type the type to set
     */
    public void setType(final DivType type)
    {
        this.type = type;
    }

    /**
     * @param verse the verse to set
     */
    public void setVerse(final VerseCT[] verse)
    {
        this.verse = verse;
    }

    /**
     * @param w the w to set
     */
    public void setW(final WCT[] w)
    {
        this.w = w;
    }

    /**
     * @return the lg
     */
    public LgCT[] getLg()
    {
        return lg;
    }

    /**
     * @param lg the lg to set
     */
    public void setLg(LgCT[] lg)
    {
        this.lg = lg;
    }
}
