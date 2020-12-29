package br.com.softblue.sbpay;

public class PaymentResponse {

	private StatusPagamento status;
	private String erro;

	public PaymentResponse(StatusPagamento status) {
		this.status = status;
	}

	public PaymentResponse(String erro) {
		this.erro = erro;
	}

	public StatusPagamento getStatus() {
		return status;
	}

	public String getErro() {
		return erro;
	}

}
