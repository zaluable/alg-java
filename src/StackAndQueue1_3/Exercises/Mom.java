package StackAndQueue1_3.Exercises;

/*
 * 理解类的初始化过程
 * 创建子类line的实例前会对类进行初始化，步骤如下：
 * 1.初始化父类shap的静态成员和静态方法——无 pass
 * 2.初始化子类line的静态成员和静态方法——无 pass
 * 3.初始化父类的成员变量和构造函数——有构造函数，打印line15；
 *   因为当前要实例化的类为line，this.set()执行了子类的set函数，此时子类成员变量还未初始化，所以counter为0;
 *   打印line19
 * 4.初始化子类的成员变量——有成员变量，counter=9;
 * 5.执行子类的构造函数，打印line33,29,35
 * */
class Shap {
	void set() {
		System.out.println("Shap.set()");
	}

	Shap() {
		System.out.println("Shap().in=");
		set();
		System.out.println("Shap().out=");
	}
}

class Line extends Shap {
	int counter = 9;

	void set() {
		System.out.println("Line.set() counter=" + counter);
	}

	Line() {
		System.out.println("Line().in=" + counter);
		set();
		System.out.println("Line().out=" + counter);
	}
}

public class Mom {
	public static void main(String[] args) {
		Line t = new Line();
	}
}