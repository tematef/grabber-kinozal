package util;

import static objects.enums.Qualities.getQuality;
import static objects.enums.SearchQuery.SECTION;
import static objects.enums.SearchQuery.TEXT;
import static objects.enums.SearchQuery.QUALITY;
import static objects.enums.SearchQuery.YEAR;

public class SearchQueryBuilder {

	private String searchQuery;

	public static String buildMovieSearch(String text, String quality, String year) {
		return new StringBuilder()
				.append("&")
				.append(SECTION.getValue())
				.append("1002")
				.append("&")
				.append(TEXT.getValue())
				.append(text)
				.append("&")
				.append(QUALITY.getValue())
				.append(getQuality(quality).getIndex())
				.append("&")
				.append(YEAR.getValue())
				.append(year).toString();

	}
}
