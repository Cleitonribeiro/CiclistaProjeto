import java.util.Scanner;
import java.util.Vector;

public class Ciclista {

	public static void main(String[] args) throws CiclistaException {
		Scanner entrada = new Scanner(System.in);
		
		while(true) {
			System.out.print("Informe a distância percorrida e tempo gasto: ");
			String dadosString = entrada.nextLine();

			Vector dadosVector = interpretarDados(dadosString); 
			
			double a = (Double) dadosVector.get(0);
			double b = (Double) dadosVector.get(1);		
			double mediaFinal = calculaMedia(a, b);
	
			System.out.println("Média: " + mediaFinal);		
		}
	}
	
	private static Vector interpretarDados(String dadosString) {
		String[] dadosSeparados = dadosString.split(" ");
			
			double distancia = Double.parseDouble(dadosSeparados[0]);
			double tempo = Double.parseDouble(dadosSeparados[1]);
			
			Vector dadosVector = new Vector();
			dadosVector.add(distancia);
			dadosVector.add(tempo);
			return dadosVector;

	}

	public static double calculaMedia(double distancia, double tempo)  throws CiclistaException {
		double mediaFinal = distancia / tempo;
		
		return mediaFinal;
	}
}