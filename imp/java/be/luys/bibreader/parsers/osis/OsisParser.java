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
import be.luys.bibreader.beans.osis.AnnotateRefType;
import be.luys.bibreader.beans.osis.AttributeExtension;
import be.luys.bibreader.beans.osis.ContributorCT;
import be.luys.bibreader.beans.osis.CorpusHeaderCT;
import be.luys.bibreader.beans.osis.CoverageCT;
import be.luys.bibreader.beans.osis.CreatorCT;
import be.luys.bibreader.beans.osis.DateCT;
import be.luys.bibreader.beans.osis.DescriptionCT;
import be.luys.bibreader.beans.osis.DivCT;
import be.luys.bibreader.beans.osis.FigureCT;
import be.luys.bibreader.beans.osis.FormatCT;
import be.luys.bibreader.beans.osis.GlobalWithType;
import be.luys.bibreader.beans.osis.GlobalWithoutType;
import be.luys.bibreader.beans.osis.HeaderCT;
import be.luys.bibreader.beans.osis.IdentifierCT;
import be.luys.bibreader.beans.osis.IndexCT;
import be.luys.bibreader.beans.osis.LanguageCT;
import be.luys.bibreader.beans.osis.MilestoneCT;
import be.luys.bibreader.beans.osis.OsisAnnotateRefType;
import be.luys.bibreader.beans.osis.OsisCT;
import be.luys.bibreader.beans.osis.OsisCorpusCT;
import be.luys.bibreader.beans.osis.OsisIDRegex;
import be.luys.bibreader.beans.osis.OsisIDType;
import be.luys.bibreader.beans.osis.OsisTextCT;
import be.luys.bibreader.beans.osis.OsisWorkType;
import be.luys.bibreader.beans.osis.PCT;
import be.luys.bibreader.beans.osis.PublisherCT;
import be.luys.bibreader.beans.osis.QCT;
import be.luys.bibreader.beans.osis.RelationCT;
import be.luys.bibreader.beans.osis.RevisionDescCT;
import be.luys.bibreader.beans.osis.RoleType;
import be.luys.bibreader.beans.osis.SourceCT;
import be.luys.bibreader.beans.osis.SubjectCT;
import be.luys.bibreader.beans.osis.TitleCT;
import be.luys.bibreader.beans.osis.TitlePageCT;
import be.luys.bibreader.beans.osis.TypeCT;
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
        // choice
        final Element root = doc.getRootElement();
        result.setOsisText(readOsisText("osis", root.getChild("osisText", ns)));
        result.setOsisCorpus(readOsisCorpus("osis", root.getChild("osisCorpus", ns)));
        return result;
    }

    /**
     * @param element
     * @return
     */
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
     * @param children
     * @return
     */
    private static CoverageCT[] readCoverageCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param children
     * @return
     */
    private static CreatorCT[] readCreatorCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static DateCT[] readDateCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static DescriptionCT[] readDescriptionCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param element
     * @return
     */
    private static DivCT readDivCT(String src, final Element eDiv)
    {
        // TODO Auto-generated method stub

        src = src + "::readDivCT";
        System.out.println(src + ": " + (eDiv == null ? "n/a" : eDiv.getName()));
        if (eDiv != null)
        {
            final DivCT result = new DivCT();
            result.setA(readACTs(src, eDiv.getChildren("a", ns)));
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
    private static IndexCT[] readIndexCTs(final String src, final List children)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param src
     * @param children
     * @return
     */
    private static LanguageCT[] readLanguageCTs(final String src, final List children)
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
     * @param child
     * @return
     */
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
    private static WorkCT[] readWorkCTs(final String src, final List<Element> children)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
