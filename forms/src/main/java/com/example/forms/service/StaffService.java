package com.example.forms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.DTO.StaffDetailsDTO;
import com.example.forms.model.Contract;
import com.example.forms.model.Expenditure;
import com.example.forms.model.ForeignVisit;
import com.example.forms.model.Form5A;
import com.example.forms.model.Form5B;
import com.example.forms.model.Form5C;
import com.example.forms.model.PenaltyCase;
import com.example.forms.model.ProgressOfWork;
import com.example.forms.model.ProgressOfWorkCivil;
import com.example.forms.model.SuspensionReport;
import com.example.forms.model.User;
import com.example.forms.repository.ContractRepository;
import com.example.forms.repository.ExpenditureRepository;
import com.example.forms.repository.ForeignVisitRepository;
import com.example.forms.repository.Form5ARepository;
import com.example.forms.repository.Form5BRepository;
import com.example.forms.repository.Form5CRepository;
import com.example.forms.repository.PenaltyCaseRepository;
import com.example.forms.repository.ProgressOfWorkCivilRepository;
import com.example.forms.repository.ProgressOfWorkRepository;
import com.example.forms.repository.SuspensionReportRepository;
import com.example.forms.repository.UserRepository;

@Service
public class StaffService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SuspensionReportRepository suspensionReportRepository;
    @Autowired
    private ProgressOfWorkCivilRepository progressOfWorkCivilRepository;
    @Autowired
    private ProgressOfWorkRepository progressOfWorkRepository;
    @Autowired
    private PenaltyCaseRepository penaltyCaseRepository;
    @Autowired
    private Form5CRepository form5CRepository;
    @Autowired
    private Form5BRepository form5BRepository;
    @Autowired
    private Form5ARepository form5ARepository;
    @Autowired
    private ForeignVisitRepository foreignVisitRepository;
    @Autowired
    private ExpenditureRepository expenditureRepository;
    @Autowired
    private ContractRepository contractRepository;

    public StaffDetailsDTO getStaffDetails(String staffno) {
        StaffDetailsDTO staffDetailsDTO = new StaffDetailsDTO();

        // Fetch data for all required fields
        staffDetailsDTO.setStaffno(staffno);
        staffDetailsDTO.setUser(userRepository.findByStaffno(staffno).stream().findFirst().orElse(null));
        staffDetailsDTO.setSuspensionReport(suspensionReportRepository.findByStaffno(staffno).stream().findFirst().orElse(null));
        staffDetailsDTO.setProgressOfWorkCivils(progressOfWorkCivilRepository.findByStaffno(staffno));
        staffDetailsDTO.setProgressOfWorks(progressOfWorkRepository.findByStaffno(staffno));
        staffDetailsDTO.setPenaltyCase(penaltyCaseRepository.findByStaffno(staffno).stream().findFirst().orElse(null));
        staffDetailsDTO.setForm5Cs(form5CRepository.findByStaffno(staffno));
        staffDetailsDTO.setForm5Bs(form5BRepository.findByStaffno(staffno));
        staffDetailsDTO.setForm5As(form5ARepository.findByStaffno(staffno));
        staffDetailsDTO.setForeignVisits(foreignVisitRepository.findByStaffno(staffno));
        staffDetailsDTO.setExpenditures(expenditureRepository.findByStaffno(staffno));
        staffDetailsDTO.setContracts(contractRepository.findByStaffno(staffno));

        return staffDetailsDTO;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateVerificationStatus(Long id, String entityType, String status) {
        switch (entityType.toLowerCase()) {
            case "expenditure":
                Optional<Expenditure> expenditure = expenditureRepository.findById(id);
                expenditure.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    
                    form.setVerified(status.equals("Verified_By_Admin"));
                    
                    
                    expenditureRepository.save(form);
                });
                break;
            case "progressofwork":
                Optional<ProgressOfWork> progressOfWork = progressOfWorkRepository.findById(id);
                progressOfWork.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form.setVerified(status.equals("Verified_By_Admin"));
                    progressOfWorkRepository.save(form);
                });
                break;
            case "progressofworkcivil":
                Optional<ProgressOfWorkCivil> progressOfWorkCivil = progressOfWorkCivilRepository.findById(id);
                progressOfWorkCivil.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form.setVerified(status.equals("Verified_By_Admin"));
                    progressOfWorkCivilRepository.save(form);
                });
                break;
            case "foreignvisit":
                Optional<ForeignVisit> foreignVisit = foreignVisitRepository.findById(id);
                foreignVisit.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form.setVerified(status.equals("Verified_By_Admin"));
                    foreignVisitRepository.save(form);
                });
                break;
            case "suspensionreport":
                Optional<SuspensionReport> suspensionReport = suspensionReportRepository.findById(id);
                suspensionReport.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form.setVerified(status.equals("Verified_By_Admin"));
                    suspensionReportRepository.save(form);
                });
                break;
            case "penaltycase":
                Optional<PenaltyCase> penaltyCase = penaltyCaseRepository.findById(id);
                penaltyCase.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form.setVerified(status.equals("Verified_By_Admin"));
                    penaltyCaseRepository.save(form);
                });
                break;
            case "form5a":
                Optional<Form5A> form5A = form5ARepository.findById(id);
                form5A.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form.setVerified(status.equals("Verified_By_Admin"));
                    form5ARepository.save(form);
                });
                break;
            case "form5b":
                Optional<Form5B> form5B = form5BRepository.findById(id);
                form5B.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form.setVerified(status.equals("Verified_By_Admin"));
                    form5BRepository.save(form);
                });
                break;
            case "form5c":
                Optional<Form5C> form5C = form5CRepository.findById(id);
                form5C.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form.setVerified(status.equals("Verified_By_Admin"));
                    form5CRepository.save(form);
                });
                break;
            case "contract":
                Optional<Contract> contract = contractRepository.findById(id);
                contract.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form.setVerified(status.equals("Verified_By_Admin"));
                    contractRepository.save(form);
                });
                break;
            default:
                throw new IllegalArgumentException("Invalid entity type: " + entityType);
        }
    }

    public void updateVerificationStatusAndRemark(Long id, String entityType, String status, String remark) {
    switch (entityType.toLowerCase()) {
        case "expenditure":
            Optional<Expenditure> expenditure = expenditureRepository.findById(id);
            expenditure.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Verified_By_Admin"));
                form.setAlertremark(remark);
                expenditureRepository.save(form);
            });
            break;
        case "progress":
            Optional<ProgressOfWork> progressOfWork = progressOfWorkRepository.findById(id);
            progressOfWork.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Verified_By_Admin"));
                form.setAlertremark(remark);
                progressOfWorkRepository.save(form);
            });
            break;
        case "civil":
            Optional<ProgressOfWorkCivil> progressOfWorkCivil = progressOfWorkCivilRepository.findById(id);
            progressOfWorkCivil.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Verified_By_Admin"));
                form.setAlertremark(remark);
                progressOfWorkCivilRepository.save(form);
            });
            break;
        case "visit":
            Optional<ForeignVisit> foreignVisit = foreignVisitRepository.findById(id);
            foreignVisit.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Verified_By_Admin"));
                form.setAlertremark(remark);
                foreignVisitRepository.save(form);
            });
            break;
        case "report":
            Optional<SuspensionReport> suspensionReport = suspensionReportRepository.findById(id);
            suspensionReport.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Verified_By_Admin"));
                form.setAlertremark(remark);
                suspensionReportRepository.save(form);
            });
            break;
        case "case":
            Optional<PenaltyCase> penaltyCase = penaltyCaseRepository.findById(id);
            penaltyCase.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Verified_By_Admin"));
                form.setAlertremark(remark);
                penaltyCaseRepository.save(form);
            });
            break;
        case "form5a":
            Optional<Form5A> form5A = form5ARepository.findById(id);
            form5A.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Verified_By_Admin"));
                form.setAlertremark(remark);
                form5ARepository.save(form);
            });
            break;
        case "form5b":
            Optional<Form5B> form5B = form5BRepository.findById(id);
            form5B.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Verified_By_Admin"));
                form.setAlertremark(remark);
                form5BRepository.save(form);
            });
            break;
        case "form5c":
            Optional<Form5C> form5C = form5CRepository.findById(id);
            form5C.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Verified_By_Admin"));
                form.setAlertremark(remark);
                form5CRepository.save(form);
            });
            break;
        case "contract":
            Optional<Contract> contract = contractRepository.findById(id);
            contract.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Verified_By_Admin"));
                form.setAlertremark(remark);
                contractRepository.save(form);
            });
            break;
        default:
            throw new IllegalArgumentException("Invalid entity type: " + entityType);
    }
}
}