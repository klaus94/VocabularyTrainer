import java.util.*;

public class CompletelyRandom extends CardDrawing
{
	public int getNextVocabId(int sizeVocab)
	{
		Random rnd = new Random();
		return rnd.nextInt(sizeVocab);
	}
}