public class CompletelyRandom extends CardDrawing
{
	public int getNextVocabCardId(int sizeVocab)
	{
		if (sizeVocab < 1)
		{
			throw new IllegalArgumentException();
		}

		return random(sizeVocab) + 1;
	}
}