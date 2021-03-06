public class VocabCard
{
	private String vocable;
	private String translation;

	public VocabCard(String vocable, String translation)
	{
		if (vocable == null || translation == null)
		{
			throw new NullPointerException();
		}
		if (vocable.equals("") || translation.equals(""))
		{
			throw new IllegalArgumentException();
		}

		this.vocable = vocable;
		this.translation = translation;
	}

	public String getVocable()
	{
		return vocable;
	}

	public String getTranslation()
	{
		return translation;
	}

	public boolean equals(Object o)
	{
		if (o == null) {
			return false;
		}

		if (o instanceof VocabCard && ((VocabCard) o).getVocable().equals(vocable) && ((VocabCard) o).getTranslation().equals(translation)) {
			return true;
		}

		return false;
	}


}