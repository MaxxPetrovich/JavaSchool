package com.mpetrov.javaschool.hw.lesson5.Task1;

import java.util.Objects;

public class MyClass2 {

    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String FRIDAY = "MONDAY";
    public static final int INT = 5;
    public static final boolean BOOL = true;

    private Object field1;
    private String field2;
    private Long field3;
    private Boolean field4;

    public Object getField1() {
        return field1;
    }

    public void setField1(Object field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public Long getField3() {
        return field3;
    }

    public void setField3(Long field3) {
        this.field3 = field3;
    }

    public Boolean getField4() {
        return field4;
    }

    public void setField4(Boolean field4) {
        this.field4 = field4;
    }


    public MyClass2(String field1, String field2, Long field3, Boolean field4) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }

    @Override
    public String toString() {
        return "ManyField{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3=" + field3 +
                ", field4=" + field4 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass2 manyField = (MyClass2) o;
        return field1.equals(manyField.field1) &&
                field2.equals(manyField.field2) &&
                field3.equals(manyField.field3) &&
                field4.equals(manyField.field4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2, field3, field4);
    }

}
