import java.util.Scanner;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;

public class QuizProcess
{
	private QuizData data;
	private Scanner in;
	private PrintStream out;
	private State currentState;

	public QuizProcess(InputStream inStream, OutputStream outStream)
	{
		if (inStream == null || outStream == null)
		{
			throw new NullPointerException();
		}

		in = new Scanner(inStream);
		out = new PrintStream(outStream);
	}

	private void setState(State newState)
	{
		currentState = newState;
	}

	public void initialize(QuizData data)
	{
		if (data == null)
		{
			throw new NullPointerException();
		}

		if (currentState instanceof StartState || currentState instanceof AskingState || currentState instanceof SolutionState)
		{
			throw new IllegalStateException();
		}

		this.data = data;

		setState(new StartState());

		updateUI();
	}

	private void updateUI()
	{
		currentState.updateUI();
	}

	public void update()
	{
		if (currentState instanceof StartState || currentState instanceof SolutionState)
		{
			currentState.update();
		}
		else
		{
			throw new IllegalStateException();			// if currentState instance of AskingState or InitialState
		}
	}

	public void input()
	{			
		if (currentState instanceof AskingState)	// just AskingState is allowed to handle input()
		{
			currentState.input();
		}
		else
		{
			throw new IllegalStateException();
		}																		
		
	}

	private void setSolution(String solution)										
	{																								
		currentState.setSolution(solution);
	}

	private void drawNext()
	{
		data.drawNext();
	}

	private VocabCard getCurrentVocabCard()
	{
		return data.getCurrentVocabCard();
	}



	// INNER CLASSES
	public abstract class State
	{
		public void updateUI()
		{
			throw new IllegalStateException();
		}

		public void update()
		{
			throw new IllegalStateException();
		}

		public void input()
		{
			throw new IllegalStateException();
		}

		public void setSolution(String solution)
		{
			throw new IllegalStateException();
		}
	}

	private class StartState extends State
	{
		public void updateUI() 
		{
			out.println("Hallöle. Du willst also Englisch lernen... Zeitverschwendung. Aber du kannst es ja mal versuchen.");
		}

		public void update()
		{
			setState(new AskingState());

			drawNext();
			currentState.updateUI();
		}
	}

	private class AskingState extends State
	{
		public void updateUI()
		{
			out.println("Please translate: " + data.getCurrentVocabCard().getVocable());
		}

		public void input()
		{
			setState(new SolutionState());

			currentState.updateUI();
		}
	}

	private class SolutionState extends State
	{
		private String solution;

		public void updateUI()
		{
			VocabCard vc = new VocabCard(getCurrentVocabCard().getVocable(), in.nextLine());			// ERROR, weil 'in' Probleme macht
																										// wie greift man auf die Daten über den Scanner 'in' zu ???

			if (vc.equals(getCurrentVocabCard()))
			{
				out.println("Correct!");
			}
			else
			{
				out.println("Wrong!");

				//out.println("The correct answer would have been: " + getCurrentVocabCard().getTranslation());
			}
		}

		public void update()
		{
			// switch state:
			setState(new AskingState());

			// actions:
			drawNext();
			currentState.updateUI();
		}

		public void setSolution(String solution)
		{
			if (solution == null)
			{
				throw new NullPointerException();
			}

			if (solution.equals(""))
			{
				throw new IllegalArgumentException();
			}

			this.solution = solution;
		}
	}


}