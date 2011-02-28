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
    crostic,

    bold,

    emphasis,

    illuminated,

    italic,

    line_through,

    normal,

    small_caps
    {
        @Override
        public String toString()
        {

            return "small-caps";
        }
    },

    sub,

    hi_super
    {
        @Override
        public String toString()
        {
            return "super";
        }
    },

    underline
}
