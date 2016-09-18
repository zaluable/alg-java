package UnionFind1_5;

public class UnionFind_quickunion extends UnionFindAbstract {

	UnionFind_quickunion() {
		super();
	}

	UnionFind_quickunion(int N) {
		super(N);
	}

	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot != qRoot) {
			id[pRoot] = qRoot;
			count--;
		}
	}

	@Override
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

}
