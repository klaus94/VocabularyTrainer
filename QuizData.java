import java.util.*;

public class QuizData
{
	private Map<Integer, VocabCard> vocabMap;
	private int current;
	private CardDrawing cardDrawing;

	public QuizData(Map<Integer, VocabCard> vocabMap, boolean useCycleRandom)
	{
		//...
	}

	public int sizeVocab()
	{

	}

	public void drawNext()
	{

	}

	public VocabCard getCurrentVocabCard()
	{
		return vocabMap.get(current);
	}

}