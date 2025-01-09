package conference.management.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import conference.management.model.LectureRequest;
import conference.management.repository.UserRepository;
import conference.management.repository.entity.LectureEntity;
import conference.management.repository.entity.UserEntity;
import jakarta.persistence.Entity;

class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    @DisplayName("Test registerForLecture with already registered lecture")
    void testRegisterForLectureAlreadyRegistered() {
        String login = "userLogin";
        LectureRequest lectureRequest = new LectureRequest(1, 1);
        UserEntity userEntity = new UserEntity();
        LectureEntity lectureEntity = new LectureEntity();
        userEntity.setLectures(Set.of(lectureEntity));

        when(userRepository.findByLogin(login)).thenReturn(Optional.of(userEntity));
        when(lectureRepository.findByPathNumberAndLectureNumber(1, 1)).thenReturn(Optional.of(lectureEntity));

        assertThrows(IllegalArgumentException.class, () -> userService.registerForLecture(login, lectureRequest));
    }

    @Test
    @DisplayName("Test updateUser with valid data")
    void testUpdateUser() {
        String email = "old@example.com";
        String newEmail = "new@example.com";
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(userEntity));

        userService.updateUser(email, newEmail);

        assertEquals(newEmail, userEntity.getEmail());
        verify(userRepository).save(userEntity);
    }

    @Test
    @DisplayName("Test updateUser with invalid email")
    void testUpdateUserInvalidEmail() {
        String email = "old@example.com";
        String newEmail = "new@example.com";

        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> userService.updateUser(email, newEmail));
    }

    @Test
    @DisplayName("Test registerForLecture with valid data")
    void testRegisterForLecture() {
        String login = "userLogin";
        LectureRequest lectureRequest = new LectureRequest(1, 1);
        UserEntity userEntity = new UserEntity();
        LectureEntity lectureEntity = new LectureEntity();

        when(userRepository.findByLogin(login)).thenReturn(Optional.of(userEntity));
        when(lectureRepository.findByPathNumberAndLectureNumber(1, 1)).thenReturn(Optional.of(lectureEntity));

        userService.registerForLecture(login, lectureRequest);

        assertTrue(userEntity.getLectures().contains(lectureEntity));
        verify(userRepository).save(userEntity);
    }


    @Test
    @DisplayName("Test registerForLecture with invalid login")
    void testRegisterForLectureInvalidLogin() {
        String login = "userLogin";
        LectureRequest lectureRequest = new LectureRequest(1, 1);

        when(userRepository.findByLogin(login)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> userService.registerForLecture(login, lectureRequest));
    }


    @Test
    @DisplayName("Test registerForLecture with valid data")
    void testRegisterForLecture() {
        String login = "userLogin";
        LectureRequest lectureRequest = new LectureRequest(1, 1);
        UserEntity userEntity = new UserEntity();
        LectureEntity lectureEntity = new LectureEntity();

        when(userRepository.findByLogin(login)).thenReturn(Optional.of(userEntity));
        when(lectureRepository.findByPathNumberAndLectureNumber(1, 1)).thenReturn(Optional.of(lectureEntity));

        userService.registerForLecture(login, lectureRequest);

        assertTrue(userEntity.getLectures().contains(lectureEntity));
        verify(userRepository).save(userEntity);
    }


    @Test
    @DisplayName("Test registerForLecture with valid data")
    void testRegisterForLecture() {
        String login = "userLogin";
        LectureRequest lectureRequest = new LectureRequest(1, 1);
        UserEntity userEntity = new UserEntity();
        LectureEntity lectureEntity = new LectureEntity();

        when(userRepository.findByLogin(login)).thenReturn(Optional.of(userEntity));
        when(lectureRepository.findByPathNumberAndLectureNumber(1, 1)).thenReturn(Optional.of(lectureEntity));

        userService.registerForLecture(login, lectureRequest);

        assertTrue(userEntity.getLectures().contains(lectureEntity));
        verify(userRepository).save(userEntity);
    }


}