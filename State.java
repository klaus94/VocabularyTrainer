public abstract class State
{
	public void updateUI();

	public void update();

	public void input();

	public void setSolution(String solution);


	private class StartState extends State
	{
		public void updateUI() 
		{

		}

		public void update()
		{

		}
	}

	private class AskingState extends State
	{
		public void updateUI()
		{

		}

		public void input()
		{

		}
	}

	private class SolutionState extends State
	{
		private String solution;

		public void updateUI()
		{

		}

		public void update()
		{

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