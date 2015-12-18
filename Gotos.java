import java.util.*;
import java.util.concurrent.*;

public class Gotos {
	private static void ruler(String label) {
		String rulerStr = "------ " + label + " ";
		while (rulerStr.length() < 78) {
			rulerStr += "-";
		}
		System.out.println(rulerStr);
	}

	// 2015-DEC-15: didn't know about Java supporting goto labels.
	private static void loop1() {
		ruler("loop1");

		outer:
		for (int i = 0; i < 4; i++) {
			System.out.print("i = " + i + "> ");
			inner:
			for (int j = 0; j < 4; j++) {
				if ((i * j) > 6)
					break outer;
				System.out.print("j = " + j + " ");
			}
			System.out.println("\n");
		}

		System.out.println("");
	}

	private static void loop2() {
		ruler("loop2");

		outer:
		for (int i = 0; i < 4; i++) {
			System.out.print("i = " + i + " >\t");
			inner:
			for (int j = 0; j < 2; j++) {
				if (j == 1) {
					continue outer;
				}
				System.out.print("j = " + j + "   ");
			}
			System.out.print("\n");
		}

		System.out.println("");
	}

	public static void main(String[] args) {
		System.out.println("Loops");

		loop1();
		loop2();
	}
}
