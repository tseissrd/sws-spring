/*
 */
package com.example.sws.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Sovereign
 */
@Data
@Builder
@AllArgsConstructor(access=AccessLevel.PACKAGE)
public class UserInfo {
  
  @Id
  private final Long id;
  @NotEmpty(message="first name can not be empty")
  private final String firstName;
  @NotEmpty(message="last name can not be empty")
  private final String lastName;
  private final String middleName;
  @Email(message="email has to be in valid format")
  private final String email;
  @Pattern(
    regexp="\\+?+[0-9]{11,13}+",
    message="phone must consist of 11-13 digits with an optional preceeding plus sign"
  )
  private final String phone;
  
  public static UserInfo.UserInfoBuilder builderFrom(UserInfo template) {
    return UserInfo.builder()
      .firstName(template.firstName)
      .middleName(template.middleName)
      .lastName(template.lastName)
      .phone(template.phone)
      .email(template.email)
      .id(template.id);
  }
  
}
