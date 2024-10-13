package TD3;

public class Dictionnaire {
	public int nbMots;
	public MotDico[] dico;
	public String nom;
	public int Nmax=25;
	public Dictionnaire(String nom) {
		this.nbMots=0;
		this.dico=new MotDico[Nmax];
		this.nom=nom;
	}
	public void ajouterMot(MotDico m) {
		if(nbMots<Nmax) {
			dico[nbMots]=m;
			nbMots++;
		}else
			System.out.println("le dict est plein");
	}
	public void supprimerMot(String ch) {
		int index=chercherMot(ch);
		if(index!=-1) {
			for(int i=0;i<nbMots-1;i++) {
				dico[i]=dico[i+1];
			}
			dico[nbMots-1]=null;
			nbMots--;
			System.out.println("Mot "+ ch +" est supprimer ");
		}else {
			System.out.println("votre mot n'est pas dans le tab");
		}
	}
	public int chercherMot(String ch) {
		for(int i=0;i<nbMots;i++) {
			if(dico[i].getMot().equals(ch)) {
				return i;
			}
		}
		return -1;
	}
	public void listerDico() {
		System.out.println("Liste des mots dans le dict " + nom + " :");
        for (int i = 0; i < nbMots; i++) {
            System.out.println("Mot : " + dico[i].getMot() + " - Définition : " + dico[i].getDefinition());
        }
    }
	public int ndSynonymes(MotDico m) {
		int n=0;
		for(int i=0;i<nbMots;i++) {
			if(dico[i]!=null && m.synonyme(dico[i])) {
				n++;
			}
		}
		return n;
	}
	public static void main(String args[]) {
        Dictionnaire larousse = new Dictionnaire("Larousse");
        MotDico mot1 = new MotDico("rapide", "Qui se déplace avec vitesse");
        MotDico mot2 = new MotDico("vite", "De manière rapide");
        MotDico mot3 = new MotDico("lent", "Qui se déplace avec lenteur");
        larousse.ajouterMot(mot1);
        larousse.ajouterMot(mot2);
        larousse.ajouterMot(mot3);
        System.out.println("Contenu du dict :");
        larousse.listerDico();
        System.out.println("\nRecherche du mot rapideur ");
        int motN = larousse.chercherMot("rapideur");
        if (motN== -1) {
            System.out.println("Le mot rapideur n'existe pas");
        }
        System.out.println("\nRecherche du mot rapide :");
        int motE = larousse.chercherMot("rapide");
        if (motE != -1) {
            System.out.println("Mot trouver: " + larousse.dico[motE].getMot());
            System.out.println("Definition : " + larousse.dico[motE].getDefinition());
        }
        System.out.println("\nNombre de synonymes du mot rapide :");
        int n1 = larousse.ndSynonymes(mot1);
        System.out.println("Le mot rapide a " + n1 + " synonyme(s)");
        System.out.println("\nSuppression du mot rapide");
        larousse.supprimerMot("rapide");
        System.out.println("\n le dict après suppression :");
        larousse.listerDico();
	}
}
