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
    int[] prev = new int[graph.nbVertices()];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    int i = queue.remove();
    boolean notFound = true;
    while (notFound) {
      treatments.setLabel(i, 1);
      for (int n: graph.neighbors(i)) {
        if(treatments.getLabel(n) == 1) continue;
        queue.add((n));
        prev[n] = i;
        if(n == destination){
          notFound = false;
        }
      }
      i = queue.remove();
    }

    List<Integer> res = new LinkedList<>();
    res.add(destination);
    while (res.get(res.size() - 1) != source) {
      res.add(prev[res.get(res.size() - 1)]);
    }
    Collections.reverse(res);
    return res;
  }
}
