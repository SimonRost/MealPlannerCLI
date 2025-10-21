package app.mealplanner.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "mealplanner", mixinStandardHelpOptions = true, version = "0.1",
		description = "Meal planning CLI")
public class Main implements Runnable {
	public static void main(String[] args) {
		int exit = new CommandLine(new Main()).execute(args);
		System.exit(exit);
	}
	@Override public void run() { System.out.println("MealPlannerCLI is alive."); }
}