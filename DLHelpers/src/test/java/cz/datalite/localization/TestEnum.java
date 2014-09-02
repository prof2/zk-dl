package cz.datalite.localization;

public enum TestEnum implements Localizable {

	//Zmeny pronaset do zurnalu!

	FOO("foo.bar");

	private String key;

	private TestEnum(String key) {
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}

}
