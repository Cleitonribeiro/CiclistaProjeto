import java.util.Scanner;

public class Ciclista {

	public static void main(String [] args) throws CiclistaException {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("--------------");
			System.out.println("Selecione a unidade de distância:");
			System.out.println("[1] km");
			System.out.println("[2] m");
			System.out.print("> ");
			String distanciaEntrada = scanner.nextLine();
			
			System.out.println("--------------");
			System.out.println("Selecione a unidade de tempo:");
			System.out.println("[1] horas");
			System.out.println("[2] minutos");
			System.out.println("[3] segundos");
			System.out.print("> ");
			String tempoEntrada = scanner.nextLine();
			
			System.out.println("--------------");
			System.out.print("Informe distancia e tempo: ");
			String valoresEntrada = scanner.nextLine();
			
			double[] velocidadeTempo = interpretarValoresDeVelocidadeTempo(valoresEntrada);
			double velocidadeMedia = calcularVelocidadeMedia(velocidadeTempo[0], velocidadeTempo[1]);
			System.out.println("Velocidade media: " + velocidadeMedia);
		}
	}
	
	public static double calcularVelocidadeMedia(double distancia, double tempo) throws CiclistaException {
		if(tempo == 0.0) {
			throw new CiclistaException();
		}
		return distancia/tempo;
	}

	public static double[] interpretarValoresDeVelocidadeTempo(String valoresEntrada) {
		String[] velocidadeTempoString = valoresEntrada.split(" ");
		return new double[] {Double.parseDouble(velocidadeTempoString[0]), Double.parseDouble(velocidadeTempoString[1])};
	}
	
	public static double converterUnidadePadraoTempo(String valoresEntrada, String tempoEntrada) {
		String[] velocidadeTempoString = valoresEntrada.split(" ");
		
		double tempoSeparado = Double.parseDouble(velocidadeTempoString[1]);
		double padraoTempo = 0;
		
		if(tempoEntrada == "1"){
			padraoTempo = tempoSeparado*60;
		}
			
		if(tempoEntrada == "2"){
			padraoTempo = tempoSeparado;
		}
		
		if(tempoEntrada == "3"){
			padraoTempo = tempoSeparado/60;
		}
		
		return padraoTempo;
	}
	public static double converterUnidadePadraoDistancia(String valoresEntrada, String distanciaEntrada) {
		String[] velocidadeTempoString = valoresEntrada.split(" ");
		
		double distanciaSeparada = Double.parseDouble(velocidadeTempoString[0]);
		double padraoDistancia = 0;
		
		if(distanciaEntrada == "1"){
			padraoDistancia = distanciaSeparada*1000;
		}
			
		if(distanciaEntrada == "2"){
			padraoDistancia = distanciaSeparada;
		}
		
		return padraoDistancia;
	}
	public static double[] converterUnidadePadraoDistanciaTempo(String valoresEntrada,String tempoEntrada, String distanciaEntrada) {
		String[] velocidadeTempoString = valoresEntrada.split(" ");
		
		
		//DISTANCIA
		double distanciaSeparada = Double.parseDouble(velocidadeTempoString[0]);
		double padraoDistancia = 0;
		
		if(distanciaEntrada == "1"){
			padraoDistancia = distanciaSeparada*1000;
		}
			
		if(distanciaEntrada == "2"){
			padraoDistancia = distanciaSeparada;
		}
		//TEMPO
		double tempoSeparado = Double.parseDouble(velocidadeTempoString[1]);
		double padraoTempo = 0;
		
		if(tempoEntrada == "1"){
			padraoTempo = tempoSeparado*60;
		}
			
		if(tempoEntrada == "2"){
			padraoTempo = tempoSeparado;
		}
		
		if(tempoEntrada == "3"){
			padraoTempo = tempoSeparado/60;
		}
		
		return new double[] {padraoDistancia, padraoTempo};
	}
}