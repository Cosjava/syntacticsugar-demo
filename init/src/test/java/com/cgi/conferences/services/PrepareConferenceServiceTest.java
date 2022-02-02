package com.cgi.conferences.services;

import com.cgi.conferences.models.dtos.AtelierDTO;
import com.cgi.conferences.models.dtos.ConferenceDTO;
import com.cgi.conferences.models.dtos.KeyNoteDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrepareConferenceServiceTest {

    private final PrepareConferenceService prepareConferenceService = new PrepareConferenceService();

    @Test
    void testPrepareAtelierWithMateriel() {
        String result = prepareConferenceService.prepareConference(new AtelierDTO("Gradle"));
        assertThat(result).isEqualTo("Vérifier la connectique.\nPréciser aux participants qu'il faut installer: Gradle");
    }

    @Test
    void testPrepareAtelierWithOutMateriel() {
        String result = prepareConferenceService.prepareConference(new AtelierDTO());
        assertThat(result).isEqualTo("Vérifier la connectique.");
    }

    @Test
    void testPrepareConference() {
        String result = prepareConferenceService.prepareConference(new ConferenceDTO());
        assertThat(result).isEqualTo("Organiser la disposition des tables + installer de l'eau pour le présentateur.");
    }

    @Test
    void testPrepareKeyNote() {
        String result = prepareConferenceService.prepareConference(new KeyNoteDTO());
        assertThat(result).isEqualTo("Installer le matériel vidéo et vérifier la connectique");
    }

    @Test
    void testPrepareNull() {
        String result = prepareConferenceService.prepareConference(null);
        assertThat(result).isNull();
    }
}
