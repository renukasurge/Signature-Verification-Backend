package com.gen.eChannel.verification.dto;

import com.gen.eChannel.verification.util.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoginDto extends Auditable<String> {

    private String email;

    private String password;
}
