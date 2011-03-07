/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public enum OsisHi
{
    acrostic, bold, emphasis, illuminated, italic, line_through
    {/*
      * (non-Javadoc)
      * 
      * @see java.lang.Enum#toString()
      */
        @Override
        public String toString()
        {
            return "line-through";
        }
    },
    normal, small_caps
    {/*
      * (non-Javadoc)
      * 
      * @see java.lang.Enum#toString()
      */
        @Override
        public String toString()
        {
            return "small-caps";
        }
    },
    sub, sup
    {/*
      * (non-Javadoc)
      * 
      * @see java.lang.Enum#toString()
      */
        @Override
        public String toString()
        {
            return "super";
        }
    },
    underline
}
