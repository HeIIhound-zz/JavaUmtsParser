package mainDefinitivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class MainDefinitivo {

	public static final String attributes = "attributes";
	public static final String GsmRelation = "GsmRelation";

	// esto esta bien
	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

		// System.out.println("Introduzca el nombre o la ruta del fichero");
		// Scanner scan = new Scanner(System.in);
		// String filename = scan.nextLine();
		// scan.close();

		FileInputStream file = new FileInputStream(
				"C:\\Users\\usuario\\Documents\\zipPruebas\\ExportE3G-ARA10R01_18-12-01.xml");

		XMLInputFactory factory = XMLInputFactory.newInstance();

		XMLStreamReader streamReader = factory.createXMLStreamReader(file);

		PrintStream fichero = new PrintStream(new File("mainDefinitivo.txt"));// vsDataIubLink
		System.setOut(fichero);

		while (streamReader.hasNext()) {

			IubLink(streamReader);

			streamReader.next();
		} // bucle principal
		fichero.close();
		streamReader.close();
	}// main

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

	public static void IubLink(XMLStreamReader streamReader) throws XMLStreamException {

		while (true) {
			if (streamReader.isStartElement()) {
				if (streamReader.getName().getLocalPart().equals(GsmRelation)) {
					while (streamReader.hasNext()) {

						print(streamReader);

						if (streamReader.isEndElement()) {
							if (streamReader.getName().getLocalPart().equals(GsmRelation)) {
								System.out.println("");
								break;
							}
						}
						streamReader.next();
					} // while
					break;
				} else {
					streamReader.next();
				}
			} else {
				break;
			}
		}

	}// IubLink

	private static void print(XMLStreamReader streamReader) throws XMLStreamException {
		if (streamReader.hasName()) {
			if (streamReader.isStartElement()) {
				if (streamReader.getName().getLocalPart().equals(attributes)) {
					System.out.print("");
				} else {

					System.out.print(" | " + streamReader.getName().getLocalPart() + " ");

					if (streamReader.getAttributeCount() != 0) {
						System.out
								.print(streamReader.getAttributeLocalName(0) + " " + streamReader.getAttributeValue(0));
					} else {
						System.out.print("");
					}

				}
			} else if (streamReader.isEndElement()) {
				System.out.print("");
			}
		}
		if (streamReader.hasText()) {
			if (streamReader.getEventType() == XMLEvent.CHARACTERS) {
				System.out.print(streamReader.getText().trim());
			}
		} else {
			System.out.print("");
		}
	}
}
