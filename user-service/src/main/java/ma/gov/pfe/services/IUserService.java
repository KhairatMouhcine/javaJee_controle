package ma.gov.pfe.services;

import ma.gov.pfe.dtos.UserDto;
import java.util.List;

public interface IUserService {
    UserDto addUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long id);
    List<UserDto> selectUsers();
    UserDto getUserById(Long id);
}