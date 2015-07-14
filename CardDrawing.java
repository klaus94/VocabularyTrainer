import java.util.Random;

public abstract class CardDrawing
{
	public abstract int getNextVocabId(int sizeVocab);
	
	public int random(int max)
	{
		if (max <= 0) {
			throw new IllegalArgumentException();
		}
		Random random = new Random();
		return random.next(max);
	}
}