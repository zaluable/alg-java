package StackAndQueue1_3.Exercises;

import java.util.Stack;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Reads in a text file and checks to see if the parentheses are balanced.No
 * need to care the order [()]{}{[()()]()} return true [(]) return false
 * Character 大括号-brace 中括号-bracket 小括号-Parentheses
 * 
 * @author xiao
 *
 */
public class ParenthesesCheck_byBook_1_3_4 {
	private final char LEFT_BRACE = '{';
	private final char LEFT_BRACKET = '[';
	private final char LEFT_PAREN = '(';
	private final char RIGHT_BRACE = '}';
	private final char RIGHT_BRACKET = ']';
	private final char RIGHT_PAREN = ')';
	private ParenthesesCheck_byBook_1_3_4 check;

	public boolean matchParen(String target) {
		Stack<Character> stack = new Stack<Character>();
		char targetChar;
		for (int i = 0; i < target.length(); i++) {
			targetChar = target.charAt(i);
			if (targetChar == LEFT_BRACE)
				stack.push(targetChar);
			else if (targetChar == LEFT_BRACKET)
				stack.push(targetChar);
			else if (targetChar == LEFT_PAREN)
				stack.push(targetChar);

			else if (targetChar == RIGHT_BRACE) {
				if (stack.isEmpty())
					return false;
				else if (stack.pop() != LEFT_BRACE)
					return false;
			} else if (targetChar == RIGHT_BRACKET) {
				if (stack.isEmpty())
					return false;
				else if (stack.pop() != LEFT_BRACKET)
					return false;
			} else if (targetChar == RIGHT_PAREN) {
				if (stack.isEmpty())
					return false;
				else if (stack.pop() != LEFT_PAREN)
					return false;
			}
		}
		return stack.empty();
	}

	@DataProvider(name = "ObjProvider")
	public Object[][] createObj() {
		String str1 = "[()]{}{[()()]()}";
		String str2 = "[(])";
		return new Object[][] { { str1, true }, { str2, false }, };
	}

	@BeforeTest(groups = "Exercises")
	public void init() {
		check = new ParenthesesCheck_byBook_1_3_4();
	}

	@Test(dataProvider = "ObjProvider", groups = "Exercises")
	public void testParenthesesCheck(String s, boolean expected) {
		Assert.assertEquals(check.matchParen(s), expected);
	}
}
