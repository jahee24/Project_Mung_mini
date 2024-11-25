package com.mung.square.map.mapper;

import com.mung.square.dto.MapDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapMapper {
    List<MapDTO> selectall();
}
