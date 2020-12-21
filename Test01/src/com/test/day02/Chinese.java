package com.test.day02;

import java.util.Objects;

public class Chinese {

    private String id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chinese chinese = (Chinese) o;
        return id.equals(chinese.id) &&
                name.equals(chinese.name) &&
                country.equals(chinese.country);
    }

    //国籍 在此应为所有对象都具有且相同的属性，都是中国
    private String country;

}
