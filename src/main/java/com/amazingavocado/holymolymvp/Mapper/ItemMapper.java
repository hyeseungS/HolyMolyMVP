package com.amazingavocado.holymolymvp.Mapper;


import com.amazingavocado.holymolymvp.model.Item;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    @Select("select * from item")
    public List<Item> getList();
}
