package ipTracer.Rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ipTracer.Controller.IpTracerController;

@RestController
@RequestMapping("/api")

public class IpTracerWS {
	@GetMapping("/{ip}")
	
	
	public ResponseEntity<?> retornarInfoIp(@PathVariable(value = "ip") String ip) {
		IpTracerController ipTracerController = new IpTracerController();

		return new ResponseEntity<>(ipTracerController.processarIP(ip), HttpStatus.FOUND);

	}
}
