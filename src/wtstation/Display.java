package wtstation;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Display {
	
	private static String cityname;
	private static int citytemp;
	private static int cityhum;

    static void getConditions(Document doc) {

        String city = null;
        String unit = null;

        try {

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("rss");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    NodeList nl = eElement
                            .getElementsByTagName("yweather:location");

                    for (int tempr = 0; tempr < nl.getLength(); tempr++) {

                        Node n = nl.item(tempr);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element e = (Element) n;
                            city = e.getAttribute("city");
                           cityname = city;

                        }
                    }

                    NodeList nl2 = eElement
                            .getElementsByTagName("yweather:units");

                    for (int tempr = 0; tempr < nl2.getLength(); tempr++) {

                        Node n2 = nl2.item(tempr);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element e2 = (Element) n2;
                            unit = e2.getAttribute("temperature");

                        }
                    }

                    NodeList nl3 = eElement
                            .getElementsByTagName("yweather:condition");

                    for (int tempr = 0; tempr < nl3.getLength(); tempr++) {

                        Node n3 = nl3.item(tempr);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element e3 = (Element) n3;
                            citytemp = Integer.parseInt(e3.getAttribute("temp"));
                        }
                    }

                    NodeList nl4 = eElement
                            .getElementsByTagName("yweather:atmosphere");

                    for (int tempr = 0; tempr < nl4.getLength(); tempr++) {

                        Node n4 = nl4.item(tempr);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element e4 = (Element) n4;
                            cityhum = Integer.parseInt(e4.getAttribute("humidity"));
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int getTempRss(){
    	return citytemp;
    }
    public String getCityRss(){
    	return cityname;
    }
    public int getHumidityRss(){
    	return cityhum;
    }

}
