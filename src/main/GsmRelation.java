package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

//stax basado en iterator
public class GsmRelation {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

		// System.out.println("Introduzca el nombre o la ruta del fichero");
		// Scanner scan = new Scanner(System.in);
		// String filename = scan.nextLine();
		// scan.close();

		FileInputStream file = new FileInputStream("");

		XMLInputFactory factory = XMLInputFactory.newInstance();

		XMLStreamReader streamReader = factory.createXMLStreamReader(file);

		PrintStream fichero = new PrintStream(new File("GsmRelation.txt"));
		System.setOut(fichero);

		while (streamReader.hasNext()) {

			if (streamReader.isStartElement()) {
				if (streamReader.getName().toString().equals("{geranNrm.xsd}GsmRelation")) {
					printAttribut(streamReader);// GsmRelation
					streamReader.next();
					streamReader.next();
					streamReader.next();
					System.out.print(streamReader.getLocalName() + " " + streamReader.getElementText() + " | "); // adjacentcell
					streamReader.next();
					streamReader.next();
					streamReader.next();
					streamReader.next();
					System.out.print(streamReader.getLocalName() + " " + streamReader.getAttributeValue(0) + " | "); // vsDataContainer
					streamReader.next();
					streamReader.next();
					streamReader.next();
					streamReader.next();
					System.out.print(streamReader.getLocalName() + " " + streamReader.getElementText() + " | "); // vsDataType
					streamReader.next();
					streamReader.next();
					System.out.print(streamReader.getLocalName() + " " + streamReader.getElementText() + " | "); // vsDataFormatVersion
					streamReader.next();
					streamReader.next();
					streamReader.next();
					streamReader.next();
					System.out.print(streamReader.getLocalName() + " " + streamReader.getElementText() + " | "); // qOffsetlsn
					streamReader.next();
					streamReader.next();
					System.out.print(streamReader.getLocalName() + " " + streamReader.getElementText() + " | "); // mobilityRelationType
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText()); // selectionPriority
					streamReader.next();
					streamReader.next();
				} else {
					streamReader.next();
				}
			} else {
				streamReader.next();
			}
		}
		streamReader.close();
	}// main

	public static void name(XMLStreamReader streamReader) throws XMLStreamException {

		System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText() + " | ");
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

	private static void printAttribut(XMLStreamReader streamReader) throws XMLStreamException {
		System.out.print(streamReader.getLocalName() + " ");
		if (streamReader.getAttributeCount() > 0) {

			int count = streamReader.getAttributeCount();

			for (int i = 0; i < count; i++) {
				QName name = streamReader.getAttributeName(i);
				String value = streamReader.getAttributeValue(i);

				System.out.print(name.toString() + "=" + value + " | ");
				streamReader.next();
			}
		} else {
			// System.out.println("HAS NO ATTRIBUTES");
		}
	}
}