package mainDefinitivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class RncFunction {

	public static final String attributes = "attributes";
	public static final String RncFunction = "RncFunction";

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

		PrintStream fichero = new PrintStream(new File("RncFunction.txt"));// vsDataIubLink
		System.setOut(fichero);

		while (streamReader.hasNext()) {

			rncFunction(streamReader);

			streamReader.next();
		} // bucle principal
		fichero.close();
		streamReader.close();
	}// main

	public static void rncFunction(XMLStreamReader streamReader) throws XMLStreamException {

		while (true) {
			if (streamReader.isStartElement()) {
				if (streamReader.getName().getLocalPart().equals(RncFunction)) {
					while (streamReader.hasNext()) {

						print(streamReader);

						if (streamReader.isEndElement()) {
							if (streamReader.getName().getLocalPart().equals(RncFunction)) {
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

			switch (streamReader.getEventType()) {
			case XMLEvent.START_ELEMENT:
				// return "START_ELEMENT";
				System.out.print("");
				break;
			case XMLEvent.END_ELEMENT:
				// return "END_ELEMENT";
				System.out.print("");
				break;

			case XMLEvent.PROCESSING_INSTRUCTION:
				// return "PROCESSING_INSTRUCTION";
				System.out.print("");
				break;

			case XMLEvent.CHARACTERS:
				// return "CHARACTERS";
				System.out.print(streamReader.getText().trim());
				break;

			case XMLEvent.COMMENT:
				// return "COMMENT";
				System.out.print("");
				break;

			case XMLEvent.START_DOCUMENT:
				// return "START_DOCUMENT";
				System.out.print("");
				break;

			case XMLEvent.END_DOCUMENT:
				// return "END_DOCUMENT";
				System.out.print("");
				break;

			case XMLEvent.ENTITY_REFERENCE:
				// return "ENTITY_REFERENCE";
				System.out.print("");
				break;

			case XMLEvent.ATTRIBUTE:
				// return "ATTRIBUTE";
				System.out.print("");
				break;

			case XMLEvent.DTD:
				System.out.print("");
				break;

			case XMLEvent.CDATA:
				System.out.print("");
				break;

			case XMLEvent.SPACE:
				System.out.print("");
				break;
			}

		} else {
			System.out.print("");
		}
	}
}
