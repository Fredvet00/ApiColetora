package ipTracer.Controller;

import org.springframework.http.ResponseEntity;

import ipTracer.DTO.DadosIPDTO;
import ipTracer.Utils.IpTracerUtilsConnection;
import ipTracer.Utils.IpTracerUtilsJsonToDTO;
import ipTracer.Utils.IpTracerUtilsVerificators;

public class IpTracerController {
	IpTracerUtilsConnection ipTracerUtilsConnection = new IpTracerUtilsConnection();
	IpTracerUtilsJsonToDTO ipTracerUtilsJsonToDTO = new IpTracerUtilsJsonToDTO();
	IpTracerUtilsVerificators ipTracerUtilsVerificators = new IpTracerUtilsVerificators();

	public ResponseEntity<?> processarIP(String ip) { // request da api usando o IP pesquisado

		DadosIPDTO dadosIPDTO = new DadosIPDTO();
		String url = "https://api.ipfind.com/";
		String queryElement = "?ip=";
		String requestedElement = ip;

		if (ipTracerUtilsVerificators.verificarFormatoIPV4(ip)) {
			ipTracerUtilsJsonToDTO.dataTransferMethod(dadosIPDTO,
					ipTracerUtilsConnection.requestMaker(url, requestedElement, queryElement));

			return ResponseEntity.ok(dadosIPDTO);

		} else

			return ResponseEntity.ok("IP inválido");
	}

	

}
