package com.mung.square.map.controller;

import com.mung.square.dto.MapDTO;
import com.mung.square.map.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MapController {
    private final MapService mapservice;

    @GetMapping("/map")
    @ResponseBody
    public List<MapDTO> branchlist() {
        List<MapDTO> branchlist = mapservice.maplist();
        System.out.println(branchlist);
        return branchlist;
    }
}
