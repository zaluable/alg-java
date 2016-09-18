package UnionFind1_5;

import lombok.Getter;
import lombok.Setter;

public abstract class UnionFindAbstract {
	@Setter
	@Getter
	protected int count;

	protected int[] id;

	UnionFindAbstract() {
	}

	UnionFindAbstract(int N) {
		this.count = N;
		this.id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public abstract void union(int p, int q);

	public abstract int find(int p);

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

}
