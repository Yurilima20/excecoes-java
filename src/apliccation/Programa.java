package apliccation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		 SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		 
		 System.out.println("Numero do quarto ?");
		 int numero = sc.nextInt();
		 System.out.println("Data de entrada (dd/MM/yyyy)");
		 Date entrada = sdf.parse(sc.next());
		 System.out.println("Data de saída (dd/MM/yyyy)");
		 Date saida = sdf.parse(sc.next());
		 
		 if (!saida.after(entrada)) {
			 System.out.println("Erro a data de entrada não pode ser maior que a data de saída");
		 } else {
			 Reserva reserva = new Reserva(numero, saida, entrada);
			 System.out.println("Reservas : " + reserva);
			 
				System.out.println();
				System.out.println("Entre com as novas datas para atualizar a reserva ");
				System.out.println("Data de entrada (dd/MM/yyyy)");
				entrada = sdf.parse(sc.next());
				System.out.println("Data de saída (dd/MM/yyyy)");
				saida = sdf.parse(sc.next());

				String error = reserva.atualizaData(saida, entrada);
				if (error != null) {
					System.out.println("Erro na reserva " + error);
				} else {
					System.out.println("Reservas : " + reserva);
				}
				

		 }
		 
		sc.close(); 
	}
}
