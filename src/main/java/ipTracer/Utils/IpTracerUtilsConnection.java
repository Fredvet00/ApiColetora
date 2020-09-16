package ipTracer.Utils;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class IpTracerUtilsConnection {
	IpTracerUtilsJsonToDTO ipTracerUtilsJsonToDTO = new IpTracerUtilsJsonToDTO();
	public JSONObject requestMaker(String urlValue, String requestedElementValue, String queryElementValue) {
		
		
		String uri =urlValue + queryElementValue + requestedElementValue;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		JSONObject jsonObject = ipTracerUtilsJsonToDTO.transformarStringEmJson(result);
		return jsonObject;
	}
	
	
}
