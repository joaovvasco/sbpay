package br.com.softblue.sbpay;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SBPayService {
	
	private final String AUTH = "r2d2";
	
	@PostMapping(path = "/pay", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentResponse> pagar(
			@RequestHeader("Token") String token,
			@Valid @RequestBody(required = true) DadosCartao cartao,
			Errors errors
			){
		
		if(!AUTH.equals(token))
			return ResponseEntity.badRequest().body(new PaymentResponse("Token inválido"));
		
		if(errors.hasErrors())
			return ResponseEntity.ok(new PaymentResponse(StatusPagamento.CARTAO_INVALIDO));
		
		PaymentResponse response = cartao.getNumeroCartao().startsWith("1111")? new PaymentResponse(StatusPagamento.AUTORIZADO) : new PaymentResponse(StatusPagamento.NAO_AUTORIZADO);
		
		return ResponseEntity.ok(response);
	}
	
}
