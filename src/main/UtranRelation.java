package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class UtranRelation {

	public static String elemento = "{genericNrm.xsd}VsDataContainerELEMENTO_FINAL";

	public static String tipo = null;

	public static Boolean BooleanDataContainer = true;

	public static Boolean BooleanAttribute = true;

	public static final String UtranRelationInicio = "UtranRelationELEMENTO_DE_INICIO";

	public static final String UtranRelationFin = "UtranRelationELEMENTO_FINAL";

	public static String tipoVsDataMeContext = null;

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

		// System.out.println("Introduzca el nombre o la ruta del fichero");
		// Scanner scan = new Scanner(System.in);
		// String filename = scan.nextLine();
		// scan.close();

		FileInputStream file = new FileInputStream(
				"C:\\Users\\usuario\\Documents\\zipPruebas\\ExportE3G-AST60R04_18-12-01.xml");

		XMLInputFactory factory = XMLInputFactory.newInstance();

		XMLStreamReader streamReader = factory.createXMLStreamReader(file);

		PrintStream fichero = new PrintStream(new File("UtranRelation_AST60R04.txt"));// vsDataIubLink
		System.setOut(fichero);

		while (streamReader.hasNext()) {

			if (streamReader.isStartElement()) {
				tipo = streamReader.getName().getLocalPart() + getEventTypeString(streamReader.getEventType());

				if (tipo.equals(UtranRelationInicio)) {
					System.out.println(streamReader.getName().getLocalPart() + " "
							+ streamReader.getAttributeLocalName(0) + " " + streamReader.getAttributeValue(0));

					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));// AttributesInicio
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));// AttributesFin
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getAttributeName(0)
							+ streamReader.getAttributeValue(0) + " "
							+ getEventTypeString(streamReader.getEventType()));// VsDataContainerInicio
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()) + "\n");
					System.out.println(
							"---------------------------------------------------------------------------------------------------------------------------------------");

				}

			}

			streamReader.next();
		} // bucle principal
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

}
