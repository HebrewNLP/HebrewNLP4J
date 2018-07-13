package il.co.hebrewnlp.morphology;

import java.io.Serializable;

public class MorphInfo implements Serializable, Cloneable {

	private static final long serialVersionUID = 3491575400994363231L;
	
	private String BaseWord;
	private boolean Vav;
	private Shiabud Shiabud;
	private PrepositionChars PrepositionChars;
	private boolean DefiniteArticle;
	private PartOfSpeech PartOfSpeech;
	private Gender Gender;
	private boolean Plural;
	private Person Person;
	private Smikut Smikut;
	private Tense Tense;
	private Gender SuffixGender;
	private boolean SuffixPlural;
	private Person SuffixPerson;
	
	@Override
	public String toString() {
		return "MorphInfo [BaseWord=" + BaseWord + ", Vav=" + Vav + ", Shiabud=" + Shiabud + ", PrepositionChars="
				+ PrepositionChars + ", DefiniteArticle=" + DefiniteArticle + ", PartOfSpeech=" + PartOfSpeech
				+ ", Gender=" + Gender + ", Plural=" + Plural + ", Person=" + Person + ", Smikut=" + Smikut + ", Tense="
				+ Tense + ", SuffixGender=" + SuffixGender + ", SuffixPlural=" + SuffixPlural + ", SuffixPerson="
				+ SuffixPerson + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BaseWord == null) ? 0 : BaseWord.hashCode());
		result = prime * result + (DefiniteArticle ? 1231 : 1237);
		result = prime * result + ((Gender == null) ? 0 : Gender.hashCode());
		result = prime * result + ((PartOfSpeech == null) ? 0 : PartOfSpeech.hashCode());
		result = prime * result + ((Person == null) ? 0 : Person.hashCode());
		result = prime * result + (Plural ? 1231 : 1237);
		result = prime * result + ((PrepositionChars == null) ? 0 : PrepositionChars.hashCode());
		result = prime * result + ((Shiabud == null) ? 0 : Shiabud.hashCode());
		result = prime * result + ((Smikut == null) ? 0 : Smikut.hashCode());
		result = prime * result + ((SuffixGender == null) ? 0 : SuffixGender.hashCode());
		result = prime * result + ((SuffixPerson == null) ? 0 : SuffixPerson.hashCode());
		result = prime * result + (SuffixPlural ? 1231 : 1237);
		result = prime * result + ((Tense == null) ? 0 : Tense.hashCode());
		result = prime * result + (Vav ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MorphInfo other = (MorphInfo) obj;
		if (BaseWord == null) {
			if (other.BaseWord != null)
				return false;
		} else if (!BaseWord.equals(other.BaseWord))
			return false;
		if (DefiniteArticle != other.DefiniteArticle)
			return false;
		if (Gender != other.Gender)
			return false;
		if (PartOfSpeech != other.PartOfSpeech)
			return false;
		if (Person != other.Person)
			return false;
		if (Plural != other.Plural)
			return false;
		if (PrepositionChars != other.PrepositionChars)
			return false;
		if (Shiabud != other.Shiabud)
			return false;
		if (Smikut != other.Smikut)
			return false;
		if (SuffixGender != other.SuffixGender)
			return false;
		if (SuffixPerson != other.SuffixPerson)
			return false;
		if (SuffixPlural != other.SuffixPlural)
			return false;
		if (Tense != other.Tense)
			return false;
		if (Vav != other.Vav)
			return false;
		return true;
	}

	public String getBaseWord() {
		return BaseWord;
	}
	
	public void setBaseWord(String baseWord) {
		BaseWord = baseWord;
	}
	
	public boolean isVav() {
		return Vav;
	}
	
	public void setVav(boolean vav) {
		Vav = vav;
	}
	
	public Shiabud getShiabud() {
		return Shiabud;
	}
	
	public void setShiabud(Shiabud shiabud) {
		Shiabud = shiabud;
	}
	
	public PrepositionChars getPrepositionChars() {
		return PrepositionChars;
	}
	
	public void setPrepositionChars(PrepositionChars prepositionChars) {
		PrepositionChars = prepositionChars;
	}
	
	public boolean isDefiniteArticle() {
		return DefiniteArticle;
	}
	
	public void setDefiniteArticle(boolean definiteArticle) {
		DefiniteArticle = definiteArticle;
	}
	
	public PartOfSpeech getPartOfSpeech() {
		return PartOfSpeech;
	}
	
	public void setPartOfSpeech(PartOfSpeech partOfSpeech) {
		PartOfSpeech = partOfSpeech;
	}
	
	public Gender getGender() {
		return Gender;
	}
	
	public void setGender(Gender gender) {
		Gender = gender;
	}
	
	public boolean isPlural() {
		return Plural;
	}
	
	public void setPlural(boolean plural) {
		Plural = plural;
	}
	
	public Person getPerson() {
		return Person;
	}
	
	public void setPerson(Person person) {
		Person = person;
	}
	
	public Smikut getSmikut() {
		return Smikut;
	}
	
	public void setSmikut(Smikut smikut) {
		Smikut = smikut;
	}
	
	public Tense getTense() {
		return Tense;
	}
	
	public void setTense(Tense tense) {
		Tense = tense;
	}
	
	public Gender getSuffixGender() {
		return SuffixGender;
	}
	
	public void setSuffixGender(Gender suiffxGender) {
		SuffixGender = suiffxGender;
	}
	
	public boolean isSuffixPlural() {
		return SuffixPlural;
	}
	
	public void setSuffixPlural(boolean suiffxPlural) {
		SuffixPlural = suiffxPlural;
	}
	
	public Person getSuffixPerson() {
		return SuffixPerson;
	}
	
	public void setSuffixPerson(Person suiffxPerson) {
		SuffixPerson = suiffxPerson;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
