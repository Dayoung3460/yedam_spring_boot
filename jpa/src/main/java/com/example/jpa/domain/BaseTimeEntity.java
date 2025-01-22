package com.example.jpa.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
// 상속받는 자식 앤티티(Posts)에 해당 필드 추가해줌
@MappedSuperclass
// 앤티티가 등록, 수정될 때를 감지
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    // 앤티티가 생성될 때
    @CreatedDate
    private LocalDateTime createdDate;

    // update가 되면 자동으로 시간 업뎃됨
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
