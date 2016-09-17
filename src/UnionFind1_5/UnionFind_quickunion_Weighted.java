package UnionFind1_5;


public class UnionFind_quickunion_Weighted extends UnionFindAbstract {

	private int[] sz;

	UnionFind_quickunion_Weighted() {
		super();
	}

	UnionFind_quickunion_Weighted(int N) {
		super(N);
		//record the size of tree
		//为什么选择比较树的大小而不比较树的深度是因为，a树挂在b树上，a树的所有结点深度+1,如果a树大，这种性能损耗就会很大
		sz = new int[N]; 
		for (int j = 0; j < N; j++) {
			sz[j] = 1;
		}
	}

	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (qRoot != pRoot && sz[pRoot] >= sz[qRoot]) {
			id[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
			count--;
		} else if (qRoot != pRoot && sz[pRoot] < sz[qRoot]) {
			id[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
			count--;
		}
	}

	/* (non-Javadoc)
	 * @see UnionFind1_5.UnionFindAbstract#find(int)
	 * 
	 * 压缩加权算法
	 */
	@Override
	public int find(int p) {
		int temp = p;
		while (p != id[p]) {
			p = id[p];
		}
		while (temp != p){
			int next = id[temp];
			id[temp] = p;
			temp = next;
		}
		return p;
	}
}
