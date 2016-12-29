package Chapter1_UnionFind1_5;

import org.testng.annotations.Test;

public class UnionFind_quickfind extends UnionFindAbstract {

	UnionFind_quickfind() {
		super();
	}

	UnionFind_quickfind(int N) {
		super(N);
	}

	@Override
	public void union(int p, int q) {
		int pval = find(p);
		int qval = find(q);
		if (pval != qval) {
			for (int i = 0; i < id.length; i++) {
				if (id[i] == qval) {
					id[i] = pval;
				}
			}
			System.out.println("union:" + p + " " + q);
			count--;
		}
	}

	@Override
	public int find(int p) {
		return id[p];
	}

	@Test
	public void testUnionFind() {
		UnionFind_quickfind u = new UnionFind_quickfind(5);
		System.out.println("componnt count:" + u.count);
		u.union(1, 2);
		System.out.println("componnt count:" + u.count);
		u.union(2, 3);
		System.out.println("componnt count:" + u.count);
		u.union(1, 3);
		System.out.println("componnt count:" + u.count);
		u.union(0, 4);
		System.out.println("componnt count:" + u.count);
	}

}
