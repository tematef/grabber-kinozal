package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MovieRowData {

    private String name;
    private int seeds;
    private String size;

    private MovieRowData() { }

    private MovieRowData(WebElement webElement) {
        String[] longName = webElement.findElement(By.xpath("./td[2]")).getText().trim().split("/");
        this.name = longName[0] + longName[1];
        this.seeds = Integer.parseInt(webElement.findElement(By.xpath("./td[3]")).getText().trim());
        this.size = webElement.findElement(By.xpath("./td[4]")).getText().trim();
    }

    public static MovieRowData createMovieRowData(WebElement webElement) {
        return new MovieRowData(webElement);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        if (seeds != that.seeds) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return size != null ? size.equals(that.size) : that.size == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + seeds;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.name + " " + this.seeds + " " + this.size;
    }
}
