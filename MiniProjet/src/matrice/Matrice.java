package matrice;
import java.util.*;
import java.io.*;
/**
 * Cette classe represente les matrices utilisees afin de resoudre le probleme du STP
 */
public class Matrice{
	
	private int taille;
	private int[][] distances;
	
/**
 * Constructeur de la classe Matrice.
 * @param nom_fichier : nom du fichier ou sont stockees les distances sous le format defini
 */
	public Matrice(String nom_fichier) throws java.io.IOException {
		File fichier = new File(nom_fichier + ".txt");
		Scanner lecteur = new Scanner(fichier);
		
		this.taille = lecteur.nextInt();
		this.distances = new int[taille][taille];
		
		for(int i = 0; i < this.taille; i++) {
			for(int j = 0; j < this.taille; j++) {
				this.distances[i][j] = lecteur.nextInt();
			}
		}
		return;
	}
	
	/**
	 * Cette methode permet d'afficher la matrice
	 */
	public void afficheMatrice() {
		System.out.println("Nombre de villes: " + this.taille);
		for(int i = 0; i < this.taille; i++) {
			for(int j = 0; j < this.taille; j++) {
				System.out.print(this.distances[i][j] + "\t ");
			}
			System.out.println();
		}
		return;
	}
}
