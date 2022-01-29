package com.cgi.conferences.services;

import com.cgi.conferences.models.dtos.AtelierDTO;
import com.cgi.conferences.models.dtos.ConferenceDTO;
import com.cgi.conferences.models.dtos.KeyNoteDTO;
import com.cgi.conferences.models.dtos.ParentConferenceDTO;
import org.springframework.stereotype.Service;

@Service
public class PrepareConferenceService {

    public String prepareConference(ParentConferenceDTO parentConferenceDTO) {
        return switch (parentConferenceDTO) {
            case KeyNoteDTO keyNoteDTO -> keyNoteDTO.prepareAmphi();
            case AtelierDTO atelier && atelier.getMateriel() == null -> {
                String concat = atelier.prepareSalle() + atelier.demanderMateriel();
                yield concat;
            }
            case AtelierDTO atelier -> atelier.prepareSalle();
            case ConferenceDTO conference -> conference.prepareAtelier();
            case ParentConferenceDTO p -> null;
        };
    }
}
