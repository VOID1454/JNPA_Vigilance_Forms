package com.example.forms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.DTO.approverDTO;
import com.example.forms.model.Contract;
import com.example.forms.model.ForeignVisit;
import com.example.forms.model.Expenditure;
import com.example.forms.model.Form5A;
import com.example.forms.model.Form5B;
import com.example.forms.model.Form5C;
import com.example.forms.model.PenaltyCase;
import com.example.forms.model.ProgressOfWork;
import com.example.forms.model.ProgressOfWorkCivil;
import com.example.forms.model.SuspensionReport;
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

@Service
public class ApproverService {

    @Autowired
    private ExpenditureRepository form1Repository;

    @Autowired
    private Form5ARepository form5ARepository;

    @Autowired
    private Form5BRepository form5BRepository;

    @Autowired
    private Form5CRepository form5CRepository;

    @Autowired
    private ForeignVisitRepository foreignVisitRepository;

    @Autowired
    private ProgressOfWorkRepository progressOfWorkRepository;

    @Autowired
    private ProgressOfWorkCivilRepository progressOfWorkCivilRepository;

    @Autowired
    private SuspensionReportRepository suspensionReportRepository;

    @Autowired
    private PenaltyCaseRepository penaltyCaseRepository;

    @Autowired
    private ContractRepository contractRepository;

    public approverDTO getFormsByDepartment(String fordepartment) {
        approverDTO dto = new approverDTO();

        List<Expenditure> expenditures = form1Repository.findByFordepartment(fordepartment);
        List<Form5A> form5As = form5ARepository.findByFordepartment(fordepartment);
        List<Form5B> form5Bs = form5BRepository.findByFordepartment(fordepartment);
        List<Form5C> form5Cs = form5CRepository.findByFordepartment(fordepartment);
        List<ForeignVisit> foreignVisits = foreignVisitRepository.findByFordepartment(fordepartment);
        List<ProgressOfWork> progressOfWorks = progressOfWorkRepository.findByFordepartment(fordepartment);
        List<ProgressOfWorkCivil> progressOfWorkCivils = progressOfWorkCivilRepository.findByFordepartment(fordepartment);
        List<SuspensionReport> suspensionReports = suspensionReportRepository.findByFordepartment(fordepartment);
        List<PenaltyCase> penaltyCases = penaltyCaseRepository.findByFordepartment(fordepartment);
        List<Contract> contracts = contractRepository.findByFordepartment(fordepartment);

        dto.setExpenditures(expenditures);
        dto.setForm5As(form5As);
        dto.setForm5Bs(form5Bs);
        dto.setForm5Cs(form5Cs);
        dto.setForeignVisits(foreignVisits);
        dto.setProgressOfWorks(progressOfWorks);
        dto.setProgressOfWorkCivils(progressOfWorkCivils);
        dto.setSuspensionReport(suspensionReports);
        dto.setPenaltyCase(penaltyCases);
        dto.setContracts(contracts);

        return dto;
    }

    public void verifyRecord(Long id, String entityType) {
        switch (entityType) {
            case "expenditure":
                Optional<Expenditure> expenditure = form1Repository.findById(id);
                expenditure.ifPresent(form -> {
                    form.setVerified(true);
                    form1Repository.save(form);
                });
                break;
            case "form5A":
                Optional<Form5A> form5A = form5ARepository.findById(id);
                form5A.ifPresent(form -> {
                    form.setVerified(true);
                    form5ARepository.save(form);
                });
                break;
            case "form5B":
                Optional<Form5B> form5B = form5BRepository.findById(id);
                form5B.ifPresent(form -> {
                    form.setVerified(true);
                    form5BRepository.save(form);
                });
                break;
            case "form5C":
                Optional<Form5C> form5C = form5CRepository.findById(id);
                form5C.ifPresent(form -> {
                    form.setVerified(true);
                    form5CRepository.save(form);
                });
                break;
            case "foreignVisit":
                Optional<ForeignVisit> foreignVisit = foreignVisitRepository.findById(id);
                foreignVisit.ifPresent(visit -> {
                    visit.setVerified(true);
                    foreignVisitRepository.save(visit);
                });
                break;
            case "progressOfWork":
                Optional<ProgressOfWork> progressOfWork = progressOfWorkRepository.findById(id);
                progressOfWork.ifPresent(work -> {
                    work.setVerified(true);
                    progressOfWorkRepository.save(work);
                });
                break;
            case "progressOfWorkCivil":
                Optional<ProgressOfWorkCivil> progressOfWorkCivil = progressOfWorkCivilRepository.findById(id);
                progressOfWorkCivil.ifPresent(work -> {
                    work.setVerified(true);
                    progressOfWorkCivilRepository.save(work);
                });
                break;
            case "suspensionReport":
                Optional<SuspensionReport> suspensionReport = suspensionReportRepository.findById(id);
                suspensionReport.ifPresent(report -> {
                    report.setVerified(true);
                    suspensionReportRepository.save(report);
                });
                break;
            case "penaltyCase":
                Optional<PenaltyCase> penaltyCaseEntity = penaltyCaseRepository.findById(id);
                penaltyCaseEntity.ifPresent(penaltyCaseRecord -> {
                    penaltyCaseRecord.setVerified(true);
                    penaltyCaseRepository.save(penaltyCaseRecord);
                });
                break;
            case "contract":
                Optional<Contract> contract = contractRepository.findById(id);
                contract.ifPresent(c -> {
                    c.setVerified(true);
                    contractRepository.save(c);
                });
                break;
            default:
                throw new IllegalArgumentException("Invalid entity type: " + entityType);
        }
    }

    public void updateVerificationStatus(Long id, String entityType, String status) {
        switch (entityType) {
            case "expenditure":
                Optional<Expenditure> expenditure = form1Repository.findById(id);
                expenditure.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form1Repository.save(form);
                });
                break;
            case "form5A":
                Optional<Form5A> form5A = form5ARepository.findById(id);
                form5A.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form5ARepository.save(form);
                });
                break;
            case "form5B":
                Optional<Form5B> form5B = form5BRepository.findById(id);
                form5B.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form5BRepository.save(form);
                });
                break;
            case "form5C":
                Optional<Form5C> form5C = form5CRepository.findById(id);
                form5C.ifPresent(form -> {
                    form.setVerificationstatus(status);
                    form5CRepository.save(form);
                });
                break;
            case "foreignVisit":
                Optional<ForeignVisit> foreignVisit = foreignVisitRepository.findById(id);
                foreignVisit.ifPresent(visit -> {
                    visit.setVerificationstatus(status);
                    foreignVisitRepository.save(visit);
                });
                break;
            case "progressOfWork":
                Optional<ProgressOfWork> progressOfWork = progressOfWorkRepository.findById(id);
                progressOfWork.ifPresent(work -> {
                    work.setVerificationstatus(status);
                    progressOfWorkRepository.save(work);
                });
                break;
            case "progressOfWorkCivil":
                Optional<ProgressOfWorkCivil> progressOfWorkCivil = progressOfWorkCivilRepository.findById(id);
                progressOfWorkCivil.ifPresent(work -> {
                    work.setVerificationstatus(status);
                    progressOfWorkCivilRepository.save(work);
                });
                break;
            case "suspensionReport":
                Optional<SuspensionReport> suspensionReport = suspensionReportRepository.findById(id);
                suspensionReport.ifPresent(report -> {
                    report.setVerificationstatus(status);
                    suspensionReportRepository.save(report);
                });
                break;
            case "penaltyCase":
                Optional<PenaltyCase> penaltyCaseEntity = penaltyCaseRepository.findById(id);
                penaltyCaseEntity.ifPresent(penaltyCaseRecord -> {
                    penaltyCaseRecord.setVerificationstatus(status);
                    penaltyCaseRepository.save(penaltyCaseRecord);
                });
                break;
            case "contract":
                Optional<Contract> contract = contractRepository.findById(id);
                contract.ifPresent(c -> {
                    c.setVerificationstatus(status);
                    contractRepository.save(c);
                });
                break;
            default:
                throw new IllegalArgumentException("Invalid entity type: " + entityType);
        }
    }


    public void updateVerificationStatusAndRemark(Long id, String entityType, String status, String remark) {
    switch (entityType.toLowerCase()) {
        case "expenditure":
            Optional<Expenditure> expenditure = form1Repository.findById(id);
            expenditure.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Approved_By_HOD"));
                form.setAlertremark(remark);
                form1Repository.save(form);
            });
            break;
        case "progress":
            Optional<ProgressOfWork> progressOfWork = progressOfWorkRepository.findById(id);
            progressOfWork.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Approved_By_HOD"));
                form.setAlertremark(remark);
                progressOfWorkRepository.save(form);
            });
            break;
        case "civil":
            Optional<ProgressOfWorkCivil> progressOfWorkCivil = progressOfWorkCivilRepository.findById(id);
            progressOfWorkCivil.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Approved_By_HOD"));
                form.setAlertremark(remark);
                progressOfWorkCivilRepository.save(form);
            });
            break;
        case "visit":
            Optional<ForeignVisit> foreignVisit = foreignVisitRepository.findById(id);
            foreignVisit.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Approved_By_HOD"));
                form.setAlertremark(remark);
                foreignVisitRepository.save(form);
            });
            break;
        case "report":
            Optional<SuspensionReport> suspensionReport = suspensionReportRepository.findById(id);
            suspensionReport.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Approved_By_HOD"));
                form.setAlertremark(remark);
                suspensionReportRepository.save(form);
            });
            break;
        case "case":
            Optional<PenaltyCase> penaltyCase = penaltyCaseRepository.findById(id);
            penaltyCase.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Approved_By_HOD"));
                form.setAlertremark(remark);
                penaltyCaseRepository.save(form);
            });
            break;
        case "form5a":
            Optional<Form5A> form5A = form5ARepository.findById(id);
            form5A.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Approved_By_HOD"));
                form.setAlertremark(remark);
                form5ARepository.save(form);
            });
            break;
        case "form5b":
            Optional<Form5B> form5B = form5BRepository.findById(id);
            form5B.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Approved_By_HOD"));
                form.setAlertremark(remark);
                form5BRepository.save(form);
            });
            break;
        case "form5c":
            Optional<Form5C> form5C = form5CRepository.findById(id);
            form5C.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Approved_By_HOD"));
                form.setAlertremark(remark);
                form5CRepository.save(form);
            });
            break;
        case "contract":
            Optional<Contract> contract = contractRepository.findById(id);
            contract.ifPresent(form -> {
                form.setVerificationstatus(status);
                form.setVerified(status.equals("Approved_By_HOD"));
                form.setAlertremark(remark);
                contractRepository.save(form);
            });
            break;
        default:
            throw new IllegalArgumentException("Invalid entity type: " + entityType);
    }
}
}