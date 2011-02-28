/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public enum OsisLanguage
{
    IANA,

    IETF,

    ISO_639_1
    {
        @Override
        public String toString()
        {
            return "ISO-639-1";
        }
    },

    ISO_639_2
    {
        @Override
        public String toString()
        {
            return "ISO-639-2";
        }
    },

    ISO_639_2_B
    {
        @Override
        public String toString()
        {
            return "ISO-639-2-B";
        }
    },

    ISO_639_2_T
    {
        @Override
        public String toString()
        {
            return "ISO-639-2-T";
        }
    },

    LINGUIST,

    other,

    SIL
}
