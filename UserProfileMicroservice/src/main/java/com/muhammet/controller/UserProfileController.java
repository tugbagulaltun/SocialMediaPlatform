package com.muhammet.controller;

import com.muhammet.dto.request.UserProfileCreateRequestDto;
import com.muhammet.entity.UserProfile;
import com.muhammet.service.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

import static com.muhammet.config.RestApis.*;
@RestController
@RequestMapping(USER_PROFILE)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(CREATE_PROFILE)
    public ResponseEntity<Boolean> createProfile(@RequestBody @Valid UserProfileCreateRequestDto dto){
        return ResponseEntity.ok(userProfileService.save(dto));
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll(String token){
        return ResponseEntity.ok(userProfileService.getAll(token));
    }
}
