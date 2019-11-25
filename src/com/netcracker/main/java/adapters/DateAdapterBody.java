package adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateAdapterBody extends XmlAdapter<String, LocalDateTime> {
    private DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public LocalDateTime unmarshal(String xml) throws Exception {
        LocalDateTime localDate = LocalDateTime.parse(xml,dateFormat);
        return localDate;
    }

    @Override
    public String marshal(LocalDateTime date) throws Exception {
        return date.format(dateFormat);
    }
}
