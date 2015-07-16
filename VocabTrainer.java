import java.util.HashMap;
import java.util.Map;

public class VocabTrainer {

	public static void main(String[] args) {
		
		/*QuizProcess process = new QuizProcess(System.in, System.out);
		
		Map<Integer, VocabCard> vocabMap = new HashMap<Integer, VocabCard>();
		vocabMap.put(1, new VocabCard("go", "gehen"));
		vocabMap.put(2, new VocabCard("lift", "heben"));
		vocabMap.put(3, new VocabCard("fall", "fallen"));
		vocabMap.put(4, new VocabCard("time", "Zeit"));
		vocabMap.put(5, new VocabCard("house", "Haus"));
		
		process.initialize(new QuizData(vocabMap, false) );


		while (true) {
		 	process.update();
			process.input();
		}*/



		CardDrawing cardDrawing = new CompletelyRandom();

        for (int i = 0; i < 200; i++) {
            System.out.println(cardDrawing.getNextVocabCardId(5));
        }
	}
}
