/**
 * 
 */
package be.luys.bibreader;

import java.io.File;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import be.luys.bibreader.parsers.osis.OsisParser;

/**
 * @author fks/el
 * 
 */
public class BibleReader
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            parse(new File(args[0]));
        }
        catch (JDOMException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void parse(File file) throws JDOMException, IOException
    {
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(file);
        Element root = doc.getRootElement();
        String tagName = root.getName();
        System.out.println(tagName);
        if (tagName.equalsIgnoreCase("osis"))
        {
            System.out.println(OsisParser.parseOsis(doc));
        }
    }
}
