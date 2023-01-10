package com.bms.petcaresystem.exception;


import com.bms.petcaresystem.exception.currentstatus.CurrentStatusListEmptyException;
import com.bms.petcaresystem.exception.currentstatus.CurrentStatusNotFoundException;
import com.bms.petcaresystem.exception.facility.FacilityAlreadyExistException;
import com.bms.petcaresystem.exception.facility.FacilityListEmptyException;
import com.bms.petcaresystem.exception.facility.FacilityNotFoundException;
import com.bms.petcaresystem.exception.invoice.InvoiceListEmptyException;
import com.bms.petcaresystem.exception.invoice.InvoiceNotFoundException;
import com.bms.petcaresystem.exception.note.NoteListEmptyException;
import com.bms.petcaresystem.exception.note.NoteNotFoundException;
import com.bms.petcaresystem.exception.owner.OwnerAlreadyExistException;
import com.bms.petcaresystem.exception.owner.OwnerListEmptyException;
import com.bms.petcaresystem.exception.owner.OwnerNotFoundException;
import com.bms.petcaresystem.exception.pet.PetListEmptyException;
import com.bms.petcaresystem.exception.pet.PetNotFoundException;
import com.bms.petcaresystem.exception.petcase.PetCaseListEmptyException;
import com.bms.petcaresystem.exception.petcase.PetCaseNotFoundException;
import com.bms.petcaresystem.exception.petservice.PetServiceAlreadyExistException;
import com.bms.petcaresystem.exception.petservice.PetServiceListEmptyException;
import com.bms.petcaresystem.exception.petservice.PetServiceNotFoundException;
import com.bms.petcaresystem.exception.petserviceplan.PetServicePlanListEmptyException;
import com.bms.petcaresystem.exception.petserviceplan.PetServicePlanNotFoundException;
import com.bms.petcaresystem.exception.petserviceprovider.PetServiceProviderListEmptyException;
import com.bms.petcaresystem.exception.petserviceprovider.PetServiceProviderNotFoundException;
import com.bms.petcaresystem.exception.provider.ProviderListEmptyException;
import com.bms.petcaresystem.exception.provider.ProviderNotFoundException;
import com.bms.petcaresystem.exception.species.SpeciesAlreadyExistException;
import com.bms.petcaresystem.exception.species.SpeciesListEmptyException;
import com.bms.petcaresystem.exception.species.SpeciesNotFoundException;
import com.bms.petcaresystem.exception.status.StatusAlreadyExistException;
import com.bms.petcaresystem.exception.status.StatusListEmptyException;
import com.bms.petcaresystem.exception.status.StatusNotFoundException;
import com.bms.petcaresystem.exception.statuscategory.StatusCategoryAlreadyExistException;
import com.bms.petcaresystem.exception.statuscategory.StatusCategoryListEmptyException;
import com.bms.petcaresystem.exception.statuscategory.StatusCategoryNotFoundException;
import com.bms.petcaresystem.exception.unit.UnitAlreadyExistException;
import com.bms.petcaresystem.exception.unit.UnitListEmptyException;
import com.bms.petcaresystem.exception.unit.UnitNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CurrentStatusListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleCurrentStatusListEmptyException(CurrentStatusListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(CurrentStatusNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleCurrentStatusNotFoundException(CurrentStatusNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(FacilityAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleFacilityAlreadyExistException(FacilityAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(FacilityListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleFacilityListEmptyException(FacilityListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(FacilityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleFacilityNotFoundException(FacilityNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(InvoiceListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleInvoiceListEmptyException(InvoiceListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(InvoiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleInvoiceNotFoundException(InvoiceNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(NoteListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNoteListEmptyException(NoteListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(NoteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNoteNotFoundException(NoteNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(OwnerAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleOwnerAlreadyExistException(OwnerAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(OwnerListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleOwnerListEmptyException(OwnerListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(OwnerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleOwnerNotFoundException(OwnerNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(PetListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePetListEmptyException(PetListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(PetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePetNotFoundException(PetNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(PetCaseListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePetCaseListEmptyException(PetCaseListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(PetCaseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePetCaseNotFoundException(PetCaseNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(PetServiceAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handlePetServiceAlreadyExistException(PetServiceAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(PetServiceListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePetServiceListEmptyException(PetServiceListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(PetServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePetServiceNotFoundException(PetServiceNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(PetServicePlanListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePetServicePlanListEmptyException(PetServicePlanListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(PetServicePlanNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePetServicePlanNotFoundException(PetServicePlanNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(PetServiceProviderListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePetServiceProviderListEmptyException(PetServiceProviderListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(PetServiceProviderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePetServiceProviderNotFoundException(PetServiceProviderNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(ProviderListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleProviderListEmptyException(ProviderListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(ProviderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleProviderNotFoundException(ProviderNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(SpeciesAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleSpeciesAlreadyExistException(SpeciesAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(SpeciesListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleSpeciesListEmptyException(SpeciesListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(SpeciesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleSpeciesNotFoundException(SpeciesNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(StatusAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleStatusAlreadyExistException(StatusAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(StatusListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleStatusListEmptyException(StatusListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(StatusNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleStatusNotFoundException(StatusNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(StatusCategoryAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleStatusCategoryAlreadyExistException(StatusCategoryAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(StatusCategoryListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleStatusCategoryListEmptyException(StatusCategoryListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(StatusCategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleStatusCategoryNotFoundException(StatusCategoryNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(UnitAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleUnitAlreadyExistException(UnitAlreadyExistException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(UnitListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleUnitListEmptyException(UnitListEmptyException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(UnitNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleUnitNotFoundException(UnitNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
}
