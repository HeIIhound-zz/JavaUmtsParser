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

		PrintStream fichero = new PrintStream(new File("GsmRelation.txt"));// vsDataIubLink
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
								if(num<1){
									for(String e : lista) {
											System.out.println(e.trim());
									}
									//System.out.print(lista.toString());
									lista.clear();
									num++;
								}
								if(num < 2) {
									num++;
									if(num == 2) {
									System.exit(0);
									}
								}
								//System.exit(0);
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
					//System.out.print('"' + streamReader.getName().getLocalPart() + '"' + ",");
					//lista.add('"'+streamReader.getName().getLocalPart()+'"');
					if (streamReader.getAttributeCount() != 0) {
						//System.out.print(streamReader.getAttributeValue(0));
						//lista.add('"'+streamReader.getAttributeValue(0)+'"');
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
				// System.out.print(streamReader.getText().trim());
				//System.out.println(String.valueOf(streamReader.getText().trim()));
				
				if(streamReader.getText() == "\\r") {
					System.out.println("1");
				}else{
					System.out.println("2");
				}
				System.exit(0);
			}
		} else {
			System.out.print("");
		}
	}

}
