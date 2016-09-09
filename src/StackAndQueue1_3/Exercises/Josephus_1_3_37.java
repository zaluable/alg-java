/**
 * 2016 下午3:38:18 
 * zhangxiao3
 * 编写一个Q的用例，接收人数N和数字M，叫到M的人将要被处决
 */
package StackAndQueue1_3.Exercises;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Josephus_1_3_37 {

	private int[] people;
	private int N;
	private int M;
	Josephus_1_3_37(int N,int M){
		this.N = N;
		this.M = M;
		people = new int[N];
		for (int i = 0; i < N; i++){
			people[i] = i;
		}
	}
	Josephus_1_3_37(){
		
	}
	public int dequeue(int index){
		int temp = people[index];
		for (int i = index; i < N-1; i++){
			people[i] = people[i+1];
		}
		N--;
		return temp;
	}
	
	public void calling(){
		int i = 0;
		while (N > 1){			
			while ((i+1) % M != 0){
				i++;
				System.out.println("i:"+i);
				
			}
			System.out.println("i+++++++:"+i+" "+N);
			int j = i % N;
			
			System.out.println("dequeue:"+dequeue(j)+" "+"i:"+i);
			i++;
		}
	}
//	@DataProvider(name = "Josephus")
//	public Object[][] create(){
//		return new Object[][]{
//			{7,2},
//		};
//	}
//	@Test(dataProvider = "Josephus")
	@Test
	public void testJosephus(){
		Josephus_1_3_37 Josephus = new Josephus_1_3_37(7,2);
		Josephus.calling();
	}
}
