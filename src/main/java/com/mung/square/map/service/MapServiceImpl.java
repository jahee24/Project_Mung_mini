package com.mung.square.map.service;

import com.mung.square.dto.MapDTO;
import com.mung.square.map.dao.MapDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService{
    private final MapDAO mapDAO;

    @Override
    public List<MapDTO> maplist() {
        return mapDAO.maplist();
    }
}
