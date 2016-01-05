package my;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLParserSAX {

	public static void main(String[] args) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			SAXParseReader sAXParseReader = new SAXParseReader();
			saxParser.parse(new File("typologyOrg.xml"),sAXParseReader);
			// Get typologies list
			List<Typology> typologies = sAXParseReader.getTypologies();
			// print Typology information
			for (Typology typology : typologies)
				System.out.println(typology);
			System.out.println("end of for loop");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
