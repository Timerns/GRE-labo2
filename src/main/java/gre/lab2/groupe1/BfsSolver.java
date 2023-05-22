package gre.lab2.groupe1;

import gre.lab2.graph.Graph;
import gre.lab2.graph.VertexLabelling;
import gre.lab2.gui.MazeSolver;

import java.util.*;

/**
 * Classe qui résout un labyrinthe donné en effectuant une exploration en largeur et
 * retournant la suite des sommets à visiter pour rejoindre la destination à partir
 * de la source
 *
 * @author Grégory Rey-Mermet
 * @author Tim Ernst
 */
public final class BfsSolver implements MazeSolver {
  @Override
  public List<Integer> solve(Graph graph, int source, int destination, VertexLabelling<Integer> treatments) {
    //Initialise un tableau de prédécesseur pour tous les somments du graphe
    int[] prev = new int[graph.nbVertices()];

    //Liste des sommets à traiter
    Queue<Integer> queue = new LinkedList<>();

    //Le sommet en cours de traitement
    int i = source;

    //Permet de savoir si la destination a été trouvée afin d'arrêter la recherche
    boolean notFound = true;

    //Effectue la recherche de la destination
    while (notFound) {
      //Indique que le sommet est en cours de traitement
      treatments.setLabel(i, 1);

      //Pour tous les voisins du sommets i
      for (int n : graph.neighbors(i)) {
        //Si le sommet est déjà traité on ne le traite pas une seconde fois
        if (treatments.getLabel(n) == 1) continue;

        //Ajoute le sommet à la liste et défini son prédécesseur
        queue.add(n);
        prev[n] = i;

        //Si on a terminé on s'arrête car il n'y a pas besoin d'aller plus loin
        if(n == destination){
          notFound = false;
        }
      }

      //Nouveau sommet à traiter
      i = queue.remove();
    }

    //Récupère le chemin de la source à la destination pour le retourner
    LinkedList<Integer> res = new LinkedList<>();
    res.add(destination);

    //Ajout le prédécesseur de nos sommets à la liste jusqu'à ce qu'on soit remonté à la source
    while (res.getFirst() != source) {
      res.addFirst(prev[res.getFirst()]);
    }

    return res;
  }
}
