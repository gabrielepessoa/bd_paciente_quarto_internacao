package infraestrutura.dominio;

import java.text.SimpleDateFormat;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class Date {

	public java.util.Date transformaData(String data) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return formatador.parse(data);
		} catch (ParseException | java.text.ParseException ex) {
			throw new RuntimeException(ex);
		}
	}
}
