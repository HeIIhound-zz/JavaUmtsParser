package mainDefinitivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class UtranCell {

	public static final String attributes = "attributes";
	public static final String UtranCell = "UtranCell";

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

		PrintStream fichero = new PrintStream(new File("UtranCell.txt"));// vsDataIubLink
		System.setOut(fichero);

		while (streamReader.hasNext()) {

			utranCell(streamReader);

			streamReader.next();
		} // bucle principal
		fichero.close();
		streamReader.close();
	}// main

	public static void utranCell(XMLStreamReader streamReader) throws XMLStreamException {

		while (true) {
			if (streamReader.isStartElement()) {
				if (streamReader.getName().getLocalPart().equals(UtranCell)) {
					while (streamReader.hasNext()) {

						print(streamReader);

						if (streamReader.isEndElement()) {
							if (streamReader.getName().getLocalPart().equals(UtranCell)) {
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
