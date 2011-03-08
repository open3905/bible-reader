/**
 * 
 */
package be.luys.bibreader.parsers.osis;

import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;

import be.luys.bibreader.beans.osis.ACT;
import be.luys.bibreader.beans.osis.AbbrCT;
import be.luys.bibreader.beans.osis.AnnotateRefType;
import be.luys.bibreader.beans.osis.AttributeExtension;
import be.luys.bibreader.beans.osis.Calendar;
import be.luys.bibreader.beans.osis.ChapterCT;
import be.luys.bibreader.beans.osis.CloserCT;
import be.luys.bibreader.beans.osis.ContributorCT;
import be.luys.bibreader.beans.osis.CorpusHeaderCT;
import be.luys.bibreader.beans.osis.CoverageCT;
import be.luys.bibreader.beans.osis.CreatorCT;
import be.luys.bibreader.beans.osis.DateCT;
import be.luys.bibreader.beans.osis.DescriptionCT;
import be.luys.bibreader.beans.osis.DescriptionType;
import be.luys.bibreader.beans.osis.DivCT;
import be.luys.bibreader.beans.osis.DivType;
import be.luys.bibreader.beans.osis.DivineNameCT;
import be.luys.bibreader.beans.osis.EventType;
import be.luys.bibreader.beans.osis.FigureCT;
import be.luys.bibreader.beans.osis.ForeignCT;
import be.luys.bibreader.beans.osis.FormatCT;
import be.luys.bibreader.beans.osis.GlobalWithType;
import be.luys.bibreader.beans.osis.GlobalWithoutType;
import be.luys.bibreader.beans.osis.HeaderCT;
import be.luys.bibreader.beans.osis.HiCT;
import be.luys.bibreader.beans.osis.IdentifierCT;
import be.luys.bibreader.beans.osis.IndexCT;
import be.luys.bibreader.beans.osis.InscriptionCT;
import be.luys.bibreader.beans.osis.LanguageCT;
import be.luys.bibreader.beans.osis.LbCT;
import be.luys.bibreader.beans.osis.LgCT;
import be.luys.bibreader.beans.osis.ListCT;
import be.luys.bibreader.beans.osis.MentionedCT;
import be.luys.bibreader.beans.osis.MilestoneCT;
import be.luys.bibreader.beans.osis.MilestoneEndCT;
import be.luys.bibreader.beans.osis.MilestoneStartCT;
import be.luys.bibreader.beans.osis.NameCT;
import be.luys.bibreader.beans.osis.NoteCT;
import be.luys.bibreader.beans.osis.OsisAnnotateRefType;
import be.luys.bibreader.beans.osis.OsisCT;
import be.luys.bibreader.beans.osis.OsisCorpusCT;
import be.luys.bibreader.beans.osis.OsisIDRegex;
import be.luys.bibreader.beans.osis.OsisIDType;
import be.luys.bibreader.beans.osis.OsisRefType;
import be.luys.bibreader.beans.osis.OsisTextCT;
import be.luys.bibreader.beans.osis.OsisWorkType;
import be.luys.bibreader.beans.osis.PCT;
import be.luys.bibreader.beans.osis.PublisherCT;
import be.luys.bibreader.beans.osis.QCT;
import be.luys.bibreader.beans.osis.ReferenceCT;
import be.luys.bibreader.beans.osis.RelationCT;
import be.luys.bibreader.beans.osis.RevisionDescCT;
import be.luys.bibreader.beans.osis.RoleType;
import be.luys.bibreader.beans.osis.SaluteCT;
import be.luys.bibreader.beans.osis.SegCT;
import be.luys.bibreader.beans.osis.SignedCT;
import be.luys.bibreader.beans.osis.SourceCT;
import be.luys.bibreader.beans.osis.SpeakerCT;
import be.luys.bibreader.beans.osis.SpeechCT;
import be.luys.bibreader.beans.osis.SubjectCT;
import be.luys.bibreader.beans.osis.TableCT;
import be.luys.bibreader.beans.osis.TitleCT;
import be.luys.bibreader.beans.osis.TitlePageCT;
import be.luys.bibreader.beans.osis.TransChangeCT;
import be.luys.bibreader.beans.osis.TypeCT;
import be.luys.bibreader.beans.osis.VerseCT;
import be.luys.bibreader.beans.osis.WCT;
import be.luys.bibreader.beans.osis.WorkCT;
import be.luys.bibreader.parsers.ParserTool;

/**
 * @author fks/el
 * 
 */
public class OsisParser
{

    private static Namespace ns = Namespace.getNamespace("http://www.bibletechnologies.net/2003/OSIS/namespace");

    public static OsisCT parseOsis(final Document doc)
    {
        final OsisCT result = new OsisCT();
        final Element root = doc.getRootElement();
        result.setOsisText(readOsisText("osis", root.getChild("osisText", ns)));
        result.setOsisCorpus(readOsisCorpus("osis", root.getChild("osisCorpus", ns)));
        return result;
    }

    /**
     * @param src
     * @param element
     * @return
     */
    @SuppressWarnings("unchecked")
    private static AbbrCT readAbbrCT(String src, final Element eAbbrCT)
    {
        src = src + "::readAbbrCT";
        System.out.println(src + ": " + (eAbbrCT == null ? "n/a" : eAbbrCT.getName()));
        if (eAbbrCT != null)
        {
            final AbbrCT result = new AbbrCT();
            result.setA(readACTs(src, eAbbrCT.getChildren("a", ns)));
            result.setCanonocal(ParserTool.getBooleanAttributeValue(eAbbrCT, "canonical", null));
            result.setDivineName(readDivineName(src, eAbbrCT.getChildren("divineName", ns)));
            result.seteID(eAbbrCT.getAttributeValue("eID"));
            result.setExpansion(eAbbrCT.getAttributeValue("expansion"));
            result.setForeign(readForeignCTs(src, eAbbrCT.getChildren("foreign", ns)));
            result.setGlobalWithType(readGlobalWithType(src, eAbbrCT));
            result.setIndex(readIndexCTs(src, eAbbrCT.getChildren("index", ns)));
            result.setName(readNameCTs(src, eAbbrCT.getChildren("name", ns)));
            result.setNote(readNoteCTs(src, eAbbrCT.getChildren("note", ns)));
            result.setReference(readReferenceCTs(src, eAbbrCT.getChildren("reference", ns)));
            result.setsID(eAbbrCT.getAttributeValue("sID"));
            result.setW(readWCTs(src, eAbbrCT.getChildren("w", ns)));
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static AbbrCT[] readAbbrCTs(String src, final List<Element> eAbbrCTs)
    {
        src = src + "::readAbbrCTs";
        System.out.println(src + ": " + (eAbbrCTs == null ? "n/a" : eAbbrCTs.size() + " elements"));
        int l;
        if ((eAbbrCTs != null) && ((l = eAbbrCTs.size()) > 0))
        {
            final AbbrCT[] result = new AbbrCT[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = readAbbrCT(src, eAbbrCTs.get(i));
            }
            return result;
        }
        return null;
    }

    /**
     * @param element
     * @return
     */
    @SuppressWarnings("unchecked")
    private static ACT readACT(String src, final Element eACT)
    {
        src = src + "::readACT";
        System.out.println(src + ": " + (eACT == null ? "n/a" : eACT.getName()));
        if (eACT != null)
        {
            final ACT result = new ACT();
            result.setIndex(readIndexCTs(src, eACT.getChildren("index", ns)));
            result.setCanonical(ParserTool.getBooleanAttributeValue(eACT, "canonical", null));
            result.setHref(eACT.getAttributeValue("href"));
            result.setGlobalWithType(readGlobalWithType(src, eACT));
            return result;
        }
        return null;
    }

    /**
     * @param children
     * @return
     */
    private static ACT[] readACTs(String src, final List<Element> eACTs)
    {
        src = src + "::readACTs";
        System.out.println(src + ": " + (eACTs == null ? "n/a" : eACTs.size() + " elements"));
        int l;
        if ((eACTs != null) && ((l = eACTs.size()) > 0))
        {
            final ACT[] result = new ACT[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = readACT(src, eACTs.get(i));
            }
            return result;
        }
        return null;
    }

    /**
     * @param attribute
     * @return
     */
    private static AnnotateRefType readAnnotateRefType(String src, final Attribute aAnnotateRefType)
    {
        src = src + "::readAnnotateRefType";
        System.out.println(src + ": " + (aAnnotateRefType == null ? "n/a" : aAnnotateRefType.getName()));
        String value;
        if ((aAnnotateRefType != null) && ((value = aAnnotateRefType.getValue()) != null) && ((value = value.trim()).length() > 0))
        {
            final AnnotateRefType result = new AnnotateRefType();
            result.setTypes(readOsisAnnotateRefTypes(src, value.split(" ")));
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param attribute
     * @return
     */
    private static AttributeExtension readAttributeExtension(String src, final Attribute aAttributeExtension)
    {
        src = src + "::readAttributeExtension";
        System.out.println(src + ": " + (aAttributeExtension == null ? "n/a" : aAttributeExtension.getName()));
        String value;
        if ((aAttributeExtension != null) && ((value = aAttributeExtension.getValue()) != null) && ((value = value.trim()).length() > 0))
        {
            final AttributeExtension result = new AttributeExtension();
            if (result.setValue(value))
            {
                System.out.println(src + "::result= " + value);
                return result;
            }
        }
        return null;
    }

    /**
     * @param src
     * @param attribute
     * @return
     */
    private static Calendar readCalendar(String src, final Attribute aCalendar)
    {
        src = src + "::readCalendar";
        System.out.println(src + ": " + (aCalendar == null ? "n/a" : aCalendar.getName()));
        String value;
        if ((aCalendar != null) && ((value = aCalendar.getValue()) != null) && ((value = value.trim()).length() > 0))
        {
            final Calendar[] values = Calendar.values();
            for (final Calendar c : values)
            {
                if (c.toString().equals(value))
                {
                    System.out.println(src + "::result= " + c);
                    return c;
                }
            }
        }
        return null;
    }

    /**
     * @param src
     * @param element
     * @return
     */
    @SuppressWarnings("unchecked")
    private static ChapterCT readChapterCT(String src, final Element eChapterCT)
    {
        src = src + "::readChapterCT";
        System.out.println(src + ": " + (eChapterCT == null ? "n/a" : eChapterCT.getName()));
        if (eChapterCT != null)
        {
            final ChapterCT result = new ChapterCT();
            result.setA(readACTs(src, eChapterCT.getChildren("a", ns)));
            result.setAbbr(readAbbrCTs(src, eChapterCT.getChildren("abbr", ns)));
            result.setCanonical(ParserTool.getBooleanAttributeValue(eChapterCT, "canonical", ns));
            result.setChapterTitle(eChapterCT.getAttributeValue("chapterTitle"));
            result.setCloser(readCloserCTs(src, eChapterCT.getChildren("closer", ns)));
            result.setDate(readDateCTs(src, eChapterCT.getChildren("date", ns)));
            result.setDiv(readDivCTs(src, eChapterCT.getChildren("div", ns)));
            result.setDivineName(readDivineName(src, eChapterCT.getChildren("divineName", ns)));
            result.seteID(eChapterCT.getAttributeValue("eID"));
            result.setFigure(readFigureCTs(src, eChapterCT.getChildren("figure", ns)));
            result.setForeign(readForeignCTs(src, eChapterCT.getChildren("foreign", ns)));
            result.setGlobalWithType(readGlobalWithType(src, eChapterCT));
            result.setHi(readHiCTs(src, eChapterCT.getChildren("hi", ns)));
            result.setIndex(readIndexCTs(src, eChapterCT.getChildren("index", ns)));
            result.setInscription(readInscriptionCTs(src, eChapterCT.getChildren("inscription", ns)));
            result.setLb(readLbCTs(src, eChapterCT.getChildren("lb", ns)));
            result.setLg(readLgCTs(src, eChapterCT.getChildren("lg", ns)));
            result.setList(readListCTs(src, eChapterCT.getChildren("list", ns)));
            result.setMentioned(readMentionedCTs(src, eChapterCT.getChildren("mentioned", ns)));
            result.setMilestone(readMilestoneCTs(src, eChapterCT.getChildren("milestone", ns)));
            result.setMilestoneEnd(readMilestoneEndCTs(src, eChapterCT.getChildren("milestoneEnd", ns)));
            result.setMilestoneStart(readMilestoneStartCTs(src, eChapterCT.getChildren("milestoneStart", ns)));
            result.setName(readNameCTs(src, eChapterCT.getChildren("name", ns)));
            result.setNote(readNoteCTs(src, eChapterCT.getChildren("note", ns)));
            result.setOsisRef(readOsisRefType(src, eChapterCT.getAttribute("osisRef")));
            result.setP(readPCTs(src, eChapterCT.getChildren("p", ns)));
            result.setQ(readQCTs(src, eChapterCT.getChildren("q", ns)));
            result.setReference(readReferenceCTs(src, eChapterCT.getChildren("reference", ns)));
            result.setSalute(readSaluteCTs(src, eChapterCT.getChildren("salute", ns)));
            result.setSeg(readSegCTs(src, eChapterCT.getChildren("seg", ns)));
            result.setsID(eChapterCT.getAttributeValue("sID"));
            result.setSigned(readSignedCTs(src, eChapterCT.getChildren("signed", ns)));
            result.setSpeaker(readSpeakerCTs(src, eChapterCT.getChildren("speaker", ns)));
            result.setSpeech(readSpeechCTs(src, eChapterCT.getChildren("speech", ns)));
            result.setTable(readTableCTs(src, eChapterCT.getChildren("table", ns)));
            result.setTitle(readTitleCTs(src, eChapterCT.getChildren("title", ns)));
            result.setTransChange(readTransChangeCTs(src, eChapterCT.getChildren("transChange", ns)));
            result.setVerse(readVerseCTs(src, eChapterCT.getChildren("verse", ns)));
            result.setW(readWCTs(src, eChapterCT.getChildren("w", ns)));
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static ChapterCT[] readChapterCTs(String src, final List<Element> eChapterCTs)
    {
        src = src + "::readChapterCTs";
        System.out.println(src + ": " + (eChapterCTs == null ? "n/a" : eChapterCTs.size() + " elements"));
        int l;
        if ((eChapterCTs != null) && ((l = eChapterCTs.size()) > 0))
        {
            final ChapterCT[] result = new ChapterCT[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = readChapterCT(src, eChapterCTs.get(i));
            }
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static CloserCT[] readCloserCTs(String src, final List<Element> eCloserCTs)
    {
        src = src + "::readCloserCTs";
        System.out.println(src + ": " + (eCloserCTs == null ? "n/a" : eCloserCTs.size() + " elements"));
        int l;
        if ((eCloserCTs != null) && ((l = eCloserCTs.size()) > 0))
        {
            final CloserCT[] result = new CloserCT[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = readCloserCT(src, eCloserCTs.get(i));
            }
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param element
     * @return
     */
    private static CloserCT readCloserCT(String src, Element element)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param element
     * @return
     */
    private static ContributorCT readContributorCT(String src, final Element eContributorCT)
    {
        src = src + "::readContributorCT";
        System.out.println(src + ": " + (eContributorCT == null ? "n/a" : eContributorCT.getName()));
        if (eContributorCT != null)
        {
            final ContributorCT result = new ContributorCT();
            result.setValue(eContributorCT.getTextNormalize());
            result.setCanonical(ParserTool.getBooleanAttributeValue(eContributorCT, "canonical", null));
            result.setFile_as(eContributorCT.getAttributeValue("file-as"));
            result.setGlobalWithType(readGlobalWithType(src, eContributorCT));
            result.setRole(readRoleType(src, eContributorCT.getAttribute("role")));
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static ContributorCT[] readContributorCTs(String src, final List<Element> eContributorCTs)
    {
        src = src + "::readContributorCTs";
        System.out.println(src + ": " + (eContributorCTs == null ? "n/a" : eContributorCTs.size() + " elements"));
        int l;
        if ((eContributorCTs != null) && ((l = eContributorCTs.size()) > 0))
        {
            final ContributorCT[] result = new ContributorCT[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = readContributorCT(src, eContributorCTs.get(i));
            }
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param child
     * @return
     */
    @SuppressWarnings("unchecked")
    private static CorpusHeaderCT readCorpusHeaderCT(String src, final Element eCorpusHeaderCT)
    {
        src = src + "::readCorpusHeaderCT";
        System.out.println(src + ": " + (eCorpusHeaderCT == null ? "n/a" : eCorpusHeaderCT.getName()));
        if (eCorpusHeaderCT != null)
        {
            final CorpusHeaderCT result = new CorpusHeaderCT();
            result.setCanonical(ParserTool.getBooleanAttributeValue(eCorpusHeaderCT, "canonical", ns));
            result.setRevisionDesc(readRevisionDescCTs(src, eCorpusHeaderCT.getChildren("revisionDesc", ns)));
            result.setWork(readWorkCTs(src, eCorpusHeaderCT.getChildren("work", ns)));
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param element
     * @return
     */
    private static CoverageCT readCoverageCT(String src, final Element eCoverageCT)
    {
        src = src + "::readCoverageCT";
        System.out.println(src + ": " + (eCoverageCT == null ? "n/a" : eCoverageCT.getName()));
        if (eCoverageCT != null)
        {
            final CoverageCT result = new CoverageCT();
            result.setValue(eCoverageCT.getTextNormalize());
            result.setCanonical(ParserTool.getBooleanAttributeValue(eCoverageCT, "canonical", null));
            result.setGlobalWithType(readGlobalWithType(src, eCoverageCT));
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static CoverageCT[] readCoverageCTs(String src, final List<Element> eCoverageCTs)
    {
        src = src + "::readCoverageCTs";
        System.out.println(src + ": " + (eCoverageCTs == null ? "n/a" : eCoverageCTs.size() + " elements"));
        int l;
        if ((eCoverageCTs != null) && ((l = eCoverageCTs.size()) > 0))
        {
            final CoverageCT[] result = new CoverageCT[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = readCoverageCT(src, eCoverageCTs.get(i));
            }
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param element
     * @return
     */
    private static CreatorCT readCreatorCT(String src, final Element eCreatorCT)
    {
        src = src + "::readCreatorCT";
        System.out.println(src + ": " + (eCreatorCT == null ? "n/a" : eCreatorCT.getName()));
        if (eCreatorCT != null)
        {
            final CreatorCT result = new CreatorCT();
            result.setCanonical(ParserTool.getBooleanAttributeValue(eCreatorCT, "canonical", null));
            result.setGlobalWithType(readGlobalWithType(src, eCreatorCT));
            result.setRole(readRoleType(src, eCreatorCT.getAttribute("role")));
            result.setValue(eCreatorCT.getTextNormalize());
            return result;
        }
        return null;
    }

    /**
     * @param children
     * @return
     */
    private static CreatorCT[] readCreatorCTs(String src, final List<Element> eCreatorCTs)
    {
        src = src + "::readCreatorCTs";
        System.out.println(src + ": " + (eCreatorCTs == null ? "n/a" : eCreatorCTs.size() + " elements"));
        int l;
        if ((eCreatorCTs != null) && ((l = eCreatorCTs.size()) > 0))
        {
            final CreatorCT[] result = new CreatorCT[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = readCreatorCT(src, eCreatorCTs.get(i));
            }
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param element
     * @return
     */
    @SuppressWarnings("unchecked")
    private static DateCT readDateCT(String src, final Element eDateCT)
    {
        src = src + "::readDateCT";
        System.out.println(src + ": " + (eDateCT == null ? "n/a" : eDateCT.getName()));
        if (eDateCT != null)
        {
            final DateCT result = new DateCT();
            result.setA(readACTs(src, eDateCT.getChildren("a", ns)));
            result.setCanonical(ParserTool.getBooleanAttributeValue(eDateCT, "canonical", null));
            result.setEvent(readEventType(src, eDateCT.getAttribute("event")));
            result.setGlobalWithType(readGlobalWithType(src, eDateCT));
            result.setIndex(readIndexCTs(src, eDateCT.getChildren("index", ns)));
            result.setNote(readNoteCTs(src, eDateCT.getChildren("note", ns)));
            result.setType(readCalendar(src, eDateCT.getAttribute("type")));
            result.setW(readWCTs(src, eDateCT.getChildren("w", ns)));
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static DateCT[] readDateCTs(String src, final List<Element> eDateCTs)
    {
        src = src + "::readDateCTs";
        System.out.println(src + ": " + (eDateCTs == null ? "n/a" : eDateCTs.size() + " elements"));
        int l;
        if ((eDateCTs != null) && ((l = eDateCTs.size()) > 0))
        {
            final DateCT[] result = new DateCT[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = readDateCT(src, eDateCTs.get(i));
            }
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param element
     * @return
     */
    private static DescriptionCT readDescriptionCT(String src, final Element eDescriptionCT)
    {
        src = src + "::readDescriptionCT";
        System.out.println(src + ": " + (eDescriptionCT == null ? "n/a" : eDescriptionCT.getName()));
        if (eDescriptionCT != null)
        {
            final DescriptionCT result = new DescriptionCT();
            result.setCanonical(ParserTool.getBooleanAttributeValue(eDescriptionCT, "canonical", ns));
            result.setDescriptionType(readDescriptionType(src, eDescriptionCT.getAttribute("type")));
            result.setGlobalWithoutType(readGlobalWithoutType(src, eDescriptionCT));
            result.setValue(eDescriptionCT.getTextNormalize());
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static DescriptionCT[] readDescriptionCTs(String src, final List<Element> eDescriptionCTs)
    {
        src = src + "::readDescriptionCTs";
        System.out.println(src + ": " + (eDescriptionCTs == null ? "n/a" : eDescriptionCTs.size() + " elements"));
        int l;
        if ((eDescriptionCTs != null) && ((l = eDescriptionCTs.size()) > 0))
        {
            final DescriptionCT[] result = new DescriptionCT[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = readDescriptionCT(src, eDescriptionCTs.get(i));
            }
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param attribute
     * @return
     */
    private static DescriptionType readDescriptionType(String src, final Attribute aDescriptionType)
    {
        src = src + "::readDescriptionType";
        System.out.println(src + ": " + (aDescriptionType == null ? "n/a" : aDescriptionType.getName()));
        String value;
        if ((aDescriptionType != null) && ((value = aDescriptionType.getValue()) != null) && ((value = value.trim()).length() > 0))
        {
            final DescriptionType result = new DescriptionType();
            result.setValue(value);
            return result;
        }
        return null;
    }

    /**
     * @param element
     * @return
     */
    @SuppressWarnings("unchecked")
    private static DivCT readDivCT(String src, final Element eDiv)
    {
        src = src + "::readDivCT";
        System.out.println(src + ": " + (eDiv == null ? "n/a" : eDiv.getName()));
        if (eDiv != null)
        {
            final DivCT result = new DivCT();
            result.setA(readACTs(src, eDiv.getChildren("a", ns)));
            result.setAbbr(readAbbrCTs(src, eDiv.getChildren("abbr", ns)));
            result.setCanonical(ParserTool.getBooleanAttributeValue(eDiv, "canonical", null));
            result.setChapter(readChapterCTs(src, eDiv.getChildren("chapter", ns)));
            result.setCloser(readCloserCTs(src, eDiv.getChildren("closer", ns)));
            result.setDate(readDateCTs(src, eDiv.getChildren("date", ns)));
            result.setDiv(readDivCTs(src, eDiv.getChildren("div", ns)));
            result.setDivineName(readDivineName(src, eDiv.getChildren("divineName", ns)));
            result.seteID(eDiv.getAttributeValue("eID"));
            result.setFigure(readFigureCTs(src, eDiv.getChildren("figure", ns)));
            result.setForeign(readForeignCTs(src, eDiv.getChildren("foreign", ns)));
            result.setGlobalWithoutType(readGlobalWithoutType(src, eDiv));
            result.setHi(readHiCTs(src, eDiv.getChildren("hi", ns)));
            result.setIndex(readIndexCTs(src, eDiv.getChildren("index", ns)));
            result.setInscription(readInscriptionCTs(src, eDiv.getChildren("inscription", ns)));
            result.setLb(readLbCTs(src, eDiv.getChildren("lb", ns)));
            result.setLg(readLgCTs(src, eDiv.getChildren("lg", ns)));
            result.setList(readListCTs(src, eDiv.getChildren("list", ns)));
            result.setMentioned(readMentionedCTs(src, eDiv.getChildren("mentioned", ns)));
            result.setMilestone(readMilestoneCTs(src, eDiv.getChildren("milestoneStart", ns)));
            result.setMilestoneEnd(readMilestoneEndCTs(src, eDiv.getChildren("milestoneEnd", ns)));
            result.setMilestoneStart(readMilestoneStartCTs(src, eDiv.getChildren("milestoneStart", ns)));
            result.setName(readNameCTs(src, eDiv.getChildren("name", ns)));
            result.setNote(readNoteCTs(src, eDiv.getChildren("note", ns)));
            result.setOsisRef(readOsisRefType(src, eDiv.getAttribute("osisRef")));
            result.setP(readPCTs(src, eDiv.getChildren("p", ns)));
            result.setQ(readQCTs(src, eDiv.getChildren("q", ns)));
            result.setReference(readReferenceCTs(src, eDiv.getChildren("reference", ns)));
            result.setSalute(readSaluteCTs(src, eDiv.getChildren("salute", ns)));
            result.setScope(readOsisRefType(src, eDiv.getAttribute("scope")));
            result.setSeg(readSegCTs(src, eDiv.getChildren("seg", ns)));
            result.setsID(eDiv.getAttributeValue("sID"));
            result.setSigned(readSignedCTs(src, eDiv.getChildren("signed", ns)));
            result.setSpeaker(readSpeakerCTs(src, eDiv.getChildren("speaker", ns)));
            result.setSpeech(readSpeechCTs(src, eDiv.getChildren("speech", ns)));
            result.setTable(readTableCTs(src, eDiv.getChildren("table", ns)));
            result.setTitle(readTitleCTs(src, eDiv.getChildren("title", ns)));
            result.setTitlePage(readTitlePageCT(src, eDiv.getChild("titlePage", ns)));
            result.setTransChange(readTransChangeCTs(src, eDiv.getChildren("transChange", ns)));
            result.setType(readDivType(src, eDiv.getAttribute("type")));
            result.setVerse(readVerseCTs(src, eDiv.getChildren("verse", ns)));
            result.setW(readWCTs(src, eDiv.getChildren("w", ns)));
            return result;
        }
        return null;
    }

    /**
     * @param children
     * @return
     */
    private static DivCT[] readDivCTs(String src, final List<Element> eDivs)
    {
        // TODO Auto-generated method stub
        src = src + "::readDivCTs";
        System.out.println(src + ": " + (eDivs == null ? "n/a" : eDivs.size() + " elements"));
        int l;
        if ((eDivs != null) && ((l = eDivs.size()) > 0))
        {
            final DivCT[] result = new DivCT[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = readDivCT(src, eDivs.get(i));
            }
            return result;

        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static DivineNameCT[] readDivineName(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param attribute
     * @return
     */
    private static DivType readDivType(final String src, final Attribute attribute)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param attribute
     * @return
     */
    private static EventType readEventType(final String src, final Attribute attribute)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static FigureCT[] readFigureCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static ForeignCT[] readForeignCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static FormatCT[] readFormatCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param eTitlePageCT
     * @return
     */
    private static GlobalWithoutType readGlobalWithoutType(String src, final Element element)
    {
        // TODO Auto-generated method stub
        src = src + "::readGlobalWithoutType";
        System.out.println(src + ": " + (element == null ? "n/a" : element.getName()));
        if (element != null)
        {

        }
        return null;
    }

    /**
     * @param eTitlePageCT
     * @return
     */
    private static GlobalWithType readGlobalWithType(String src, final Element element)
    {
        // TODO Auto-generated method stub
        src = src + "::readGlobalWithType";
        System.out.println(src + ": " + (element == null ? "n/a" : element.getName()));
        if (element != null)
        {

        }
        return null;
    }

    /**
     * @param src
     * @param child
     * @return
     */
    private static HeaderCT readHeaderCT(String src, final Element eHeaderCT)
    {
        // TODO Auto-generated method stub
        src = src + "::readHeaderCT";
        System.out.println(src + ": " + (eHeaderCT == null ? "n/a" : eHeaderCT.getName()));
        if (eHeaderCT != null)
        {
            final HeaderCT result = new HeaderCT();
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static HiCT[] readHiCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static IdentifierCT[] readIdentifierCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static IndexCT[] readIndexCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static InscriptionCT[] readInscriptionCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static LanguageCT[] readLanguageCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static LbCT[] readLbCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static LgCT[] readLgCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static ListCT[] readListCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static MentionedCT[] readMentionedCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static MilestoneCT[] readMilestoneCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static MilestoneEndCT[] readMilestoneEndCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static MilestoneStartCT[] readMilestoneStartCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static NameCT[] readNameCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static NoteCT[] readNoteCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param split
     * @return
     */
    private static OsisAnnotateRefType[] readOsisAnnotateRefTypes(String src, final String[] sARTs)
    {
        src = src + "::readOsisAnnotateRefTypes";
        System.out.println(src + ": " + (sARTs == null ? "n/a" : sARTs.length + " elements"));
        int l;
        if ((sARTs != null) && ((l = sARTs.length) > 0))
        {
            final OsisAnnotateRefType[] result = new OsisAnnotateRefType[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = new OsisAnnotateRefType(sARTs[i]);
            }
            return result;
        }
        return null;
    }

    /**
     * @param child
     * @return
     */
    @SuppressWarnings("unchecked")
    private static OsisCorpusCT readOsisCorpus(String src, final Element eOsisCorpus)
    {
        src = src + "::readOsisCorpus";
        System.out.println(src + ": " + (eOsisCorpus == null ? "n/a" : eOsisCorpus.getName()));
        if (eOsisCorpus != null)
        {
            final OsisCorpusCT result = new OsisCorpusCT();
            result.setHeader(readCorpusHeaderCT(src, eOsisCorpus.getChild("header", ns)));
            result.setOsisText(readOsisTextCTs(src, eOsisCorpus.getChildren("osisText", ns)));
            result.setTitlePage(readTitlePageCT(src, eOsisCorpus.getChild("titlePage", ns)));
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param attribute
     * @return
     */
    private static OsisIDType readOsisIDType(String src, final Attribute aOsisIDType)
    {
        src = src + "::readOsisIDType";
        System.out.println(src + ": " + (aOsisIDType == null ? "n/a" : aOsisIDType.getName()));
        String value;
        if ((aOsisIDType != null) && ((value = aOsisIDType.getValue()) != null) && ((value = value.trim()).length() > 0))
        {

            final OsisIDType result = new OsisIDType();
            final String[] tokens = value.split(" ");
            final int l = tokens.length;
            if (l > 0)
            {
                final OsisIDRegex[] values = new OsisIDRegex[l];
                for (int i = 0; i < l; i++)
                {
                    values[i] = new OsisIDRegex();
                    values[i].setValue(tokens[i]);
                    System.out.println(src + "::result[" + i + "]" + ": " + tokens[i]);
                }
                result.setValues(values);
            }
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param attribute
     * @return
     */
    private static OsisRefType readOsisRefType(final String src, final Attribute attribute)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param child
     * @return
     */
    @SuppressWarnings("unchecked")
    private static OsisTextCT readOsisText(String src, final Element eOsisText)
    {
        src = src + "::readOsisText";
        System.out.println(src + ": " + (eOsisText == null ? "n/a" : eOsisText.getName()));
        if (eOsisText != null)
        {
            final OsisTextCT result = new OsisTextCT();
            result.setAnnotateRef(readAnnotateRefType(src, eOsisText.getAttribute("annotateRef")));
            result.setCanonical(ParserTool.getBooleanAttributeValue(eOsisText, "canonical", null));
            result.setDiv(readDivCTs(src, eOsisText.getChildren("div", ns)));
            result.setHeader(readHeaderCT(src, eOsisText.getChild("header", ns)));
            result.setiD(eOsisText.getAttributeValue("ID", ParserTool.xmlNS));
            result.setLang(eOsisText.getAttributeValue("lang", ParserTool.xmlNS));
            result.setOsisID(readOsisIDType(src, eOsisText.getAttribute("osisID")));
            result.setOsisIDWork(readOsisWorkType(src, eOsisText.getAttribute("osisIDWork")));
            result.setOsisRefWork(readOsisWorkType(src, eOsisText.getAttribute("osisRefWork")));
            result.setSpace(eOsisText.getAttributeValue("space", ParserTool.xmlNS));
            result.setSubType(readAttributeExtension(src, eOsisText.getAttribute("subType")));
            result.setTitlePage(readTitlePageCT(src, eOsisText.getChild("titlePage", ns)));
            result.setType(readAttributeExtension(src, eOsisText.getAttribute("type")));
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static OsisTextCT[] readOsisTextCTs(String src, final List<Element> eOsisTextCTs)
    {
        src = src + "::readOsisTextCTs";
        System.out.println(src + ": " + (eOsisTextCTs == null ? "n/a" : eOsisTextCTs.size() + " elements"));
        int l;
        if ((eOsisTextCTs != null) && ((l = eOsisTextCTs.size()) > 0))
        {
            final OsisTextCT[] result = new OsisTextCT[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = readOsisText(src, eOsisTextCTs.get(i));
            }
            return result;

        }
        return null;
    }

    /**
     * @param src
     * @param attribute
     * @return
     */
    private static OsisWorkType readOsisWorkType(String src, final Attribute aOsisWorkType)
    {
        src = src + "::readOsisWorkType";
        System.out.println(src + ": " + (aOsisWorkType == null ? "n/a" : aOsisWorkType.getName()));
        String value;
        if ((aOsisWorkType != null) && ((value = aOsisWorkType.getValue()) != null) && ((value = value.trim()).length() > 0))
        {
            final OsisWorkType result = new OsisWorkType();
            if (result.setValue(value))
            {
                System.out.println(src + "::result= " + value);
                return result;
            }
        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static PCT[] readPCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static PublisherCT[] readPublisherCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static QCT[] readQCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static ReferenceCT[] readReferenceCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static RelationCT[] readRelationCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static RevisionDescCT[] readRevisionDescCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param attribute
     * @return
     */
    private static RoleType readRoleType(final String src, final Attribute attribute)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static SaluteCT[] readSaluteCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static SegCT[] readSegCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static SignedCT[] readSignedCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static SourceCT[] readSourceCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static SpeakerCT[] readSpeakerCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static SpeechCT[] readSpeechCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static SubjectCT[] readSubjectCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static TableCT[] readTableCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static TitleCT[] readTitleCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param child
     * @return
     */
    @SuppressWarnings("unchecked")
    private static TitlePageCT readTitlePageCT(String src, final Element eTitlePageCT)
    {
        src = src + "::readTitlePageCT";
        System.out.println(src + ": " + (eTitlePageCT == null ? "n/a" : eTitlePageCT.getName()));
        if (eTitlePageCT != null)
        {
            final TitlePageCT result = new TitlePageCT();
            result.setCanonical(ParserTool.getBooleanAttributeValue(eTitlePageCT, "canonical", null));
            result.setContributor(readContributorCTs(src, eTitlePageCT.getChildren("contributor", ns)));
            result.setCoverage(readCoverageCTs(src, eTitlePageCT.getChildren("coverage", ns)));
            result.setCreator(readCreatorCTs(src, eTitlePageCT.getChildren("creator", ns)));
            result.setDate(readDateCTs(src, eTitlePageCT.getChildren("date", ns)));
            result.setDescription(readDescriptionCTs(src, eTitlePageCT.getChildren("description", ns)));
            result.setFigure(readFigureCTs(src, eTitlePageCT.getChildren("figure", ns)));
            result.setFormat(readFormatCTs(src, eTitlePageCT.getChildren("format", ns)));
            result.setGlobalWithType(readGlobalWithType(src, eTitlePageCT));
            result.setIdentifier(readIdentifierCTs(src, eTitlePageCT.getChildren("identifier", ns)));
            result.setLanguage(readLanguageCTs(src, eTitlePageCT.getChildren("language", ns)));
            result.setMilestone(readMilestoneCTs(src, eTitlePageCT.getChildren("milestone", ns)));
            result.setP(readPCTs(src, eTitlePageCT.getChildren("p", ns)));
            result.setPublisher(readPublisherCTs(src, eTitlePageCT.getChildren("publisher", ns)));
            result.setRelation(readRelationCTs(src, eTitlePageCT.getChildren("relation", ns)));
            result.setSource(readSourceCTs(src, eTitlePageCT.getChildren("source", ns)));
            result.setSubject(readSubjectCTs(src, eTitlePageCT.getChildren("subject", ns)));
            result.setTitle(readTitleCTs(src, eTitlePageCT.getChildren("title", ns)));
            result.setType(readTypeCTs(src, eTitlePageCT.getChildren("type", ns)));
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static TransChangeCT[] readTransChangeCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static TypeCT[] readTypeCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static VerseCT[] readVerseCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param element
     * @return
     */
    private static WCT readWCT(final String src, final Element element)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param children
     * @return
     */
    private static WCT[] readWCTs(String src, final List<Element> eWCTs)
    {
        src = src + "::readWCTs";
        System.out.println(src + ": " + (eWCTs == null ? "n/a" : eWCTs.size() + " elements"));
        int l;
        if ((eWCTs != null) && ((l = eWCTs.size()) > 0))
        {
            final WCT[] result = new WCT[l];
            for (int i = 0; i < l; i++)
            {
                result[i] = readWCT(src, eWCTs.get(i));
            }
            return result;
        }
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static WorkCT[] readWorkCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
