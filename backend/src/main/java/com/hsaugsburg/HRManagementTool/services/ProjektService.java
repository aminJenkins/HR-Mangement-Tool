package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.database.repository.ProjektRepo;
import com.hsaugsburg.HRManagementTool.dto.project.CreateProjectDTO;
import com.hsaugsburg.HRManagementTool.dto.project.ProjektDTO;
import com.hsaugsburg.HRManagementTool.models.Projekt;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProjektService {
    @Autowired
    private ProjektRepo projektRepo;
    @Autowired
    private MitarbeiterService mitarbeiterService;
    @Autowired
    private KontingentService kontingentService;


    public ProjektEntity getProjektEntity(int projektID) {
        return projektRepo.findById(projektID);
    }

    public Set<ProjektDTO> getProjektDTOs(String userMail) {
        return Projekt.parseEntitiesToDTOs(
                projektRepo.findByMitarbeiterID(mitarbeiterService.getMitarbeiterDTO(userMail).getId()));
    }

    public ProjektDTO createProject(CreateProjectDTO createProjectDto) {
        MitarbeiterEntity leiter = mitarbeiterService.getMitarbeiterEntityById(createProjectDto.getLeiterID());
        Set<MitarbeiterEntity> beteiligte = mitarbeiterService.getMitarbeiterEntities(createProjectDto.getProjektbeteiligte());
        Set<KontingentEntity> kontingente = kontingentService.getKontingentEntitiesById(createProjectDto.getKontingente());

        ProjektEntity newProjekt = createProjectDto.parseToEntity(leiter, beteiligte, kontingente);
        return ProjektDTO.parseFromEntity(projektRepo.save(newProjekt));
    }

    public List<ProjektDTO> getAllProjects() {
        return ProjektDTO.parseFromEntities(projektRepo.findAll());
    }

    public ProjektDTO updateProject(ProjektDTO projektDTO) {
        MitarbeiterEntity leiter = mitarbeiterService.getMitarbeiterEntityById(projektDTO.getLeiterID());
        Set<MitarbeiterEntity> beteiligte = mitarbeiterService.getMitarbeiterEntities(projektDTO.getProjektbeteiligte());
        Set<KontingentEntity> kontingente = kontingentService.getKontingentEntitiesById(projektDTO.getKontingente());
        ProjektEntity newProjekt = projektDTO.parseToEntity(leiter, beteiligte, kontingente);
        return Projekt.parseEntityToDTO(projektRepo.save(newProjekt));
    }

    public void deleteProject(int projectId) {
//        ProjektEntity p = projektRepo.findById(projectId).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Projekt nicht gefunden"));
//        System.out.println("leiter: "+p.getLeiter());
        if (projektRepo.existsById(projectId)) {
            projektRepo.deleteById(projectId);

        }
    }
}
