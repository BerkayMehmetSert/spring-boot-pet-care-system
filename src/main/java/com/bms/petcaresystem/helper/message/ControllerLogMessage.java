package com.bms.petcaresystem.helper.message;

public class ControllerLogMessage {
    private ControllerLogMessage() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static class CurrentStatus {
        private CurrentStatus() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CURRENT_STATUS_CREATED = "Current Status Controller: Current status created successfully";
        public static final String CURRENT_STATUS_UPDATED = "Current Status Controller: Current status updated successfully";
        public static final String CURRENT_STATUS_DELETED = "Current Status Controller: Current status deleted successfully";
        public static final String CURRENT_STATUS_FOUND = "Current Status Controller: Current status found successfully";
        public static final String CURRENT_STATUS_LISTED = "Current Status Controller: Current status listed successfully";
    }

    public static class Facility {
        private Facility() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String FACILITY_CREATED = "Facility Controller: Facility created successfully";
        public static final String FACILITY_UPDATED = "Facility Controller: Facility updated successfully";
        public static final String FACILITY_DELETED = "Facility Controller: Facility deleted successfully";
        public static final String FACILITY_FOUND = "Facility Controller: Facility found successfully";
        public static final String FACILITY_LISTED = "Facility Controller: Facility listed successfully";
    }

    public static class Invoice {
        private Invoice() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String INVOICE_CREATED = "Invoice Controller: Invoice created successfully";
        public static final String INVOICE_UPDATED = "Invoice Controller: Invoice updated successfully";
        public static final String INVOICE_FOUND = "Invoice Controller: Invoice found successfully";
    }

    public static class Note {
        private Note() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String NOTE_CREATED = "Note Controller: Note created successfully";
        public static final String NOTE_UPDATED = "Note Controller: Note updated successfully";
        public static final String NOTE_DELETED = "Note Controller: Note deleted successfully";
        public static final String NOTE_LISTED = "Note Controller: Note listed successfully";
    }

    public static class Owner {
        private Owner() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String OWNER_CREATED = "Owner Controller: Owner created successfully";
        public static final String OWNER_UPDATED = "Owner Controller: Owner updated successfully";
        public static final String OWNER_DELETED = "Owner Controller: Owner deleted successfully";
        public static final String OWNER_FOUND = "Owner Controller: Owner found successfully";
        public static final String OWNER_LISTED = "Owner Controller: Owner listed successfully";
    }

    public static class Pet {
        private Pet() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String OWNER_ADDED_TO_PET = "Pet Controller: Owner added to pet successfully";
        public static final String OWNER_REMOVED_TO_PET = "Pet Controller: Owner removed to pet successfully";
        public static final String PET_CREATED = "Pet Controller: Pet created successfully";
        public static final String PET_UPDATED = "Pet Controller: Pet updated successfully";
        public static final String PET_DELETED = "Pet Controller: Pet deleted successfully";
        public static final String PET_FOUND = "Pet Controller: Pet found successfully";
        public static final String PET_LISTED = "Pet Controller: Pet listed successfully";
    }

    public static class PetCase {
        private PetCase() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PET_CASE_COMPLETED = "Pet Case Controller: Pet case completed successfully";
        public static final String PET_CASE_CREATED = "Pet Case Controller: Pet case created successfully";
        public static final String PET_CASE_UPDATED = "Pet Case Controller: Pet case updated successfully";
        public static final String PET_CASE_DELETED = "Pet Case Controller: Pet case deleted successfully";
        public static final String PET_CASE_FOUND = "Pet Case Controller: Pet case found successfully";
        public static final String PET_CASE_LISTED = "Pet Case Controller: Pet case listed successfully";
    }

    public static class PetService {
        private PetService() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String SPECIES_ADDED_TO_PET_SERVICE = "Pet Service Controller: Species added to pet service successfully";
        public static final String PET_SERVICE_CREATED = "Pet Service Controller: Pet service created successfully";
        public static final String PET_SERVICE_UPDATED = "Pet Service Controller: Pet service updated successfully";
        public static final String PET_SERVICE_DELETED = "Pet Service Controller: Pet service deleted successfully";
        public static final String PET_SERVICE_FOUND = "Pet Service Controller: Pet service found successfully";
        public static final String PET_SERVICE_LISTED = "Pet Service Controller: Pet service listed successfully";
    }

    public static class PetServicePlan {
        private PetServicePlan() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PET_SERVICE_PLAN_CREATED = "Pet Service Plan Controller: Pet service plan created successfully";
        public static final String PET_SERVICE_PLAN_UPDATED = "Pet Service Plan Controller: Pet service plan updated successfully";
        public static final String PET_SERVICE_PLAN_DELETED = "Pet Service Plan Controller: Pet service plan deleted successfully";
        public static final String PET_SERVICE_PLAN_FOUND = "Pet Service Plan Controller: Pet service plan found successfully";
        public static final String PET_SERVICE_PLAN_LISTED = "Pet Service Plan Controller: Pet service plan listed successfully";
    }

    public static class PetServiceProvider {
        private PetServiceProvider() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PET_SERVICE_PROVIDER_COMPLETED = "Pet Service Provider Controller: Pet service provider completed successfully";
        public static final String PET_SERVICE_PROVIDER_CREATED = "Pet Service Provider Controller: Pet service provider created successfully";
        public static final String PET_SERVICE_PROVIDER_UPDATED = "Pet Service Provider Controller: Pet service provider updated successfully";
        public static final String PET_SERVICE_PROVIDER_DELETED = "Pet Service Provider Controller: Pet service provider deleted successfully";
        public static final String PET_SERVICE_PROVIDER_FOUND = "Pet Service Provider Controller: Pet service provider found successfully";
        public static final String PET_SERVICE_PROVIDER_LISTED = "Pet Service Provider Controller: Pet service provider listed successfully";
    }

    public static class Provider {
        private Provider() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PROVIDER_CREATED = "Provider Controller: Provider created successfully";
        public static final String PROVIDER_UPDATED = "Provider Controller: Provider updated successfully";
        public static final String PROVIDER_DELETED = "Provider Controller: Provider deleted successfully";
        public static final String PROVIDER_FOUND = "Provider Controller: Provider found successfully";
        public static final String PROVIDER_LISTED = "Provider Controller: Provider listed successfully";
    }

    public static class Species {
        private Species() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String SPECIES_UPDATED = "Species Controller: Species updated successfully";
        public static final String SPECIES_DELETED = "Species Controller: Species deleted successfully";
        public static final String SPECIES_FOUND = "Species Controller: Species found successfully";
        public static final String SPECIES_LISTED = "Species Controller: Species listed successfully";
    }

    public static class Status {
        private Status() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_CREATED = "Status Controller: Status created successfully";
        public static final String STATUS_UPDATED = "Status Controller: Status updated successfully";
        public static final String STATUS_DELETED = "Status Controller: Status deleted successfully";
        public static final String STATUS_FOUND = "Status Controller: Status found successfully";
        public static final String STATUS_LISTED = "Status Controller: Status listed successfully";
    }

    public static class StatusCategory {
        private StatusCategory() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_CATEGORY_CREATED = "Status Category Controller: Status category created successfully";
        public static final String STATUS_CATEGORY_UPDATED = "Status Category Controller: Status category updated successfully";
        public static final String STATUS_CATEGORY_DELETED = "Status Category Controller: Status category deleted successfully";
        public static final String STATUS_CATEGORY_FOUND = "Status Category Controller: Status category found successfully";
        public static final String STATUS_CATEGORY_LISTED = "Status Category Controller: Status category listed successfully";
    }

    public static class Unit {
        private Unit() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String UNIT_CREATED = "Unit Controller: Unit created successfully";
        public static final String UNIT_UPDATED = "Unit Controller: Unit updated successfully";
        public static final String UNIT_DELETED = "Unit Controller: Unit deleted successfully";
        public static final String UNIT_FOUND = "Unit Controller: Unit found successfully";
        public static final String UNIT_LISTED = "Unit Controller: Unit listed successfully";
    }
}