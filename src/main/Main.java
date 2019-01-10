package main;

import javax.xml.stream.events.XMLEvent;

public class Main {

	/*
	 * private static List<String> lista;
	 * 
	 * public static void main (String[] args) {
	 * 
	 * 
	 * 
	 * System.out.println("Introduzca el nombre o la ruta del fichero"); Scanner
	 * scan = new Scanner(System.in); String ruta = scan.nextLine(); scan.close();
	 * 
	 * 
	 * String filename = ruta;
	 * 
	 * 
	 * lista = new ArrayList<String>(); lista.add(filename);
	 * 
	 * for(String corredor : lista) {
	 * 
	 * }
	 * 
	 * //clase de fabrica stax XMLInputFactory xmlFactory =
	 * XMLInputFactory.newInstance();
	 * 
	 * 
	 * 
	 * try { FileInputStream fis = new FileInputStream(filename);
	 * 
	 * xmlFactory.createXMLStreamReader(fis);
	 * 
	 * hola(filename, xmlFactory);
	 * 
	 * 
	 * 
	 * for (int i = 0 ; i < count ; i++) { // pass the file name.. all relative
	 * entity // references will be resolved against this // as base URI.
	 * XMLStreamReader xmlr = xmlif.createXMLStreamReader(filename, new
	 * FileInputStream(filename));
	 * 
	 * // when XMLStreamReader is created, // it is positioned at START_DOCUMENT
	 * event. int eventType = xmlr.getEventType(); printEventType(eventType);
	 * printStartDocument(xmlr);
	 * 
	 * // check if there are more events // in the input stream
	 * while(xmlr.hasNext()) { eventType = xmlr.next(); printEventType(eventType);
	 * 
	 * // these functions print the information // about the particular event by
	 * calling // the relevant function printStartElement(xmlr);
	 * printEndElement(xmlr); printText(xmlr); printPIData(xmlr);
	 * printComment(xmlr); } }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (XMLStreamException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * private static void hola(String filename, XMLInputFactory xmlFactory) {
	 * 
	 * for (int i = 0 ; i < 5 ; i++) { // pass the file name.. all relative entity
	 * // references will be resolved against this // as base URI. XMLStreamReader
	 * xmlr = xmlFactory.createXMLStreamReader(filename, new
	 * FileInputStream(filename));
	 * 
	 * // when XMLStreamReader is created, // it is positioned at START_DOCUMENT
	 * event. int eventType = xmlr.getEventType(); printEventType(eventType);
	 * printStartDocument(xmlr);
	 * 
	 * // check if there are more events // in the input stream
	 * while(xmlr.hasNext()) { eventType = xmlr.next(); printEventType(eventType);
	 * 
	 * // these functions print the information // about the particular event by
	 * calling // the relevant function printStartElement(xmlr);
	 * printEndElement(xmlr); printText(xmlr); printPIData(xmlr);
	 * printComment(xmlr); } }
	 * 
	 * }
	 */

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

	public static void printEventType(int eventType) {
		System.out.print("EVENT TYPE(" + eventType + "):");
		System.out.println(getEventTypeString(eventType));
	}

}
