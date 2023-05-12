package gre.lab2.groupe1;

/**
 * Classe qui ...
 *
 * @author Grégory Rey-Mermet
 * @author Tim Ernst
 */
final class UnionFind {

  int[] sommets;
  int[] rangs;
  int size;
  public UnionFind(int size) {
    sommets = new int[size];
    rangs = new int[size];
    this.size = size;
    for (int i = 0; i < size; i++) {
      sommets[i] = i;
    }
  }
  //path splitting
  public int find(int v) {
    int prev = -1;
    while (v != sommets[v]) {
      if(prev != -1) {
        sommets[prev] = sommets[v];
      }
      prev = v;
      v = sommets[v];
    }
    return v;
  }

  public boolean union(int u, int v) {
    // Indication : retourne false si les deux sommets font partie de la même composante connexe
    int racineU = find(u);
    int racineV = find(v);
    if (racineU == racineV) return false;

    if(rangs[racineU] > rangs[racineV]){
      sommets[racineV] = racineU;
    } else if(rangs[racineU] < rangs[racineV]) {
      sommets[racineU] = racineV;
    } else {
      sommets[racineV] = racineU;
      rangs[racineU]++;
    }
    return true;
  }
}
