package matrice;
import java.util.*;
import java.io.*;
/**
 * Cette classe represente les matrices utilisees afin de resoudre le probleme du STP
 */
public class Matrice{
	
	private int taille;
	private int[][] distances;
	
	private int distance_min;
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
				int current = lecteur.nextInt();
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
	
	/**
	 * Methode renvoyant le plus grand element de la colonne i de la matrice (sans considerer "l'infini".
	 * @param i colonne
	 * @return plus grand entier de la colonne i;
	 */
	public int recherche_max_colonne(int i) {
		int max_col = 0;
		int current = 0;
		for(int j = 0; j < this.taille; j++) {
			current = this.distances[j][i];
			if((current > max_col)&&(current != this.infini)) {
				max_col = current;
			}
		}
		return max_col;
	}
	
	/**
	 * Methode renvoyant le plus grand element de la ligne j de la matrice (sans considerer "l'infini".
	 * @param j ligne
	 * @return plus grand entier de la ligne j;
	 */
	public int recherche_max_ligne(int j) {
		int max_col = 0;
		int current = 0;
		for(int i = 0; i < this.taille; i++) {
			current = this.distances[j][i];
			if((current > max_col)&&(current != this.infini)) {
				max_col = current;
			}
		}
		return max_col;
	}

	public int recherche_min_colonne(int i) {
		int min_col = this.distances[0][i];
		int current = 0;
		for(int j = 1; j < this.taille; j++) {
			current = this.distances[j][i];
			if(current < min_col) {
				min_col = current;
			}
		}
		return min_col;
	}
	
	public int recherche_min_ligne(int j) {
		int min_col = this.distances[j][0];
		int current = 0;
		for(int i = 1; i < this.taille; i++) {
			current = this.distances[j][i];
			if(current < min_col) {
				min_col = current;
			}
		}
		return min_col;
	}
	
	public int reduction() {
		for(int i = 0;i < this.taille; i++) {
			int a = this.recherche_max_colonne(i);
			int b = this.recherche_min_colonne(i);
			System.out.println("Colonne :" + i + " | Max : " + a +" / Min : " + b);
		}
		for(int i = 0;i < this.taille; i++) {
			int a = this.recherche_max_ligne(i);
			int b = this.recherche_min_ligne(i);
			System.out.println("Ligne :" + i + " | Max : " + a +" / Min : " + b);
		}
		return 0;
	}
	
	
}
