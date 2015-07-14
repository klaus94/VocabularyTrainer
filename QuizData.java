import java.util.*;

public class QuizData
{
	private Map<Integer, VocabCard> vocabMap;
	private int current;
	private CardDrawing cardDrawing;

	public QuizData(Map<Integer, VocabCard> vocabMap, boolean useCycleRandom)
	{
		if (vocabMap == null) {
			throw new NullPointerException();
		}

		if (vocabMap.isEmpty()) {
			throw new IllegalArgumentException();
		}

		for (Integer i : vocabMap.keySet()) {
			if (i <= 0 || vocabMap.get(i) == null || i > sizeVocab()) {
				throw new IllegalArgumentException();
			}
		}

		this.vocabMap = vocabMap;
		if (useCycleRandom == true) {
			cardDrawing = new CycleRandom();
		} else {
			cardDrawing = new CompletelyRandom();
		}
	}

	public int sizeVocab()
	{
		return vocabMap.size();
	}

	public void drawNext()
	{
		//cardDrawing.getNextVocabId(sizeVocab());
	}

	public VocabCard getCurrentVocabCard()
	{
		return vocabMap.get(current);
	}

}