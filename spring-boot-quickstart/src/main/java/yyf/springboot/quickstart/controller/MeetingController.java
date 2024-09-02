package yyf.springboot.quickstart.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yyf.springboot.quickstart.entity.Meeting;
import yyf.springboot.quickstart.service.MeetingService;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Resource
    private MeetingService meetingService;

    @PostMapping("/check")
    public ResponseEntity<String> check(@RequestBody Meeting meeting) {
        if (meetingService.isRoomAvailable(meeting)) {
            //添加到会议室列表
            meetingService.addMeeting(meeting);
            return ResponseEntity.ok("会议室可用！");
        }else {
            return ResponseEntity.ok("会议室已被占用！");
        }
    }
}
