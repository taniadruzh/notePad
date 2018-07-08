package com.checkData;

import com.model.Person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CheckData {

    public static int checkPhone(Person person){
        Pattern p = Pattern.compile("^\\+380\\d{9}$");
        Matcher m = p.matcher(person.getPhone());
        if (m.matches()) {
            return 0;
        } else {
            return 1;
        }
    }
}
