/**
 * 
 */
package be.luys.bibreader.beans.osis;

/**
 * @author fks/el
 * 
 */
public class OsisGenRegex
{
    private String value;
    private static final String pattern = "((((\\p{L}|\\p{N}|_)+)(\\.(\\p{L}|\\p{N}|_))*:)?([^:\\s])+)";
}
