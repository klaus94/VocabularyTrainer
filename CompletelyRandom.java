public class CompletelyRandom extends CardDrawing
{
	public int getNextVocabId(int sizeVocab)
	{
		return random(sizeVocab + 1);
	}
}