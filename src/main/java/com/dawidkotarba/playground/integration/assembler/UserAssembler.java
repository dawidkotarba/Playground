package com.dawidkotarba.playground.integration.assembler;

import com.dawidkotarba.playground.integration.dto.UserOutDto;
import com.dawidkotarba.playground.model.entities.User;

import javax.inject.Named;
import java.util.function.Function;

/**
 * Created by Zakochani on 11.05.2016.
 */

@Named
public class UserAssembler {

    public Function<User, UserOutDto> convert() {
        return user -> {
            UserOutDto outDto = new UserOutDto();
            outDto.setUserId(user.getId());
            outDto.setUsername(user.getUsername());
            outDto.setEnabled(user.isEnabled());
            outDto.setRole(user.getRole());
            return outDto;
        };

    }
}