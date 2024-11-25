package com.mung.square.map.controller;

import com.mung.square.dto.MapDTO;
import com.mung.square.map.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MapController {
    private final MapService mapservice;

    @GetMapping("/map")
    public String branchlist(Model model) {
        List<MapDTO> branchlist = mapservice.maplist();
        model.addAttribute("branchlist", branchlist);
        System.out.println(branchlist);
        return "redirect:/";
    }
}
