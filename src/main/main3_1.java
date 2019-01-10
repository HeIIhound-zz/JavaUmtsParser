package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class main3_1 {

	public static String elemento = "{genericNrm.xsd}VsDataContainerELEMENTO_FINAL";

	public static String tipo = null;

	public static Boolean BooleanDataContainer = true;

	public static Boolean BooleanAttribute = true;

	public static final String vsDataContainer = "{genericNrm.xsd}VsDataContainer";

	public static final String vsDataMeContext = "{EricssonSpecificAttributes.15.25.xsd}vsDataMeContext";

	public static String tipoVsDataMeContext = null;

	public static final String attribute = "{genericNrm.xsd}attributes";

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

		// System.out.println("Introduzca el nombre o la ruta del fichero");
		// Scanner scan = new Scanner(System.in);
		// String filename = scan.nextLine();
		// scan.close();

		FileInputStream file = new FileInputStream(
				"C:\\Users\\usuario\\Documents\\zipPruebas\\ExportE3G-ARA10R01_18-12-01.xml");

		XMLInputFactory factory = XMLInputFactory.newInstance();

		XMLStreamReader streamReader = factory.createXMLStreamReader(file);

		PrintStream fichero = new PrintStream(new File("ficheroMain3_1.txt"));
		System.setOut(fichero);

		while (streamReader.hasNext()) {

			while (streamReader.isStartElement()) {

				tipo = streamReader.getName().toString();

				while (tipo.equals(vsDataMeContext)) {

					switch (streamReader.getEventType()) {

					case XMLEvent.CDATA:
						System.out.println(streamReader.getElementText() + " +1");

					default:
						break;
					}

					if (streamReader.isEndElement() && tipo.equals(vsDataMeContext)) {
						System.exit(0);
						break;
					} else {
						streamReader.next();
					}
				}
				break;
			}
			streamReader.next();
		}
		streamReader.close();
	}// main

	public static void name(XMLStreamReader streamReader) throws XMLStreamException {

		System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText() + " | ");
	}

	/*
	 * private static void printAttribut(XMLStreamReader streamReader) throws
	 * XMLStreamException { System.out.print(streamReader.getLocalName() + " "); if
	 * (streamReader.getAttributeCount() > 0) {
	 * 
	 * int count = streamReader.getAttributeCount();
	 * 
	 * for (int i = 0; i < count; i++) { QName name =
	 * streamReader.getAttributeName(i); String value =
	 * streamReader.getAttributeValue(i);
	 * 
	 * System.out.println(name.toString() + "=" + value); streamReader.next(); } }
	 * else { // System.out.println("HAS NO ATTRIBUTES"); } }
	 */

	public final static int getTipo(String tipo) {

		if (tipo.equals(vsDataContainer)) {
			return 1;
		} else if (tipo.equals(attribute)) {
			return 2;
		} else {
			return 0;
		}

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

	/*
	 * while(vsTrue) { streamReader.next(); streamReader.next();
	 * while(streamReader.isStartElement()) {
	 * tipoVsDataMeContext=streamReader.getName().toString();
	 * 
	 * System.out.println(streamReader.getLocalName()+" "+streamReader.
	 * getElementText()); //System.exit(0);
	 * /*while(Objects.equals(tipoVsDataMeContext, vsDataMeContext)) {
	 * System.out.println("Holaa"); System.exit(0); break; } break; }
	 * while(streamReader.isEndElement()) {
	 * tipo=streamReader.getName()+getEventTypeString(streamReader.getEventType());
	 * //break; } while(Objects.equals(tipo, elemento)) { System.out.println(tipo);
	 * System.out.println("holaa"); System.out.println(streamReader.getLocation());
	 * System.exit(0); vsTrue = false; break; } //break; imprime todos los
	 * vsDataContainer }
	 */

}
