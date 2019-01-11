package mainDefinitivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class GsmRelation {

	public static final String attributes = "attributes";
	public static final String GsmRelation = "GsmRelation";

	static int num = 0;

	public static ArrayList<String> lista = new ArrayList<String>();
	public static ArrayList<String> list2 = new ArrayList<String>();

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

		// System.out.println("Introduzca el nombre o la ruta del fichero");
		// Scanner scan = new Scanner(System.in);
		// String filename = scan.nextLine();
		// scan.close();

		FileInputStream file = new FileInputStream(
				"C:\\Users\\usuario\\Documents\\zipPruebas\\ExportE3G-ARA10R01_18-12-01.xml");

		XMLInputFactory factory = XMLInputFactory.newInstance();

		XMLStreamReader streamReader = factory.createXMLStreamReader(file);

		PrintStream fichero = new PrintStream(new File("GsmRelation.txt"));
		System.setOut(fichero);

		while (streamReader.hasNext()) {

			gsmRelation(streamReader);

			streamReader.next();
		} // bucle principal
		fichero.close();
		streamReader.close();
	}// main

	public static void gsmRelation(XMLStreamReader streamReader) throws XMLStreamException {

		while (true) {
			if (streamReader.isStartElement()) {
				if (streamReader.getName().getLocalPart().equals(GsmRelation)) {
					while (streamReader.hasNext()) {

						print(streamReader);

						if (streamReader.isEndElement()) {
							if (streamReader.getName().getLocalPart().equals(GsmRelation)) {
								if (num < 1) {
									int ultimo = 1;
									for (String e : lista) {

										if (ultimo++ == lista.size()) {
											System.out.print('"' + e + '"' + "\n");
										} else {
											System.out.print('"' + e + '"' + ",");
										}
									}
									lista.clear();
								}
								int ultimo = 1;
								for (String e : list2) {
									if (ultimo++ == list2.size()) {
										System.out.print('"' + e + '"' + "\n");
									} else {
										System.out.print('"' + e + '"' + ",");
									}
								}
								list2.clear();
								num++;
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

	}// gsmRelation

	private static void print(XMLStreamReader streamReader) throws XMLStreamException {
		if (streamReader.hasName()) {
			if (streamReader.isStartElement()) {
				if (streamReader.getName().getLocalPart().equals(attributes)) {
					System.out.print("");
				} else {
					lista.add(streamReader.getName().getLocalPart());
					if (streamReader.getAttributeCount() != 0) {
						list2.add(streamReader.getAttributeValue(0));
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
				if (streamReader.getText().contains("\n")) {

				} else {
					list2.add(streamReader.getText().trim());
				}
			}
		} else {
			System.out.print("");
		}
	}

}
