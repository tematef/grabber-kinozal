package objects;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class MovieRowData {

    private String nameRu;
    private String nameEng;
    private int seeds;
    private String size;

    private MovieRowData() { }

    private MovieRowData(WebElement webElement) {
        String[] longName = webElement.findElement(By.xpath("./td[2]")).getText().trim().split("/");
        this.nameRu = longName[0];
        this.nameEng = longName[0];
        this.seeds = Integer.parseInt(webElement.findElement(By.xpath("./td[3]")).getText().trim());
        this.size = webElement.findElement(By.xpath("./td[4]")).getText().trim();
    }

    public static MovieRowData createMovieRowData(WebElement webElement) {
        return new MovieRowData(webElement);
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public int getSeeds() {
        return seeds;
    }

    public void setSeeds(int seeds) {
        this.seeds = seeds;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieRowData that = (MovieRowData) o;
        return seeds == that.seeds &&
                Objects.equals(nameRu, that.nameRu) &&
                Objects.equals(nameEng, that.nameEng) &&
                Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameRu, nameEng, seeds, size);
    }

    @Override
    public String toString() {
        return this.nameRu +
                StringUtils.SPACE +
                this.nameEng +
                StringUtils.SPACE +
                this.seeds +
                StringUtils.SPACE +
                this.size;
    }
}
