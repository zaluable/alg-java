package ArrayTest;

import org.testng.annotations.Test;

public class StackSimuWithSingleNode<Item> {
	//栈顶元素
	private Node first;
	//定义栈的大小
	private int N;
	//定义内部类——Node
	private class Node{
		Item item;
		Node next;
	}
	public int size(){
		return N;
	}
	public boolean isEmpty(){
		return first == null;
	}
	//入栈
	public void push(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	//删除栈顶元素，即出栈
	public Item pop(){
		Item oldItem = first.item;
		first = first.next;
		N--;
		return oldItem;
	}
	@Test
	public void testStackSimuWithSingleNode(){
		String[] strlist = {"to","be","or","not","to","-","be","-","-","that","-","-","-","is"};
		StackSimuWithSingleNode<String> stackSimuWithSingleNode = new StackSimuWithSingleNode<String>();
		for(int i = 0; i < strlist.length; i++){
			if (strlist[i].equals("-")){
				System.out.println(stackSimuWithSingleNode.pop());
			}else{
				stackSimuWithSingleNode.push(strlist[i]);
			}
			System.out.println("SIZE:"+stackSimuWithSingleNode.size());
		}
		
	}
	
}
