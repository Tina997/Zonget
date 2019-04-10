package es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation;

public class SignUpConfirmationModel implements SignUpConfirmationContract.Model {

    @Override
    public void fetchSignUpConfirmationData() {}

    @Override
    public String getMessage(String accountName, String accountDni) {

        //TODO mejorar esto
        return "Bienvido a Zonget " + accountName + "con DNI " + accountDni;
    }

}

