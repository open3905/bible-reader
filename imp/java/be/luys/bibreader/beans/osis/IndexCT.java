/**
 * 
 */
package be.luys.bibreader.beans.osis;

import java.io.Serializable;

/**
 * @author fks/el
 * 
 */
public class IndexCT implements Serializable
{
    private boolean canonical;
    /**
     * req
     */
    private String index;
    /**
     * req
     */
    private String level1;

    private String level2;
    private String level3;
    private String level4;
    private String see;
}
