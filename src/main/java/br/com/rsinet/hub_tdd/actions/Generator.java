package br.com.rsinet.hub_tdd.actions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {

	public static String dataHoraParaArquivo() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
	}
}
