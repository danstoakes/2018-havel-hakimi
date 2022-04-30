public class Main
{
	public static void main (String[] args)
	{
		if (args.length != 1)
			throwError("Not enough or too many arguments supplied.");
		
		int[] degreeSequence = HavelHakimi.convertInputToArray(args[0]);
		
		if (degreeSequence == null)
			throwError("");
		
		System.out.println(HavelHakimi.checkPossibility(degreeSequence));
	}
	
	private static void help ()
	{
		System.out.println("\nThis program uses the Havel-Hakimi algorithm to calculate whether a simple graph exists for the input degree sequence or not.");
		System.out.println("The input degree sequence should follow the format: n,n,n,n...etc up until a total of 10 elements.");
	}
	
	private static void throwError (String message)
	{
		if (message != "")
			System.out.println(message);
		help();
		System.exit(0);
	}
}