package matrice;
import java.io.IOException;

/**
 * Voici la classe a executer pour tester le programme
 *
 */
public class Executable {

	public static void main(String[] args) throws IOException {
		Matrice matrice = new Matrice("TSP005");
		matrice.afficheMatrice();
	}

}