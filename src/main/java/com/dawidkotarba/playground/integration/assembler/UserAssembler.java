package com.dawidkotarba.playground.integration.assembler;

import com.dawidkotarba.playground.integration.dto.UserOutDto;
import com.dawidkotarba.playground.model.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zakochani on 11.05.2016.
 */

@Service
public class UserAssembler {

    public UserOutDto convert(User user) {
        UserOutDto outDto = new UserOutDto();
        outDto.setUserId(user.getId());
        outDto.setUsername(user.getUsername());
        outDto.setEnabled(user.isEnabled());
        outDto.setRole(user.getRole());
        return outDto;
    }

    public List<UserOutDto> convertToDto(List<User> users) {
        List<UserOutDto> result = new ArrayList<>();
        users.forEach(user -> result.add(convert(user)));
        return result;
    }
}
