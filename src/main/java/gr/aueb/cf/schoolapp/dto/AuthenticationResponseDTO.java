package gr.aueb.cf.schoolapp.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDTO {
    private String firstname;
    private String lastname;
    private String token;
}
