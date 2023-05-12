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
    return Collections.emptyList();
  }
}
