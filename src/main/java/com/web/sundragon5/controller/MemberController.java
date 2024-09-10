package com.web.sundragon5.controller;

import com.web.sundragon5.dto.*;
import com.web.sundragon5.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public MemberSaveResponseDto saveMember(@RequestBody MemberSaveRequestDto requestDto) {
        return memberService.saveMember(requestDto);
    }

    @GetMapping("/members")
    public List<MemberSimpleResponseDto> getMembers() {
        return memberService.getMembers();
    }

    @GetMapping("/members/{memberId}")
    public MemberDetailResponseDto detailMember(@PathVariable Long memberId) {
        return memberService.detailMember(memberId);
    }

    @PutMapping("/members/{memberId}")
    public MemberUpdateResponseDto updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto requestDto) {
        return memberService.updateMember(memberId, requestDto);
    }

    @DeleteMapping("/members/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
    }

}
