package adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateAdapterComment extends XmlAdapter<String, ZonedDateTime> {
    private DateTimeFormatter dateFormat = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @Override
    public ZonedDateTime unmarshal(String xml) throws Exception {
        return ZonedDateTime.parse(xml,dateFormat);
    }

    @Override
    public String marshal(ZonedDateTime date) throws Exception {
        return date.format(dateFormat);
    }
}
