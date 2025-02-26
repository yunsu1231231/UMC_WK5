package umc.study.converter;

import umc.study.domain.Missions;
import umc.study.domain.Regions;
import umc.study.domain.Stores;
import umc.study.domain.Users;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.mapping.User_Missions;
import umc.study.web.dto.StoreRequestDTO;

public class StoreConverter {

    public static Stores toStore(StoreRequestDTO.StoreDTO storeDTO, Regions region) {
        return Stores.builder()
                .name(storeDTO.getName())
                .address(storeDTO.getAddress())
                .region(region)
                .build();
    }

    // User_Missions 객체 생성 메서드
    public static User_Missions toUserMission(Users user, Missions mission, StoreRequestDTO.MissionChallengeRequestDto requestDto) {
        return User_Missions.builder()
                .users(user) // 연관된 Users 설정
                .missions(mission) // 연관된 Missions 설정
                .status(MemberStatus.valueOf(requestDto.getStatus().toUpperCase())) // 상태 설정
                .build();
    }

    /*
    // Missions 객체 생성 메서드
    public static Missions toMission(StoreRequestDTO.MissionDTO request, Stores store, Timestamp createdAt) {
        return Missions.builder()
                .name(request.getName())
                .description(request.getDescription())
                .store(store)
                .createdAt(createdAt)
                .build();
    }
    */

}