package com.web.sundragon5.service;

import com.web.sundragon5.dto.*;
import com.web.sundragon5.entity.Member;
import com.web.sundragon5.repositoty.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto) {
        Member newMember = new Member(requestDto.getName());

        Member savedMember = memberRepository.save(newMember);

        return new MemberSaveResponseDto(savedMember.getId(), savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getMembers() {
        List<Member> memberList = memberRepository.findAll();

        List<MemberSimpleResponseDto> dtoList = new ArrayList<>();

        for (Member member : memberList) {
            MemberSimpleResponseDto dto = new MemberSimpleResponseDto(member.getName());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public MemberDetailResponseDto detailMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("멤버가 없습니다"));

        return new MemberDetailResponseDto(member.getName());
    }

    public MemberUpdateResponseDto updateMember(Long memberId, MemberUpdateRequestDto requestDto) {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("멤버가 없습니다"));

        member.update(requestDto.getName());

        return new MemberUpdateResponseDto(member.getId(), member.getName());
    }

    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("멤버가 없습니다"));

        memberRepository.delete(member);
    }
}
