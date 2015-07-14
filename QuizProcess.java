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

		in = (Scanner)inStream;
		out = (PrintStream)outStream;
	}

	public void setStream(State newState)
	{

	}

	public void initialize(QuizData data)
	{
		if (data == null)
		{
			throw new NullPointerException();
		}

		this.data = data;
	}

	public void updateUI()
	{

	}

	public void update()
	{

	}

	public void input()
	{

	}

	private void setSolution(String solution)
	{

	}

	private void drawNext()
	{

	}

	private VocabCard getCurrentVocabCard()
	{

	}

	private void println(String fmt, Object[VARARGS???])
	{

	}

	private String nextLine()
	{
		
	}

}