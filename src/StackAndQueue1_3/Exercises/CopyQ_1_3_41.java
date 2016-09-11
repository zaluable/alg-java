/**
 *  2016 Sep 11, 2016 1:52:04 PM
 *  xiao
 *  编写一个新的构造函数，使以下代码 Queue<Item> r = new Queue<Item>(q);
 *  得到的r指向队列q的另一个新的独立的副本。可以对q或者r进行任意入列或者出列操作，但两者不会互相影响
 *  提示：从q中取出所有元素再将他们插入q和r
 */
package StackAndQueue1_3.Exercises;

import org.testng.annotations.Test;

import StackAndQueue1_3.QueueSimuWithNode;

/**
 * @author xiao
 * @param <Item>
 *
 */
public class CopyQ_1_3_41<Item> extends QueueSimuWithNode<Item>{
	CopyQ_1_3_41(){
		super();
	}
	<T extends QueueSimuWithNode<Item>> CopyQ_1_3_41(T q){
		CopyQ_1_3_41<Item> temp = new CopyQ_1_3_41<Item>();
		while (!q.isEmpty()){
			temp.enqueue(q.dequeue());
		}
		while (!temp.isEmpty()){
			Item item = temp.dequeue();
			q.enqueue(item);
			this.enqueue(item);
		}
	}
	@Test
	public void testCopyQ(){
		CopyQ_1_3_41<String> A = new CopyQ_1_3_41<String>();
		String[] str = {"a","b","c"};
		for (String s : str){
			A.enqueue(s);
		}
		CopyQ_1_3_41<String> copyA = new CopyQ_1_3_41<String>(A);
		System.out.println(copyA.toString());
	}
}
