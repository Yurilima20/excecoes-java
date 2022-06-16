package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
  private Integer numeroQuarto; 
  private Date saida; 
  private Date entrada;
  
  public static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
  
	public Reserva(Integer numeroQuarto, Date saida, Date entrada) {
		this.numeroQuarto = numeroQuarto;
		this.saida = saida;
		this.entrada = entrada;
	}

	
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getSaida() {
		return saida;
	}

	public Date getEntrada() {
		return entrada;
	}


   public long duracao() {
	   long diff = saida.getTime() - entrada.getTime();
	   return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
   }
  
   public String atualizaData(Date saida, Date entrada) {
	   Date agora = new Date();
		 if(saida.before(agora) || entrada.before(agora)) {
			 return "Não pode atualizar a data para uma data que não seja a partir da data presente";
		 } else if (!saida.after(entrada)) {
			 return "Erro a data de entrada não pode ser maior que a data de saída";
		 }
	   this.saida = saida; 
	   this.entrada = entrada;
	   return null; 
   }
   
   @Override
   public String toString() {
	   return "Quarto " + numeroQuarto + ", entrada " + sdf.format(entrada) + ", saida " + sdf.format(saida)
	  + ","  + duracao() + " noites";
   }
  
}
