package ipTracer.Controller;




import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import ipTracer.DTO.DadosIPDTO;

public class IpTracerController {

	public DadosIPDTO requisitarDadosIP(String ip) {  //request da api usando o IP pesquisado
		final boolean validacao = validarFormatoIPV4(ip);
		DadosIPDTO dadosIPDTO = new DadosIPDTO();
		if (validacao) {
			final String requestedIP = ip;
			final String uri = "https://api.ipfind.com/?ip=" + requestedIP;

			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(uri, String.class);
			System.out.println(transformarStringEmJson(result));
			JSONObject jsonObject = transformarStringEmJson(result);
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
	         
	       
			return dadosIPDTO;
			
		} else
			
			return null;
	}

	public boolean validarFormatoIPV4(String ip) { //valida formato de IPv4
		try {
			if (ip == null || ip.isEmpty()) {
				return false;
			}

			String[] parts = ip.split("\\.");
			if (parts.length != 4) {
				return false;
			}

			for (String s : parts) {
				int i = Integer.parseInt(s);
				if ((i < 0) || (i > 255)) {
					return false;
				}
			}
			if (ip.endsWith(".")) {
				return false;
			}

			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public JSONObject transformarStringEmJson(String string) { //transforma string em json
		try {
			JSONObject jsonObject = new JSONObject(string);
			return jsonObject;
		} catch (JSONException err) {
			System.out.println("Error" + err.toString());
		}
		return null;
	}
	
	
	
}
