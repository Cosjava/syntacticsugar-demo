package com.cgi.conferences.services;

import com.cgi.conferences.models.dtos.AtelierDTO;
import com.cgi.conferences.models.dtos.ConferenceDTO;
import com.cgi.conferences.models.dtos.KeyNoteDTO;
import com.cgi.conferences.models.dtos.ParentConferenceDTO;
import org.springframework.stereotype.Service;

@Service
public class PrepareConferenceService {

    public String prepareConference(ParentConferenceDTO parentConferenceDTO) {
        if (parentConferenceDTO instanceof KeyNoteDTO) {
            return ((KeyNoteDTO) parentConferenceDTO).prepareAmphi();
        } else if (parentConferenceDTO instanceof AtelierDTO && ((AtelierDTO) parentConferenceDTO).getMateriel() == null) {
            return ((AtelierDTO) parentConferenceDTO).prepareSalle() + ((AtelierDTO) parentConferenceDTO).demanderMateriel();
        } else if (parentConferenceDTO instanceof AtelierDTO) {
            return ((AtelierDTO) parentConferenceDTO).prepareSalle();
        } else if (parentConferenceDTO instanceof ConferenceDTO) {
            return ((ConferenceDTO) parentConferenceDTO).prepareAtelier();
        }
        return null;
    }
}
