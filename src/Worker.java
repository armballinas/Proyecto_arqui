
public class Worker implements Runnable {

	
	private double malla[][];
	private int ini;
	private int fin;
	private Worker izq;
	private Worker der;
	
	public Worker(double malla[][], int i, int j, Worker izq, Worker der){
		this.malla = malla;
		this.ini = i;
		this.fin = j;
		this.izq = izq;
		this.der = der;
	}
	
	public Worker() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		;

	}
	
	public double getValue(int i, int j){
		return malla[i][j];
	}

}
