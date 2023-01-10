package com.bms.petcaresystem.helper.message;

public class BusinessMessage {
    public static final String ILLEGAL_STATE_EXCEPTION = "Utility class cannot be instantiated";

    private BusinessMessage() {
        throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
    }

    public static class CurrentStatus {
        private CurrentStatus() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CURRENT_STATUS_NOT_FOUND = "Current status not found, please try again";
        public static final String CURRENT_STATUS_LIST_EMPTY = "Current status list is empty, please try again";
    }

    public static class Facility {
        private Facility() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String FACILITY_NOT_FOUND = "Facility not found, please try again";
        public static final String FACILITY_ALREADY_EXISTS = "Facility already exists, please try again";
        public static final String FACILITY_LIST_EMPTY = "Facility list is empty, please try again";
        public static final String FACILITY_LISTED = "Facility listed successfully";
    }

    public static class Invoice {
        private Invoice() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String INVOICE_NOT_FOUND = "Invoice not found, please try again";
    }

    public static class Note {
        private Note() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String NOTE_NOT_FOUND = "Note not found, please try again";
        public static final String NOTE_LIST_EMPTY = "Note list is empty, please try again";
    }

    public static class Owner {
        private Owner() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String OWNER_NOT_FOUND = "Owner not found, please try again";
        public static final String OWNER_ALREADY_EXISTS = "Owner already exists, please try again";
        public static final String OWNER_LIST_EMPTY = "Owner list is empty, please try again";
    }

    public static class Pet {
        private Pet() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PET_NOT_FOUND = "Pet not found, please try again";
        public static final String PET_LIST_EMPTY = "Pet list is empty, please try again";
    }

    public static class PetCase {
        private PetCase() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PET_CASE_NOT_FOUND = "Pet case not found, please try again";
        public static final String PET_CASE_LIST_EMPTY = "Pet case list is empty, please try again";
    }

    public static class PetService {
        private PetService() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String SPECIES_NOT_FOUND = "Species not found, please try again";
        public static final String PET_SERVICE_NOT_FOUND = "Pet service not found, please try again";
        public static final String PET_SERVICE_ALREADY_EXISTS = "Pet service already exists, please try again";
        public static final String PET_SERVICE_LIST_EMPTY = "Pet service list is empty, please try again";
    }

    public static class PetServicePlan {
        private PetServicePlan() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PET_SERVICE_PLAN_NOT_FOUND = "Pet service plan not found, please try again";
        public static final String PET_SERVICE_PLAN_LIST_EMPTY = "Pet service plan list is empty, please try again";
    }

    public static class PetServiceProvider {
        private PetServiceProvider() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PET_SERVICE_PROVIDER_NOT_FOUND = "Pet service provider not found, please try again";
        public static final String PET_SERVICE_PROVIDER_LIST_EMPTY = "Pet service provider list is empty, please try again";
    }

    public static class Provider {
        private Provider() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PROVIDER_NOT_FOUND = "Provider not found, please try again";
        public static final String PROVIDER_LIST_EMPTY = "Provider list is empty, please try again";
        public static final String PROVIDER_LISTED = "Provider listed successfully";
    }

    public static class Species {
        private Species() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String SPECIES_NOT_FOUND = "Species not found, please try again";
        public static final String SPECIES_LIST_EMPTY = "Species list is empty, please try again";
    }

    public static class Status {
        private Status() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_NOT_FOUND = "Status not found, please try again";
        public static final String STATUS_ALREADY_EXISTS = "Status already exists, please try again";
        public static final String STATUS_LIST_EMPTY = "Status list is empty, please try again";
    }

    public static class StatusCategory {
        private StatusCategory() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_CATEGORY_NOT_FOUND = "Status category not found, please try again";
        public static final String STATUS_CATEGORY_ALREADY_EXISTS = "Status category already exists, please try again";
        public static final String STATUS_CATEGORY_LIST_EMPTY = "Status category list is empty, please try again";
    }

    public static class Unit {
        private Unit() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String UNIT_NOT_FOUND = "Unit not found, please try again";
        public static final String UNIT_ALREADY_EXISTS = "Unit already exists, please try again";
        public static final String UNIT_LIST_EMPTY = "Unit list is empty, please try again";
    }

}
