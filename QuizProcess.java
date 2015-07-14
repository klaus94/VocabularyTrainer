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

		this.data = data;

		// initialize state
		setState(new StartState());
	}

	private void updateUI()
	{
		currentState.updateUI();
	}

	public void update()
	{
		currentState.update();
	}

	public void input()
	{																								// ??????????????
		currentState.input();
	}

	private void setSolution(String solution)										
	{																								// ??????????????
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
			System.out.println("Hallöle. Du willst also Englisch lernen... Zeitverschwendung. Aber du kannst es ja mal versuchen.");
		}

		public void update()
		{
			// switch state:
			setState(new AskingState());

			// actions:
			drawNext();
			updateUI();
		}
	}

	private class AskingState extends State
	{
		public void updateUI()
		{
			// action:
			drawNext();
		}

		public void input()
		{
			// switch state:
			setState(new SolutionState());

			// actions:
			updateUI();
		}
	}

	private class SolutionState extends State
	{
		private String solution;

		public void updateUI()
		{
			VocabCard vc = new VocabCard(getCurrentVocabCard().getVocable(), in.nextLine());

			if (vc.equals(getCurrentVocabCard()))
			{
				out.println("Correct!");
			}
			else
			{
				out.println("Wrong!");

				// optional output:
				out.println("The correct answer would have been: " + getCurrentVocabCard().getTranslation());
			}
		}

		public void update()
		{
			// switch state:
			setState(new AskingState());

			// actions:
			drawNext();
			updateUI();
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