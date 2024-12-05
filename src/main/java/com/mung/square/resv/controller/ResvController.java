package com.mung.square.resv.controller;

import com.mung.square.dto.ResvDTO;
import com.mung.square.dto.UserDTO;
import com.mung.square.resv.service.ResvService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;


@Controller
@RequestMapping("/resv")
@RequiredArgsConstructor
public class ResvController {
    private final ResvService resvService;


    @GetMapping
    public String resv(HttpSession session, Model model) {
        String phoneNumber = (String) session.getAttribute("phoneNumber");
        String name = (String) session.getAttribute("name");
        String userId = (String) session.getAttribute("userId");

        UserDTO user = new UserDTO();
        user.setUserId(userId);
        user.setPhoneNumber(phoneNumber);
        user.setName(name);
        model.addAttribute("user", user);


        return "/include/resvContent";
    }

    // view 에서 controller 로

    // 예약을 처리하는 엔드포인트
    @PostMapping("/reserve")
    @ResponseBody
    public ResvDTO createReservation(@RequestBody ResvDTO resvDTO) {
        String userId = resvDTO.getUserId();
        String branchName = resvDTO.getBranchName();
        String status = resvDTO.getStatus();
        String resvDate = resvDTO.getResvDate();
        Timestamp startTime = resvDTO.getStartTime();
        Timestamp endTime = resvDTO.getEndTime();
        int barcount = resvDTO.getBarCount();

        resvService.createReservation(resvDTO);
        return resvDTO;

    }
}
