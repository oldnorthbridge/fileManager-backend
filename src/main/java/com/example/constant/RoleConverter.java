package com.example.constant;

import com.example.enumeration.Authority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;
// 这个类的实际作用就是数据类型转换，因为我们的数据库中只能存基本类型，
@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Authority, String> {
    @Override
    public String convertToDatabaseColumn(Authority authority) {
        if (authority == null) {
            return null;
        }
        return authority.getValue();
    }

    @Override
    public Authority convertToEntityAttribute(String code) {
        if(code == null) {
            return null;
        }
        return Stream.of(Authority.values())
                .filter(authority -> authority.getValue().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        /*
        * Authority.values() 是属于枚举类的一个静态方法，其作用在于获取枚举类的所有属性
        * 然后就把获取到的所有值和数据库查询到值一一比对，如果找到了，就把数据返回出去，否则抛出一个非法参数异常
        * */
    }
}
