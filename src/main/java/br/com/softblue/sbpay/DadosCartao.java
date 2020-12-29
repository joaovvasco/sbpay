package br.com.softblue.sbpay;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class DadosCartao {
	
	@NotBlank
	@Pattern(regexp = "\\d{16}", message = "Número do cartão inválido")
	private String numeroCartao;

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

}
