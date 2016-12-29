/**
 *  2016 8:00:40 AM
 *  xiao
 *  删除第K个元素，实现一个类并支持如下API
 *  泛型一般队列的API
 *          GeneralizedQueue() 创建一条空队列
 *  boolean isEmpty()
 *  void    insert(Item item)  添加一个元素
 *  Item    delete()   		   删除并返回最早插入的第K个元素
 *  用数组实现该数据类型，然后用链表实现该数据类型
 */
package Chapter1_StackAndQueue1_3.Exercises;

import org.testng.annotations.Test;

public class GeneralizedQueueWithArr_1_3_38<Item> {
	private Item[] arr;
	private int addIndex;

	@SuppressWarnings("unchecked")
	GeneralizedQueueWithArr_1_3_38() {
		arr = (Item[]) new Object[10];
		addIndex = 0;
	}

	public boolean isEmpty() {
		return addIndex == 0;
	}

	public void insert(Item item) {
		arr[addIndex++] = item;
	}

	public Item delete(int k) {
		if (isEmpty() || k > addIndex)
			return null;
		Item temp = arr[k - 1];
		for (int i = k - 1; i < addIndex - 2; i++) {
			arr[k - 1] = arr[k];
		}
		addIndex--;
		return temp;
	}

	@Test
	public void testGeneralizedQueueWithArr() {
		GeneralizedQueueWithArr_1_3_38<String> G = new GeneralizedQueueWithArr_1_3_38<String>();
		String[] test = { "a", "b", "c", "d", "e" };
		for (String str : test) {
			G.insert(str);
		}
		System.out.println(G.delete(2));
	}
}
