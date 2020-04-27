package allibe_TPArbreAVL;
import java.util.*;
import java.io.*;

public class Matrice{
	
	private int taille;
	private int[][] distances;
	
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
	
	public void affiche() {
		System.out.println("Nombre de villes:" + this.taille);
		for(int i = 0; i < this.taille; i++) {
			for(int j = 0; j < this.taille; j++) {
				System.out.print(this.distances[i][j] + " ");
			}
			System.out.println();
		}
		return;
	}
}
