package com.softserve.edu.opencart.data.field;

import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.AlertsText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ListOfFieldsRepository {
    private static volatile ListOfFieldsRepository instance = null;

    private ListOfFieldsRepository() {
    }

    public static ListOfFieldsRepository get() {
        if (instance == null) {
            synchronized (ListOfFieldsRepository.class) {
                if (instance == null) {
                    instance = new ListOfFieldsRepository();
                }
            }
        }
        return instance;
    }
    public IListOfFields nehgativeFields(){
        List<Object[]> negativeData = new ArrayList<Object[]>()
        {
            {
                add(new Object[] { UserRepository.get().userZvarych(),UserRepository.get().userWithoutName(), AlertsText.FIRST_NAME_MUST_BE_1_TO_32.toString()});
                add(new Object[] {UserRepository.get().userZvarych(), UserRepository.get().userWithoutLastName(), AlertsText.LAST_NAME_MUST_BE_1_TO_32.toString()});
                add(new Object[] {UserRepository.get().userZvarych(), UserRepository.get().userWithoutAddress(), AlertsText.ADDRESS_MUST_BE_3_TO_128.toString()});
                add(new Object[] {UserRepository.get().userZvarych(), UserRepository.get().userWithoutCity(), AlertsText.CITY_MUST_BE_2_TO_128.toString()});
                add(new Object[] {UserRepository.get().userZvarych(), UserRepository.get().userWithoutCountry(), AlertsText.NOT_SELECTED_COUNTRY.toString()});
                add(new Object[] {UserRepository.get().userZvarych(), UserRepository.get().userWithoutRegion(), AlertsText.NOT_SELECTED_REGION.toString()});
            }
        };

        return new ListOfFields(negativeData);
    }
    public IListOfFields nehgativeFieldsForRegistration(){
        List<Object[]> negativeData = new ArrayList<Object[]>()
        {
            {
                add(new Object[] {UserRepository.get().userWithoutName(), AlertsText.FIRST_NAME_MUST_BE_1_TO_32.toString()});
                add(new Object[] {UserRepository.get().userWithoutLastName(), AlertsText.LAST_NAME_MUST_BE_1_TO_32.toString()});
                add(new Object[] {UserRepository.get().userWithoutEmail(), AlertsText.NOT_VALID_EMAIL.toString()});
                add(new Object[] {UserRepository.get().userWithoutTelephon(), AlertsText.NOT_VALID_TELEPHONE.toString()});
                add(new Object[] {UserRepository.get().userWithoutAddress(), AlertsText.NOT_VALID_ADDRESS.toString()});
                add(new Object[] {UserRepository.get().userWithoutCity(), AlertsText.CITY_MUST_BE_2_TO_128.toString()});
                add(new Object[] {UserRepository.get().userWithoutCountry(), AlertsText.NOT_SELECTED_COUNTRY.toString()});
                add(new Object[] {UserRepository.get().userWithoutRegion(), AlertsText.NOT_SELECTED_REGION.toString()});
                add(new Object[] {UserRepository.get().userWithoutPass(), AlertsText.NOT_VALID_PASS.toString()});
                add(new Object[] {UserRepository.get().userWithoutConfirmPass(), AlertsText.NOT_VALID_CONFIRM_PASS.toString()});
            }
        };

        return new ListOfFields(negativeData);
    }
}
