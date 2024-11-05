public class Section {
    private String code;
    private String day;
    private String hours;
    private int quota;

    public Section(String code, String day, String hours, int quota) {
        this.code = code;
        this.day = day;
        this.hours = hours;
        this.quota = quota;
    }

    public String getCode() {
        return code;
    }

    public String getDay() {
        return day;
    }

    public String getHours() {
        return hours;
    }

    public int getQuota() {
        return quota;
    }
}
