package com.web.sundragon5.repositoty;

import com.web.sundragon5.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
