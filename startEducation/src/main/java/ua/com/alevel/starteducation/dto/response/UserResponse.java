package ua.com.alevel.starteducation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.starteducation.Routes;
import ua.com.alevel.starteducation.model.auth.EducationUser;
import ua.com.alevel.starteducation.model.auth.KnownAuthority;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.time.OffsetDateTime;
import java.util.EnumSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class UserResponse{

    private Long id;
    private String email;
    private OffsetDateTime createdAt;
    private Set<KnownAuthority> authorities;

    public UserResponse(Long id, String email, OffsetDateTime createdAt, EducationUser user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
        var knownAuthorities = EnumSet.copyOf(user.getAuthorities().keySet());
    }

    public static UserResponse fromUserWithBasicAttributes(EducationUser user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getCreatedAt(),
                null);
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String path() {
        return Routes.user(id);
    }


}
