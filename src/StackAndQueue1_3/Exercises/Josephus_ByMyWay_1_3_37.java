/**
 * 2016 下午3:38:18 
 * zhangxiao3
 * 编写一个Q的用例，接收人数N和数字M，叫到M的人将要被处决
 */
package StackAndQueue1_3.Exercises;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Josephus_ByMyWay_1_3_37 {
	
	private int[] people; //定义数组people用来存放参与者
	private int N;  //人数
	private int M;  //中奖编号
	//构造函数
	Josephus_ByMyWay_1_3_37(int N,int M){
		this.N = N;
		this.M = M;
		people = new int[N];
		for (int i = 0; i < N; i++){
			people[i] = i;
		}
	}
	//测试需要定义空构造函数
	Josephus_ByMyWay_1_3_37(){}
	
	
	/**
	 * @param index 为要被删除的索引
	 * @return 出队的数字
	 */
	public int dequeue(int index){
		int temp = people[index];
		//索引后的元素整体往前移一位，同时长度减1
		for (int i = index; i < N-1; i++){
			people[i] = people[i+1];
		}
		N--;
		return temp;
	}
	
	/**
	 *  迭代循环叫号
	 */
	public void calling(){
		int point = 0; //指针位于起始索引位置
		while (N > 0){ //队列不为空的情况下进入循环
			//因为point已经指向了第一个元素，说明已经叫到了第一号,所以要减1
			point = point + M - 1;
			System.out.println("dequeue:"+dequeue(point % N));
		}
	}
	@DataProvider(name = "Josephus")
	public Object[][] create(){
		return new Object[][]{
			{7,2},
		};
	}
	@Test(dataProvider = "Josephus",groups = "Exercises")
	public void testJosephus(int N,int M){
		Josephus_ByMyWay_1_3_37 Josephus = new Josephus_ByMyWay_1_3_37(N,M);
		Josephus.calling();
	}
}
