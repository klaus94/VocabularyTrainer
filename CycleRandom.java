import java.util.*;

public class CycleRandom extends CardDrawing
{
	private List<Integer> cycleList;

	public int getNextVocabId(int sizeVocab)
	{
		if (cycleList == null || cycleList.size() == 0) {
			initializeCycleList(sizeVocab);
		}
		return removeRandomFromCycleList();
	}

	private void initializeCycleList(int sizeVocab)
	{
		cycleList = new LinkedList<Integer>();
		for (int i = 1; i <= sizeVocab; i++) {
			cycleList.add(i);
		}
	}

	private int removeRandomFromCycleList()
	{
		int remove = random(cycleList.size());
		return cycleList.remove(remove);
	}
}