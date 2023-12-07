package afluex.hrm.afluexhr.Model;

public class SliderData {


    private String url;
    private Integer file;

    public SliderData() {
    }

    public SliderData(String url, Integer file) {
        this.url = url;
        this.file = file;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getFile() {
        return file;
    }

    public void setFile(Integer file) {
        this.file = file;
    }
}

