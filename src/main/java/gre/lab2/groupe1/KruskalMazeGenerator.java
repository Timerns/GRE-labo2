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
    // Affichage : après union, marquer les deux extrémités de l'arête traitée comme PROCESSED puis supprimer le mur
    List<Edge> edges = builder.topology().edges();
    Collections.shuffle(edges);
    UnionFind uf = new UnionFind(builder.topology().nbVertices());
    for (Edge e: edges) {
      if(uf.union(e.u(),e.v())) {
        builder.removeWall(e.u(), e.v());
        builder.progressions().setLabel(e.u(), Progression.PROCESSED);
        builder.progressions().setLabel(e.v(), Progression.PROCESSED);
      }
    }

  }
}

// TODO
//  - Renommage du package ;
//  - Implémentation des classes KruskalMazeGenerator, UnionFind et BfsSolver ;
//  - Documentation abondante des trois classes comprenant :
//    - la javadoc, avec auteurs et description des implémentations ;
//    - des commentaires sur les différentes parties de vos algorithmes.
