package ArrayTest;

public class ParenthesesCheck<Item> {
	private int size = 0;
	private Node first;
	private class Node{
		Item item;
		Node next;
	}
	public void push (Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		oldFirst = first.next;
		size++;
	}
	public Item pop (){
		Item itemTemp = first.item;
		first.next = first;
		size--;
		return itemTemp;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	//迭代循环元素，如果能匹配就将元素出栈，如果不能匹配就将元素入栈
	public void iterCheck(Item patten){
		if (checkPair(patten)){
			pop();
		}else{
			push(patten);
		}
	}
	//校验是否被迭代元素与栈顶元素配对
	public boolean checkPair(Item patten){
		if (patten.equals("}") && first.item.equals("{")){
			return true;
		}else if (patten.equals("]") && first.item.equals("[")){
			return true;
		}else if (patten.equals(")") && first.item.equals("(")){
			return true;
		}else {
			return false;
		}
	}
	public boolean checkParentheses(Item[] items){
		for (Item item : items){
			iterCheck(item);
		}
		if (isEmpty()){
			return true;
		}else{
			return false;
		}
	}
}
