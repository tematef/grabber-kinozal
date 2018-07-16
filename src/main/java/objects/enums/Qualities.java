package objects.enums;

import java.util.Arrays;

public enum Qualities {

	FULL_HD("1080", "3"),
	ULTRA_HD("2160", "7"),
	REMUX("remux", "4");

	private String name;
	private String index;

	Qualities(String name, String index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public String getIndex() {
		return index;
	}

	public static Qualities getQuality(String name) {
		return Arrays.asList(Qualities.values()).stream()
				.filter(quality -> quality.getName().equals(name)).findFirst()
				.orElse(null);
	}
}
