package ipTracer.DTO;


import org.json.JSONArray;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DadosIPDTO {
	
	private String Ip;
	private String Pais;
	private String Sig_pais;
	private String Continente;
	private String Sig_Continente;
	private String Municipio;
	private String Cidade;
	private String Estado;
	private String Cod_regiao;
	private String Timezone;
	private String Dono;
	private String Longitude;
	private String Latitude;
	private String Moeda;
	private String[] Linguagens;
	//String continent, owner,country,city,timezone,latitude,county,continent_code,ip_address,country_code,warning,languages[];




}
