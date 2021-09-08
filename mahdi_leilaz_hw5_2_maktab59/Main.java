
public class Main {

	public static void main(String[] args) {

		///////////////////////////////////////
		printingHeader("Setting Container Up!");
		Container container = new Container();
		container.setLengthOfArray(6);
		container.ArrayFilling(3);
		container.ArrayFilling(1);
		container.ArrayFilling(5);
		container.ArrayFilling(4);
		container.ArrayFilling(2);
		container.ArrayFilling(2);
		container.printing();

		///////////////////////////////////////
		printingHeader("Sorting The Elements!");
		System.out.println("  :: Soting From Min To Max ::");
		printingArray(container.SortToMax());
		System.out.println("\n");
		System.out.println("  :: Soting From Max To Min ::");
		printingArray(container.SortToMin());
		System.out.println();

		///////////////////////////////////////
		printingHeader("Adding New Element!");
		System.out.println("  :: AddElementWithIndex(value: 10,index: 3) ::");
		container.AddElementWithIndex(10, 3);
		container.printing();
		System.out.println();

		///////////////////////////////////////
		System.out.println("  :: See New Sort Array ::");
		System.out.println();
		System.out.println("In This Program Input Array Sorted Just One Time!");
		System.out.println("And Then We Work With Sorted Array; (see Container Class)");
		printingArray(container.SortToMax());
		System.out.println("\n");
		System.out.println("  :: Adding without Index: AddNewElement(23) ::");
		container.AddNewElement(23);
		container.printing();
		System.out.println();

		///////////////////////////////////////
		printingHeader("Deleting An Element");
		System.out.println("  :: Deleting by Index: DeleteElementByIndex(7) ::");
		container.DeleteElementByIndex(7);
		container.printing();
		System.out.println(
				"\n  :: Deleting by value: DeleteElementByValue(2) ::\n(We have two times 2 and we want delet them)");
		container.DeleteElementByValue(2);
		container.printing();
		System.out.println("\n  :: See New Sort Array ::");
		printingArray(container.SortToMax());
		System.out.println("\n");
		System.out.println("  :: I added two timed 2 at the end of array again ::");
		container.AddNewElement(2);
		container.AddNewElement(2);
		System.out.println();

		///////////////////////////////////////
		printingHeader("Searching An Element");
		System.out.println("  :: It return An Array That contains Indices Of All searched Value in our Array ::");
		System.out.println("  :: We are going to search 2 ::");
		int[] searchResult = container.SearchByValue(2);

		if (searchResult != null) {
			System.out.printf("\nWe have %d times %d in our Array. The "
					+ ((searchResult.length == 1) ? "index is " : "indices are "), searchResult.length, 2);
			for (int i = 0; i < searchResult.length; i++) {
				System.out.print(searchResult[i] + "  ");
				if (searchResult.length - 1 - i != 0)
					System.out.print("and  ");
			}
			System.out.println();
		}
		///////////////////////////////////////
		printingHeader("I Hope You Enjoy It");

	}

	public static void printingHeader(String input) {
		int length = 90;
		int stringLength = input.length();
		int lengthOfEquals = (length - stringLength - 4) / 2;
		System.out.println();
		System.out.print(" ");
		for (int i = 0; i < lengthOfEquals; i++)
			System.out.print("=");
		System.out.print(" ");
		System.out.print(input);
		System.out.print(" ");
		for (int i = 0; i < lengthOfEquals; i++)
			System.out.print("=");
		System.out.println("\n");
	}

	public static void printingArray(int[] input) {
		System.out.print("{");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			if (i != input.length - 1)
				System.out.print(", ");
		}
		System.out.print("}");
	}

}
