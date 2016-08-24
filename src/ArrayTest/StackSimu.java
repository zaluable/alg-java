package ArrayTest;

import java.util.Arrays;
import java.util.Iterator;

import org.testng.annotations.Test;





/**
 * @author zhangxiao3
 * 模拟栈的构成
 * 实现Iterable接口，实现Iteraor方法返回一个可以反向输出的迭代器
 */
public class StackSimu<Item> implements Iterable<Item>{
	//定义一个数组变量
	private Item[] stack;
	//定义一个指针一方面标示数组的下标，一方面在赋值后N++标示数组size
	private int N = 0 ;
	//初始化stack容量
	@SuppressWarnings("unchecked")
	public StackSimu(int cap){
		stack = (Item[])new Object[cap];
	}
	
	public StackSimu(){
	}
	
	public Boolean isEmpty(){
		return N == 0;
	}
	public int size(){
		return N;
	}
	//指针向前指一位
	public Item pop(){
		Item tempItem = stack[--N];
		//避免游离对象
		stack[N] = null;
		//如果有效元素的长度等于栈长度的1/4，栈长度减半
		if (N > 0 && N == stack.length/4){resize(stack.length/2);}
		return tempItem;
	}
	//将s赋值给当前指针位置，同时指针指向下一位
	public void push(Item item){
		//容量不够时数组长度加倍
		if (N == stack.length){resize(stack.length*2);}
		stack[N++] = item;
	}
	private Item[] resize(int max){
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[])new Object[max];
		for(int i = 0;i < N;i++){
			temp[i] = stack[i] ;
		}
		stack = temp;
		return stack;
	}
	//覆盖toString方法
	public String toString(){
		@SuppressWarnings("unchecked")
		Item[] c = (Item[])new Object[N];
		for(int j = 0; j < N;j++){
			c[j] = stack[j];
		}
		return Arrays.toString(c);
	}
	//实现Iterator方法返回一个逆向迭代器
	public Iterator<Item> iterator(){
		return new ReverseArray();
	}
	
	private class ReverseArray implements Iterator<Item>{
		private int i = N;
		public boolean hasNext() {
			if(i > 0){
			return true;
			}else return false;
		}
 
		public Item next() {
			return stack[--i];
		}

		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	@Test
	public void testStackSimu(){
//	public static void main(String[] args){
		String[] strlist = {"to","be","or","not","to","-","be","-","-","that","-","-","-","is"};
		StackSimu<String> stackSimu = new StackSimu<String>(5);
		for (int i = 0; i < strlist.length; i++){
			String str = strlist[i];
			if (str.equals("-")){
				stackSimu.pop();
			}else{
				stackSimu.push(str);
			}			
			System.out.println("Size:"+stackSimu.size());
		}
		Iterator<String> iter = stackSimu.iterator();
		while (iter.hasNext()){
			String s = iter.next();
			System.out.println(s);
		}
	}
}
