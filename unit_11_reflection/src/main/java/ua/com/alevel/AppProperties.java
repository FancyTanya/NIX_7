package ua.com.alevel;

public class AppProperties {

    @PropertyKey("property.string")
    public String stringValue;
    @PropertyKey("property.int")
    public int intValue;
    @PropertyKey("property.long")
    public long longValue;
    @PropertyKey("property.double")
    public double doubleValue;
    @PropertyKey("property.char")
    public char charValue;
    @PropertyKey("property.boolean")
    public boolean booleanValue;

    @Override
    public String toString() {
        return "AppProperties{" +
                "stringValue='" + stringValue + '\'' +
                ", intValue=" + intValue +
                ", longValue=" + longValue +
                ", doubleValue=" + doubleValue +
                ", charValue=" + charValue +
                ", booleanValue=" + booleanValue +
                '}';
    }
}
