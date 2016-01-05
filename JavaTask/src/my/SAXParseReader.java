package my;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParseReader extends DefaultHandler {

	List<Typology> typologies = new ArrayList<Typology>();
	Typology typology = null;
	int m_nodeIx; // tracks the current node
	Stack<Integer> m_parentStack; // tracks its parent

	//HashMap<String, Typology> levelMap = new HashMap<String, Typology>();
	Stack<Typology> typologyStack = new Stack<Typology>();

	boolean code = false;
	boolean name = false;
	boolean asciiCode = false;

	@Override
	public void startDocument() throws SAXException {

		m_nodeIx = -1;
		m_parentStack = new Stack<Integer>();
		m_parentStack.push(new Integer(m_nodeIx));
	}

	public List<Typology> getTypologies() {
		return typologies;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equalsIgnoreCase("Typology")) {
			m_parentStack.pop();
			// typologies.add(typology);
			typologies.add(typologyStack.pop());
		}

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("Typology")) {
			typology = new Typology();
			++m_nodeIx;
			int parentNodeIx = ((Integer) m_parentStack.peek()).intValue();
			typology.setNodeIndex(m_nodeIx);
			typology.setParentIndex(parentNodeIx);
			m_parentStack.push(Integer.valueOf(m_nodeIx));
			typologyStack.push(typology);
		} else if (qName.equalsIgnoreCase("Code")) {
			code = true;
		} else if (qName.equalsIgnoreCase("Name")) {
			name = true;
		} else if (qName.equalsIgnoreCase("ASCIICode")) {
			asciiCode = true;
		}

	}

	@Override
	public void characters(char ch[], int start, int length)
			throws SAXException {
		if (code) {
			typology.setCode(new String(new String(ch, start, length)));
			code = false;

		} else if (name) {
			typology.setName(new String(ch, start, length));
			name = false;

		} else if (asciiCode) {
			typology.setAsciiCode(new String(ch, start, length));
			asciiCode = false;

		}

	}

}
