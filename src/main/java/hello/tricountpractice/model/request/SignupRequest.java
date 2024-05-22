package hello.tricountpractice.model.request;

import lombok.Data;

@Data
public class SignupRequest {
    private String loginId;
    private String loginPassword;
    private String name;
}
