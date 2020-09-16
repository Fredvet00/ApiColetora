package ipTracer.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ipTracer.DTO.DadosIPDTO;


public class IpTracerUtilsJsonToDTO {
JSONObject jsonObject = new JSONObject();
DadosIPDTO dadosIPDTO = new DadosIPDTO();

public DadosIPDTO dataTransferMethod(DadosIPDTO dadosIPDTO, JSONObject jsonObject ) {
	dadosIPDTO.setIp(jsonObject.get("ip_address").toString());
	dadosIPDTO.setCidade(jsonObject.get("city").toString());
	dadosIPDTO.setCod_regiao(jsonObject.get("region_code").toString());
	dadosIPDTO.setContinente(jsonObject.get("continent").toString());
	dadosIPDTO.setSig_Continente(jsonObject.get("continent_code").toString());
	dadosIPDTO.setDono(jsonObject.get("owner").toString());
	dadosIPDTO.setEstado(jsonObject.get("region").toString());
	dadosIPDTO.setLatitude(jsonObject.get("latitude").toString());
	dadosIPDTO.setLongitude(jsonObject.get("longitude").toString());
	dadosIPDTO.setMoeda(jsonObject.get("currency").toString());
	dadosIPDTO.setMunicipio(jsonObject.get("county").toString());
	dadosIPDTO.setPais(jsonObject.get("country").toString());
	dadosIPDTO.setSig_pais(jsonObject.get("country_code").toString());
	dadosIPDTO.setTimezone(jsonObject.get("timezone").toString());
	JSONArray jsonArray = (JSONArray) jsonObject.get("languages");
	String[] aux = new String[jsonArray.length()];
	for (int i = 0; i < jsonArray.length(); i++) {
		aux[i] = jsonArray.get(i).toString();
	}
	dadosIPDTO.setLinguagens(aux);
	
	return dadosIPDTO;
}
	
public JSONObject transformarStringEmJson(String string) { // transforma string em json
	try {
		JSONObject jsonObject = new JSONObject(string);
		return jsonObject;
	} catch (JSONException err) {
		System.out.println("Error" + err.toString());
	}
	return null;
}
	
}
