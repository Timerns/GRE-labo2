package gre.lab2.groupe1;

/**
 * Classe qui permet de réaliser des opérations sur un arbre avec une opérations find
 * permettant d'optimiser un arbre et de trouver sa racine ainsi qu'une opération union
 * permettant de réalsier l'union entre 2 arbres
 *
 * @author Grégory Rey-Mermet
 * @author Tim Ernst
 */
final class UnionFind {
  private final int[] sommets;
  private final int[] rangs;

  /**
   * Constructeur de la classe UnionFind
   * @param size  Taille de l'arbre
   */
  public UnionFind(int size) {
    sommets = new int[size];
    rangs = new int[size];

    for (int i = 0; i < size; i++) {
      sommets[i] = i;
    }
  }

  /**
   * Fonction find en path splitting
   * @param v Sommet recherché
   * @return  Racine du sommet
   */
  public int find(int v) {
    int prev = -1;

    //Tant que le sommet n'est pas égale à la racine cela veut dire que l'on a pas
    //encore itéré jusqu'à la racine donc on continue
    while (v != sommets[v]) {
      if (prev != -1) {
        //On met à jour le parent du sommet en lui attribuant son grand parent
        sommets[prev] = sommets[v];
      }

      //Met à jour le précédent pour la prochaine itération
      prev = v;
      //Trouve le parent de v qui sera notre prochain sommet mis à jour
      v = sommets[v];
    }

    return v;
  }

  /**
   * Réalise l'union entre 2 arbres en prenant en paramètre les racines de ces 2 arbres
   *
   * Indication : retourne false si les deux sommets font partie de la même composante connexe
   * @param u Sommet de l'arbre
   * @param v Sommet de l'arbre
   * @return  True : L'union a été effectuée / False : L'union n'a pas été effectuée
   */
  public boolean union(int u, int v) {
    //On cherche les racines de nos 2 sommets
    int racineU = find(u);
    int racineV = find(v);

    //Si les 2 sommets font partie de la même composante connexe
    if (racineU == racineV) return false;

    //Réalise l'union entre les 2 arbres, on garde comme racine celui ayant le rang le
    //plus élevé ou en cas d'égalité on conserve la racine u
    if (rangs[racineU] > rangs[racineV]) {
      sommets[racineV] = racineU;
    } else if (rangs[racineU] < rangs[racineV]) {
      sommets[racineU] = racineV;
    } else {
      sommets[racineV] = racineU;
      rangs[racineU]++;
    }

    return true;
  }
}
