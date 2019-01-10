package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class main5 {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

		// System.out.println("Introduzca el nombre o la ruta del fichero");
		// Scanner scan = new Scanner(System.in);
		// String filename = scan.nextLine();
		// scan.close();

		// List<RncFunction> RncFunctionList = new ArrayList<>();

		// bulkCmConfigDataFile bulkCmConfigDataFile = null;

		FileInputStream file = new FileInputStream(
				"C:\\Users\\usuario\\Documents\\zipPruebas\\ExportE3G-ARA10R01_18-12-01.xml");

		XMLInputFactory factory = XMLInputFactory.newInstance();

		// factory.setEventAllocator(allocator);

		XMLStreamReader streamReader = factory.createXMLStreamReader(file);

		// PrintStream fichero = new PrintStream(new File("ficheroMain5.txt"));
		// String local = null;
		while (streamReader.hasNext()) {
			// Move to next event

			if (streamReader.isStartElement()) {
				if (streamReader.getLocalName() == "UtranCell") {
					printAttribut(streamReader);

					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getPrefix() + " " + streamReader.getLocalName());
					streamReader.next();
					streamReader.next();
					streamReader.next();
					streamReader.next();
					streamReader.next();
					// System.out.println(streamReader.getLocation());
					// printAttributes(streamReader);
					// System.out.println(streamReader.getLocalName()+"
					// "+streamReader.getElementText());
					name(streamReader);
					streamReader.next();
					streamReader.next();
					name(streamReader);
					streamReader.next();
					streamReader.next();
					name(streamReader);
					streamReader.next();
					streamReader.next();
					System.out.print(streamReader.getLocalName());
					streamReader.next();
				} else {
					streamReader.next();
				}
			} else if (streamReader.isEndElement()) {
				if (streamReader.getLocalName() == "fin RncFunction") {
					System.out.println(streamReader.getLocalName());
					streamReader.next();
				} else {
					streamReader.next();
				}
			} else {
				streamReader.next();
			}
			// local = streamReader.getLocalName();
			// System.out.println(streamReader.getLocalName());
			// System.out.println(streamReader.getAttributeCount());
		}
		streamReader.close();
		// System.setOut(fichero);

	}// main

	public static void name(XMLStreamReader streamReader) throws XMLStreamException {

		System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
	}

	// devuelve el tipo de evento del cursor
	public final static String getEventTypeString(int eventType) {
		switch (eventType) {
		case XMLEvent.START_ELEMENT:
			// return "START_ELEMENT";
			return "ELEMENTO_DE_INICIO";

		case XMLEvent.END_ELEMENT:
			// return "END_ELEMENT";
			return "ELEMENTO_FINAL";

		case XMLEvent.PROCESSING_INSTRUCTION:
			// return "PROCESSING_INSTRUCTION";
			return "INSTRUCCION_DE_PROCESAMIENTO";

		case XMLEvent.CHARACTERS:
			// return "CHARACTERS";
			return "CARACTERES";

		case XMLEvent.COMMENT:
			// return "COMMENT";
			return "COMENTARIO";

		case XMLEvent.START_DOCUMENT:
			// return "START_DOCUMENT";
			return "COMIENZO_DEL_DOCUMENTO";

		case XMLEvent.END_DOCUMENT:
			// return "END_DOCUMENT";
			return "FIN_DEL_DOCUMENTO";

		case XMLEvent.ENTITY_REFERENCE:
			// return "ENTITY_REFERENCE";
			return "REFERENCIA_DE_ENTIDAD";

		case XMLEvent.ATTRIBUTE:
			// return "ATTRIBUTE";
			return "ATRIBUTO";

		case XMLEvent.DTD:
			return "DTD";

		case XMLEvent.CDATA:
			return "CDATA";

		case XMLEvent.SPACE:
			return "SPACE";
		}
		// return "UNKNOWN_EVENT_TYPE , " + eventType;
		return "TIPO_DE_EVENTO_DESCONOCIDO , " + eventType;
	}

	private static void printAttribut(XMLStreamReader streamReader) {
		System.out.println(streamReader.getLocalName());
		if (streamReader.getAttributeCount() > 0) {

			int count = streamReader.getAttributeCount();

			for (int i = 0; i < count; i++) {
				QName name = streamReader.getAttributeName(i);
				String value = streamReader.getAttributeValue(i);

				System.out.println(name.toString() + " " + value);
			}
		} else {
			// System.out.println("HAS NO ATTRIBUTES");
		}
	}

	/*
	 * private static void printAttributes(XMLStreamReader xmlr) { if
	 * (xmlr.getAttributeCount() > 0) { System.out.println("\nHAS ATTRIBUTES: ");
	 * 
	 * int count = xmlr.getAttributeCount();
	 * 
	 * for (int i = 0; i < count; i++) { QName name = xmlr.getAttributeName(i);
	 * String namespace = xmlr.getAttributeNamespace(i); String type =
	 * xmlr.getAttributeType(i); String prefix = xmlr.getAttributePrefix(i); String
	 * value = xmlr.getAttributeValue(i);
	 * 
	 * System.out.println("ATTRIBUTE-PREFIX: " + prefix);
	 * System.out.println("ATTRIBUTE-NAMESP: " + namespace);
	 * System.out.println("ATTRIBUTE-NAME:   " + name.toString());
	 * System.out.println("ATTRIBUTE-VALUE:  " + value);
	 * System.out.println("ATTRIBUTE-TYPE:  " + type); } } else {
	 * //System.out.println("HAS NO ATTRIBUTES"); } }
	 */

}
