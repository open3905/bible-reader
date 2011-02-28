/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class OsisWorkType
{
    private String value;
    private static final String pattern = "((\\p{L}|\\p{N}|_)+)((\\.(\\p{L}|\\p{N}|_)+)*)?";
}
