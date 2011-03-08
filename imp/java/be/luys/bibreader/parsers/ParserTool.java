/**
 * 
 */
package be.luys.bibreader.parsers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom.Element;
import org.jdom.Namespace;

/**
 * @author fks/el
 * 
 */
public class ParserTool
{
    public static final Namespace xmlNS = Namespace.getNamespace("xml", "http://www.w3.org/XML/1998/namespace");

    public static double getDoubleAttributeValue(final Element e, final String attributeName, Namespace ns)
    {
        try
        {
            return Double.parseDouble(ns == null ? e.getAttributeValue(attributeName) : e.getAttributeValue(attributeName, ns));
        }
        catch (Exception ex)
        {
            return -1.0;
        }
    }

    public static boolean getBooleanAttributeValue(final Element e, final String attributeName, Namespace ns)
    {
        try
        {
            return Boolean.parseBoolean(ns == null ? e.getAttributeValue(attributeName) : e.getAttributeValue(attributeName, ns));
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    public static double getDoubleValueOfChild(final Element e, final String childName, Namespace ns)
    {
        final String value = getValueOfChild(e, childName, ns);
        if (value != null)
        {
            try
            {
                return Double.parseDouble(value);
            }
            catch (final NumberFormatException ex)
            {
                ex.printStackTrace();
            }
        }
        return -1.0;
    }

    public static int getIntValueOfChild(final Element e, final String childName, Namespace ns)
    {
        final String value = getValueOfChild(e, childName, ns);
        if (value != null)
        {
            try
            {
                return Integer.parseInt(value);
            }
            catch (final NumberFormatException ex)
            {
                ex.printStackTrace();
            }
        }
        return -1;
    }

    public static Date getDateValueOfChild(final Element e, final String childName, Namespace ns, DateFormat dateFormat)
    {
        final String value = getValueOfChild(e, childName, ns);
        System.err.println("parsing " + value);
        if (value != null)
        {
            try
            {
                if (dateFormat == null)
                {
                    dateFormat = new SimpleDateFormat();
                }
                return dateFormat.parse(value);
            }
            catch (final ParseException ex)
            {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static boolean getBooleanValueOfChild(final Element e, final String childName, Namespace ns)
    {
        final String value = getValueOfChild(e, childName, ns);
        if (value != null)
        {
            try
            {
                return Boolean.parseBoolean(value);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public static String getValueOfChild(final Element e, final String childName, Namespace ns)
    {
        final Element child = ns == null ? e.getChild(childName) : e.getChild(childName, ns);
        if (child != null)
            return child.getValue();
        return null;
    }
}
