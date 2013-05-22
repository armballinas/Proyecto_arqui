
public class Manager {

	private static final String CAD_AYUDA = "Debes de escribir 5 argumentos en en siguiente orden:\n numero de renglones, numero de columnas, numero de workers,constante de calor 1, constante de calor 2";

	//atributos
	private static int ren;
	private static int work;
	private static double cx;
	private static double cy;
	private static double malla[][];
	private static double centro;
	private static int control;
	
	/**
	 * @param args los argumentos de consola:
	 * 1.- Renglones (int)
	 * 2.- Columnas (int)
	 * 3.- Workers (int)
	 * 4.- Constante Cx (double)
	 * 5.- Constante Cy (double)
	 */
	public static void main(String[] args) {
		if(args.length != 5){
			ayuda();
		}
		else{
			ren = Integer.parseInt(args[0]);
			work = Integer.parseInt(args[1]);
			cx = Double.parseDouble(args[2]);		}
			cy = Double.parseDouble(args[3]);
			centro = Double.parseDouble(args[4]);
			control = 0;
			llenaMalla();
			imprimemalla();
			distribuyetrabajo();
			while(control < work){
				;
			}
			imprimemalla();
			
	}

	public static synchronized void incrementaControl(){
		control++;
	}
	
	public static void rearma(int i, int j){
		//Aquí el hilo reasigna la malla de manager con sus resultados
	}
	
	private static void distribuyetrabajo() {
		// TODO Auto-generated method stub
		Worker arr[] = new Worker[work];
		int i;
		for(i=0; i<work-1;i++){
			double[][] pedazo = divideMalla(ren/work, i);
			arr[i] = new Worker(pedazo,i,ren,null,null);
		}
		
		double[][] pedazo = divideMalla(ren-i,work-1);
		arr[work] = new Worker(pedazo,i,ren,null,null);
		
		/*for(int i = 0;i<work;i++){
			arr[i].run();
		}*/
	}

	private static double[][] divideMalla(int tam, int pos){
		double[][] pedazo = new double[ren][tam];
		int it = 0;
		int jit = 0;
		for(int i=0; i<ren; i++ ){
			for(int j=pos; j<tam; j++){
				pedazo[it][jit] = malla[i][j];
				jit++;
			}
			it++;
		}
		return pedazo;
	}
	private static void imprimemalla() {
		for(int i = 0;i<ren;i++){
			for(int j=0;j<ren;j++){
				System.out.print(malla[i][j] + " ");
			}
			System.out.print("\n");
		}
		
	}

	private static void llenaMalla() {
		malla = new double[ren][ren];
		int cen = ren/2;
		for(int i=0;i<ren;i++){
			for(int j=0;j<ren;j++){
				malla[i][j] = 0;  
			}
		}
		malla[cen][cen] = centro;
	}

	private static void ayuda() {
		System.out.println(CAD_AYUDA);
	}
	
	private static double[][] arma(Worker[] w){
		for(int j = 0;j<ren; j++){
			for(int i = 0; i<ren; i++){
				w[i].malla[j][i]
			}
		}
	}
}
