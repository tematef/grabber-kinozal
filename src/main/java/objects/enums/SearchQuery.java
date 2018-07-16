package objects.enums;

public enum SearchQuery {

	TEXT("s="),
	SECTION("c="),
	QUALITY("v="),
	YEAR("d=");

	private String value;

	SearchQuery(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
