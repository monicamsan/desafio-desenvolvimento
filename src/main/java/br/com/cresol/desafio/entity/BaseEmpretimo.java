package br.com.cresol.desafio.entity;

import java.math.BigDecimal;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import br.com.cresol.desafio.exception.DesafioCresolException;


/**
 * @author Fernando Estrela
 *
 */
@MappedSuperclass
public class BaseEmpretimo {
	

	private static final String PREFIX_NU_CONTRATO = "AAAAMMDD";
	private static final Integer NU_MAX_SUFIX = 6;
	private static final BigDecimal VALOR_CONTRATO_BASE = BigDecimal.valueOf(1000);
	private static final Integer MAX_QTDE_PARCELA = 24;
	
	private String numeroContrato;
	private BigDecimal valorContrato;
	private Integer quantidadeParcelas;
	private BigDecimal taxaJurosParcela;
	
	public BaseEmpretimo() {}
	
	public BaseEmpretimo(BigDecimal valorContrato, Integer quantidadeParcelas) {
		super();
		this.valorContrato = valorContrato;
		this.quantidadeParcelas = quantidadeParcelas;
		this.validaQuantidadeMaximaDeParcelas();
		this.geraTaxaJuros();
	}
	
	public BaseEmpretimo(BigDecimal valorContrato, Integer quantidadeParcelas,String numeroContrato) {
		this(valorContrato, quantidadeParcelas);
		this.numeroContrato = numeroContrato;	
	}
	public String getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public BigDecimal getValorContrato() {
		return valorContrato;
	}
	public void setValorContrato(BigDecimal valorContrato) {
		this.valorContrato = valorContrato;
	}
	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	public BigDecimal getTaxaJurosParcela() {
		return taxaJurosParcela;
	}
	public void setTaxaJurosParcela(BigDecimal taxaJurosParcela) {
		this.taxaJurosParcela = taxaJurosParcela;
	}
	
	@Transient
	public void geraNumeroContrato(Integer sequencial) {
		try {
			StringBuilder numeroContratoSb = new StringBuilder(PREFIX_NU_CONTRATO);
			for(int i = 0 ; i < (NU_MAX_SUFIX -sequencial.toString().length()) ; i++) {
				numeroContratoSb.append("0");
			}
			this.numeroContrato = numeroContratoSb.append(sequencial.toString()).toString();
		}catch (Exception e) {
			throw new DesafioCresolException(e, "Erro ao gerar numero do contrato.");
		}
	}
	@Transient
	public void geraTaxaJuros() {
		try {
			this.taxaJurosParcela = new BigDecimal(this.valorContrato.compareTo(VALOR_CONTRATO_BASE) == 1 ? "3.0" : "1.8");
			this.taxaJurosParcela = this.quantidadeParcelas > 12 ? this.taxaJurosParcela.add(new BigDecimal("0.5")) : taxaJurosParcela;
		}catch (Exception e) {
			throw new DesafioCresolException(e, "Erro ao calcular taxa de juros");
		}
	}
	@Transient
	public void validaQuantidadeMaximaDeParcelas() {
		if(this.quantidadeParcelas != null && this.quantidadeParcelas > MAX_QTDE_PARCELA ) throw new DesafioCresolException("A quantidade de parcelas ecedue o maximo permitido.");
	}

}
