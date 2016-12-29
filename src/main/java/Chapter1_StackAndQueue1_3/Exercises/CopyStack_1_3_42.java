package Chapter1_StackAndQueue1_3.Exercises;

import Chapter1_StackAndQueue1_3.StackSimuWithNode;

public class CopyStack_1_3_42<Item> extends StackSimuWithNode<Item> {
	CopyStack_1_3_42() {
		super();
	}

	<T extends StackSimuWithNode<Item>> CopyStack_1_3_42(T t) {
		CopyStack_1_3_42<Item> temp = new CopyStack_1_3_42<Item>();
		while (!t.isEmpty()) {
			temp.push(t.pop());
		}
		while (!temp.isEmpty()) {
			Item item = temp.pop();
			t.push(item);
			this.push(item);
		}
	}

}
