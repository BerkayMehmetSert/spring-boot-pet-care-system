package com.bms.petcaresystem.helper.message;

public class BusinessLogMessage {
    private BusinessLogMessage() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static class CurrentStatus {
        private CurrentStatus() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CURRENT_STATUS_CREATED = "Current status created successfully";
        public static final String CURRENT_STATUS_UPDATED = "Current status updated successfully";
        public static final String CURRENT_STATUS_DELETED = "Current status deleted successfully";
        public static final String CURRENT_STATUS_FIND = "Current status found successfully";
        public static final String CURRENT_STATUS_LIST = "Current status list found successfully";
        public static final String CURRENT_STATUS_NOT_FOUND = "Current status not found, please try again";
        public static final String CURRENT_STATUS_LIST_EMPTY = "Current status list is empty";
    }

    public static class Facility {
        private Facility() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String FACILITY_CREATED = "Facility created successfully";
        public static final String FACILITY_UPDATED = "Facility updated successfully";
        public static final String FACILITY_DELETED = "Facility deleted successfully";
        public static final String FACILITY_FIND = "Facility found successfully";
        public static final String FACILITY_NOT_FOUND = "Facility not found, please try again";
        public static final String FACILITY_LIST_EMPTY = "Facility list is empty";
        public static final String FACILITY_ALREADY_EXISTS = "Facility already exists, please try again";
    }

    public static class Invoice {
        private Invoice() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String INVOICE_CREATED = "Invoice created successfully";
        public static final String INVOICE_UPDATED = "Invoice updated successfully";
        public static final String INVOICE_FIND = "Invoice found successfully";
        public static final String INVOICE_NOT_FOUND = "Invoice not found, please try again";
    }

    public static class Note {
        private Note() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String NOTE_CREATED = "Note created successfully";
        public static final String NOTE_UPDATED = "Note updated successfully";
        public static final String NOTE_DELETED = "Note deleted successfully";
        public static final String NOTE_LIST = "Note list found successfully";
        public static final String NOTE_NOT_FOUND = "Note not found, please try again";
        public static final String NOTE_LIST_EMPTY = "Note list is empty";
    }

    public static class Owner {
        private Owner() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String OWNER_CREATED = "Owner created successfully";
        public static final String OWNER_UPDATED = "Owner updated successfully";
        public static final String OWNER_DELETED = "Owner deleted successfully";
        public static final String OWNER_FIND = "Owner found successfully";
        public static final String OWNER_LIST = "Owner list found successfully";
        public static final String OWNER_NOT_FOUND = "Owner not found, please try again";
        public static final String OWNER_LIST_EMPTY = "Owner list is empty";
        public static final String OWNER_ALREADY_EXISTS = "Owner already exists, please try again";
    }

    public static class Pet {
        private Pet() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PET_OWNER_ADDED = "Pet owner added successfully";
        public static final String PET_OWNER_REMOVED = "Pet owner removed successfully";
        public static final String PET_CREATED = "Pet created successfully";
        public static final String PET_UPDATED = "Pet updated successfully";
        public static final String PET_DELETED = "Pet deleted successfully";
        public static final String PET_FIND = "Pet found successfully";
        public static final String PET_LIST = "Pet list found successfully";
        public static final String PET_NOT_FOUND = "Pet not found, please try again";
        public static final String PET_LIST_EMPTY = "Pet list is empty";
    }

    public static class PetCase {
        private PetCase() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PET_CASE_COMPLETED = "Pet case completed successfully";
        public static final String PET_CASE_CREATED = "Pet case created successfully";
        public static final String PET_CASE_UPDATED = "Pet case updated successfully";
        public static final String PET_CASE_DELETED = "Pet case deleted successfully";
        public static final String PET_CASE_FIND = "Pet case found successfully";
        public static final String PET_CASE_LIST = "Pet case list found successfully";
        public static final String PET_CASE_NOT_FOUND = "Pet case not found, please try again";
        public static final String PET_CASE_LIST_EMPTY = "Pet case list is empty";
    }

    public static class PetService {
        private PetService() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String SPECIES_ADDED_TO_PET_SERVICE = "Species added to pet service successfully";
        public static final String SPECIES_NOT_FOUND = "Species not found, please try again";
        public static final String SPECIES_UPDATED_TO_PET_SERVICE = "Species updated to pet service successfully";
        public static final String SPECIES_REMOVED_TO_PET_SERVICE = "Species removed to pet service successfully";
        public static final String PET_SERVICE_CREATED = "Pet service created successfully";
        public static final String PET_SERVICE_UPDATED = "Pet service updated successfully";
        public static final String PET_SERVICE_DELETED = "Pet service deleted successfully";
        public static final String PET_SERVICE_FIND = "Pet service found successfully";
        public static final String PET_SERVICE_LIST = "Pet service list found successfully";
        public static final String PET_SERVICE_NOT_FOUND = "Pet service not found, please try again";
        public static final String PET_SERVICE_LIST_EMPTY = "Pet service list is empty";
        public static final String PET_SERVICE_ALREADY_EXISTS = "Pet service already exists, please try again";
    }

    public static class PetServicePlan {
        private PetServicePlan() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PET_SERVICE_PLAN_CREATED = "Pet service plan created successfully";
        public static final String PET_SERVICE_PLAN_UPDATED = "Pet service plan updated successfully";
        public static final String PET_SERVICE_PLAN_DELETED = "Pet service plan deleted successfully";
        public static final String PET_SERVICE_PLAN_FIND = "Pet service plan found successfully";
        public static final String PET_SERVICE_PLAN_LIST = "Pet service plan list found successfully";
        public static final String PET_SERVICE_PLAN_NOT_FOUND = "Pet service plan not found, please try again";
        public static final String PET_SERVICE_PLAN_LIST_EMPTY = "Pet service plan list is empty";
    }

    public static class PetServiceProvider {
        private PetServiceProvider() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PET_SERVICE_PROVIDER_COMPLETED = "Pet service provider completed successfully";
        public static final String PET_SERVICE_PROVIDER_CREATED = "Pet service provider created successfully";
        public static final String PET_SERVICE_PROVIDER_UPDATED = "Pet service provider updated successfully";
        public static final String PET_SERVICE_PROVIDER_DELETED = "Pet service provider deleted successfully";
        public static final String PET_SERVICE_PROVIDER_FIND = "Pet service provider found successfully";
        public static final String PET_SERVICE_PROVIDER_LIST = "Pet service provider list found successfully";
        public static final String PET_SERVICE_PROVIDER_NOT_FOUND = "Pet service provider not found, please try again";
        public static final String PET_SERVICE_PROVIDER_LIST_EMPTY = "Pet service provider list is empty";
    }

    public static class Provider {
        private Provider() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PROVIDER_CREATED = "Provider created successfully";
        public static final String PROVIDER_UPDATED = "Provider updated successfully";
        public static final String PROVIDER_DELETED = "Provider deleted successfully";
        public static final String PROVIDER_FIND = "Provider found successfully";
        public static final String PROVIDER_LIST = "Provider list found successfully";
        public static final String PROVIDER_NOT_FOUND = "Provider not found, please try again";
        public static final String PROVIDER_LIST_EMPTY = "Provider list is empty";
    }

    public static class Species {
        private Species() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String SPECIES_CREATED = "Species created successfully";
        public static final String SPECIES_UPDATED = "Species updated successfully";
        public static final String SPECIES_DELETED = "Species deleted successfully";
        public static final String SPECIES_FIND = "Species found successfully";
        public static final String SPECIES_LIST = "Species list found successfully";
        public static final String SPECIES_NOT_FOUND = "Species not found, please try again";
        public static final String SPECIES_LIST_EMPTY = "Species list is empty";
    }

    public static class Status {
        private Status() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_CREATED = "Status created successfully";
        public static final String STATUS_UPDATED = "Status updated successfully";
        public static final String STATUS_DELETED = "Status deleted successfully";
        public static final String STATUS_FIND = "Status found successfully";
        public static final String STATUS_LIST = "Status list found successfully";
        public static final String STATUS_NOT_FOUND = "Status not found, please try again";
        public static final String STATUS_LIST_EMPTY = "Status list is empty";
        public static final String STATUS_ALREADY_EXISTS = "Status already exists, please try again";
    }

    public static class StatusCategory {
        private StatusCategory() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_CATEGORY_CREATED = "Status category created successfully";
        public static final String STATUS_CATEGORY_UPDATED = "Status category updated successfully";
        public static final String STATUS_CATEGORY_DELETED = "Status category deleted successfully";
        public static final String STATUS_CATEGORY_FIND = "Status category found successfully";
        public static final String STATUS_CATEGORY_NOT_FOUND = "Status category not found, please try again";
        public static final String STATUS_CATEGORY_LIST_EMPTY = "Status category list is empty";
        public static final String STATUS_CATEGORY_LISTED = "Status category listed successfully";
        public static final String STATUS_CATEGORY_ALREADY_EXISTS = "Status category already exists, please try again";
    }

    public static class Unit {
        private Unit() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String UNIT_CREATED = "Unit created successfully";
        public static final String UNIT_UPDATED = "Unit updated successfully";
        public static final String UNIT_DELETED = "Unit deleted successfully";
        public static final String UNIT_FIND = "Unit found successfully";
        public static final String UNIT_LIST = "Unit list found successfully";
        public static final String UNIT_NOT_FOUND = "Unit not found, please try again";
        public static final String UNIT_LIST_EMPTY = "Unit list is empty";
        public static final String UNIT_ALREADY_EXISTS = "Unit already exists, please try again";
    }
}
