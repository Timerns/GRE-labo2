package gre.lab2.groupe1;

import gre.lab2.graph.Edge;
import gre.lab2.gui.MazeBuilder;
import gre.lab2.gui.MazeGenerator;
import gre.lab2.gui.Progression;

import java.util.Collections;
import java.util.List;

/**
 * Classe qui génère un labyrinthe aléatoire à l'aide de l'algorithme de Kruskal
 *
 * @author Grégory Rey-Mermet
 * @author Tim Ernst
 */
public final class KruskalMazeGenerator implements MazeGenerator {
  @Override
  public void generate(MazeBuilder builder, int from) {
    //Affichage : après union, marquer les deux extrémités de l'arête traitée comme PROCESSED puis supprimer le mur
    List<Edge> edges = builder.topology().edges();
    //On veut s'assurer que les arrêtes soient prises aléatoirement pour la génération du labyrinthe
    Collections.shuffle(edges);
    UnionFind uf = new UnionFind(builder.topology().nbVertices());

    for (Edge e: edges) {
      //Si on peut réaliser l'union on enlève le mur entre les 2 sommets
      if (uf.union(e.u(),e.v())) {
        builder.removeWall(e.u(), e.v());
        builder.progressions().setLabel(e.u(), Progression.PROCESSED);
        builder.progressions().setLabel(e.v(), Progression.PROCESSED);
      }
    }
  }
}
