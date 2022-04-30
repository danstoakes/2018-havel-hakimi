import java.util.Scanner;
import java.util.regex.*;
import java.util.Arrays;

public class Havel_Hakimi {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.print("Degree sequence (max. 10): ");
		String degreeSequenceEntry = userInput.nextLine();
		int[] degreeSequence = convertToArray(degreeSequenceEntry);

		degreeSequence = sortArray(degreeSequence);

		System.out.println(checkPossibility(degreeSequence));

		for (int element : degreeSequence) {
			System.out.println(element);
		}
	}

	public static int[] convertToArray(String degreeSequence) {

		int whileCounter = 0;
		Pattern regExpression = Pattern.compile("-?\\d+");
		Matcher expressionMatcher = regExpression.matcher(degreeSequence);
		int[] degreeArrayTemp = new int[50];

		while (expressionMatcher.find()) {
			degreeArrayTemp[whileCounter] = Integer.parseInt(expressionMatcher.group());
			whileCounter++;
		}

		int[] degreeArray = new int[whileCounter];
		for (int i = 0; i < whileCounter; i++) {
			degreeArray[i] = degreeArrayTemp[i];
		}
		return degreeArray;
	}

	public static int[] sortArray(int[] existingArray) {
		Arrays.sort(existingArray);

		for (int i = 0; i < existingArray.length / 2; i++) {
			int temp = existingArray[i];
			existingArray[i] = existingArray[existingArray.length - i - 1];
			existingArray[existingArray.length - i - 1] = temp;
		}

		return existingArray;
	}

	public static int[] checkResultingArray(int[] existingArray, boolean finalShuffle) {
		int currentCount = existingArray.length;
		for (int element : existingArray) {
			if (element == 0) {
				currentCount--;
			}
		}
		if (finalShuffle) {
			existingArray = sortArray(existingArray);
		}
		int[] finalArray = new int[currentCount];
		for (int i = 0; i < currentCount; i++) {
			finalArray[i] = existingArray[i];
		}
		return finalArray;
	}

	public static String checkPossibility(int[] existingArray) {
		int sumOfValues = 0;
		boolean processCompleted = false;
		int n;
		int currentLength = existingArray.length;

		for(int i = 0; i < existingArray.length; i++) {
			sumOfValues += existingArray[i];
		}
		if (sumOfValues % 2 == 0) {			
			if (existingArray[0] <= existingArray.length - 1) {
				while (processCompleted == false) {
					n = existingArray[0];
					existingArray[0] = 0;
					if (n < currentLength && n != 0) {
						for (int i = 1; i <= n; i++) {
							existingArray[i]--;
						}
						existingArray = sortArray(existingArray);
						for (int element : existingArray) {
							if (element == 0) {
								currentLength--;
							}
						}
						checkResultingArray(existingArray, false);
					} else {
						processCompleted = true;
						return "Output produced: " + checkResultingArray(existingArray, true);
					}
				}
			} else {
				return "Not possible: Highest degree is greater than the number of vertices.";
			}
		} else {
			return "Not possible: Total sum of numbers is odd.";
		}
		return "Default";
	}
}