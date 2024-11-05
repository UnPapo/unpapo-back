package com.comparsas.unpapo.service;

import com.comparsas.unpapo.entity.Likes;
import com.comparsas.unpapo.repository.LikeRepository;
import com.comparsas.unpapo.repository.UserRepository;
import com.comparsas.unpapo.utils.models.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;

    public ApiResponse<Boolean> userLike(Long userIdLiker, Long userIdLiked) {
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        Likes like = new Likes(new Date(),
                userRepository.getReferenceById(userIdLiker),
                userRepository.getReferenceById(userIdLiked));
        return apiResponse;
    }

}
