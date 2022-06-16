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
  
   public void atualizaData(Date saida, Date entrada) {
	   this.saida = saida; 
	   this.entrada = entrada;
   }
   
   @Override
   public String toString() {
	   return "Quarto " + numeroQuarto + ", entrada " + sdf.format(entrada) + ", saida " + sdf.format(saida)
	  + ","  + duracao() + " noites";
   }
  
}
