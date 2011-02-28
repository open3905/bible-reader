/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class OsisCorpusCT
{
    /**
     * 0 - 1
     */
    private CorpusHeaderCT header;
    /**
     * 0 - 1
     */
    private TitlePageCT titlePage;
    /**
     * 1 - ..
     */
    private OsisTextCT[] osisText;
    private static final String TEIform = "teiCorpus.2";
}
