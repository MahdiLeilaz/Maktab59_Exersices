
public class Container {
	private int[] inputArray;
	private int[] sortedInputArray;
	private int[] sortedArrayIndices;
	private int[] reverseSortedArrayIndices;
	private int lengthOfArray = 0;
	private int counter = 0;

	public Container() {
	}

	public int[] getInputArray() {
		return this.inputArray;
	}

	public int getLengthOfArray() {
		return this.lengthOfArray;
	}

	public void setLengthOfArray(int lengthOfArray) {
		if (this.lengthOfArray == 0) {
			this.lengthOfArray = lengthOfArray;
			this.inputArray = new int[lengthOfArray];
			this.sortedInputArray = new int[lengthOfArray];
			this.sortedArrayIndices = new int[lengthOfArray];
			this.reverseSortedArrayIndices = new int[lengthOfArray];
		} else
			System.out.println("The length of Array is already determined!");
	}

	public void ArrayFilling(int input) {
		this.inputArray[counter] = input;
		this.sortedInputArray[counter] = input;
		this.sortedArrayIndices[counter] = counter;
		this.reverseSortedArrayIndices[counter] = counter;
		counter++;
		if (counter == lengthOfArray) {
			System.out.println("  :: The Array Is Seted! ::");
			this.setInitialSettings();
		}
	}

	private void Sort() {
		boolean isContinue = true;
		int i = 0;
		while (i <= lengthOfArray / 2) {
			while (isContinue) {
				if (sortedInputArray[lengthOfArray - 1 - i] < sortedInputArray[i])
					IndexChanging(lengthOfArray - 1 - i, i, this.sortedInputArray);
				else
					isContinue = false;
			}

			isContinue = true;
			int temp = -1;

			int j = 1;
			if (i != 0)
				while (sortedInputArray[lengthOfArray - 1 - i] >= sortedInputArray[lengthOfArray - 1 - i + j]) {
					j++;
					temp = j - 1;
					if (lengthOfArray - 1 - i + j > lengthOfArray - 1)
						break;
				}
			if (temp != -1)
				IndexChanging(lengthOfArray - 1 - i, lengthOfArray - 1 - i + temp, this.sortedInputArray);
			temp = -1;
			j = 1;
			if (i != 0)
				while ((sortedInputArray[i] <= sortedInputArray[i - j])) {
					j++;
					temp = j - 1;
					if (i - j == -1)
						break;
				}
			if (temp != -1)
				IndexChanging(i, i - temp, this.sortedInputArray);
			temp = -1;
			i++;
		}
	}

	private void IndexChanging(int initialIndex, int destinationIndex, int[] inputArray) {
		if (initialIndex == destinationIndex) {
			System.out.println("InitialIndex Can Not Be Equal DestinationIndex");
			return;
		}

		int[] relatedArray;
		if (inputArray == this.inputArray)
			relatedArray = reverseSortedArrayIndices;
		else if (inputArray == this.sortedInputArray)
			relatedArray = this.sortedArrayIndices;
		else
			relatedArray = inputArray;

		int swap = inputArray[initialIndex];
		int relatedSwap = relatedArray[initialIndex];

		int length = initialIndex - destinationIndex;
		if (length < 0)
			length = -length;
		length++;

		if (initialIndex > destinationIndex) {
			for (int i = 0; i < length - 1; i++) {
				inputArray[initialIndex - i] = inputArray[initialIndex - i - 1];
				relatedArray[initialIndex - i] = relatedArray[initialIndex - i - 1];
			}
			inputArray[destinationIndex] = swap;
			relatedArray[destinationIndex] = relatedSwap;
			return;
		}

		for (int i = 0; i < length - 1; i++) {
			inputArray[initialIndex + i] = inputArray[initialIndex + i + 1];
			relatedArray[initialIndex + i] = relatedArray[initialIndex + i + 1];
		}
		inputArray[destinationIndex] = swap;
		relatedArray[destinationIndex] = relatedSwap;

		return;
	}

	private void reverseSortedIndexArrayBuilder() {
		for (int i = 0; i < lengthOfArray; i++) {
			reverseSortedArrayIndices[sortedArrayIndices[i]] = i;
		}
	}

	private void setInitialSettings() {
		this.Sort();
		this.reverseSortedIndexArrayBuilder();
	}

	public void printing() {
		System.out.printf("Array = {");
		for (int i = 0; i < lengthOfArray - 1; i++) {
			System.out.printf("%d, ", inputArray[i]);
		}
		System.out.printf("%d}\n", inputArray[lengthOfArray - 1]);

		System.out.printf("The length of the Array is %d\n", lengthOfArray);
	}

	public int[] SortToMax() {
		return this.sortedInputArray;
	}

	public int[] SortToMin() {
		int[] sortedToMinArray = new int[lengthOfArray];
		for (int i = 0; i < lengthOfArray; i++) {
			sortedToMinArray[i] = sortedInputArray[lengthOfArray - 1 - i];
		}
		return sortedToMinArray;
	}

	public void AddElementWithIndex(int input, int index) {
		lengthOfArray++;
		int[] inputArray = new int[lengthOfArray];
		int[] sortedArray = new int[lengthOfArray];
		int[] sortedIndixArray = new int[lengthOfArray];
		int[] reversedIndexArray = new int[lengthOfArray];

		int sortedIndex = SortedArrayIndexFindig(input);
		int countArray = 0;
		int countSorted = 0;
		int countSortedIndex = 0;

		for (int i = 0; i < this.lengthOfArray - 1; i++) {

			if (countArray == index) {
				inputArray[countArray] = input;
				countArray++;
			}
			if (countSorted == sortedIndex) {
				sortedArray[countSorted] = input;
				sortedIndixArray[countSortedIndex] = index;
				reversedIndexArray[sortedIndixArray[countSortedIndex]] = countSortedIndex;
				countSorted++;
				countSortedIndex++;
			}

			inputArray[countArray] = this.inputArray[i];
			countArray++;

			sortedArray[countSorted] = this.sortedInputArray[i];
			countSorted++;

			if (this.sortedArrayIndices[i] < index) {
				sortedIndixArray[countSortedIndex] = this.sortedArrayIndices[i];
				reversedIndexArray[sortedIndixArray[countSortedIndex]] = countSortedIndex;
				countSortedIndex++;
			} else {
				sortedIndixArray[countSortedIndex] = this.sortedArrayIndices[i] + 1;
				reversedIndexArray[sortedIndixArray[countSortedIndex]] = countSortedIndex;
				countSortedIndex++;
			}
		}

		if (index == lengthOfArray - 1) {
			inputArray[lengthOfArray - 1] = input;
		}

		if (sortedIndex == lengthOfArray - 1) {
			sortedArray[lengthOfArray - 1] = input;
		}

		if (sortedIndex == lengthOfArray - 1) {
			sortedIndixArray[lengthOfArray - 1] = index;
			reversedIndexArray[sortedIndixArray[countSortedIndex]] = countSortedIndex;
		}

		this.inputArray = inputArray;
		this.sortedInputArray = sortedArray;
		this.sortedArrayIndices = sortedIndixArray;
		this.reverseSortedArrayIndices = reversedIndexArray;
	}

	private int SortedArrayIndexFindig(int input) {
		int upLimit = lengthOfArray - 2;
		int downLimit = 0;
		int length = upLimit - downLimit + 1;
		int range;
		int chosenIndex = -1;
		if (input > sortedInputArray[upLimit])
			chosenIndex = upLimit + 1;
		else if (input <= sortedInputArray[downLimit])
			chosenIndex = downLimit;
		else {
			while (length > 3) {
				range = RangeFinding(downLimit, upLimit, input);
				if (range == -1) {
					break;
				} else if (range == 0) {
					upLimit = (upLimit - length / 2) + 1;
				} else {
					downLimit = (downLimit + length / 2) - 1;
				}
				length = upLimit - downLimit + 1;
			}
		}
		length = upLimit - downLimit + 1;
		if (length == 2)
			chosenIndex = downLimit + 1;
		else if (length == 3) {
			if (input > sortedInputArray[downLimit + 1])
				chosenIndex = downLimit + 2;
			else
				chosenIndex = downLimit + 1;
		}
		return chosenIndex;
	}

	private int RangeFinding(int startIndex, int endIndex, int searchValue) {

		int doNotexist = -1;
		int firstHalf = 0;
		int secondHalf = 1;
		int length = endIndex - startIndex + 1;

		if (sortedInputArray[startIndex] > searchValue || sortedInputArray[endIndex] < searchValue)
			return doNotexist;

		if (sortedInputArray[startIndex + length / 2 - 1] < searchValue)
			return secondHalf;

		return firstHalf;
	}

	public void AddNewElement(int input) {
		AddElementWithIndex(input, lengthOfArray);
	}

	public void DeleteElementByIndex(int index) {
		lengthOfArray--;
		int[] inputArray = new int[lengthOfArray];
		int[] sortedArray = new int[lengthOfArray];
		int[] sortedIndixArray = new int[lengthOfArray];
		int[] reversedIndexArray = new int[lengthOfArray];

		int sortedIndex = this.reverseSortedArrayIndices[index];
		int countArray = 0;
		int countSorted = 0;
		int countSortedIndex = 0;

		for (int i = 0; i < lengthOfArray; i++) {
			if (countArray == index) {
				countArray++;
			}
			if (countSorted == sortedIndex) {
				countSorted++;
				countSortedIndex++;
			}

			inputArray[i] = this.inputArray[countArray];
			countArray++;
			sortedArray[i] = this.sortedInputArray[countSorted];
			countSorted++;

			if (this.sortedArrayIndices[countSortedIndex] < index) {
				sortedIndixArray[i] = this.sortedArrayIndices[countSortedIndex];
				reversedIndexArray[sortedIndixArray[i]] = i;
				countSortedIndex++;
			} else {
				sortedIndixArray[i] = this.sortedArrayIndices[countSortedIndex] - 1;
				reversedIndexArray[sortedIndixArray[i]] = i;
				countSortedIndex++;
			}

		}

		this.inputArray = inputArray;
		this.sortedInputArray = sortedArray;
		this.sortedArrayIndices = sortedIndixArray;
		this.reverseSortedArrayIndices = reversedIndexArray;
	}

	public void DeleteElementByValue(int value) {
		int[] indieces = SearchByValue(value);
		if (indieces == null) {
			return;
		}
		for (int i = 0; i < indieces.length; i++)
			DeleteElementByIndex(indieces[i]);
	}

	public void DeletLastElement() {
		DeleteElementByIndex(lengthOfArray - 1);
	}

	public int[] SearchByValue(int input) {
		int sortedIndex = SortedArrayIndexFindig(input);
		// int index = this.sortedArrayIndices[sortedIndex];
		int count = ValueCounter(sortedIndex, input);
		int[] indieces = new int[count];
		for (int i = 0; i < count; i++)
			indieces[i] = this.sortedArrayIndices[sortedIndex + i];

		if (count != 0)
			return indieces;
		else
			System.out.println("  :: The Input Number Is Not In Our Array ::");
		return null;
	}

	private int ValueCounter(int sortedIndex, int value) {
		int counter = 0;
		while (sortedInputArray[sortedIndex + counter] == value) {
			counter++;
			if (sortedIndex + counter > this.lengthOfArray - 1)
				break;
		}
		return counter;
	}
}
