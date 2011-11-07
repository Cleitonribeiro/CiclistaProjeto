import java.util.Scanner;

public class Ciclista {

	//CONSTANTES 
	public static final String KILOMETROS = "1";
	public static final String METROS = "2";
	
	public static final String HORA = "1";
	public static final String MINUTOS = "2";
	public static final String SEGUNDOS = "3";
	
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
			double[] velocidadeTempoMS = converterUnidadePadraoDistanciaTempo(valoresEntrada,tempoEntrada, distanciaEntrada);
			double velocidadeMedia = calcularVelocidadeMedia(velocidadeTempoMS[0], velocidadeTempoMS[1]);
			double velocidadeMediaKmH=velocidadeMedia * 3.6;
			
			System.out.println("Selecione o formato de exibição: ");
			System.out.println("[1] m/s");
			System.out.println("[2] km/h");
			String formatoExibicao = scanner.nextLine();
			
			if(formatoExibicao.equals("1")){
				System.out.println("Velocidade media(m/s): " + velocidadeMedia +  " m/s " );
			}
			
			if(formatoExibicao.equals( "2")){
				System.out.println("Velocidade media(km/h): " + velocidadeMediaKmH +  " km/h " );
			}
			
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
		
		if(distanciaEntrada.equals(KILOMETROS)){
			padraoDistancia = distanciaSeparada*1000;
		}
			
		if(distanciaEntrada.equals(METROS)){
			padraoDistancia = distanciaSeparada;
		}
		
		return padraoDistancia;
	}
	public static double[] converterUnidadePadraoDistanciaTempo(String valoresEntrada,String tempoEntrada, String distanciaEntrada) {
		String[] velocidadeTempoString = valoresEntrada.split(" ");
		
		
		//DISTANCIA
		double distanciaSeparada = Double.parseDouble(velocidadeTempoString[0]);
		double padraoDistancia = 0;
		
		if(distanciaEntrada.equals("1")){
			padraoDistancia = distanciaSeparada*1000;
		}
			
		if(distanciaEntrada.equals("2")){
			padraoDistancia = distanciaSeparada;
		}
		//TEMPO
		double tempoSeparado = Double.parseDouble(velocidadeTempoString[1]);
		
		double padraoTempo = 0;
		
		if(tempoEntrada.equals("1")){
			padraoTempo = tempoSeparado*3600;
			
		}
			
		if(tempoEntrada.equals("2")){
			padraoTempo = tempoSeparado*60;
		}
		
		if(tempoEntrada.equals("3")){
			padraoTempo = tempoSeparado;
		}
		

		return new double[] {padraoDistancia, padraoTempo};
	}
}