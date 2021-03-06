package com.alibaba.daybits.support.odps.udf;

import com.alibaba.daybits.DayBits;
import com.alibaba.daybits.DayBitsUtils;
import com.aliyun.odps.udf.UDF;

public class DayBitsGet extends UDF {

    public DayBitsGet(){
    }

    public Boolean evaluate(String text, String date) {
        if (text == null || text.isEmpty() || date == null || date.isEmpty()) {
            return null;
        }

        DayBits daybits = DayBitsUtils.parse(text);
        return daybits.get(date);
    }
    
    public Boolean evaluate(String text, Long date) {
        if (text == null || text.isEmpty() || date == null) {
            return null;
        }
        
        DayBits daybits = DayBitsUtils.parse(text);
        return daybits.get(date.intValue());
    }

}
