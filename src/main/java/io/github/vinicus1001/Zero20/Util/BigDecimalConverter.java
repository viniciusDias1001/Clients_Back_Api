package io.github.vinicus1001.Zero20.Util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class BigDecimalConverter {

    public BigDecimal converter(String value){

        if (value == null){
            return null;
        }
        value = value.replace(".","").replace(",",".");
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal;
    }
}
