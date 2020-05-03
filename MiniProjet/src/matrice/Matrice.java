package matrice;
import java.util.*;
import java.io.*;
/**
 * Cette classe represente les matrices utilisees afin de resoudre le probleme du STP
 */
public class Matrice{
	
	private int taille;
	private int[][] distances;
	
	private int infini;
	
/**
 * Constructeur de la classe Matrice.
 * @param nom_fichier : nom du fichier ou sont stockees les distances sous le format defini
 */
	public Matrice(String nom_fichier) throws java.io.IOException {
		File fichier = new File(nom_fichier + ".txt");
		Scanner lecteur = new Scanner(fichier);
		
		this.taille = lecteur.nextInt();
		this.distances = new int[taille][taille];
		this.infini = 0;
		
		for(int i = 0; i < this.taille; i++) {
			for(int j = 0; j < this.taille; j++) {
				int current = lecteur.nextInt()
				this.distances[i][j] = current;
				if(current > this.infini) {
					this.infini = current;
				}
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
	
	public int recherche_max_colonne(int i) {
		int max_col = 0;
		for(int j = 0; j < this.taille; j++) {
			current = this.distances[j][i];
			if((current > max_col)&&(current != this.infini)) {
				max_col = current;
			}
		}
		return max_col;
	}
	
	public int reduction_colonne() {
		for(int i = 0;i < this.taille; i++) {
			System.out.println(this.recherche_max_colonne(i));
		}
		return 0;
	}
	
	
}
