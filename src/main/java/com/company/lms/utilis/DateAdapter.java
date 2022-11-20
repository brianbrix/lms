package com.company.lms.utilis;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {
    private static final String CUSTOM_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public Date unmarshal(String v) throws Exception {
        var s =  new SimpleDateFormat(CUSTOM_FORMAT_STRING).parse(v);
        System.out.println("%%%%%%%%%%%%%%%"+s);
        return s;
    }

    @Override
    public String marshal(Date aLong) throws Exception {
        return new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(aLong);
    }

}
