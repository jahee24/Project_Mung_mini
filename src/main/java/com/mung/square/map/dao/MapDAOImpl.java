package com.mung.square.map.dao;

import com.mung.square.dto.MapDTO;
import com.mung.square.map.mapper.MapMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MapDAOImpl implements MapDAO {
    private final MapMapper mapMapper;

    @Override
    public List<MapDTO> maplist() {
        return mapMapper.selectall();
    }
}
