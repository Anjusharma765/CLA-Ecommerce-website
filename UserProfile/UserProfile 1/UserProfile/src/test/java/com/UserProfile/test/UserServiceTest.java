package com.UserProfile.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.UserProfile.model.Profile;
import com.UserProfile.model.User;
import com.UserProfile.model.changeName;
import com.UserProfile.repository.NameRepository;
import com.UserProfile.repository.UserRepository;
import com.UserProfile.service.NameService;
import com.UserProfile.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;
    
    @Mock
    private NameRepository nameRepository;

    @InjectMocks
    private NameService nameService;

    @Test
    public void testSaveUser() {
        // Create a user
        Profile user = new Profile();
        user.setId(1L);
       // user.setUserName("testUser");

        // Mock userRepository.save() method
        when(userRepository.save(user)).thenReturn(user);

        // Call the service method
        Profile savedUser = userService.saveUser(user);

        // Verify that userRepository.save() was called with the correct user object
        verify(userRepository, times(1)).save(user);

        // Verify that the saved user object matches the original user object
        assertEquals(user, savedUser);
    }
   /* @Test
    void testChangeMyName_Success() {
        // Arrange
        Long userId = 1L;
        String newName = "John Doe";
        changeName user = new changeName();
        user.setId(userId);
       // user.setUsername("Old Name");
        user.setOldName("Old Name");
        user.setNewName(newName);

        // Mocking repository behavior
        when(nameRepository.findById(userId)).thenReturn(Optional.of(user));
        when(nameRepository.save(any())).thenReturn(user);

        // Act
        changeName updatedUser = nameService.changeMyName(userId, newName);

        // Assert
        assertNotNull(updatedUser);
        //assertEquals(newName, updatedUser.getUsername());
        assertEquals(newName, updatedUser.getNewName());
        assertEquals("Old Name", updatedUser.getOldName()); // Assuming the old name is still stored
        verify(nameRepository, times(1)).findById(userId);
        verify(nameRepository, times(1)).save(user);
    }*/

   /* @Test
    void testChangeMyName_UserNotFound() {
        // Arrange
        Long userId = 1L;
        String newName = "John Doe";

        // Mocking repository behavior
        when(nameRepository.findById(userId)).thenReturn(Optional.empty());

        // Act
        //changeName updatedUser = nameService.changeMyName(userId, newName);

        // Assert
        assertNull(updatedUser);
        verify(nameRepository, times(1)).findById(userId);
        verify(nameRepository, never()).save(any());
    }
*/
   
}
