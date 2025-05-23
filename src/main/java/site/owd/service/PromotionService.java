package site.owd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.owd.dto.CreatePromotionGroupDto;
import site.owd.dto.PromotionGroupDto;
import site.owd.dto.PromotionGroupInfoDto;
import site.owd.entity.PromotionGroup;
import site.owd.entity.PromotionGroupMember;
import site.owd.entity.Store;
import site.owd.repository.PromotionGroupMemberRepository;
import site.owd.repository.PromotionGroupRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PromotionService {

    final PromotionGroupRepository promotionGroupRepository;
    final PromotionGroupMemberRepository promotionGroupMemberRepository;

    public CreatePromotionGroupDto createPromotionGroup() {
        List<PromotionGroup> promotionGroups = promotionGroupRepository.findAll();

        List<PromotionGroupDto> responseList = promotionGroups.stream()
            .map(group -> {
                List<PromotionGroupMember> members = promotionGroupMemberRepository.findAll().stream()
                    .filter(member -> member.getPromotionGroup().getId().equals(group.getId()))
                    .collect(Collectors.toList());

                List<PromotionGroupInfoDto> stores = members.stream()
                    .map(member -> mapStoreToDto(member.getStore()))
                    .collect(Collectors.toList());

                return new PromotionGroupDto(
                    group.getId(),
                    group.getTitle(),
                    stores
                );
            })
            .collect(Collectors.toList());

        return new CreatePromotionGroupDto(responseList);
    }

    private PromotionGroupInfoDto mapStoreToDto(Store store) {
        double randomDistance = Math.round((Math.random() * 5.0) * 100.0) / 100.0;

        return new PromotionGroupInfoDto(
            store.getName(),
            store.getCategory(),
            store.getAddress(),
            store.getPromotionRate(), // 추후 계산 방식에 따라 수정 가능
            randomDistance     // 추후 위치 기반 계산 필요
        );
    }
}
