package com.baeldung.crud;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.baeldung.crud.controllers.TutorController;
import com.baeldung.crud.entities.Tutor;
import com.baeldung.crud.repositories.TutorRepository;

public class TutorControllerUnitTest {

    private static TutorController tutorController;
    private static TutorRepository mockedTutorRepository;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;

    @BeforeClass
    public static void setUpTutorControllerInstance() {
        mockedTutorRepository = mock(TutorRepository.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        tutorController = new TutorController(mockedTutorRepository);
    }

    @Test
    public void whenCalledAdd_thenCorrect() {
        Tutor tutor = new Tutor("John", "Smith", "john@domain.com");
        assertThat(tutorController.create(tutor)).isEqualTo("tutors/create");
    }
    
    @Test
    public void whenCalledaddTutorAndValidTutor_thenCorrect() {
        Tutor tutor = new Tutor("John", "Smith", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(tutorController.addTutor(tutor, mockedBindingResult, mockedModel)).isEqualTo("index");
    }

    @Test
    public void whenCalledaddTutorAndInValidTutor_thenCorrect() {
        Tutor tutor = new Tutor("John", "Smith", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(tutorController.addTutor(tutor, mockedBindingResult, mockedModel)).isEqualTo("add-tutor");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalledshowUpdateForm_thenIllegalArgumentException() {
        assertThat(tutorController.showUpdateForm(0, mockedModel)).isEqualTo("update-tutor");
    }
    
    @Test
    public void whenCalledupdateTutorAndValidTutor_thenCorrect() {
        Tutor tutor = new Tutor("John", "Smith", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(tutorController.updateTutor(1l, tutor, mockedBindingResult, mockedModel)).isEqualTo("index");
    }

    @Test
    public void whenCalledupdateTutorAndInValidTutor_thenCorrect() {
        Tutor tutor = new Tutor("John", "Smith", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(tutorController.updateTutor(1l, tutor, mockedBindingResult, mockedModel)).isEqualTo("update-tutor");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void whenCalleddeleteTutor_thenIllegalArgumentException() {
        assertThat(tutorController.deleteTutor(1l, mockedModel)).isEqualTo("index");
    }
}
