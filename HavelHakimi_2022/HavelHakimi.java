import java.util.Arrays;

public class HavelHakimi 
{
	private static int[] sortArray(int[] existingArray) 
	{
		Arrays.sort(existingArray);
		
		// reverse the array (largest to smallest)
		for (int i = 0; i < existingArray.length / 2; i++) {
			int temp = existingArray[i];
			existingArray[i] = existingArray[existingArray.length - i - 1];
			existingArray[existingArray.length - i - 1] = temp;
		}
		
		return existingArray;
	}
	
	public static int[] convertInputToArray (String input)
	{
		boolean invalidComponent = false;
		
		if (input.contains(",") && input.length() > 1 || input.length() == 1) 
		{
			// remove leading and/or trailing spaces
			input = input.trim();
			// split the string input by the delimiter "," into array elements
			String[] sequenceComponents = input.split(",");
			int[] output = new int[sequenceComponents.length];
			
			for (int i = 0; i < sequenceComponents.length; i++)
			{
				try 
				{
					// parse the string to an integer and add to the array if valid
					int sequenceComponent = Integer.parseInt(sequenceComponents[i]);
					output[i] = sequenceComponent;
				} catch (NumberFormatException exception) 
				{
					invalidComponent = true;
					System.out.println("Input " + sequenceComponents[i] + " is not a valid integer.");
				}
			}
			
			if (!invalidComponent)
				return sortArray(output);
		} else {
			System.out.println("Invalid degree sequence entered.");
		}
		
		return null;
	}
	
	public static int[] checkResultingArray (int[] existingArray)
	{
		int currentCount = existingArray.length;
		for (int element : existingArray) 
		{
			if (element == 0)
				currentCount--;
		}
		// construct an array of the size of remaining elements
		int[] finalArray = new int[currentCount];
		for (int i = 0; i < currentCount; i++)
			finalArray[i] = existingArray[i];
		
		return finalArray;
	}
	
	public static String checkPossibility (int[] existingArray)
	{
		int currentLength = existingArray.length;
		// sum the values of the array
		int sumOfValues = 0;
		for(int i = 0; i < existingArray.length; i++)
			sumOfValues += existingArray[i];
		
		if (sumOfValues % 2 == 0) 
		{			
			if (existingArray[0] <= existingArray.length - 1) 
			{
				boolean processCompleted = false;
				while (processCompleted == false) 
				{
					int n = existingArray[0];
					existingArray[0] = 0;
					if (n < currentLength && n != 0) 
					{
						for (int i = 1; i <= n; i++)
							existingArray[i]--;
						
						existingArray = sortArray(existingArray);
						for (int element : existingArray) 
						{
							if (element == 0)
								currentLength--;
						}
						
						checkResultingArray(existingArray);
					} else 
					{
						processCompleted = true;
						return "Possible: a graph can be constructed from the input degree sequence.";
					}
				}
			} else 
			{
				return "Not possible: highest degree is greater than the number of vertices.";
			}
		} else 
		{
			return "Not possible: total sum of numbers is odd.";
		}
		return "Error: the degree sequence could not be parsed.";
	}
}