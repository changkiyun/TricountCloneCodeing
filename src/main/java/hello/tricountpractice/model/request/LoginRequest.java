package hello.tricountpractice.model.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String loginId;
    private String loginPassword;
}
