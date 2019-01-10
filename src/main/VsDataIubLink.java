package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class VsDataIubLink {

	public static String elemento = "{genericNrm.xsd}VsDataContainerELEMENTO_FINAL";

	public static String tipo = null;

	public static Boolean BooleanDataContainer = true;

	public static Boolean BooleanAttribute = true;

	public static final String attributesInicio = "attributesELEMENTO_DE_INICIO";

	public static final String attributesFin = "attributesFin";

	public static final String vsDataContainerInicio = "VsDataContainerELEMENTO_DE_INICIO";

	public static final String vsDataContainerFin = "VsDataContainerELEMENTO_FINAL";

	public static final String vsDataMeContext = "{EricssonSpecificAttributes.15.25.xsd}vsDataMeContext";

	public static final String vsDataIubLinkInicio = "vsDataIubLinkELEMENTO_DE_INICIO";

	public static final String vsDataIubLinkFin = "vsDataIubLinkELEMENTO_FINAL";

	public static final String userPlaneTransportOptionInicio = "userPlaneTransportOptionELEMENTO_DE_INICIO";

	public static final String userPlaneTransportOptionFin = "userPlaneTransportOptionELEMENTO_FINAL";

	public static String tipoVsDataMeContext = null;

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

		// System.out.println("Introduzca el nombre o la ruta del fichero");
		// Scanner scan = new Scanner(System.in);
		// String filename = scan.nextLine();
		// scan.close();

		FileInputStream file = new FileInputStream(
				"/home/orlando/Documentos/ExportE3G-ARA10R01_18-12-01.xml");

		XMLInputFactory factory = XMLInputFactory.newInstance();

		XMLStreamReader streamReader = factory.createXMLStreamReader(file);

		PrintStream fichero = new PrintStream(new File("vsDataIubLink_AST60R04.txt"));// vsDataIubLink


		System.setOut(fichero);

		while (streamReader.hasNext()) {

			/*
			 * switch(streamReader.) {
			 * 
			 * }
			 */

			if (streamReader.isStartElement()) {
				tipo = streamReader.getName().getLocalPart() + getEventTypeString(streamReader.getEventType());

				if (tipo.equals(vsDataIubLinkInicio)) {
					System.out.println(streamReader.getName().getLocalPart() + " "
							+ getEventTypeString(streamReader.getEventType()));

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
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));// userPlaneTransportOptionInicio
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));// userPlaneTransportOptionFin
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));// controlPlaneTransportOptionInicio
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()));// controlPlaneTransportOptionFinal
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
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(streamReader.getLocalName() + " " + streamReader.getElementText());
					streamReader.next();
					streamReader.next();
					System.out.println(
							streamReader.getLocalName() + " " + getEventTypeString(streamReader.getEventType()) + "\n");// vsDataIubLinkFinal
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------");
				}

			}
			/*
			 * if(streamReader.isEndElement()) { tipo =
			 * streamReader.getName().getLocalPart()+getEventTypeString(streamReader.
			 * getEventType()); if(tipo.equals(vsDataIubLinkFin)) {
			 * System.out.println(streamReader.getName().getLocalPart()+" "
			 * +getEventTypeString(streamReader.getEventType())+"\n"); }
			 * 
			 * }
			 */

			streamReader.next();
		} // bucle principal
		streamReader.close();
	}// main

	public static void name(XMLStreamReader streamReader) throws XMLStreamException {

		/*
		 * while(streamReader.getName().getLocalPart().equals(attribute)) {
		 * System.out.println(streamReader.getName().getLocalPart()+" "
		 * +getEventTypeString(streamReader.getEventType()));
		 * 
		 * if(streamReader.isEndElement() &&
		 * streamReader.getName().getLocalPart().equals(attribute)) {
		 * System.out.println(streamReader.getName().getLocalPart()+" "
		 * +getEventTypeString(streamReader.getEventType())); break; }else {
		 * streamReader.next(); tipo =
		 * streamReader.getName().getLocalPart()+getEventTypeString(streamReader.
		 * getEventType()); } }
		 */

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

		if (tipo.equals(vsDataContainerInicio)) {
			return 1;
		} else if (tipo.equals(attributesInicio)) {
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
